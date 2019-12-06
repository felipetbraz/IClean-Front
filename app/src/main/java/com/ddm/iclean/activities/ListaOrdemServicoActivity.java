package com.ddm.iclean.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
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
    List ordemServicos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ordem_servico);
        buscarOrdensServico();
    }

    public void buscarOrdensServico(){
        SharedPreferences sp = getSharedPreferences("dados", 0);
        String token = sp.getString("token", null);

        RetrofitService.getServico(this).buscaOrdemServicos(token).enqueue(new Callback<ResponseEntitity<DtoOrdemServico>>() {
            @Override
            public void onResponse(Call<ResponseEntitity<DtoOrdemServico>> call, Response<ResponseEntitity<DtoOrdemServico>> response) {
                if(response.body() == null) {
                    Toast.makeText(ListaOrdemServicoActivity.this, "não consegui buscar os anuncios", Toast.LENGTH_SHORT).show();
                    return;
                }

                ordemServicos.addAll(response.body().getContent());
                preencherRecyclerView();
            }

            @Override
            public void onFailure(Call<ResponseEntitity<DtoOrdemServico>> call, Throwable t) {

            }
        });
    }

    private void preencherRecyclerView() {
        RecyclerView recyclerView= findViewById(R.id.action_listar_orderm_servico);
        OrdemServicoAdapter ordemServicoAdapter = new OrdemServicoAdapter(this, ordemServicos);
        recyclerView.setAdapter(ordemServicoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
