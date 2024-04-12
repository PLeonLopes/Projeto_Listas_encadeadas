package Projeto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     
        LSSequencial listasequencial = new LSSequencial();                      // cria uma lista sequencial de alunos, usando o LSSequencial
        int escolha = 0;
        Scanner entrada = new Scanner(System.in);
        String saida = "1";                                                     // Valor inicial que vai ser usado no do-while do case 1


        do {
            listasequencial.exibirMenu();
            escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Cadastrando aluno.");
                    Aluno alunoTemp = new Aluno();                              // instancia para novo aluno
                    System.out.println("Informe o RGM: ");
                    alunoTemp.rgm = entrada.nextLine();                         // recebe 

                    LSEncadeada listaDisciplinasTemp = new LSEncadeada();       // cria a lista encadeada, usando o LSEncadeada

                    do {

                        Disciplina disciplinaTemp = new Disciplina();           // instancia para disciplinas
                        System.out.println("Cadastre uma disciplina [0 - SAIR]: ");
    
                        saida = entrada.next();                                 // 0 - para de receber disciplina
                        if (saida.equals("0")) {
                            break;
                        }
                        disciplinaTemp.nome = saida;
    
                        System.out.println("Nota da disciplina: ");           
                        disciplinaTemp.nota = entrada.nextFloat();
    
                        listaDisciplinasTemp.inserirNoInicio(disciplinaTemp);   // guarda a nota

                    } while (saida != "0");
                    alunoTemp.disciplinas = listaDisciplinasTemp;
				    listasequencial.inserirAlunoOrdenado(alunoTemp);            // guarda as informações na lista
                    break;
                case 2:
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

                case 3:
                    
                    break;
                
                case 4:
                    
                    break;
                
                case 5:
                    
                    break;
                
                case 6:

                    break;
            
                default:
                    break;
            }








            


        } while (escolha != 5);
















        // listasequencial.creditos();
    }

}
