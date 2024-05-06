/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mercadinho.bean.Mercadinho;

/**
 *
 * @author Senai
 */
public class MercadinhoDAO {
    public List<Mercadinho> read() {
        List<Mercadinho> enderecos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM enderecos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Mercadinho endereco = new Mercadinho();
                endereco.setId_endereco(rs.getInt("id_endereco"));
                endereco.setUsuario_id1(rs.getInt("usuario_id1"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setCep(rs.getString("cep"));
                endereco.setComplemento(rs.getString("complemento"));
                enderecos.add(endereco);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return enderecos;
    }
    
    public void create(Mercadinho endereco) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO enderecos (rua, numero, cep, complemento) VALUES (?, ?, ?, ?)");
            stmt.setString(1, endereco.getRua());
            stmt.setInt(2, endereco.getNumero());
            stmt.setString(3, endereco.getCep());
            stmt.setString(4, endereco.getComplemento());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public List<Mercadinho> read2() {
        List<Mercadinho> usuarios = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM usuarios");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Mercadinho usuario = new Mercadinho();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome_usuario(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setData_nascimento(rs.getDate("data_nascimento"));
                usuario.setCpf(rs.getString("cpf"));
                usuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return usuarios;
    }
    
    public Mercadinho validaUser(Mercadinho user) {
        Mercadinho usuarioValido = new Mercadinho();
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND senha = ?");
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                usuarioValido.setId_usuario(rs.getInt("id_usuario"));
                System.out.println("DAO: " + usuarioValido.getId_usuario());
            }
            
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            usuarioValido.setId_usuario(0);
            usuarioValido.setUsuario("");
            usuarioValido.setSenha("");
        }
        return usuarioValido;
    }
 
     public void create2(Mercadinho usuario) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO usuarios (nome, senha, usuario, telefone, data_nascimento, cpf) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getUsuario());
            stmt.setString(4, usuario.getTelefone());
            stmt.setDate(5, usuario.getData_nascimento());
            stmt.setString(6, usuario.getCpf());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
     
     public List<Mercadinho> listarProdutos() {
        List<Mercadinho> produtos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM produtos LIMIT 10");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Mercadinho produto = new Mercadinho();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setImgBlob(rs.getBlob("imagem"));
                Blob blob = rs.getBlob("imagem");
                produto.setValor(rs.getFloat("valor"));
                produto.setCategoriaId(rs.getInt("categoriaId"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagem(rs.getBytes("imagem"));
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
     
    public void create3(Mercadinho produto) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO produtos (nome, descricao, categoria_id, valor, imagem) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, produto.getNome_produto());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getCategoriaId());
            stmt.setFloat(4, produto.getValor());
            stmt.setBytes(5, produto.getImagem());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public List<Mercadinho> buscaProdutos(String busca) {
        List<Mercadinho> resultadoBusca = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ? OR descricao LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Mercadinho prod = new Mercadinho();
                prod.setIdProduto(rs.getInt("id_produto"));
                prod.setNome(rs.getString("nome"));
                prod.setCategoriaId(rs.getInt("categoria_id"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setValor(rs.getFloat("valor"));
                prod.setImagem(rs.getBytes("imagem"));
                
                resultadoBusca.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultadoBusca;
    }
    
    public List<Mercadinho> listarCategorias() {
        List<Mercadinho> categorias = new ArrayList();
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM categorias");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Mercadinho categoriaAtual = new Mercadinho();
                categoriaAtual.setIdCategoria(rs.getInt("id_categoria"));
                categoriaAtual.setNome(rs.getString("nome"));
                
                categorias.add(categoriaAtual);
            }
        } catch(SQLException e) {
            
        }
        
        return categorias;
    }
    
}
