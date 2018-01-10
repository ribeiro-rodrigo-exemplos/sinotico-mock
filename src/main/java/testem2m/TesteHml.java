package testem2m;

import br.com.m2msolutions.copiloto.client.Copiloto;
import br.com.m2msolutions.copiloto.client.builder.CopilotoBuilder;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rodrigo on 22/12/17.
 */
public class TesteHml {

    private static int idVeiculo = 16254;
    private static String idHorario = "1361024";

    public static void main(String[] args){

        /*HazelcastInstance instance = criarInstance();
        IMap<String,Alocacao> mapa = instance.getMap("alocacao");

        gravaAlocacao(mapa);

        Alocacao alocacao = mapa.get(idHorario);

        System.out.println(alocacao.getDataTransmissao()); */

        //Copiloto copiloto = CopilotoBuilder.build("172.18.107.218",6565);

        Date dataTransmissao = criarTransmissao("2017-12-24 20:39:00");

        Copiloto copiloto = CopilotoBuilder.build("localhost",6565);

        System.out.println("chamando "+new Date());

        Double minutos = copiloto
                            .emViagemComVeiculo(35810)
                            .comModulo()
                            .modelo("MAXTRACK")
                            .identificador("1234")
                            .doCliente(209)
                            .naLinha("555b4eadaecc1a6638f3ab2b")
                            .noTrajeto("5a3c0d3d4b7fbeb83c72fa50")
                            .comPercentualDeConclusao(25.0f)
                            .transmitiuEm(dataTransmissao)
                            .calcular()
                            .regulagem();

        System.out.println("retornando "+new Date());

        System.out.println(minutos+" ---- ");


    }

    private static void gravaAlocacao(IMap<String,Alocacao> mapa){

        Alocacao alocacao = new Alocacao();
        alocacao.setViagemId("viagem01");
        alocacao.setPartida("17:00:00");
        //alocacao.setChegada();
    }

    private static Date criarTransmissao(String dataHora){

        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dataHora);
            return date;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static HazelcastInstance criarInstance(){
        ClientConfig config = new ClientConfig();
        //config.getNetworkConfig().addAddress("10.10.1.48:5701");
        //config.getNetworkConfig().addAddress("localhost");
        //config.getNetworkConfig().addAddress("172.18.107.208");
        config.getSerializationConfig().addPortableFactory(1,new MyFactory());
        HazelcastInstance instance = HazelcastClient.newHazelcastClient(config);
        return instance;
    }
}

