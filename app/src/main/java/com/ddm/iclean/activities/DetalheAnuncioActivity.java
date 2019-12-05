package com.ddm.iclean.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoUser;
import com.ddm.iclean.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalheAnuncioActivity extends AppCompatActivity {
    private static final String TAG = "DetalheAnuncioActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_anuncio);
        Intent intent = getIntent();

        int nome = intent.getIntExtra("id",-1);
        Double preco = intent.getDoubleExtra("preco",1.1);
        String titulo = intent.getStringExtra("titulo");
        String descricao = intent.getStringExtra("descricao");

        ((TextView)findViewById(R.id.descricaoAnuncio)).setText("descrição: "+descricao);
        ((TextView)findViewById(R.id.precoAnuncio)).setText("Preço: "+preco);
        ((TextView)findViewById(R.id.tituloAnuncio)).setText(titulo+"");
    }
}
