package com.ddm.iclean.dto;

import java.util.Date;

public class DtoOrdemServico {
    private long id;
    private Date dataInclusao;
    private int avaliacaoCliente;
    private int avaliacaoPrestador;
    private String status;
    private long clienteId;
    private long enderecoId;
    private long anuncioId;

    public DtoOrdemServico(long id, String status ,Date dataInclusao,int avaliacaoCliente,
                           int avaliacaoPrestador, long clienteId, long enderecoId, long anuncioId) {
        super();
        this.id = id;
        this.status = status;
        this.dataInclusao = dataInclusao;
        this.avaliacaoCliente = avaliacaoCliente;
        this.avaliacaoPrestador = avaliacaoPrestador;
        this.clienteId = clienteId;
        this.enderecoId = enderecoId;
        this.anuncioId = anuncioId;
    }


    public DtoOrdemServico(Date dateEnv, int avaliacaoCliente, int avaliacaoPrestador, long clienteId, long enderecoId, long anuncioId) {
        super();
        this.dataInclusao = dataInclusao;
        this.avaliacaoCliente = this.avaliacaoCliente;
        this.avaliacaoPrestador = this.avaliacaoPrestador;
        this.clienteId = this.clienteId;
        this.enderecoId = this.enderecoId;
        this.anuncioId = this.anuncioId;
    }

    public String getStatus() {return status;};

    public void setStatus(String status){this.status = status;};

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
