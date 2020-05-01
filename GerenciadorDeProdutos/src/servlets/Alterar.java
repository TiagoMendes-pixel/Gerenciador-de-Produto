package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;


@WebServlet("/Alterar.do")
public class Alterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Recebendo os dados do form:
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		double valor = Double.parseDouble(request.getParameter("valor"));
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		
		//Preparando um objeto do tipo produto:
		
		Produto p = new Produto();
		p.setCodigo(codigo);
		p.setDescricao(descricao);
		p.setEstoque(estoque);
		p.setNome(nome);
		p.setValor(valor);
		
		//Declarando uma Service:
		
		ProdutoService produtoService = new ProdutoService();
		produtoService.alterar(p);
		
		
		
		
	}

}
