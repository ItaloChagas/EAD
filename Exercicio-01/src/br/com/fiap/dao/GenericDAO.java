package br.com.fiap.dao;

public interface GenericDAO<T, K> {

	public void cadastrar(T entity);
	public void atualizar(T entity);
	public void deletar(K entity) throws KeyNotFoundException;
	public T pesquisar(K id) throws KeyNotFoundException;
	public void commit() throws CommitException; 
	
}
