/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.bean;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author Senai
 */
public class Mercadinho {
    private int idCategoria;
    private String nome;
    ////////////////////////////////////////
    private int id_endereco;
    private int usuario_id1;
    private String rua;
    private int numero;
    private String cep;
    private String complemento;
    /////////////////////////////////////
    private int id_estoque;
    private int produto_id2;
    private int quantidad_estoque;
    ///////////////////////////////////////
    private int id_pedido;
    private int usuario_id2;
    private int usuario_id;
    private String status_pagamento;
    private String metodo_Pagamento;
    private float valorTotal;
    private Date data_hora;
    ///////////////////////////////////
    private int id_pedido_produto;
    private int pedido_id;
    private int produto_id;
    private float preco_unitario;
    /////////////////////////////////////////
    private int idProduto;
    private String nome_produto;
    private byte[] imagem;
    private Blob imgBlob;
    private float valor;
    private int categoriaId;
    private String descricao;
    //////////////////////////////////////
    private int id_usuario;
    private String nome_usuario;
    private String senha;
    private String usuario;
    private String telefone;
    private Date data_nascimento;
    private String cpf;

    public Mercadinho() {
    }

    public Mercadinho(int idCategoria, String nome, int id_endereco, int usuario_id1, String rua, int numero, String cep, String complemento, int id_estoque, int produto_id2, int quantidad_estoque, int id_pedido, int usuario_id2, int usuario_id, String status_pagamento, String metodo_Pagamento, float valorTotal, Date data_hora, int id_pedido_produto, int pedido_id, int produto_id, float preco_unitario, int idProduto, String nome_produto, byte[] imagem, Blob imgBlob, float valor, int categoriaId, int id_usuario, String nome_usuario, String senha, String usuario, String telefone, Date data_nascimento, String cpf, String descricao) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.id_endereco = id_endereco;
        this.usuario_id1 = usuario_id1;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.id_estoque = id_estoque;
        this.produto_id2 = produto_id2;
        this.quantidad_estoque = quantidad_estoque;
        this.id_pedido = id_pedido;
        this.usuario_id2 = usuario_id2;
        this.usuario_id = usuario_id;
        this.status_pagamento = status_pagamento;
        this.metodo_Pagamento = metodo_Pagamento;
        this.valorTotal = valorTotal;
        this.data_hora = data_hora;
        this.id_pedido_produto = id_pedido_produto;
        this.pedido_id = pedido_id;
        this.produto_id = produto_id;
        this.preco_unitario = preco_unitario;
        this.idProduto = idProduto;
        this.nome_produto = nome_produto;
        this.imagem = imagem;
        this.imgBlob = imgBlob;
        this.valor = valor;
        this.categoriaId = categoriaId;
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.senha = senha;
        this.usuario = usuario;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.descricao = descricao;
        
        
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getUsuario_id1() {
        return usuario_id1;
    }

    public void setUsuario_id1(int usuario_id1) {
        this.usuario_id1 = usuario_id1;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    public int getProduto_id2() {
        return produto_id2;
    }

    public void setProduto_id2(int produto_id2) {
        this.produto_id2 = produto_id2;
    }

    public int getQuantidad_estoque() {
        return quantidad_estoque;
    }

    public void setQuantidad_estoque(int quantidad_estoque) {
        this.quantidad_estoque = quantidad_estoque;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getUsuario_id2() {
        return usuario_id2;
    }

    public void setUsuario_id2(int usuario_id2) {
        this.usuario_id2 = usuario_id2;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(String status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public String getMetodo_Pagamento() {
        return metodo_Pagamento;
    }

    public void setMetodo_Pagamento(String metodo_Pagamento) {
        this.metodo_Pagamento = metodo_Pagamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public int getId_pedido_produto() {
        return id_pedido_produto;
    }

    public void setId_pedido_produto(int id_pedido_produto) {
        this.id_pedido_produto = id_pedido_produto;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Blob getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(Blob imgBlob) {
        this.imgBlob = imgBlob;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
       
}
