package com.fstech.ferramentalayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    EditText edtNomeCmpleto;

    Button btnConfirmar;

    ToggleButton tbLigado;

    Switch  swMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);

        edtNomeCmpleto = findViewById(R.id.edtNomeCompleto);

        btnConfirmar = findViewById(R.id.btnConfirmar);

        tbLigado = findViewById(R.id.tbLigado);

        swMostrar = findViewById(R.id.swMostrar);




        txtTitulo.setText("Retrato");

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean dadosOk = true;

                if (TextUtils.isEmpty(edtNomeCmpleto.getText().toString())){
                    edtNomeCmpleto.setError("Digite o nome completo");
                    dadosOk = false;
                }

                if (dadosOk) {
                    Toast.makeText(getBaseContext(), "Você digitou: " + edtNomeCmpleto.getText(), Toast.LENGTH_LONG).show();
                }

            }
        });

        tbLigado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tbLigado.isChecked()) edtNomeCmpleto.setEnabled(false);
                else edtNomeCmpleto.setEnabled(true);



            }
        });

        swMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swMostrar.isChecked()){
                    txtTitulo.setVisibility(View.GONE);

                }else{
                    txtTitulo.setVisibility(View.VISIBLE);
                    txtTitulo.setText(txtTitulo.getText().toString().toUpperCase());
                }
            }
        });



    }
}