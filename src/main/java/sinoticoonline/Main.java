package sinoticoonline;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args)throws Exception{
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        VeiculoEmTrajeto veiculoEmTrajeto1 = criaVeiculoEmTrajeto(35810,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 22:45:00",true);

        VeiculoEmTrajeto veiculoEmTrajeto2 = criaVeiculoEmTrajeto(30826,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 23:20:00",false);

        VeiculoEmTrajeto veiculoEmTrajeto3 = criaVeiculoEmTrajeto(34394,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 22:18:00",false);

        VeiculoEmTrajeto veiculoEmTrajeto4 = criaVeiculoEmTrajeto(35810,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 22:45:00",false);

        VeiculoEmTrajeto veiculoEmTrajeto5 = criaVeiculoEmTrajeto(34152,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 22:45:00",false);

        VeiculoEmTrajeto veiculoEmTrajeto6 = criaVeiculoEmTrajeto(16435,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2018-11-27 16:07:28",true);


        /*veiculoEmTrajeto1.iniciarViagem();
        veiculoEmTrajeto2.iniciarViagem();
        veiculoEmTrajeto3.iniciarViagem();
        veiculoEmTrajeto4.iniciarViagem();
        veiculoEmTrajeto5.iniciarViagem();*/
        veiculoEmTrajeto6.iniciarViagem(); //87594

        //dp

       /* VeiculoEmTrajeto veiculoEmTrajeto6 = criaVeiculoEmTrajeto(35810,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 22:45:00",true);

        VeiculoEmTrajeto veiculoEmTrajeto7 = criaVeiculoEmTrajeto(30826,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 23:20:00",true);

        VeiculoEmTrajeto veiculoEmTrajeto8 = criaVeiculoEmTrajeto(34394,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 22:18:00",true);

        VeiculoEmTrajeto veiculoEmTrajeto9 = criaVeiculoEmTrajeto(35810,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 22:45:00",false);

        VeiculoEmTrajeto veiculoEmTrajeto10 = criaVeiculoEmTrajeto(34152,209,"1414",
                "555b4eadaecc1a6638f3ab2b","5a3c0d3d4b7fbeb83c72fa50","2017-12-20 22:45:00",false);

        veiculoEmTrajeto6.iniciarViagem();
        veiculoEmTrajeto7.iniciarViagem();
        veiculoEmTrajeto8.iniciarViagem();
        veiculoEmTrajeto9.iniciarViagem();
        veiculoEmTrajeto10.iniciarViagem();*/


        Thread.sleep(40000000);
    }

    private static VeiculoEmTrajeto criaVeiculoEmTrajeto(Integer id, Integer clienteId, String identificadorModulo,
                                                         String linhaId, String trajetoId,String dtAberturaViagem,
                                                         boolean distanciaMinima)throws Exception{

        Date dtAbertura = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dtAberturaViagem);

        Veiculo veiculo = new Veiculo(id,clienteId,identificadorModulo);
        Trajeto trajeto = new Trajeto(trajetoId,linhaId);
        VeiculoEmTrajeto veiculoEmTrajeto = new VeiculoEmTrajeto(veiculo,trajeto,dtAbertura,distanciaMinima);

        return veiculoEmTrajeto;
    }
}
