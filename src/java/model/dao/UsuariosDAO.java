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
import mercadinho.bean.UsuarioDTO;


/**
 *
 * @author Senai
 */
public class UsuariosDAO {
    public List<UsuarioDTO> read2() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM usuarios");
            rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome_usuario(rs.getString("nome"));
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
    
    public int validaUser(UsuarioDTO user) {
        int idUsuario = 0;
        try {
            Connection con = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = con.prepareStatement("SELECT id_usuario FROM usuarios WHERE usuario = ? AND senha = ?");
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                idUsuario = rs.getInt("id_usuario");            }
            
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return idUsuario;
    }
    
    public void create2(UsuarioDTO usuario) {
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
    
    public UsuarioDTO leia(int idUsuarioCookie) {
        UsuarioDTO objUsuario = new UsuarioDTO();
       int idUsuario = 0;
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuarios WHERE id_usuario = ?");
            stmt.setInt(1, idUsuarioCookie);
            rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("aquii id cookie usuario");
                System.out.println(idUsuario = rs.getInt("id_usuario"));

                objUsuario.setId_usuario(rs.getInt("id_usuario"));
                objUsuario.setNome_usuario(rs.getString("nome"));
                objUsuario.setUsuario(rs.getString("usuario"));
                objUsuario.setSenha(rs.getString("senha"));
                objUsuario.setTelefone(rs.getString("telefone"));
                objUsuario.setCpf(rs.getString("cpf"));

            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objUsuario;
    }
}
