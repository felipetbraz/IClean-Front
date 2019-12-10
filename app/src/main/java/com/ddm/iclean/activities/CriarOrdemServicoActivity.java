package com.ddm.iclean.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoOrdemServico;
import com.ddm.iclean.services.RetrofitService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CriarOrdemServicoActivity extends AppCompatActivity {
    private static final String TAG = "CriarOrdemServicoActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_anuncio);
    }

    public void contratarOrdemServico() throws ParseException {
        SharedPreferences sp = getSharedPreferences("dados", 0);
        String token = sp.getString("token", null);
        long id = 2;

        String data = "20/10/2019";
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        Date dateEnv = formatter.parse(data);
        String status = "ABERTO";
        int avaliacaoCliente = 0;
        int avaliacaoPrestador = 0;
        long clienteId = 2;
        long enderecoId= 1;
        long anuncioId = 3;

        DtoOrdemServico dtoOrdemServico = new DtoOrdemServico(dateEnv, avaliacaoCliente, avaliacaoPrestador, clienteId, enderecoId, anuncioId);

        RetrofitService.getServico(this).criarOrdemServicos(dtoOrdemServico, token).enqueue(new Callback<DtoOrdemServico>(){

            @Override
            public void onResponse(Call<DtoOrdemServico> call, Response<DtoOrdemServico> response) {
                Toast.makeText(CriarOrdemServicoActivity.this, "Ordem servico cadastrado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DtoOrdemServico> call, Throwable t) {
                Log.d(TAG, "falhou ao cadastrar: "+t.getMessage());
            }
        });


    }
}
