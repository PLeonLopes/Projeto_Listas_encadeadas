package Projeto;

public class LSSequencial {
    
    Aluno[] alunos = new Aluno[60];             // Criação de um array de 60 posições, do tipo Aluno
    int tamanho = 0;                            // indice do último elemento da lista (tamanho)

    public boolean estaVazia() {                // Função para verificar se a lista está vazia ou não
        return (tamanho == 0);                  // se o tamanho for 0, retorna true (1), caso esteja vazia e false (0) se não
    }

    public boolean estaCheia() {                // Função para verificar se a lista está cheia ou não
        return (tamanho == alunos.length);      // se o tamanho for 60 (nesse caso), retorna true (caso cheia) ou false (não cheia)
    }

    public int tamanhoLista() {                 // Função para retornar o tamanho atual da lista
        return tamanho;                         // retorna o índice do último elemento (tamanho)
    }

    public Aluno buscarIndice(int pos) {        // Função do tipo ALUNO para obter elemento de uma posição na lista
        if ((pos >= tamanho) || (pos < 0)) {    // VERIFICA SE A POSIÇÃO DO ELEMENTO É VÁLIDA (1-60, no caso)
            return null;                        // Se não for, retorna nulo
        }
        return alunos[pos];                     // retorna o elemento
    }

    public boolean compara(Aluno a1, Aluno a2) {
        return (a1.rgm.equals(a2.rgm) && (a1.disciplinas.equals(a2.disciplinas)));
    }

    public int retornarPosicao(Aluno aluno) {   // Função para obter a posicao de um elemento, a partir de seu valor
		for (int i = 0; i <= tamanho; i++) {    // Roda todo o array
            if (compara(alunos[i], aluno)) {    // Compara o elemento dado e o possível elemento que está na lista
                return i;                       // RETORNA A POSIÇÃO DO ELEMENTO, CASO ELE ESTEJA NA LISTA
            }
        }
		return -1;                              // retorna -1 caso o elemento não esteja na lista
	}

    public void deslocarParaDireita(int pos) {  // Função para deslocar o elemento para a direita, para a inserção de um novo elemento
		for (int i = tamanho; i > pos; i--) {   // roda a lista
            alunos[i] = alunos[i - 1];          // desloca o elemento para a direita
        }
	}

    public boolean inserirAluno(int pos, Aluno a1) {            // Função para inserir aluno
		if (estaCheia() || (pos > tamanho) || (pos < 0)) {      // checa se é possível
            return false;
        }
        // realiza as operações de inserção
		deslocarParaDireita(pos);                               
		alunos[pos] = a1;
		tamanho++;
		return true;
	}
    
    public void deslocarParaEsquerda(int pos) {                 // Função para deslocar o elemento para a esquerda, para a remoção de um elemento
		for (int i = pos; i < (tamanho - 1); i++) {             // roda a lista
            alunos[i] = alunos[i + 1];                          // desloca o elemento para a esquerda
        }
	}

    public void exibirLista() {                                 // Função para printar a lista de alunos e rgms
		for (int i = 0; i < tamanho; i++)
			System.out.println(
            "\nAluno " + (i + 1) +
            "\nRGM: " + alunos[i].rgm);
	}

    public void creditos() {
        String[] equipe = {"Pedro Lucas Targino Felipe da Silva", "Pedro Nícollas Pereira Leon Lopes", "Ricardo Silva Flores", "Victor Hugo Barbosa Vasconcelos", "Wellington Araújo Ferreira Junior"};

        System.out.println("\nNomes dos integrantes da equipe:");
        for (String nome : equipe) {
            System.out.println("- " + nome);
        }
        System.out.println();        
    }


}
