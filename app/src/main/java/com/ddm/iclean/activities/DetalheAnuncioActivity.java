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
        setContentView(R.layout.activity_cadastro_de_usuario);
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String cpf = intent.getStringExtra("cpf");
        String email = intent.getStringExtra("email");
    }

    public void Cadastrar(View view){
        String nome = ((EditText) findViewById(R.id.et_cadastro_usuario_nome)).getText().toString();
        String cpf = ((EditText) findViewById(R.id.et_cadastro_usuario_cpf)).getText().toString();
        String email = ((EditText) findViewById(R.id.et_cadastro_usuario_email)).getText().toString();
        String senha = ((EditText) findViewById(R.id.et_cadastro_usuario_senha)).getText().toString();
        DtoUser dtoUser;
        if(senha.isEmpty())
            dtoUser = new DtoUser(nome, cpf, email);
        else
            dtoUser = new DtoUser(nome, cpf, senha, email);
        String token = getToken();

    }

    private String getToken(){
        SharedPreferences sp = getSharedPreferences("dados", 0);
        return sp.getString("token", null);
    }
}
