/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import mercadinho.bean.Mercadinho;
import model.dao.MercadinhoDAO;

/**
 *
 * @author Senai
 */
@MultipartConfig

public class ProdutosServlet extends HttpServlet {

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
        List<Mercadinho> mercadinho = mercadinhoDao.listarCategorias();
        request.setAttribute("categoria", mercadinho);
        String url = request.getServletPath();
        if(url.equals("/cadastrar-produto")) {
            String nextPage = "/WEB-INF/jsp/TelaCadProdutos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if(url.equals("/Home")){
            List<Mercadinho> produtos = mercadinhoDao.listarProdutos();
            request.setAttribute("produtos", produtos);
            String nextPage = "/WEB-INF/jsp/TelaPrincipal.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")) {
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            if(busca.equals("")) {
                String categoria = request.getParameter("cat");
                List<Mercadinho> produtos = mercadinhoDao.buscaCategoria(Integer.parseInt(categoria));
                request.setAttribute("produtos", produtos);
            } else {
                busca = "%"+busca+"%";
                List<Mercadinho> produtos = mercadinhoDao.buscaProdutos(busca);
                request.setAttribute("produtos", produtos);
            }
            String nextPage = "/WEB-INF/jsp/TelaProdutos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
        
        
        String nextPage = "/WEB-INF/jsp/TelaProdutos.jsp";
        
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
        Mercadinho newProduto = new Mercadinho();

        newProduto.setNome_produto(request.getParameter("nome"));
        newProduto.setCategoriaId(Integer.parseInt(request.getParameter("mercadinho")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setValor(Float.parseFloat(request.getParameter("valor")));
        Part filePart = request.getPart("imagem");
        InputStream istream = filePart.getInputStream();
        ByteArrayOutputStream byteA = new ByteArrayOutputStream();
        byte[] img = new byte[4096];
        int byteRead = -1;
        while((byteRead = istream.read(img)) != -1 ) {
            byteA.write(img, 0, byteRead);
        }
        byte[] imgBytes = byteA.toByteArray();
        newProduto.setImagem(imgBytes);
        MercadinhoDAO produtosD = new MercadinhoDAO();
        produtosD.create3(newProduto);
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
