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
import mercadinho.bean.HistoricoDTO;

/**
 *
 * @author Senai
 */
public class HistoricoDAO {

    public void cadastrarHistorico(HistoricoDTO h) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO historico (nome_historico, valor_historico, imagem_historico, descricao_historico, quantidade_historico, produto_id4, usuario_id4) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, h.getNome_historico());
            stmt.setFloat(2, h.getValor_historico());
            stmt.setString(3, h.getImagem_historico());
            stmt.setString(4, h.getDescricao_historico());
            stmt.setInt(5, h.getQuantidade_historico());
            stmt.setInt(6, h.getProduto_id4());
            stmt.setInt(7, h.getUsuario_id4());
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HistoricoDTO> mostrarHistorico(int idUsuario) {
        List<HistoricoDTO> pedidos = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            System.out.println("Chegou mn");
            System.out.println(idUsuario);
            stmt = conexao.prepareStatement("SELECT * FROM historico WHERE usuario_id4 = ?");
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                HistoricoDTO objPedido = new HistoricoDTO();
                System.out.println("cheguei");
                objPedido.setId_pedidosProdutos(rs.getInt("id_pedido_produto"));
                objPedido.setNome_historico(rs.getString("nome_historico"));
                objPedido.setValor_historico(rs.getFloat("valor_historico"));
                objPedido.setImagem_historico(rs.getString("imagem_historico"));
                objPedido.setDescricao_historico(rs.getString("descricao_historico"));
                objPedido.setQuantidade_historico(rs.getInt("quantidade_historico"));
                objPedido.setProduto_id4(rs.getInt("produto_id4"));
                objPedido.setUsuario_id4(rs.getInt("usuario_id4"));
                pedidos.add(objPedido);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

}
