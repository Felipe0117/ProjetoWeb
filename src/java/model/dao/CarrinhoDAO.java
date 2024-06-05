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
import mercadinho.bean.CarrinhoDTO;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {
    public List<CarrinhoDTO> leia() {
        List<CarrinhoDTO> Carrinho = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("SELECT * FROM carrinho");
         rs = stmt.executeQuery();
         while(rs.next()){
             CarrinhoDTO objCarrinho = new CarrinhoDTO();
             objCarrinho.setId_carrinho(rs.getInt("id_carrinho"));
             objCarrinho.setNomeCarrinho(rs.getString("nome_produto_carrinho"));
             objCarrinho.setValorCarrinho(rs.getFloat("valor_produto_carrinho"));
             objCarrinho.setImagemCarrinho(rs.getString("imagem_produto_carrinho"));
             objCarrinho.setDescricaoCarrinho(rs.getString("descricao_produto_carrinho"));
             objCarrinho.setQuantidadeCarrinho(rs.getInt("quantidadecarrinho"));
             objCarrinho.setProdutoId3(rs.getInt("produto_id3"));
      //       objCarrinho.setUsuarioId3(rs.getInt("usuario_id3"));
             Carrinho.add(objCarrinho);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }  
        return Carrinho;
    }
    public void cadastrarCarrinho(CarrinhoDTO c){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
         //            stmt = conexao.prepareStatement("INSERT INTO carrinho (nome_produto_carrinho, valor_produto_carrinho, imagem_produto_carrinho, descricao_produto_carrinho, quantidade_carrinho, produto_id3, usuario_id3) VALUES (?,?,?,?,?,?,?)");  
            stmt = conexao.prepareStatement("INSERT INTO carrinho (nome_produto_carrinho, valor_produto_carrinho, imagem_produto_carrinho, descricao_produto_carrinho, quantidadecarrinho, produto_id3) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, c.getNomeCarrinho());
            stmt.setFloat(2, c.getValorCarrinho());
            stmt.setString(3, c.getImagemCarrinho());
            stmt.setString(4, c.getDescricaoCarrinho());
            stmt.setInt(5, c.getQuantidadeCarrinho());
            stmt.setInt(6, c.getProdutoId3());
          //  stmt.setInt(7, c.getUsuarioId3());
            stmt.executeUpdate();
           
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //  Luan me passou e explicou o codigo
         public List<CarrinhoDTO> leiaTotal() {
        List<CarrinhoDTO> Carrinho = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("SELECT SUM(p.valor * c.quantidadecarrinho) AS total FROM produtos p INNER JOIN carrinho c ON p.id_produto = c.produto_id3");
         rs = stmt.executeQuery();
         if(rs.next()){
             CarrinhoDTO objCarrinho = new CarrinhoDTO();
             objCarrinho.setTotal(rs.getFloat("total"));
             Carrinho.add(objCarrinho);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }  
        return Carrinho;
    }
}
