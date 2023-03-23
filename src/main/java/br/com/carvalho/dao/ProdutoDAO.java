/**
 * 
 */
package br.com.carvalho.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.carvalho.dao.generic.GenericDAO;
import br.com.carvalho.domain.Produto;



/**
 * @author manoel.carvalho
 *
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {
	
	public ProdutoDAO() {
		super();
	}

	@Override
	public Class<Produto> getTipoClasse() {
		return Produto.class;
	}

	@Override
	public void atualiarDados(Produto entity, Produto entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setDescricao(entity.getDescricao());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setMarca(entity.getMarca());
		entityCadastrado.setValor(entity.getValor());
	}

	@Override
	protected String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_PRODUTO ");
		sb.append("(CODIGO, NOME, MARCA, DESCRICAO, VALOR)");
		sb.append("VALUES (?,?,?,?,?)");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
		stmInsert.setString(1, entity.getCodigo());
		stmInsert.setString(2, entity.getNome());
		stmInsert.setString(3, entity.getMarca());
		stmInsert.setString(4, entity.getDescricao());
		stmInsert.setBigDecimal(5, entity.getValor());
	}

	@Override
	protected String getQueryExclusao() {
		return "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException {
		stmExclusao.setString(1, valor);
	}

	@Override
	protected String getQueryAtualizacao() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_PRODUTO ");
		//sb.append("SET CODIGO = ?,");
		sb.append("SET NOME = ?,");
		sb.append("MARCA = ?,");
		sb.append("DESCRICAO = ?,");
		sb.append("VALOR = ?");
		sb.append(" WHERE CODIGO = ? ");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
		//stmUpdate.setString(1, entity.getCodigo());
		stmUpdate.setString(1, entity.getNome());
		stmUpdate.setString(2, entity.getMarca());
		stmUpdate.setString(3, entity.getDescricao());
		stmUpdate.setBigDecimal(4, entity.getValor());
		stmUpdate.setString(5, entity.getCodigo());
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
		stmUpdate.setString(1, valor);
	}

}
