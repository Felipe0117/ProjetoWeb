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
public class PedidosProdutos {
   private int id_pedidosProdutos;
   private String nome_produtos_pedidos;
   private float valor_pedidos_produtos;
   private String imagem_pedidos_produtos;
   private String descricao_pedidos_produtos;
   private int quantidade_pedidos_produtos;
   private int produto_id4;
   private int usuario_id4;
   private int categoria_id4;
   private String nome_categoria;

    public PedidosProdutos() {
    }

    public PedidosProdutos(int id_pedidosProdutos, String nome_produtos_pedidos, float valor_pedidos_produtos, String imagem_pedidos_produtos, String descricao_pedidos_produtos, int quantidade_pedidos_produtos, int produto_id4, int usuario_id4, int categoria_id4, String nome_categoria) {
        this.id_pedidosProdutos = id_pedidosProdutos;
        this.nome_produtos_pedidos = nome_produtos_pedidos;
        this.valor_pedidos_produtos = valor_pedidos_produtos;
        this.imagem_pedidos_produtos = imagem_pedidos_produtos;
        this.descricao_pedidos_produtos = descricao_pedidos_produtos;
        this.quantidade_pedidos_produtos = quantidade_pedidos_produtos;
        this.produto_id4 = produto_id4;
        this.usuario_id4 = usuario_id4;
        this.categoria_id4 = categoria_id4;
        this.nome_categoria = nome_categoria;
    }

    public int getId_pedidosProdutos() {
        return id_pedidosProdutos;
    }

    public void setId_pedidosProdutos(int id_pedidosProdutos) {
        this.id_pedidosProdutos = id_pedidosProdutos;
    }

    public String getNome_produtos_pedidos() {
        return nome_produtos_pedidos;
    }

    public void setNome_produtos_pedidos(String nome_produtos_pedidos) {
        this.nome_produtos_pedidos = nome_produtos_pedidos;
    }

    public float getValor_pedidos_produtos() {
        return valor_pedidos_produtos;
    }

    public void setValor_pedidos_produtos(float valor_pedidos_produtos) {
        this.valor_pedidos_produtos = valor_pedidos_produtos;
    }

    public String getImagem_pedidos_produtos() {
        return imagem_pedidos_produtos;
    }

    public void setImagem_pedidos_produtos(String imagem_pedidos_produtos) {
        this.imagem_pedidos_produtos = imagem_pedidos_produtos;
    }

    public String getDescricao_pedidos_produtos() {
        return descricao_pedidos_produtos;
    }

    public void setDescricao_pedidos_produtos(String descricao_pedidos_produtos) {
        this.descricao_pedidos_produtos = descricao_pedidos_produtos;
    }

    public int getQuantidade_pedidos_produtos() {
        return quantidade_pedidos_produtos;
    }

    public void setQuantidade_pedidos_produtos(int quantidade_pedidos_produtos) {
        this.quantidade_pedidos_produtos = quantidade_pedidos_produtos;
    }

    public int getProduto_id4() {
        return produto_id4;
    }

    public void setProduto_id4(int produto_id4) {
        this.produto_id4 = produto_id4;
    }

    public int getUsuario_id4() {
        return usuario_id4;
    }

    public void setUsuario_id4(int usuario_id4) {
        this.usuario_id4 = usuario_id4;
    }

    public int getCategoria_id4() {
        return categoria_id4;
    }

    public void setCategoria_id4(int categoria_id4) {
        this.categoria_id4 = categoria_id4;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }
    
    
   
   

    
}
