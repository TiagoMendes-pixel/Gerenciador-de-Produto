package service;

import java.util.ArrayList;
import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {

	
	private ProdutoDAO produtoDAO;
	
	public ProdutoService() {
		this.produtoDAO = new ProdutoDAO();
			
	}
	
	
	public void cadastrar(Produto produto) {
		produtoDAO.cadastrar(produto);
	}
	
	public void alterar(Produto produto) {
		produtoDAO.alterar(produto);
		
	}
	
	public void excluir(Produto produto) {
		produtoDAO.excluir(produto);
		
	}
	
	public Produto consultar(int codigo) {
		return produtoDAO.consultar(codigo);
		
		
	}
	
	public ArrayList<Produto> ListarProduto(){
		return produtoDAO.listarProdutos();
	}
}
