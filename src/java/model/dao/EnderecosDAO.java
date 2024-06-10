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
import mercadinho.bean.EnderecoDTO;


/**
 *
 * @author Senai
 */
public class EnderecosDAO {
    public List<EnderecoDTO> read() {
        List<EnderecoDTO> enderecos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM enderecos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                EnderecoDTO endereco = new EnderecoDTO();
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
    
    public void create(EnderecoDTO endereco) {
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
    
}
