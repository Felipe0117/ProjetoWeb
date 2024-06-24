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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mercadinho.bean.CategoriaDTO;
import mercadinho.bean.HistoricoDTO;
import mercadinho.bean.UsuarioDTO;
import model.dao.CategoriasDAO;
import model.dao.HistoricoDAO;
import model.dao.UsuariosDAO;

/**
 *
 * @author felip
 */
@MultipartConfig
public class DadosServlet extends HttpServlet {

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
        UsuarioDTO usuario = new UsuarioDTO();
        UsuariosDAO usuarios = new UsuariosDAO();
        CategoriasDAO mercadinhoDao = new CategoriasDAO();
        HistoricoDAO historico = new HistoricoDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarCookie")) {
                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
            }
        }
        
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id + "servlet");
            List<HistoricoDTO> historicos = historico.mostrarHistorico(id);
            request.setAttribute("historicos", historicos);

            List<CategoriaDTO> mercadinho = mercadinhoDao.listarCategorias();
            request.setAttribute("categoria", mercadinho);

            String nextPage = "/WEB-INF/jsp/TelaDados.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
