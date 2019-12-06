package com.ddm.iclean.services;

import com.ddm.iclean.dto.DtoAnuncio;
import com.ddm.iclean.dto.DtoLogin;
import com.ddm.iclean.dto.DtoOrdemServico;
import com.ddm.iclean.dto.DtoUser;
import com.ddm.iclean.entity.ResponseEntitity;

import java.util.List;

import kotlin.ParameterName;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InterfaceDeServicos {

    @POST("/usuarios")
    Call<DtoUser> cadastraUsuario(@Body DtoUser dtoUser);

    @POST("/auth/login")
    Call<DtoLogin> login(@Body DtoLogin dtoLogin);

    @GET("/usuarios")
    Call<List<DtoUser>> todosUsuarios(@Header("Authorization") String authorization);

    @PUT("/usuarios/{id}")
    Call<DtoUser> alteraUsuario(@Body DtoUser user, @Path("id") int id, @Header("Authorization") String authorization);

    @DELETE("/usuarios/{id}")
    Call<Void> excluirUsuario(@Path("id") int id, @Header("Authorization") String token);

    @GET("/anuncios")
    Call<ResponseEntitity<DtoAnuncio>> buscarAnuncios();

    @GET("/anuncios/titulo")
    Call<ResponseEntitity<DtoAnuncio>> buscarAnunciosPalavra(@Query("palavra") String palavra);

    @POST("/anuncios")
    Call<DtoAnuncio> cadastraAnuncio(@Body DtoAnuncio dtoAnuncio, @Header("Authorization") String token);

    @GET("/ordensServicos")
    Call<ResponseEntitity<DtoOrdemServico>> buscaOrdemServicos(@Header("Authorization") String token);

    @POST("/ordensServicos")
    Call<DtoOrdemServico> criarOrdemServicos(@Body DtoOrdemServico dtoOrdemServico, @Header("Authorization") String token);
}