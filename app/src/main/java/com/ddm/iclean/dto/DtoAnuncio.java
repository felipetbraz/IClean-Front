package com.ddm.iclean.dto;

public class DtoAnuncio {

    private String titulo;
    private String descricao;
    private Double preco;
    private Boolean status;
    private Long usuarioId;
    private Long especialidadeId;

    public DtoAnuncio(String titulo, String descricao, Double preco, Boolean status, Long usuarioId, Long especialidadeId) {
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
        this.usuarioId = usuarioId;
        this.especialidadeId = especialidadeId;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(Long especialidadeId) {
        this.especialidadeId = especialidadeId;
    }
}
