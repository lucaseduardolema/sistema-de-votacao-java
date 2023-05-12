package com.trybe.acc.java.sistemadevotacao;

/**
 * .
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * .
   */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos() {
    this.votos += 1;
  }

  public void receberVotos() {
    this.setVotos();
  }
}
