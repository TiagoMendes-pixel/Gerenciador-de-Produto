package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

@WebServlet("/Consultar_produto.do")
public class Consultar_produto extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ProdutoService produtoService = new ProdutoService();
	
		Produto p = produtoService.consultar(codigo);
		
		
		PrintWriter saida = response.getWriter();
		saida.println(p.getCodigo() + " " + p.getNome() + " "+ p.getDescricao() +" " + p.getEstoque() + " " + p.getValor());
		
	}

}
