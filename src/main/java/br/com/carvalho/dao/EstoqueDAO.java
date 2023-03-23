/**
 * 
 */
package br.com.carvalho.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.carvalho.dao.generic.GenericDAO;
import br.com.carvalho.domain.Estoque;

import br.com.carvalho.generic.IEstoqueDAO;

/**
 * @author manoel.carvalho
 *
 */
public class EstoqueDAO  extends GenericDAO<Estoque, String> implements IEstoqueDAO{
	
	public EstoqueDAO() {
		super();
	}

	@Override
	public Class<Estoque> getTipoClasse() {
		// TODO Auto-generated method stub
		return Estoque.class;
	}

	@Override
	public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
		entityCadastrado.setCodigo(entity.getCodigo());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setQuantidade(entity.getQuantidade());
		
		
	}

	@Override
	protected String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_ESTOQUE ");
		sb.append("(CODIGO,NOME,QUANTIDADE)");
		sb.append("VALUES (?,?,?)");
		return sb.toString();
	}
	
	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
		stmInsert.setString(1, entity.getCodigo());
		stmInsert.setString(2, entity.getNome());
		stmInsert.setInt(3, entity.getQuantidade());
		
	}

	@Override
	protected String getQueryExclusao() {
		// TODO Auto-generated method stub
		return  "DELETE FROM TB_ESTOQUE WHERE CODIGO = ?";
	}
	

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmDelete, String valor) throws SQLException {
		stmDelete.setString(1, valor);
		
	}


	@Override
	protected String getQueryAtualizacao() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_ESTOQUE ");
		sb.append("SET NOME = ?,");
		sb.append("QUANTIDADE = ? ");
		sb.append(" WHERE CODIGO = ? ");
		return sb.toString();
	}

	

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
		stmUpdate.setString(1, entity.getNome());
		stmUpdate.setLong(2, entity.getQuantidade());
		stmUpdate.setString(3, entity.getCodigo());
		
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
		stmUpdate.setString(1, valor);
		
	}

}
