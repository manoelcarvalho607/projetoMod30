/**
 * 
 */
package br.com.carvalho.dao;

import br.com.carvalho.dao.generic.IGenericDAO;
import br.com.carvalho.domain.Venda;
import br.com.carvalho.exceptions.DAOException;
import br.com.carvalho.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author manoel.carvalho
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
