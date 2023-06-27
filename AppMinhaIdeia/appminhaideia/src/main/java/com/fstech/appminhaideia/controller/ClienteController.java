package com.fstech.appminhaideia.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.fstech.appminhaideia.api.AppUtil;
import com.fstech.appminhaideia.datamodel.ClienteDataModel;
import com.fstech.appminhaideia.datasource.AppDataBase;
import com.fstech.appminhaideia.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    String versaApp;
    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG,"ClienteController: Cnectado");
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoDoObjeto = new ContentValues();

//        dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.IDADE,obj.getIdade());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE,obj.getTelefone());



        // Enviar dados (dosdosObjeto) para classe AppDataBase
        return insert(ClienteDataModel.TABELA,dadoDoObjeto);



    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.IDADE,obj.getIdade());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE,obj.getTelefone());

        // Enviar dados (dosdosObjeto) para classe AppDataBase
        return update(ClienteDataModel.TABELA,dadoDoObjeto);

    }

    @Override
    public boolean deletar(int id) {

        return deleteById(ClienteDataModel.TABELA,id);

    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes(ClienteDataModel.TABELA);

    }
}
