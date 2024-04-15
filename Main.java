import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     
        LSSequencial listasequencial = new LSSequencial();          // cria uma lista sequencial de alunos, usando o LSSequencial               
        int escolha = 0;
        Scanner entrada = new Scanner(System.in);

        do{
            listasequencial.exibirMenu();
            escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1: // Cadastrar aluno
                    System.out.println("Cadastrando aluno.");
                    Aluno alunoTemp = new Aluno();                                      // instancia para novo aluno
                    System.out.println("Informe o RGM: ");                            
                    alunoTemp.rgm = entrada.nextLine();
                    if (alunoTemp.rgm == ""){                                           // Checa se o RGM é vazio
                        System.out.println("Insira o RGM.");
                        break;
                    }
                    @SuppressWarnings("unused") String alunoRGM = alunoTemp.rgm;

                    if (listasequencial.rgmExistente(alunoTemp.getRgm())) {             // caso rgm já existente
                        System.out.println("RGM já cadastrado.");
                        break;
                    }
                    

                    LSEncadeada listaDisciplinasTemp = new LSEncadeada();               // cria a lista encadeada, usando o LSEncadeada

                    while (true) {
                        String disciplina;
                        Disciplina disciplinaTemp = new Disciplina();                   // instancia para disciplinas
                        System.out.println("Cadastre uma disciplina [0 - SAIR]: ");

                        disciplina = entrada.nextLine();                                 // 0 - para de receber disciplina
                        if (disciplina == "") {
                            System.out.println("Insira uma Disciplina.");              // Checa se a disciplina é vazia
                            break;
                        }
                        String saida = disciplina;
                        if (saida.equals("0")) {
                            break;
                        }
                        disciplinaTemp.nome = saida;

                        System.out.println("Nota da disciplina: ");                     
                        disciplinaTemp.nota = entrada.nextFloat();
                        entrada.nextLine();

                        listaDisciplinasTemp.inserirNoInicio(disciplinaTemp); // guarda a nota
                    }
                    
                    alunoTemp.disciplinas = listaDisciplinasTemp;
                    listasequencial.inserirAlunoOrdenado(alunoTemp); // guarda as informações na lista
                    break;
                case 2: // Buscar aluno via RGM
                    System.out.println("Informe o RGM para busca: ");
                    String i = entrada.nextLine();

                    alunoTemp = listasequencial.buscarPorRgm(i);

                    if (alunoTemp != null) {
                        System.out.println("As disciplinas do aluno são: \n");
                        alunoTemp.disciplinas.exibirLista();
                    } else {
                        System.out.println("Aluno não está na lista");
                    }
                    break;
                case 3: // Mostrar todos os alunos
                    int cont = 1;
                    for (int y = 0; y < listasequencial.tamanho; y++) {
                        System.out.println("\nAluno "+ cont +":\nRGM: " + listasequencial.alunos[y].getRgm());
                        listasequencial.alunos[y].disciplinas.exibirLista();
                        cont++;
                    }
                    break;
                case 4: // Remover um aluno
                    System.out.printf("Digite o RGM do aluno a ser Apagado: ");
                    String rgm = entrada.nextLine();
                    listasequencial.removerAluno(rgm);
                    break;
                case 5: // Créditos
                    listasequencial.creditos();
                    break;
                case 6: // Sair
                    System.out.println("Programa Encerrado.");
                    break;
                default:
                    System.out.println("Entrada Inválida. Tente Novamente.");
            }
        } while(escolha != 6);
        entrada.close(); // Liberação da memória do Scanner
    }
}
