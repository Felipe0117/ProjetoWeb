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
public class EnderecoDTO {
    private int id_endereco;
    private int usuario_id1;
    private String rua;
    private int numero;
    private String cep;
    private String complemento;

    public EnderecoDTO() {
    }

    public EnderecoDTO(int id_endereco, int usuario_id1, String rua, int numero, String cep, String complemento) {
        this.id_endereco = id_endereco;
        this.usuario_id1 = usuario_id1;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getUsuario_id1() {
        return usuario_id1;
    }

    public void setUsuario_id1(int usuario_id1) {
        this.usuario_id1 = usuario_id1;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
    
}
