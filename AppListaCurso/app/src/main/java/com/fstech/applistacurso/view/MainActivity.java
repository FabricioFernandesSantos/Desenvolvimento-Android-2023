package com.fstech.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fstech.applistacurso.R;
import com.fstech.applistacurso.controller.PessoaController;
import com.fstech.applistacurso.model.Pessoa;


public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    SharedPreferences.Editor listavip;


    public static final String NOME_PREFERENCES = "pref_listavip";


    PessoaController controller;

    Pessoa pessoa;


    EditText editPrimeiroNome;
    EditText editSobrenomeAluno;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        pessoa = new Pessoa();

        controller.buscar(pessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenomeAluno = findViewById(R.id.editSobrenomeAluno);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenomeAluno.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());


        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenomeAluno.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");


                controller.limpar();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenomeAluno.getText().toString());

                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                pessoa.setSobreNome(editNomeCurso.getText().toString());
                pessoa.setSobreNome(editTelefoneContato.getText().toString());


                Toast.makeText(MainActivity.this, "Salvo "+ pessoa.toString(), Toast.LENGTH_SHORT).show();

                listavip.putString("primeiroNome",pessoa.getPrimeiroNome());
                listavip.putString("sobreNome",pessoa.getSobreNome());
                listavip.putString("nomeCurso",pessoa.getCursoDesejado());
                listavip.putString("telefoneContato",pessoa.getTelefoneContato());
                listavip.apply();


                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_SHORT).show();

                controller.salvar(pessoa);
                
                Toast.makeText(MainActivity.this, "Salvo " + pessoa.

            }

        });



        Log.i("POOAndroid", pessoa.toString());


        Log.i("POOAndroid",pessoa.toString());


        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());


    }
}