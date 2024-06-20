/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mercadinho.bean.ProdutoDTO;


/**
 *
 * @author Senai
 */
public class ProdutosDAO {
    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoDTO> produtos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM produtos LIMIT 10");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome_produto(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setCategoriaId(rs.getInt("categoria_id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getString("imagem"));
                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return produtos;
    }
    
    public void create3(ProdutoDTO produto) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO produtos (nome, descricao, categoria_id, valor, imagem, estoque) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, produto.getNome_produto());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getCategoriaId());
            stmt.setFloat(4, produto.getValor());
            stmt.setString(5, produto.getImagem());
            stmt.setInt(6, produto.getEstoque());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public List<ProdutoDTO> buscaProdutos(String busca) {
        List<ProdutoDTO> resultadoBusca = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ? OR descricao LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                ProdutoDTO prod = new ProdutoDTO();
                prod.setIdProduto(rs.getInt("id_produto"));
                prod.setNome_produto(rs.getString("nome"));
                prod.setCategoriaId(rs.getInt("categoria_id"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getFloat("valor"));
                prod.setImagem(rs.getString("imagem"));
                
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }
    
    public List<ProdutoDTO> buscarProduto(int id_produto){
            List<ProdutoDTO> produto = new ArrayList<>();
            try{
                Connection conexao = Conexao.conectar();
                PreparedStatement stmt = null;
                ResultSet rs = null;
               
                stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE id_produto = ?");
                stmt.setInt(1, id_produto);
                rs = stmt.executeQuery();
                while (rs.next()){
                    ProdutoDTO produtos = new ProdutoDTO();
                    produtos.setIdProduto(rs.getInt("id_produto"));                    
                    produtos.setNome_produto(rs.getString("nome"));
                    produtos.setCategoriaId(rs.getInt("categoria_id"));
                    produtos.setDescricao(rs.getString("descricao"));
                    produtos.setValor(rs.getFloat("valor"));
                    produtos.setImagem(rs.getString("imagem"));
                    produto.add(produtos);
                }
                rs.close();
                stmt.close();
                conexao.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return produto;
        }
    
    public List<ProdutoDTO> buscaCategoria (int categoria) {
        List<ProdutoDTO> resultadoBusca = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE categoria_id = ?");
            stmt.setInt(1, categoria);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                ProdutoDTO prod = new ProdutoDTO();
                prod.setIdProduto(rs.getInt("id_produto"));
                prod.setNome_produto(rs.getString("nome"));
                prod.setCategoriaId(rs.getInt("categoria_id"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getFloat("valor"));
                prod.setImagem(rs.getString("imagem"));
                
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }
    
    public int verEstoque(int produtoId) {
    int estoque = 0;
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        stmt = conexao.prepareStatement("SELECT estoque FROM produtos WHERE id_produto = ?");
        stmt.setInt(1, produtoId);

        rs = stmt.executeQuery();
        if (rs.next()) {
            estoque = rs.getInt("estoque");
        }
       
        rs.close();
        stmt.close();
        conexao.close();
       
    } catch (SQLException e) {
        e.printStackTrace();
    }
   
    return estoque;
}

    public int retirarProduto(int quantUsuario, int produtoId){
   
    try{    
    Connection conexao = Conexao.conectar();
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
    stmt = conexao.prepareStatement("SELECT estoque FROM produtos WHERE id_produto = ?");
    stmt.setInt(1, produtoId);
    rs = stmt.executeQuery();
   
    if(rs.next()){
        int quantAtual = rs.getInt("estoque");
        System.out.println("quantidadeDesejada "+quantUsuario);
        System.out.println("quantidadeAtual "+quantAtual);
        if(quantAtual >= quantUsuario){
           
            int novaQuant = quantAtual - quantUsuario;
            System.out.println("chego aqui no deletarProdutoQuantidade "+ novaQuant);
        stmt = conexao.prepareStatement("UPDATE produtos SET estoque = ? WHERE id_produto = ?");
        stmt.setInt(1, novaQuant);
        stmt.setInt(2, produtoId);
        stmt.executeUpdate();
       
          rs.close();
        stmt.close();
        conexao.close();    
        quantAtual = 0;
        quantUsuario = 0;
        novaQuant = 0;
        }
       
    }
   
    } catch (SQLException e){
        e.printStackTrace();
    }
    return 0;
}
    
    public int aumentarProduto(int produtoId, int quantCarrinho){
    try{    
    Connection conexao = Conexao.conectar();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    stmt = conexao.prepareStatement("SELECT estoque FROM produtos WHERE id_produto = ?");
    stmt.setInt(1, produtoId);
    rs = stmt.executeQuery();
   
    if(rs.next()){
        int quantAtual = rs.getInt("quantidade");
       
            int novaQuant = quantAtual + quantCarrinho;

        stmt = conexao.prepareStatement("UPDATE produtos SET estoque = ? WHERE id_produto = ?");


        stmt.setInt(1, novaQuant);
        stmt.setInt(2, produtoId);
        stmt.executeUpdate();
       
        rs.close();
        stmt.close();
        conexao.close();      
        quantAtual = 0;
        quantCarrinho = 0;
        novaQuant = 0;
    }
   
    } catch (SQLException e){
        e.printStackTrace();
    }
return 0;
} 
    
}

