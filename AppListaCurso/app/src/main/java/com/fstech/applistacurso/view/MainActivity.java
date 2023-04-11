package com.fstech.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.fstech.applistacurso.R;
import com.fstech.applistacurso.model.Pessoa;


public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Fabricio");
        pessoa.setSobreNome("Santos");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("62-5555-6666");

    }
}