package br.com.fiap.dao;

public interface IGenericDAO<E, K> {

	public void cadastrar(E entity);
	public void atualizar(E entity);
	public void deletar(K codigo);
	public E buscar(K codigo);
	public void commit() throws CommitException;
	
}
