package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;


@WebServlet("/ListarProduto.do")
public class ListarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pegando a lista de produtos
		ProdutoService produtoService = new ProdutoService();
		
		//Criando um ArrayList para aarmazenar os produtos que vieram da service que chama o DAO:
		ArrayList<Produto> ListaProdutos = produtoService.ListarProduto();
		
		// Definir o tipo de conteúdo da resposta:
		response.setContentType("text/html");
		
		//Criando um objeto de saída de dados:
		PrintWriter saida = response.getWriter();
		
		saida.println("Lista de produto cadastrados: <br> ");
		
		//Percorrendo o ArrayList e imprimindo os dados de cada produto:
		
		ListaProdutos.forEach (p -> {
			
			saida.println(p.getCodigo());
			saida.println(p.getDescricao());
			saida.println(p.getEstoque());
			saida.println(p.getValor());
			saida.println(p.getNome());
			saida.println("<br>");
			
		});
		
		
	}

}
