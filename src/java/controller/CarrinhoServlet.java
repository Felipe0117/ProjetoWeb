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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mercadinho.bean.CarrinhoDTO;
import mercadinho.bean.CategoriaDTO;
import model.dao.CarrinhoDAO;
import model.dao.CategoriasDAO;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = {"/irCheckOut"})
@MultipartConfig
public class CarrinhoServlet extends HttpServlet {
    

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
        CarrinhoDAO carrinhos = new CarrinhoDAO();
        CategoriasDAO mercadinhoDao = new CategoriasDAO();
        CarrinhoDAO carrinho = new CarrinhoDAO();
        
        List<CarrinhoDTO> carro = carrinhos.leia();
            request.setAttribute("carro", carro);
            
            List<CategoriaDTO> mercadinho = mercadinhoDao.listarCategorias();
        request.setAttribute("categoria", mercadinho);
        List<CarrinhoDTO> totalCarrinho = carrinho.leiaTotal();
            request.setAttribute("totalCarrinho", totalCarrinho);
            
        String nextPage = "/WEB-INF/jsp/TelaCarrinho.jsp";
        
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
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("continuarCookie")) {
                    if (action.equals("/irCheckOut")) {
                        String nextPage = "/WEB-INF/jsp/TelaCheckOut.jsp";            
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                        dispatcher.forward(request, response);
                    }
                }
            }PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Você precisa estar logado na sua conta');");
            out.println("window.location.href = './Login';");
            out.println("</script>");

        } else {
            
            processRequest(request, response);
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