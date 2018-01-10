package sinoticoonline;

import br.com.m2msolutions.copiloto.client.Copiloto;
import br.com.m2msolutions.copiloto.client.builder.CopilotoBuilder;

import java.util.Date;

public class VeiculoEmTrajeto {
    private Veiculo veiculo;
    private Trajeto trajeto;
    private ExecutorDeViagem executorDeViagem;
    private Date dataAberturaViagem;
    private Copiloto copiloto;
    private boolean distanciaMinima;

    public VeiculoEmTrajeto(Veiculo veiculo, Trajeto trajeto,Date dataAberturaViagem) {
        this(veiculo,trajeto,dataAberturaViagem,false);
    }

    public VeiculoEmTrajeto(Veiculo veiculo, Trajeto trajeto,Date dataAberturaViagem,boolean distanciaMinima){
        this.veiculo = veiculo;
        this.trajeto = trajeto;
        this.dataAberturaViagem = dataAberturaViagem;
        executorDeViagem = new ExecutorDeViagem();
        this.distanciaMinima = distanciaMinima;

        copiloto = CopilotoBuilder.build("localhost",6565);
    }

    public void iniciarViagem(){
        executorDeViagem.executar();
    }

    private class ExecutorDeViagem{
        Runnable runnable;
        private final int transmissaoDelay = 10;
        private final int chanceDeNaoEvoluir = 30;
        private float percentualDeConclusao = 0;
        Date ultimaTransmissao;
        private double minutosRegulados = 0.0;


        public ExecutorDeViagem(){

            ultimaTransmissao = dataAberturaViagem;

            runnable = new Runnable() {
                public void run() {

                    try{

                        while(true){
                            Thread.sleep(transmissaoDelay*1000);
                            if(distanciaMinima){
                                chamarCopilotoDistanciaMinima(3);
                            }
                            else{

                                Date dtTransmissao = criaDataTransmissao();
                                atualizaPercentual();
                                chamarCopiloto(dtTransmissao);
                            }

                        }

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
        }

        public void executar(){
            Thread t = new Thread(runnable);
            t.start();
        }

        private void chamarCopiloto(Date dataTransmissao){

            System.out.println("chamando "+new Date()+" ");

            System.out.println("transmissao "+dataTransmissao+" percentual "+percentualDeConclusao);

            Double minutos = copiloto
                                .emViagemComVeiculo(veiculo.getId())
                                .comModulo()
                                .modelo(veiculo.getModeloModulo())
                                .identificador(veiculo.getIdentificadorModulo())
                                .doCliente(veiculo.getClienteId())
                                .naLinha(trajeto.getLinhaId())
                                .noTrajeto(trajeto.getTrajetoId())
                                .comPercentualDeConclusao(percentualDeConclusao)
                                .transmitiuEm(dataTransmissao)
                                .calcular()
                                .regulagem();

            System.out.println("retornando "+new Date());

            System.out.println(minutos+" ---- "+" veiculo: "+veiculo.getId());

            if(minutos != null)
                minutosRegulados = minutos;
        }

        private void chamarCopilotoDistanciaMinima(long tempo){
            boolean notificado = copiloto.notificar(
                    veiculo.getClienteId(),
                    veiculo.getId(),
                    trajeto.getLinhaId(),
                    trajeto.getTrajetoId(),
                    tempo,
                    1l
            );

            System.out.println("veiculo "+veiculo.getId()+" notificou distancia minima: "+notificado);
        }

        private Date criaDataTransmissao(){
            ultimaTransmissao.setSeconds(ultimaTransmissao.getSeconds() + transmissaoDelay);
            return ultimaTransmissao;
        }

        private void atualizaPercentual(){

            int chance =  (int) (Math.random() * 100) + 1;

            double evolucao = 0;

            if(minutosRegulados <= 1.5){
                if(chance > 70)
                    evolucao = (Math.random() * 3) + 1;
            }
            else
            if(minutosRegulados <= 2.0){
                if(chance > 90)
                    evolucao = (Math.random() * 2) + 1;
            }
            else
                if(minutosRegulados <= 3.0){
                    if(chance > 97)
                        evolucao = (Math.random() * 1);
                }

            percentualDeConclusao += evolucao;
        }
    }
}
