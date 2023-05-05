package com.fstech.appgaseta.apoio;

public class UtilGasEta {

    public static String menssagem(){

        return "Qualquer menssagem";

    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol<=precoIdeal){
            mensagemDeRetorno = "Abastecer com Etanol";
        }else{
            mensagemDeRetorno = "Abastecer com Gasolina";
        }

        return mensagemDeRetorno;

    }

}
