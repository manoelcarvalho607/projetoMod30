/**
 * 
 */
package br.com.carvalho;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.carvalho.dao.EstoqueDAO;

import br.com.carvalho.dao.IProdutoDAO;
import br.com.carvalho.dao.IVendaDAO;
import br.com.carvalho.dao.ProdutoDAO;
import br.com.carvalho.domain.Estoque;
import br.com.carvalho.domain.Produto;
import br.com.carvalho.domain.ProdutoQuantidade;
import br.com.carvalho.domain.Venda;
import br.com.carvalho.exceptions.DAOException;
import br.com.carvalho.exceptions.MaisDeUmRegistroException;
import br.com.carvalho.exceptions.TableException;
import br.com.carvalho.exceptions.TipoChaveNaoEncontradaException;
import br.com.carvalho.generic.IEstoqueDAO;
import br.com.carvalho.services.EstoqueService;
import br.com.carvalho.services.IEstoqueService;

/**
 * @author manoel.carvalho
 *
 */
public class EstoqueServiceTest {
	
	private IEstoqueService estoqueservice;
	
	
	private IProdutoDAO produtoDao;
	
	
	
	
	private Produto produto;
	
	private ProdutoQuantidade prodQ;
	
	public EstoqueServiceTest() {
		IEstoqueDAO dao  = new EstoqueDAO();
		produtoDao = new ProdutoDAO();
		estoqueservice = new EstoqueService(dao);
		
	}
	
	
	private Produto cadastrarProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		
		Produto produto = new Produto();
		
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setMarca("Produto 1");
		produto.setValor(valor);
		produtoDao.cadastrar(produto);
		
		
		return produto;
	}
		
	
	private ProdutoQuantidade  QuantidadeProduto(Integer valor) {
		ProdutoQuantidade prodQ = new ProdutoQuantidade();
		prodQ.setQuantidade(valor);
		
		
		return prodQ;
	}

	
	@Before
	public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);
		this.prodQ = QuantidadeProduto(20);
	}
	
	
	@After
	public void end() throws DAOException {
		excluirProdutos();
		excluirQuantidade();
	}
	
	
	private void excluirProdutos() throws DAOException {
		Collection<Produto> list = this.produtoDao.buscarTodos();
		for (Produto prod : list) {
			this.produtoDao.excluir(prod.getCodigo());
		}
	}
	
	private void excluirQuantidade() throws DAOException {
		Collection<Estoque> list = this.estoqueservice.buscarTodos();
		for(Estoque estoque : list) {
			this.estoqueservice.excluir(estoque.getCodigo());
		}
	}
	

	
	@Test
	public void cadastrar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		
		Estoque estoque = new Estoque();
		estoque.setCodigo("E2");
		estoque.setNome("cerveja");
		estoque.setQuantidade(prodQ.getQuantidade());
		
		Boolean create = estoqueservice.cadastrar(estoque);
		
		Assert.assertNotNull(create);
	}
	
	
	
	@Test
	public void pesquisarEstoque() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
		Estoque estoque = new Estoque();
		estoque.setCodigo("E3");
		estoque.setNome("refrigerante");
		estoque.setQuantidade(prodQ.getQuantidade());
		estoqueservice.cadastrar(estoque);
		
		Estoque ConsultarEstoque = estoqueservice.consultar(estoque.getCodigo());
		Assert.assertNotNull(ConsultarEstoque);
	}
	
	@Test
	public void alterarquantidade() throws TipoChaveNaoEncontradaException, DAOException {
		Estoque estoque = new Estoque();
		
		estoque.setNome("bebida");
		estoqueservice.alterar(estoque);
		
		Assert.assertEquals("bebida", estoque.getNome());
	}
	
	
	@Test
	public void excluir() throws DAOException, TipoChaveNaoEncontradaException {
		Estoque estoque = new Estoque();
		estoque.setCodigo("E4");
		estoque.setNome("vinho");
		estoque.setQuantidade(prodQ.getQuantidade());
		estoqueservice.cadastrar(estoque);
		
		estoqueservice.excluir(estoque.getCodigo());
	}
	
	
	
	
	
}
