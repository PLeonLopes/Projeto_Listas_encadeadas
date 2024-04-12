package Projeto;

public class Disciplina {

	String nome;            // NOME da disciplina
	float nota;				// NOTA do aluno
    Disciplina proximo;     // APONTA para o próximo nó da lista


    // MÉTODOS GETTERS E SETTERS
    // (GET -> retorna seu valor | SET -> define ou atualiza), métodos de acesso e modificação
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina getProximo() {
		return proximo;
	}
	public void setProximo(Disciplina proximo) {
		this.proximo = proximo;
	}

}