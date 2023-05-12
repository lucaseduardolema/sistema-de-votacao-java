package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * .
 */
public class Principal {

  /**
   * .
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    GerenciamentoVotacao gerenciador = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);
    short option = 1;
    short menu = 1;
    String nome;
    int numCandidato;
    String cpf;

    while (menu == 1) {
      System.out.println("Cadastrar pessoa candidata?\n" + "1 - Sim\n" + "2 - Não\n"
          + "Entre com o número correspondente à opção desejada:");

      option = scanner.nextShort();

      switch (option) {
        case 1:
          System.out.println("Entre com o nome da pessoa candidata:");
          nome = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          numCandidato = scanner.nextInt();
          gerenciador.cadastrarPessoaCandidata(nome, numCandidato);
          break;
        case 2:
          menu = 2;
          break;
        default:
          System.out.println("Opção inválida");
      }
    }

    while (menu == 2) {
      System.out.println("\n\nCadastrar pessoa eleitora?\n" + "1 - Sim\n" + "2 - Não\n"
          + "Entre com o número correspondente à opção desejada:");

      option = scanner.nextShort();

      switch (option) {
        case 1:
          System.out.println("Entre com o nome da pessoa eleitora:");
          nome = scanner.next();
          System.out.println("Entre com o cpf da pessoa eleitora:");
          cpf = scanner.next();
          gerenciador.cadastrarPessoaEleitora(nome, cpf);
          break;
        case 2:
          menu = 3;
          break;
        default:
          System.out.println("Opção inválida");
      }
    }

    while (menu == 3) {
      System.out.println("\n\nEntre com o número correspondente à opção desejada:\n" + "1 - Votar\n"
          + "2 - Resultado Parcial\n" + "3 - Finalizar Votação");

      option = scanner.nextShort();

      switch (option) {
        case 1:
          System.out.println("Entre com o cpf da pessoa eleitora:");
          cpf = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          numCandidato = scanner.nextInt();
          gerenciador.votar(cpf, numCandidato);
          break;
        case 2:
          gerenciador.mostrarResultado();
          break;
        case 3:
          gerenciador.mostrarResultado();
          menu = 0;
          break;
        default:
          System.out.println("Opção inválida");
      }
    }
    scanner.close();
  }
}
