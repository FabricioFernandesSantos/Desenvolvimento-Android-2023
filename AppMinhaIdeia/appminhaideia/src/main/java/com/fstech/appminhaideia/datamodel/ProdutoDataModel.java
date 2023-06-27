package com.fstech.appminhaideia.datamodel;

public class ProdutoDataModel {

    //Nome da tabela
    public static final String TABELA = "prduto";

    // Campos da tabela
    public static final String ID = "id"; //integer
    public static final String NOME = "nome"; //text
    public static final String FORNECEDOR = "fornecedor"; //text

    //Query para criar tabela
    public static String  queryCriarTabela = "";

    public static String criarTabela() {
        if (queryCriarTabela != null) {
            queryCriarTabela = "";
        }

        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " INTEGER primary key autoincrement, ";
        queryCriarTabela += NOME + " TEXT, ";
        queryCriarTabela += FORNECEDOR + " TEXT ";
        queryCriarTabela += ")";


        return queryCriarTabela;

    }


}
