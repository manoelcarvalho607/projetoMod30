/**
 * 
 */
package br.com.carvalho.services;

import br.com.carvalho.domain.Cliente;
import br.com.carvalho.exceptions.DAOException;
import br.com.carvalho.services.generic.IGenericService;

/**
 * @author manoel.carvalho
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
