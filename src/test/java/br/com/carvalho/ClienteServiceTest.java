/**
 * 
 */
package br.com.carvalho;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.carvalho.dao.ClienteDaoMock;
import br.com.carvalho.dao.IClienteDAO;
import br.com.carvalho.domain.Cliente;
import br.com.carvalho.exceptions.DAOException;
import br.com.carvalho.exceptions.TipoChaveNaoEncontradaException;
import br.com.carvalho.services.ClienteService;
import br.com.carvalho.services.IClienteService;



/**
 * @author manoel.carvalho
 *
 */
public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Manoel");
		cliente.setCidade("iacanga");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Manoel Roberio");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Manoel Roberio", cliente.getNome());
	}
}
