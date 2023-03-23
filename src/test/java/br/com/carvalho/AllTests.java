/**
 * 
 */
package br.com.carvalho;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author manoel.carvalho
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
	ProdutoServiceTest.class, ProdutoDAOTest.class,
	VendaDAOTest.class, EstoqueServiceTest.class, EstoqueDaoTest.class})
public class AllTests {

}
