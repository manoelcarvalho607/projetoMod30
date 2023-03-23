/**
 * 
 */
package br.com.carvalho.services;



import br.com.carvalho.domain.Estoque;
import br.com.carvalho.exceptions.DAOException;
import br.com.carvalho.generic.IEstoqueDAO;
import br.com.carvalho.services.generic.GenericService;

/**
 * @author manoel.carvalho
 *
 */
public class EstoqueService extends GenericService<Estoque, String> implements IEstoqueService{

	public EstoqueService(IEstoqueDAO dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	

	


	


}
