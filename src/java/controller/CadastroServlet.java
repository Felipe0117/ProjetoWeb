/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mercadinho.bean.UsuarioDTO;
import model.dao.UsuariosDAO;

/**
 *
 * @author Senai
 */
@WebServlet(name = "CadastroServlet", urlPatterns = {"/Cadastro", "/cadastrar"})
public class CadastroServlet extends HttpServlet {
    UsuarioDTO usuario = new UsuarioDTO();
    UsuariosDAO usuarios = new UsuariosDAO();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/TelaCadastro.jsp";
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/cadastrar")) {
            user(request, response);
        } else {
            processRequest(request, response);
        }
    }
    
    protected void user(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        usuario.setNome_usuario(request.getParameter("nome_usuario"));//a variável Nome_usuario receberá o conteúdo do input "nome_usuario"
        usuario.setSenha(request.getParameter("senha"));
        usuario.setUsuario(request.getParameter("user"));
        usuario.setTelefone(request.getParameter("telefone"));
        usuario.setData_nascimento(Date.valueOf(request.getParameter("data_nascimento")));
        usuario.setCpf(request.getParameter("cpf"));
        
        
       
        if (usuario.getNome_usuario().trim().equals("")//função que impede que algum dos valores do cadastro seja nulo
                || usuario.getSenha().trim().equals("")
                || usuario.getUsuario().trim().equals("")
                || usuario.getCpf().trim().equals("")
                || usuario.getTelefone().trim().equals("")) {
            out.println("<script type=\"text/javascript\">");//código destinado a printar um aviso na tela o usuário
            out.println("alert('Por favor, preencha todos os campos.');");
            out.println("window.location.href = './CadastroServlet';");
            out.println("</script>");
        } else {
            System.out.println("...");
            usuarios.create2(usuario);
            response.sendRedirect("./Login");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
