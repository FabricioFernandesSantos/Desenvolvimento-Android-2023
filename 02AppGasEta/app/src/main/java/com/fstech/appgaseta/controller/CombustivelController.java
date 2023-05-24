package com.fstech.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import com.fstech.appgaseta.database.GasEtaDB;
import com.fstech.appgaseta.model.Combustivel;
import com.fstech.appgaseta.view.GasEtaActivity;

import java.util.List;

public class CombustivelController extends GasEtaDB {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    //psfs
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity){
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCES,0);

        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel){

        ContentValues dados = new ContentValues();


        dadosPreferences.putString("Combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("preco", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();

        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvarObjeto("combustivel", dados);

    }

    public List<Combustivel> getListaDeDados(){

        return listarDados();
    }


    public void alterar(Combustivel combustivel){


        ContentValues dados = new ContentValues();

        dados.put("id", combustivel.getId());
        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        alterarObjeto("Combustivel",dados);


    }

    public void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }

}
