package com.ddm.iclean.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoAnuncio;
import com.ddm.iclean.dto.DtoOrdemServico;
import com.ddm.iclean.entity.ResponseEntitity;
import com.ddm.iclean.helpers.AnuncioAdapter;
import com.ddm.iclean.helpers.OrdemServicoAdapter;
import com.ddm.iclean.services.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaOrdemServicoActivity extends AppCompatActivity {
    private static final String TAG = "ListaOrdemServicoActivity";
    List<DtoOrdemServico>  lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ordem_servico);
        buscarOrdensServico();
    }

    private void preencherRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.rv_todos_ordem);
        OrdemServicoAdapter mAdapter = new OrdemServicoAdapter(this, lista);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void buscarOrdensServico(){
        SharedPreferences sp = getSharedPreferences("dados", 0);
        String token = sp.getString("token", null);

        RetrofitService.getServico(this).buscaOrdemServicos(token).enqueue(new Callback<List<DtoOrdemServico>>() {
            @Override
            public void onResponse(Call<List<DtoOrdemServico>> call, Response<List<DtoOrdemServico>> response) {
                if(response.body() == null) {
                    Toast.makeText(ListaOrdemServicoActivity.this, "não consegui buscar as ordem de servico", Toast.LENGTH_SHORT).show();
                    return;
                }

                lista.clear();
                lista.addAll(response.body());
                preencherRecyclerView();
            }

            @Override
            public void onFailure(Call<List<DtoOrdemServico>> call, Throwable t) {
                Toast.makeText(ListaOrdemServicoActivity.this, "erro", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}
