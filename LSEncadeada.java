package Projeto;

public class LSEncadeada {
 
    Disciplina primeiro = null;
	Disciplina ultimo = null;
	int tamanho = 0;
    
    public boolean estaVazia() {    // Função para verificar se a lista está vazia ou não
		if (tamanho == 0) {         // se o tamanho for 0, retorna true (1)
            return true;
        }
		return false;               // se o tamanho não for 0, retorna false (0)
	}

    public int tamanhoDaLista() {   // Função para retornar o tamanho atual da lista
		return (tamanho);
	}

    public void inserirNoInicio(Disciplina dado) {      // Função para inserir elemento no início da lista
		if (estaVazia()) {
            primeiro = ultimo = dado;                   // Se estiver a vazia, o primeiro ultimo e dado são iguais
        } else {
			dado.proximo = primeiro;                    // Se não estiver vazia, o dado inserido é o primeiro
			primeiro = dado;
		}
		tamanho++;                                      // aumenta o tamanho da lista
	}

    public void inserirNoFim(Disciplina dado) {         // Função para inserir elemento no final da lista
		if (estaVazia()) {
            primeiro = ultimo = dado;                   // Se estiver a vazia, o primeiro ultimo e dado são iguais
        } else {
			ultimo.proximo = dado;                      // Se não estiver vazia, o dado inserido é o último
			ultimo = dado;
		}
		tamanho++;
	}

    public void exibirLista() {                             // Função para exibir lista encadeda (disciplinas)
		Disciplina temp = primeiro;                         // SE LISTA NÃO ESTIVER VAZIA
		if (!estaVazia()) {
			for (int i = 0; i < tamanho; i++) {
				System.out.println("Nome: " + temp.nome + " | Nota: " + temp.nota); // O loop passa pelas disciplinas e printa
				temp = temp.proximo;
			}
		}
	}


    public void removerPorRgm(String nomeprocurado) {           // Função para remover o nome selecionado
		if (tamanho == 0) {                                     // Se a lista estiver vazia ^^ (alterar depois)
			System.out.println("A lista está vazia!");   
			return;
		} else if (tamanho == 1) {                              // Se o tamanho for 1
            if (primeiro.nome.equals(nomeprocurado)) {          // e for igual ao número digitado
				primeiro = ultimo = null;                       // remove, anula e diminui o tamanho
				tamanho--;                                      
				return;
			} else {
				System.out.println("O nome " + nomeprocurado + " não está na lista.");  // caso não esteja na lista
				return;
			}
		}

		Disciplina primDisci = primeiro;                    // Inicialização da variável primeira (posição 0)
		Disciplina ultiDisci = null;                        // inicialização da variável ultima (nulo em primeiro momento)

		for (int i = 0; i < tamanho; i++) {
			if (nomeprocurado.equals(primDisci.nome)) {             // Verifica se o nome da disciplina no nó atual (primDisci.nome) é igual ao nomeprocurado
				if (i == 0) {                                       // VERIFICA SE O NÓ ATUAL É O PRIMEIRO DA LISTA
					System.out.println("O nome procurado é o primeiro nó da lista, e será removido.");
					primeiro = primeiro.proximo;                    // aponta para o próximo nó
					tamanho--;                                      // diminui o tamanho da lista
					return;
				} else {                                            // se não for o primeiro nó
					ultiDisci.proximo = primDisci.proximo;          // remove e aponta para o próximo
					tamanho--;                                      // diminui o tamanho
					return;
				}
			} else {    // se o nome não for encontrado no loop, os apontadores voltam para o início
				ultiDisci = primDisci;  
				primDisci = primDisci.proximo;
			}
		}
		System.out.println("Disciplina " + nomeprocurado + " não está na lista");       // se não achar, imprime mensagem informando que o nome não está na lista
		return;
	}

}
