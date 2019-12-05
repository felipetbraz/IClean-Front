package com.ddm.iclean.dto;

import java.util.Date;

public class DtoOrdemServico {
    private Long id;
    private Date dataInclusao;
    private int avaliacaoCliente;
    private int avaliacaoPrestador;
    private Long clienteId;
    private Long enderecoId;
    private Long anuncioId;

    public DtoOrdemServico(Long id, Date dataInclusao,int avaliacaoCliente,
                           int avaliacaoPrestador, Long clienteId, Long enderecoId, Long anuncioId) {
        this.id = id;
        this.dataInclusao = dataInclusao;
        this.avaliacaoCliente = avaliacaoCliente;
        this.avaliacaoPrestador = avaliacaoPrestador;
        this.clienteId = clienteId;
        this.enderecoId = enderecoId;
        this.anuncioId = anuncioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public int getAvaliacaoCliente() {
        return avaliacaoCliente;
    }

    public void setAvaliacaoCliente(int avaliacaoCliente) {
        this.avaliacaoCliente = avaliacaoCliente;
    }

    public int getAvaliacaoPrestador() {
        return avaliacaoPrestador;
    }

    public void setAvaliacaoPrestador(int avaliacaoPrestador) {
        this.avaliacaoPrestador = avaliacaoPrestador;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Long getAnuncioId() {
        return anuncioId;
    }

    public void setAnuncioId(Long anuncioId) {
        this.anuncioId = anuncioId;
    }
}
