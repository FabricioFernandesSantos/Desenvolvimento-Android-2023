package com.fstech.appgaseta.controller;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.fstech.appgaseta.model.Pessoa;
import com.fstech.appgaseta.view.MainActivity;

public class PessoaController {


    SharedPreferences preferences;
    SharedPreferences.Editor listavip;

    public static final String NOME_PREFERENCES = "pref_listavip";


    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listavip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }


    public void salvar(Pessoa pessoa) {

        listavip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listavip.putString("sobreNome", pessoa.getSobreNome());
        listavip.putString("nomeCurso", pessoa.getCursoDesejado());
        listavip.putString("telefoneContato", pessoa.getTelefoneContato());
        listavip.apply();

    }

    public Pessoa buscar(Pessoa pessoa) {

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));


        return pessoa;
    }

    public void limpar() {
        listavip.clear();
        listavip.apply();

    }
}
