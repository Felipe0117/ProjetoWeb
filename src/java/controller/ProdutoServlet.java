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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mercadinho.bean.CarrinhoDTO;
import mercadinho.bean.Mercadinho;
import model.dao.CarrinhoDAO;
import model.dao.MercadinhoDAO;

/**
 *
 * @author Senai
 */
@WebServlet (urlPatterns = "/enviarItemCarrinho")
@MultipartConfig
public class ProdutoServlet extends HttpServlet {
              CarrinhoDTO carrinho = new CarrinhoDTO();
    CarrinhoDAO carrinhos = new CarrinhoDAO();
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
        MercadinhoDAO mercadinhoDao = new MercadinhoDAO();
        int id_produto = Integer.parseInt(request.getParameter("id"));
        
        List<Mercadinho> produtos = mercadinhoDao.buscarProduto(id_produto);
        
        request.setAttribute("produtos", produtos);
        
        
        String url = request.getServletPath();
        
        
        
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
            if(action.equals("/enviarItemCarrinho")){
              produto(request, response);  
            }else{
                processRequest(request, response);
            }
                
    }

    protected void produto(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            CarrinhoDTO carrinho = new CarrinhoDTO();
            PrintWriter out = response.getWriter();
            System.out.println(request.getParameter("nome_produto_carrinho"));
            System.out.println(request.getParameter("valor_produto_carrinho"));
            carrinho.setNomeCarrinho(request.getParameter("nome_produto_carrinho"));
            carrinho.setValorCarrinho(Float.parseFloat(request.getParameter("valor_produto_carrinho")));
            carrinho.setDescricaoCarrinho(request.getParameter("descricao_produto_carrinho"));
            carrinho.setQuantidadeCarrinho(Integer.parseInt(request.getParameter("quantidade_carrinho")));
            carrinho.setProdutoId3(Integer.parseInt(request.getParameter("produto_id3")));
            carrinho.setImagemCarrinho(request.getParameter("imagem_produto_carrinho"));
            carrinhos.cadastrarCarrinho(carrinho);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Compra feita com sucesso.');");
            out.println("window.location.href = './pages/TelaProduto.jsp';");
            out.println("</script>");
            response.sendRedirect("./Home");
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
