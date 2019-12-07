package com.ddm.iclean.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoOrdemServico;
import com.ddm.iclean.services.RetrofitService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public void contratarOrdemServico(View view) {
        SharedPreferences sp = getSharedPreferences("dados", 0);
        String token = sp.getString("token", null);
        Long id = sp.getLong("id", Long.valueOf("1"));

        Date currentTime = Calendar.getInstance().getTime();
        DateFormat df = new DateFormat();
        

        DtoOrdemServico dtoOrdemServico = new DtoOrdemServico( currentTime ,0,0,Long.valueOf("1"),Long.valueOf("1"),Long.valueOf("1"));

        RetrofitService.getServico(this).criarOrdemServicos(dtoOrdemServico,token).enqueue(new Callback<DtoOrdemServico>() {
            @Override
            public void onResponse(Call<DtoOrdemServico> call, Response<DtoOrdemServico> response) {
                System.out.println("deu bom");
            }

            @Override
            public void onFailure(Call<DtoOrdemServico> call, Throwable t) {
                System.out.println("Deu ruim");
            }
        });
    }
}
