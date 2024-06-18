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
public class PedidoDTO {
    private int id_pedido;
    private int endereco_id;
    private int usuario_id;
    private String status_entrega;
    private String metodo_Pagamento;
    private float valorTotal;
    private Date data_hora;

    public PedidoDTO() {
    }

    public PedidoDTO(int id_pedido, int endereco_id, int usuario_id, String status_entrega, String metodo_Pagamento, float valorTotal, Date data_hora) {
        this.id_pedido = id_pedido;
        this.endereco_id = endereco_id;
        this.usuario_id = usuario_id;
        this.status_entrega = status_entrega;
        this.metodo_Pagamento = metodo_Pagamento;
        this.valorTotal = valorTotal;
        this.data_hora = data_hora;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(int endereco_id) {
        this.endereco_id = endereco_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getStatus_entrega() {
        return status_entrega;
    }

    public void setStatus_entrega(String status_entrega) {
        this.status_entrega = status_entrega;
    }

    public String getMetodo_Pagamento() {
        return metodo_Pagamento;
    }

    public void setMetodo_Pagamento(String metodo_Pagamento) {
        this.metodo_Pagamento = metodo_Pagamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }
    
    
    
}
