package m2m.teste;

import br.com.m2msolutions.copiloto.client.Copiloto;
import br.com.m2msolutions.copiloto.client.builder.CopilotoBuilder;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by rodrigo on 27/11/17.
 */

public class Main {

    public static void main(String[] args){

        Alocacao alocacao = criarAlocacao();

        HazelcastInstance instance = criarInstance();

        Integer idVeiculo = 14;

        Map<Integer,Alocacao> mapa = instance.getMap("alocacao");
        mapa.put(idVeiculo,alocacao);

        Date dataTransmissao = criarTransmissao(alocacao,7);

        System.out.println(dataTransmissao);

        Copiloto copiloto = CopilotoBuilder.build("localhost",6565);

        Integer minutos = copiloto
                            .emViagemComVeiculo(idVeiculo)
                                .comModulo()
                                    .modelo("MAXTRACK")
                                    .identificador("1234")
                                .doCliente(209)
                                .naLinha("56b6646230d5843076998c18")
                                .noTrajeto("56b6646230d5843076998c13")
                                    .comPercentualDeConclusao(25.0f)
                                .transmitiuEm(dataTransmissao)
                            .calcular()
                            .minutosDeAtrasoOuAdiantamento();

        System.out.println(minutos+" ---- ");

    }

    private static Alocacao criarAlocacao(){
        Alocacao alocacao = new Alocacao();
        alocacao.setAberturaViagem("2017-11-27 10:05:00");
        alocacao.setPartida("2017-11-27 10:00:00");
        alocacao.setChegada("2017-11-27 11:00:00");
        return alocacao;
    }

    private static Date criarTransmissao(Alocacao alocacao,Integer minutosDepois){
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(alocacao.getAberturaViagem());
            date.setMinutes(date.getMinutes() + minutosDepois);
            return date;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static HazelcastInstance criarInstance(){
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress("localhost:5701");
        config.getSerializationConfig().addPortableFactory(1,new MyFactory());
        HazelcastInstance instance = HazelcastClient.newHazelcastClient(config);
        return instance;
    }
}
