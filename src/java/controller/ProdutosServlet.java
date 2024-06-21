/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
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
        CategoriasDAO mercadinhoDao = new CategoriasDAO();
        ProdutosDAO produtosDao = new ProdutosDAO();
        UsuarioDTO usuario = new UsuarioDTO();
        UsuariosDAO usuarios = new UsuariosDAO();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarCookie")) {

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
            }
        }

        List<CategoriaDTO> mercadinho = mercadinhoDao.listarCategorias();
        request.setAttribute("categoria", mercadinho);
        String url = request.getServletPath();
        if (url.equals("/cadastrar-produto")) {
            String nextPage = "/WEB-INF/jsp/TelaCadProdutos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/Home")) {
            List<ProdutoDTO> produtos = produtosDao.listarProdutos();
            request.setAttribute("produtos", produtos);
            String nextPage = "/WEB-INF/jsp/TelaPrincipal.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")) {
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            if (busca.equals("")) {
                System.out.println("Produto não encontrado");
                String categoria = request.getParameter("cat");
                List<ProdutoDTO> produtos = produtosDao.buscaCategoria(Integer.parseInt(categoria));
                request.setAttribute("produtos", produtos);
            } else {
                busca = "%" + busca + "%";
                List<ProdutoDTO> produtos = produtosDao.buscaProdutos(busca);
                request.setAttribute("produtos", produtos);
            }
            String nextPage = "/WEB-INF/jsp/TelaProdutos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/ir_carrinho")) {
            String nextPage = "/WEB-INF/jsp/TelaCarrinho.jsp";
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
        ProdutoDTO newProduto = new ProdutoDTO();

        newProduto.setNome_produto(request.getParameter("nome"));
        newProduto.setCategoriaId(Integer.parseInt(request.getParameter("mercadinho")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setValor(Float.parseFloat(request.getParameter("valor")));

        Part filePart = request.getPart("imagem");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        if (fileName != null && !fileName.isEmpty()) {
            String basePath = getServletContext().getRealPath("/") + "assets"; // Caminho para a pasta assets
            File uploads = new File(basePath);
            if (!uploads.exists()) {
                uploads.mkdirs(); // Cria o diretório se não existir
            }
            File file = new File(uploads, fileName);

            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace(); // Trate as exceções de forma adequada
            }

            // Configurando apenas o caminho relativo da imagem no banco de dados
            newProduto.setImagem("assets/" + fileName);
        } else {
            newProduto.setImagem(null);
        }

        ProdutosDAO produtosD = new ProdutosDAO();
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
