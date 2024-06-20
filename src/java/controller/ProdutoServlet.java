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
import mercadinho.bean.ProdutoDTO;
import mercadinho.bean.UsuarioDTO;
import model.dao.CarrinhoDAO;
import model.dao.CategoriasDAO;
import model.dao.ProdutosDAO;
import model.dao.UsuariosDAO;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = {"/enviarItemCarrinho"})
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
        CategoriasDAO produtosDao = new CategoriasDAO();
        ProdutosDAO mercadinhoDao = new ProdutosDAO();
        int id_produto = Integer.parseInt(request.getParameter("id"));

        UsuarioDTO usuario = new UsuarioDTO();
    UsuariosDAO usuarios = new UsuariosDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarCookie")) {

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
            }
        }
        
        List<ProdutoDTO> produtos = mercadinhoDao.buscarProduto(id_produto);

        request.setAttribute("produtos", produtos);

        List<CategoriaDTO> mercadinho = produtosDao.listarCategorias();
        request.setAttribute("categoria", mercadinho);

        String url = request.getServletPath();

        String nextPage = "/WEB-INF/jsp/TelaProduto.jsp";
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
            ProdutoDTO produto = new ProdutoDTO();
            ProdutosDAO produtos = new ProdutosDAO();
        String action = request.getServletPath();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("continuarCookie")) {
                    if (action.equals("/enviarItemCarrinho")) {
                        int quantUsuario = Integer.parseInt(request.getParameter("quantidade"));
                        int produtoId = Integer.parseInt(request.getParameter("idProduto"));
                        int quantidadeEstoque = produtos.verEstoque(produtoId);
                            if(quantidadeEstoque >= quantUsuario){
                             produtos.retirarProduto(quantUsuario, produtoId);
                             produto(request, response);
                            }else{
                                PrintWriter out = response.getWriter();
                               out.println("<script type=\"text/javascript\">");
                               out.println("alert('Quantidade do produto indisponível');");
                               out.println("window.location.href = './Home';");
                               out.println("</script>"); 
                            }                                       
                    }
                }
            }PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Para adicionar produto ao carrinho você tem que estar logado');");
            out.println("window.location.href = './Login';");
            out.println("</script>");

        } else {
            
            processRequest(request, response);
        }

    }

    protected void produto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDTO usuario = new UsuarioDTO();
    UsuariosDAO usuarios = new UsuariosDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarCookie")) {

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
            }
        }
        CarrinhoDTO carrinho = new CarrinhoDTO();
        PrintWriter out = response.getWriter();

        carrinho.setNomeCarrinho(request.getParameter("nome"));
        carrinho.setValorCarrinho(Float.parseFloat(request.getParameter("valor")));
        carrinho.setDescricaoCarrinho(request.getParameter("descricao"));
        carrinho.setQuantidadeCarrinho(Integer.parseInt(request.getParameter("quantidade")));
        carrinho.setProdutoId3(Integer.parseInt(request.getParameter("idProduto")));
        carrinho.setImagemCarrinho(request.getParameter("imagem"));
        carrinho.setUsuarioId3(usuario.getId_usuario());
        carrinhos.cadastrarCarrinho(carrinho);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Sucesso');");
            out.println("window.location.href = './Home';");
            out.println("</script>");
        

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
