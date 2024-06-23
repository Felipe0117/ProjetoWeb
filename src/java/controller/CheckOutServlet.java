/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import mercadinho.bean.EnderecoDTO;
import mercadinho.bean.HistoricoDTO;
import mercadinho.bean.UsuarioDTO;
import model.dao.CarrinhoDAO;
import model.dao.CategoriasDAO;
import model.dao.EnderecosDAO;
import model.dao.HistoricoDAO;
import model.dao.UsuariosDAO;

/**
 *

 * @author Senai
 */
@WebServlet(urlPatterns = {"/checkout", "/modEndereco", "/adicionarItemHist"})
@MultipartConfig
public class CheckOutServlet extends HttpServlet {
     UsuarioDTO usuario = new UsuarioDTO();
        UsuariosDAO usuarios = new UsuariosDAO();
        CarrinhoDAO carrinhos = new CarrinhoDAO();
        CarrinhoDTO carrinho = new CarrinhoDTO();
        EnderecoDTO enderecos = new EnderecoDTO();
        EnderecosDAO endereco = new EnderecosDAO();
        HistoricoDTO historico = new HistoricoDTO();
        HistoricoDAO historicos = new HistoricoDAO();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        Cookie[] cookies = request.getCookies();
           for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarCookie")) {

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
                int idUsuario = Integer.parseInt(cookie.getValue());
                List<CarrinhoDTO> carro = carrinhos.leia2(idUsuario);
                request.setAttribute("carro", carro);
                List<CarrinhoDTO> totalCarrinho = carrinhos.leiaTotal(idUsuario);
        request.setAttribute("totalCarrinho", totalCarrinho);
                List<EnderecoDTO> enderecoAtual = endereco.ValidaEnd(idUsuario);
                request.setAttribute("enderecoAtual", enderecoAtual);
                               if (enderecoAtual == null || enderecoAtual.isEmpty()) {
                    enderecoAtual = new ArrayList<>();
                    EnderecoDTO defaultEndereco = new EnderecoDTO();
                    enderecoAtual.add(defaultEndereco);
                    request.setAttribute("enderecoAtual", enderecoAtual);
                }
        
        
        
            }
        }    
            
          
  
            String nextPage = "/WEB-INF/jsp/TelaCheckOut.jsp";
        
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
          String url = request.getServletPath();
              PrintWriter out = response.getWriter();
               Cookie[] cookies = request.getCookies();
               if(url.equals("/modEndereco")){
        if(cookies != null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarCookie")) {
           int idUsuario = Integer.parseInt(cookie.getValue());
           
              List<EnderecoDTO> enderecoExistente = endereco.ValidaEnd(idUsuario);
            String cep = request.getParameter("cep");
                 if (enderecoExistente == null || enderecoExistente.isEmpty()) {
                     if (cep.length() == 9) {
                     inserirEndereco(request, response);    
                     }else{
               out.println("<script type=\"text/javascript\">");
            out.println("alert('O cep deve conter 9 caracteres');");
            out.println("window.location.href = './checkout';");
            out.println("</script>");
                     }
                }else{
               if (cep.length() == 9) {
                   editarEndereco(request, response);      
                     }else{
               out.println("<script type=\"text/javascript\">");
            out.println("alert('O cep deve conter 9 caracteres');");
            out.println("window.location.href = './checkout';");
            out.println("</script>");
                     }  
                 }
 
            }
        }
        }  
               }/*Aqui para cima é somente para o cep, daquip para baixo é para adicionar os produtos aos pedidos*/
       if(url.equals("/adicionarItemHist")){
          if(cookies != null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarCookie")) {
                hist(request, response);
               /* String NumCart = request.getParameter("cartao");
                String Cvc = request.getParameter("cvc");
                String Dv = request.getParameter("dv");
                String Nome = request.getParameter("nome");
                String NumCart2 = request.getParameter("cartao2");
                String Cvc2 = request.getParameter("cvc2");
                String Dv2 = request.getParameter("dv2");
                String Nome2 = request.getParameter("nome2");
                
                if (NumCart == null || Cvc == null || Dv == null || Nome == null || NumCart2 == null || Cvc2 == null || Dv2 == null || Nome2 == null ) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Preencha as informações de pagamento');");
            out.println("window.location.href = './CheckOutServlet';");
            out.println("</script>");
        }else{
           hist(request, response);    

            }*/
        }
          }          
         }      
    }
    }
   
            protected void hist(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            
            String [] nomeHist = request.getParameterValues("nomeHist");
            String [] valor = request.getParameterValues("valor");
            String [] descricao = request.getParameterValues("descricao");
            String [] quantidade = request.getParameterValues("quantidade");
            String [] idProduto = request.getParameterValues("idProduto");
            String [] imagem = request.getParameterValues("imagem");
            int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));
            
            for (int i = 0; i < nomeHist.length; i++){
            historico.setNome_historico(nomeHist[i]);
            historico.setValor_historico(Float.parseFloat(valor[i]));
            historico.setDescricao_historico(descricao[i]);
            historico.setQuantidade_historico(Integer.parseInt(quantidade[i]));
            historico.setProduto_id4(Integer.parseInt(idProduto[i]));
            historico.setImagem_historico(imagem[i]);
            historico.setUsuario_id4(idUsuario);
            historicos.cadastrarHistorico(historico);
            
            
            }
            carrinhos.deletarCarrinho();
            
            out.println("<script type=\"text/javascript\">");
            out.println("window.location.href = './FinalServlet';");
            out.println("</script>");
            

    }
   
          protected void inserirEndereco(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();      
        EnderecoDTO newEndereco = new EnderecoDTO();

        newEndereco.setRua(request.getParameter("rua"));
        newEndereco.setNumero(Integer.parseInt(request.getParameter("numero")));
        newEndereco.setUsuario_id1(Integer.parseInt(request.getParameter("id_usuario")));
        newEndereco.setCep(request.getParameter("cep"));
        newEndereco.setComplemento(request.getParameter("complemento"));
        endereco.create(newEndereco);
                    out.println("<script type=\"text/javascript\">");
            out.println("alert('Informações adicionadas com sucesso');");
            out.println("window.location.href = './checkout';");
            out.println("</script>");
          }
         
        protected void editarEndereco(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();      
        EnderecoDTO newEndereco = new EnderecoDTO();
        newEndereco.setId_endereco(Integer.parseInt(request.getParameter("id_endereco")));
        newEndereco.setRua(request.getParameter("rua"));
        newEndereco.setUsuario_id1(Integer.parseInt(request.getParameter("id_usuario")));
        newEndereco.setNumero(Integer.parseInt(request.getParameter("numero")));
        newEndereco.setCep(request.getParameter("cep"));
        newEndereco.setComplemento(request.getParameter("complemento"));
        endereco.editarEndereco(newEndereco);
        out.println("<script type=\"text/javascript\">");
            out.println("alert('Informações alteradas com sucesso');");
            out.println("window.location.href = './checkout';");
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
