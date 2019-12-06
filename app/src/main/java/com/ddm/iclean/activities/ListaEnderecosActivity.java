package com.ddm.iclean.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoEndereco;
import com.ddm.iclean.entity.ResponseEntitity;
import com.ddm.iclean.helpers.EnderecoAdapter;
import com.ddm.iclean.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaEnderecosActivity extends AppCompatActivity {
    private static final String TAG = "ListaEnderecosActivity";
    List<DtoEndereco> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_enderecos);
        buscaDados();
    }

    private void preencherRecyclerview(){
        RecyclerView mRecyclerView = findViewById(R.id.rv_todos_enderecos);
        EnderecoAdapter mAdapter = new EnderecoAdapter(this, lista);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void buscaDados(){
        SharedPreferences sp = getSharedPreferences("dados", 0);
        String token = sp.getString("token", null);

        RetrofitService.getServico(this).todosEnderecos("Bearer "+token).enqueue(new Callback<ResponseEntitity<DtoEndereco>>() {
            @Override
            public void onResponse(Call<ResponseEntitity<DtoEndereco>> call, Response<ResponseEntitity<DtoEndereco>> response) {
                if(response.body() == null){
                    Toast.makeText(ListaEnderecosActivity.this,"Erro: Você ainda não logou",Toast.LENGTH_LONG).show();
                    return;
                }
                lista.clear();
                lista.addAll(response.body().getContent());
                preencherRecyclerview();
            }

            @Override
            public void onFailure(Call<ResponseEntitity<DtoEndereco>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
