/**
 * 
 */
package br.com.carvalho.services;

import br.com.carvalho.dao.IProdutoDAO;
import br.com.carvalho.domain.Produto;
import br.com.carvalho.exceptions.DAOException;
import br.com.carvalho.services.generic.GenericService;

/**
 * @author manoel.carvalho
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

	

	



	

}
