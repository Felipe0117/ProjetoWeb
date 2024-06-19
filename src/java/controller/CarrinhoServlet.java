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
import mercadinho.bean.UsuarioDTO;
import model.dao.CarrinhoDAO;
import model.dao.CategoriasDAO;
import model.dao.UsuariosDAO;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = {"/irCheckOut"})
@MultipartConfig
public class CarrinhoServlet extends HttpServlet {
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
        CarrinhoDAO carrinhos = new CarrinhoDAO();
        CategoriasDAO mercadinhoDao = new CategoriasDAO();
                Cookie[] cookies = request.getCookies();
                    for (Cookie cookie : cookies) { //armazena todos os cookies no array "cookies"
                       if (cookie.getName().equals("continuarCookie")) { //verifica se o cookie atual é o "continuarCookie"

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue())); //armazena as informações do usuário com base no cookie atual 
                request.setAttribute("usuario", usuario); //armazena as informações presentes em "usuario" para que possa ser utilizada quando uma requisição for chamada
                int idUsuario = Integer.parseInt(cookie.getValue()); //armazena os valores obtidos no cookie para a variável idUsuario
                List<CarrinhoDTO> carro = carrinhos.leia2(idUsuario); //lista as informações do carrinho relacionadas ao idUsuario
                request.setAttribute("carro", carro);
                List<CarrinhoDTO> totalCarrinho = carrinhos.leiaTotal(idUsuario);
        request.setAttribute("totalCarrinho", totalCarrinho);
            }
        }    
        

        List<CategoriaDTO> mercadinho = mercadinhoDao.listarCategorias();
        request.setAttribute("categoria", mercadinho);
        


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
        if (action.equals("/irCheckOut")) {
            response.sendRedirect("./CheckOutServlet");
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
