/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinho.bean;

import java.sql.Date;

/**
 *
 * @author Senai
 */
public class HistoricoDTO {
   private int id_pedidosProdutos;
   private String nome_historico;
   private float valor_historico;
   private String imagem_historico;
   private String descricao_historico;
   private int quantidade_historico;
   private Date datapedido;
   private int produto_id4;
   private int usuario_id4;
   private int categoria_id4;
   private String nome_categoria;

    public HistoricoDTO() {
    }

    public HistoricoDTO(int id_pedidosProdutos, String nome_historico, float valor_historico, String imagem_historico, String descricao_historico, int quantidade_historico, Date datapedido, int produto_id4, int usuario_id4, int categoria_id4, String nome_categoria) {
        this.id_pedidosProdutos = id_pedidosProdutos;
        this.nome_historico = nome_historico;
        this.valor_historico = valor_historico;
        this.imagem_historico = imagem_historico;
        this.descricao_historico = descricao_historico;
        this.quantidade_historico = quantidade_historico;
        this.datapedido = datapedido;
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

    public String getNome_historico() {
        return nome_historico;
    }

    public void setNome_historico(String nome_historico) {
        this.nome_historico = nome_historico;
    }

    public float getValor_historico() {
        return valor_historico;
    }

    public void setValor_historico(float valor_historico) {
        this.valor_historico = valor_historico;
    }

    public String getImagem_historico() {
        return imagem_historico;
    }

    public void setImagem_historico(String imagem_historico) {
        this.imagem_historico = imagem_historico;
    }

    public String getDescricao_historico() {
        return descricao_historico;
    }

    public void setDescricao_historico(String descricao_historico) {
        this.descricao_historico = descricao_historico;
    }

    public int getQuantidade_historico() {
        return quantidade_historico;
    }

    public void setQuantidade_historico(int quantidade_historico) {
        this.quantidade_historico = quantidade_historico;
    }

    public Date getDatapedido() {
        return datapedido;
    }

    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
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
