package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * .
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos;

  /**
   * .
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numero) {
        System.out.println("\nNúmero pessoa candidata já utilizado!\n");
        return;
      }
    }

    PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novoCandidato);
  }

  /**
   * .
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora wasRegistred =
        pessoasEleitoras.stream().filter(e -> cpf.equals(e.getCpf())).findFirst().orElse(null);

    if (wasRegistred != null) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }

    PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(novoEleitor);
  }

  /**
   * .
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numeroPessoaCandidata) {
        candidato.receberVotos();
      }
    }
    cpfComputado.add(cpfPessoaEleitora);
    this.setTotalVotos();
  }

  /**
   * .
   */
  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    for (PessoaCandidata candidato : pessoasCandidatas) {
      System.out.println(String.format("Nome: %s - %o votos ( %.2f )\n", candidato.getNome(),
          candidato.getVotos(), this.calcularPorcentagemVotos(candidato.getNumero())));
    }
    System.out.println("Total de votos: " + totalVotos);
  }

  private double calcularPorcentagemVotos(int idxPessoaCandidata) {
    double percent = 0;
    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == idxPessoaCandidata) {
        percent = (candidato.getVotos() * 100) / totalVotos;
        break;
      }
    }
    return percent;
  }

  public int getTotalVotos() {
    return totalVotos;
  }

  public void setTotalVotos() {
    this.totalVotos += 1;
  }
}
