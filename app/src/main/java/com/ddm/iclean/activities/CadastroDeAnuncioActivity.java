package com.ddm.iclean.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoAnuncio;
import com.ddm.iclean.dto.DtoUser;
import com.ddm.iclean.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroDeAnuncioActivity extends AppCompatActivity {
    private static final String TAG = "CadastroDeAnuncioActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_anuncio);
    }

    public void CadastrarAnuncio(View view) {
        String titulo = ((EditText) findViewById(R.id.et_cadastro_anuncio_titulo)).getText().toString();
        String descricao = ((EditText) findViewById(R.id.et_cadastro_anuncio_descricao)).getText().toString();
        Double preco =Double.valueOf(((EditText) findViewById(R.id.et_cadastro_anuncio_preco)).getText().toString());
        Long asdf = Long.valueOf("1");
        SharedPreferences sp = getSharedPreferences("dados", 0);
        String token = sp.getString("token", null);
        Long id = sp.getLong("id", asdf);
        DtoAnuncio dtoAnuncio = new DtoAnuncio(titulo,descricao,preco,true,id,asdf);

        RetrofitService.getServico(this).cadastraAnuncio(dtoAnuncio,token).enqueue(new Callback<DtoAnuncio>() {
            @Override
            public void onResponse(Call<DtoAnuncio> call, Response<DtoAnuncio> response) {
                Toast.makeText(CadastroDeAnuncioActivity.this, "Anuncio cadastrado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DtoAnuncio> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
