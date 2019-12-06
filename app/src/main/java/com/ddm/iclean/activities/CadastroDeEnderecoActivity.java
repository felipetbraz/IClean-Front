package com.ddm.iclean.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoEndereco;
import com.ddm.iclean.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroDeEnderecoActivity extends AppCompatActivity {
    private static final String TAG = "CadastroDeEnderecoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_endereco);
    }

    public void CadastrarEndereco(View view) {
        String logradouro = ((EditText) findViewById(R.id.et_cadastro_endereco_logradouro)).getText().toString();
        Integer numero = Integer.valueOf(((EditText) findViewById(R.id.et_cadastro_endereco_numero)).getText().toString());
        String complemento = ((EditText) findViewById(R.id.et_cadastro_endereco_complemento)).getText().toString();
        String cidade = ((EditText) findViewById(R.id.et_cadastro_endereco_cidade)).getText().toString();
        String estado = ((EditText) findViewById(R.id.et_cadastro_endereco_estado)).getText().toString();
        String cep = ((EditText) findViewById(R.id.et_cadastro_endereco_cep)).getText().toString();

        SharedPreferences sp = getSharedPreferences("dados", 0);
        String token = sp.getString("token", null);
        Long id = sp.getLong("id", -1);

        DtoEndereco dtoEndereco = new DtoEndereco(logradouro, numero, complemento, cidade, estado, cep, id);

        RetrofitService.getServico(this).cadastraEndereco(dtoEndereco, token).enqueue(new Callback<DtoEndereco>() {
            @Override
            public void onResponse(Call<DtoEndereco> call, Response<DtoEndereco> response) {
                if(response.body() == null){
                    Toast.makeText(CadastroDeEnderecoActivity.this, "Erro", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(CadastroDeEnderecoActivity.this, "Endereco cadastrado", Toast.LENGTH_LONG).show();
                startActivity(new Intent(CadastroDeEnderecoActivity.this, MainActivity.class));
            }

            @Override
            public void onFailure(Call<DtoEndereco> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
