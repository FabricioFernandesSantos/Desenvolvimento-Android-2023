package com.fstech.appminhaideia.datamodel;

public class ClienteDataModel {
    //Modelo Objeto Relacional

    //Nome da tabela
    public static final String TABELA = "cliente";

    // Campos da tabela
    public static final String ID = "id"; //integer
    public static final String NOME = "nome"; //text
    public static final String EMAIL = "email"; //text
    public static final String TELEFONE = "telefone"; //text
    public static final String IDADE = "idade"; //integer



    //Query para criar tabela
    public static String  queryCriarTabela = "";

    //Script para criar a tabela
    public static String criarTabela(){
        if (queryCriarTabela != null) {
            queryCriarTabela = "";
        }

        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" INTEGER primary key autoincrement, ";
        queryCriarTabela += NOME+" TEXT, ";
        queryCriarTabela += EMAIL+" TEXT, ";
        queryCriarTabela += TELEFONE+" TEXT, ";
        queryCriarTabela += IDADE+" INTEGER ";
        queryCriarTabela += ")";


        return queryCriarTabela;
    }


}
