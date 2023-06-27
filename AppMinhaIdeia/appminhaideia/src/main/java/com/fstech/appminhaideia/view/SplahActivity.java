package com.fstech.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.fstech.appminhaideia.R;
import com.fstech.appminhaideia.controller.ClienteController;
import com.fstech.appminhaideia.api.AppUtil;
import com.fstech.appminhaideia.model.Cliente;

public class SplahActivity extends AppCompatActivity {



    TextView txtAppVersion;
    int tempoDeEspera = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);

        Log.d(AppUtil.TAG,"onCreate: Tela Splash carregada ...");

        txtAppVersion = findViewById(R.id.txtAppVersion);



        txtAppVersion.setText(AppUtil.versaoDoAplicativoa());

        trocarTela();


    }

    private void trocarTela() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                Intent trocarDeTela = new Intent(SplahActivity.this,MainActivity.class);

                Bundle  bundle = new Bundle();
                bundle.putString("nome","Fabricio SA");
                bundle.putString("email","teste");

                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                finish();

            }
        },tempoDeEspera);



    }

}