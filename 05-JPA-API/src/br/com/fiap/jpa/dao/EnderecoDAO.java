package br.com.fiap.jpa.dao;

import br.com.fiap.Endereco;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EnderecoNaoExistenteException;

public interface EnderecoDAO {

	
	void cadastrar(Endereco endereco);
	Endereco pesquisa(int id) throws EnderecoNaoExistenteException;
	void atualizar(Endereco endereco) throws EnderecoNaoExistenteException;
	void deletar(int id) throws EnderecoNaoExistenteException;
	void commit() throws CommitException;
	
	
}
