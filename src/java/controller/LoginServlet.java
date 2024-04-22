/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mercadinho.bean.Mercadinho;
import model.dao.MercadinhoDAO;

/**
 *
 * @author Senai
 */
public class LoginServlet extends HttpServlet {
    Mercadinho usuario = new Mercadinho();
    MercadinhoDAO usuarios = new MercadinhoDAO();


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
        MercadinhoDAO usuarios= new MercadinhoDAO();
        List<Mercadinho> usuario = usuarios.read2();
        
        request.setAttribute("usuarios", usuario);
        
        
        String nextPage = "/WEB-INF/jsp/TelaLogin.jsp";
        
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
        String url = request.getServletPath();
       if(url.equals("/logar")){
           entrar(request,response);
       }else{
               processRequest(request,response);
               }
           
            
    }
    
    protected void entrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setSenha(request.getParameter("senha"));
        PrintWriter tout = response.getWriter();
        
        if (usuario.getUsuario().trim().equals("") || usuario.getSenha().trim().equals("")) {
            tout.println("<script type=\"text/javascript\">");
            tout.println("alert('Por favor, preencha todos os campos.');");
            tout.println("window.location.href = './Login';");
            tout.println("</script>");
           
           
        } else {
            Mercadinho user = usuarios.validaUser(usuario);
            if(user.getId_usuario()> 0) {
                response.sendRedirect("./Home");
            } else {
                 tout.println("<script type=\"text/javascript\">");
            tout.println("alert('Login ou senha incorretos!.');");
            tout.println("window.location.href = './Login';");
            tout.println("</script>");
            }

        }
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
        processRequest(request, response);
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
