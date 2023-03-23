/**
 * 
 */
package br.com.carvalho.domain;





import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import annotation.ColunaTabela;
import annotation.Tabela;
import annotation.TipoChave;
import br.com.carvalho.dao.Persistente;

/**
 * @author manoel.carvalho
 *
 */

@Tabela("TB_Estoque")
public class Estoque  implements Persistente  {
	
	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;
	
	@TipoChave("getCodigo")
	@ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
	private String codigo;
	
	private Produto produto;
	
	private Set<ProdutoQuantidade> produtos;
	
	@ColunaTabela(dbName = "nome", setJavaName = "setNome")
	private String nome;
	
	@ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
	private Integer quantidade;
	
	
	public Estoque() {
		this.quantidade = 0;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	public Set<ProdutoQuantidade> getProdutos() {
		return produtos;
	}


	public void setProdutos(Set<ProdutoQuantidade> produtos) {
		this.produtos = produtos;
	}

		
	public void adicionar(Integer quantidade){
		this.quantidade += quantidade; 
	}
	
	public void adicionarProduto(Produto produto, Integer quantidade) {
		
		Optional<ProdutoQuantidade> op = 
				produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		if (op.isPresent()) {
			ProdutoQuantidade produtpQtd = op.get();
			produtpQtd.adicionar(quantidade);
			this.quantidade += quantidade; 
		} else {
			// Criar fabrica para criar ProdutoQuantidade
			ProdutoQuantidade prod = new ProdutoQuantidade();
			prod.setProduto(produto);
			prod.adicionar(quantidade);
			produtos.add(prod);
			this.quantidade += quantidade; 
		}
		
	}
	
	public void removerProduto(Produto produto, Integer quantidade) {
	
		Optional<ProdutoQuantidade> op = 
				produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		
		if (op.isPresent()) {
			ProdutoQuantidade produtpQtd = op.get();
			if (produtpQtd.getQuantidade()>quantidade) {
				produtpQtd.remover(quantidade);
				this.quantidade -= quantidade;
				
			} else {
				produtos.remove(op.get());
				this.quantidade -= quantidade;
				
			}
			
		}
	}
	
	public void removerTodosProdutos() {
		
		produtos.clear();
		
	}
	
	public Integer getQuantidadeTotalProdutos() {
		// Soma a quantidade getQuantidade() de todos os objetos ProdutoQuantidade
		int result = produtos.stream()
		  .reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
		return result;
	}

	


}
