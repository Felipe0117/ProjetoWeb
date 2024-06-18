/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.bean;

/**
 *
 * @author Senai
 */
public class ProdutoDTO {
    private int idProduto;
    private String nome_produto;
    private String imagem;
    private float valor;
    private int categoriaId;
    private String descricao;
    private int estoque;

    public ProdutoDTO() {
    }

    public ProdutoDTO(int idProduto, String nome_produto, String imagem, float valor, int categoriaId, String descricao, int estoque) {
        this.idProduto = idProduto;
        this.nome_produto = nome_produto;
        this.imagem = imagem;
        this.valor = valor;
        this.categoriaId = categoriaId;
        this.descricao = descricao;
        this.estoque = estoque;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}