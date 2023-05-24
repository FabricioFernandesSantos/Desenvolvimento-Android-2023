package com.fstech.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fstech.appgaseta.R;
import com.fstech.appgaseta.apoio.UtilGasEta;
import com.fstech.appgaseta.controller.CombustivelController;
import com.fstech.appgaseta.model.Combustivel;

import java.util.List;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText edtGasolina;
    EditText edtEtanol;
    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    TextView txtResultado;

    double precoGasolina;
    double precoEtanol;

    String Resultado;

    List<Combustivel> dados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);

        dados = controller.getListaDeDados();

        Combustivel objAlteracao = dados.get(1);

        objAlteracao.setNomeDoCombustivel("****Gasolina");
        objAlteracao.setPrecoDoCombustivel(8.65);
        objAlteracao.setRecomendacao("Sem recomendação");

        controller.alterar(objAlteracao);


        edtGasolina = findViewById(R.id.editGasolina);
        edtEtanol = findViewById(R.id.editEtanol);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        txtResultado = findViewById(R.id.txtResultado);

        //      imgImagem = findViewById(R.id.imgTeste);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;

                if (TextUtils.isEmpty(edtGasolina.getText())){
                    edtGasolina.setError("Obrigatorio");
                    edtGasolina.requestFocus();
                    isDadosOk = false;
                }

                if (TextUtils.isEmpty(edtEtanol.getText())){
                    edtEtanol.setError("Obrigatorio");
                    edtEtanol.requestFocus();
                    isDadosOk = false;
                }

                if (isDadosOk){

                    precoGasolina = Double.parseDouble(edtGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(edtEtanol.getText().toString());

                    Resultado = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(Resultado);

                    btnSalvar.setEnabled(true);

                }else{
                    Toast.makeText(GasEtaActivity.this, "Digite os dados obrigatórios", Toast.LENGTH_SHORT).show();
                    btnSalvar.setEnabled(false);
                }

                txtResultado.setText(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtGasolina.setText("");
                edtEtanol.setText("");

                btnSalvar.setEnabled(false);

                controller.limpar();

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));

                controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);


            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Volte sempre", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
