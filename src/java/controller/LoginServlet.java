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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mercadinho.bean.UsuarioDTO;
import model.dao.UsuariosDAO;

/**
 *
 * @author Senai
 */
public class LoginServlet extends HttpServlet {
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
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarCookie")) {

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
            }
        }

        
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
        int idUsuario = usuarios.validaUser(usuario);
        if (usuario.getUsuario().trim().equals("") || usuario.getSenha().trim().equals("")) {
            tout.println("<script type=\"text/javascript\">");
            tout.println("alert('Por favor, preencha todos os campos.');");
            tout.println("window.location.href = './Login';");
            tout.println("</script>");
            }
           if (idUsuario > 0) {
                System.out.println("primeiro:"+idUsuario);
                Cookie cookie = new Cookie("continuarCookie", Integer.toString(idUsuario));
                response.addCookie(cookie);
                if (idUsuario == 1) {
                    response.sendRedirect("./cadastrar-produto");
                } else {
                    response.sendRedirect("./Home");
                }
            } else {
                tout.println("<script type=\"text/javascript\">");
                tout.println("alert('login não encontrado.');");
                tout.println("window.location.href = './Login';");
                tout.println("</script>");
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
