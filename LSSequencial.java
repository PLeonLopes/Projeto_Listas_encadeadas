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

    public Aluno removerAluno(String rgm) {                     // Função para remover aluno da lista
		if (buscarPorRgm(rgm) == null) {                        // checa se rgm é nulo
			System.out.println("Não é possível remover aluno inexistente.");
			return null;
		}
		int pos = retornarPosicao(buscarPorRgm(rgm));           // pega a posição do rgm digitado

		if ((pos > tamanho) || (pos < 0)) {                     // se a posição do rgm não for válida, retorna nulo
            return null;
        }
        // operações de remoção em uma lista
		Aluno aux = alunos[pos];
		deslocarParaEsquerda(pos);
		aux.disciplinas.primeiro = null;
		aux.disciplinas.ultimo = null;
		aux.disciplinas.tamanho = 0;
		tamanho--;
		return aux;
	}

    public Aluno buscarPorRgm(String rgm) {                     // Função para buscarAluno por rgm (auxilia a função remover aluno)
		for (int i = 0; i <= tamanho; i++) {                    // roda a lista
			if (alunos[i] != null) {                            // checa se a posição não é nula
				if (alunos[i].rgm.equals(rgm)) {                
					return alunos[i];                           // acha o aluno
				}
			}

		}
		return null;
	}

    public int getPosicaoOrdenada(String rgm) {                 // Função para obter a posição de determinado rgm
		int i;
		for (i = 0; i < tamanho; i++) {                         // intera toda a lista de alunos
			if ((alunos[i].rgm).compareTo(rgm) > 0) {           // compara o rgm do aluno com o rgm fornecido
				return i;                                       // retorna o índice do rgm
			}
		}
		return i;
	}

    public void inserirAlunoOrdenado(Aluno a1) {                // adicionar um aluno na lista de forma ordenada
		if (estaCheia()) {                                      // checa se está cheia
			System.out.println("A lista está cheia.");
			return;
		} else if (estaVazia()) {                               // se vazia, entra na primeira posição
			this.inserirAluno(0, a1);                       
		} else {
			this.inserirAluno(getPosicaoOrdenada(a1.rgm), a1);  // organiza em ordem
		}

	}

    public boolean rgmExistente(String alunoRGM) {              // checa se o RGM a ser cadastrado já existe 
        for (int i = 0; i < tamanho; i++) {                     
            if (alunos[i] != null && alunos[i].getRgm().equals(alunoRGM)) {
                return true;
            }
        }
        return false;
    }


    // FUNÇÃO PRA PRINTAR CRÉDITOS
    public void creditos() {    
        String[] equipe = {"Pedro Lucas Targino Felipe da Silva", "Pedro Nícollas Pereira Leon Lopes", "Ricardo Silva Flores", "Victor Hugo Barbosa Vasconcelos", "Wellington Araújo Ferreira Junior"};

        System.out.println("\nIntegrantes da equipe:");
        for (String nome : equipe) {
            System.out.println("- " + nome);
        }
        System.out.println();        
    }

    // FUNÇÃO PARA MENU DE ESCOLHAS
    public void exibirMenu() {
        System.out.println("\n=========== Menu ===========");
        System.out.println("1. Cadastrar aluno");
        System.out.println("2. Buscar aluno via RGM");
        System.out.println("3. Mostrar todos os alunos");
        System.out.println("4. Remover um aluno");
        System.out.println("5. Créditos");
        System.out.println("6. Sair");
        System.out.println("============================");
        System.out.printf("Escolha uma opção: ");
    }

}
