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


@WebServlet("/ExcluirProduto.do")
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pegando o parâmetro que representa o código do produto que o usuário pretende excluir:
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		//Criando um objeto da Service :
		ProdutoService produtoService = new ProdutoService();
		
		//Solicitando a Service que exclua o produto:
		Produto p = new Produto();
		p.setCodigo(codigo);
		produtoService.excluir(p);
		
		//Informando alguma msgm ao usuário:
		
		PrintWriter saida = response.getWriter();
		saida.println("O produto " + codigo +  " foi removido com suceso.");
			
	}

}
