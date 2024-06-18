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
public class CarrinhoDTO {
    private int id_carrinho;
    private String nomeCarrinho;
    private float valorCarrinho;
    private String imagemCarrinho ;
    private String descricaoCarrinho;
    private int quantidadeCarrinho;
    private int produtoId3;
    private float total;
    private int usuarioId3;

    public CarrinhoDTO() {
    }

    public CarrinhoDTO(int id_carrinho, String nomeCarrinho, float valorCarrinho, String imagemCarrinho, String descricaoCarrinho, int quantidadeCarrinho, int produtoId3, float total, int usuarioId3) {
        this.id_carrinho = id_carrinho;
        this.nomeCarrinho = nomeCarrinho;
        this.valorCarrinho = valorCarrinho;
        this.imagemCarrinho = imagemCarrinho;
        this.descricaoCarrinho = descricaoCarrinho;
        this.quantidadeCarrinho = quantidadeCarrinho;
        this.produtoId3 = produtoId3;
        this.total = total;
        this.usuarioId3 = usuarioId3;
    }

    public int getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(int id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public String getNomeCarrinho() {
        return nomeCarrinho;
    }

    public void setNomeCarrinho(String nomeCarrinho) {
        this.nomeCarrinho = nomeCarrinho;
    }

    public float getValorCarrinho() {
        return valorCarrinho;
    }

    public void setValorCarrinho(float valorCarrinho) {
        this.valorCarrinho = valorCarrinho;
    }

    public String getImagemCarrinho() {
        return imagemCarrinho;
    }

    public void setImagemCarrinho(String imagemCarrinho) {
        this.imagemCarrinho = imagemCarrinho;
    }

    public String getDescricaoCarrinho() {
        return descricaoCarrinho;
    }

    public void setDescricaoCarrinho(String descricaoCarrinho) {
        this.descricaoCarrinho = descricaoCarrinho;
    }

    public int getQuantidadeCarrinho() {
        return quantidadeCarrinho;
    }

    public void setQuantidadeCarrinho(int quantidadeCarrinho) {
        this.quantidadeCarrinho = quantidadeCarrinho;
    }

    public int getProdutoId3() {
        return produtoId3;
    }

    public void setProdutoId3(int produtoId3) {
        this.produtoId3 = produtoId3;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public int getUsuarioId3() {
        return usuarioId3;
    }

    public void setUsuarioId3(int usuarioId3) {
        this.usuarioId3 = usuarioId3;
    }

    
}