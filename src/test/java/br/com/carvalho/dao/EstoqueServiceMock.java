/**
 * 
 */
package br.com.carvalho.dao;

import java.util.Collection;

import br.com.carvalho.domain.Estoque;
import br.com.carvalho.exceptions.DAOException;
import br.com.carvalho.exceptions.MaisDeUmRegistroException;
import br.com.carvalho.exceptions.TableException;
import br.com.carvalho.exceptions.TipoChaveNaoEncontradaException;
import br.com.carvalho.generic.IEstoqueDAO;

/**
 * @author manoel.carvalho
 *
 */
public class EstoqueServiceMock implements IEstoqueDAO {

	@Override
	public Boolean cadastrar(Estoque entity) throws TipoChaveNaoEncontradaException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(String valor) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterar(Estoque entity) throws TipoChaveNaoEncontradaException, DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Estoque consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Estoque> buscarTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
