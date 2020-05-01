package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Produto;
import service.ProdutoService;

@WebServlet("/Cadastrar.do")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recebendo os dados que foram enviados pelo form do cliente
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Double valor = Double.parseDouble(request.getParameter("valor"));
		int estoque = Integer.parseInt(request.getParameter("estoque"));  
		
		//Preparando um objeto do tipo produto para depois enviá-lo para a Service
		Produto produtoCadastro = new Produto();
		produtoCadastro.setCodigo(codigo);
		produtoCadastro.setDescricao(descricao);
		produtoCadastro.setNome(nome);
		produtoCadastro.setEstoque(estoque);
		produtoCadastro.setValor(valor);
		
		//Solicitando a Service que execute o cadastro do professor:
		
		ProdutoService produtoService = new  ProdutoService();
		produtoService.cadastrar(produtoCadastro);
		
		// ProdutoDAO produtoDAO =  new ProdutoDAO();
		
	}
	

}
