package com.fstech.appminhaideia.controller;

import android.content.ContentValues;
import android.content.Context;

import com.fstech.appminhaideia.datamodel.ProdutoDataModel;
import com.fstech.appminhaideia.datasource.AppDataBase;
import com.fstech.appminhaideia.model.Prduto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController extends AppDataBase implements ICrud<Prduto> {

    ContentValues dadosObjeto;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Prduto obj) {

        dadosObjeto = new ContentValues();

        dadosObjeto.put(ProdutoDataModel.NOME,obj.getNome());
        dadosObjeto.put(ProdutoDataModel.FORNECEDOR,obj.getFornecedor());

        return insert(ProdutoDataModel.TABELA, dadosObjeto);
    }

    @Override
    public boolean alterar(Prduto obj) {

        dadosObjeto = new ContentValues();

        dadosObjeto.put(ProdutoDataModel.ID,obj.getId());
        dadosObjeto.put(ProdutoDataModel.NOME,obj.getNome());
        dadosObjeto.put(ProdutoDataModel.FORNECEDOR,obj.getFornecedor());

        return false;
    }

    @Override
    public boolean deletar(int id) {

        deleteById(ProdutoDataModel.TABELA,id);
        return false;


    }

    @Override
    public List<Prduto> listar() {

        List<Prduto> lista = new ArrayList<>();
        return lista;
    }
}
