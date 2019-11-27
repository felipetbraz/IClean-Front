package com.ddm.iclean.activities;

import android.content.Intent;
import android.os.Bundle;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoAnuncio;
import com.ddm.iclean.entity.ResponseEntitity;
import com.ddm.iclean.helpers.AnuncioAdapter;
import com.ddm.iclean.services.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<DtoAnuncio> anuncios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buscarAnuncios();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(item.getItemId()){
            case R.id.action_alteracao_usuario:
                startActivity(new Intent(this, AlteracaoUsuarioActivity.class));
                return true;
            case R.id.action_cadastro_de_usuario:
                startActivity(new Intent(this, CadastroDeUsuarioActivity.class));
                return true;
            case R.id.action_excluir_usuario:
                startActivity(new Intent(this, ExcluirUsuarioActivity.class));
                return true;
            case R.id.action_lista_usuarios:
                startActivity(new Intent(this, ListaUsuariosActivity.class));
                return true;
            case R.id.action_login:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void buscarAnuncios(){
        RetrofitService.getServico(this).buscarAnuncios().enqueue(new Callback<ResponseEntitity<DtoAnuncio>>() {
            @Override
            public void onResponse(Call<ResponseEntitity<DtoAnuncio>> call, Response<ResponseEntitity<DtoAnuncio>> response) {
                if(response.body() == null) {
                    Toast.makeText(MainActivity.this, "não consegui buscar os anuncios", Toast.LENGTH_SHORT).show();
                    return;
                }

                anuncios.addAll(response.body().getContent());
                preencherRecyclerView();
            }

            @Override
            public void onFailure(Call<ResponseEntitity<DtoAnuncio>> call, Throwable t) {

            }
        });
    }

    private void preencherRecyclerView() {
        RecyclerView recyclerView= findViewById(R.id.rv_todos_anuncios);
        AnuncioAdapter anuncioAdapter = new AnuncioAdapter(this, anuncios);
        recyclerView.setAdapter(anuncioAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
