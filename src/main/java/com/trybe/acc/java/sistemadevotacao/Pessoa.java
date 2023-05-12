package com.trybe.acc.java.sistemadevotacao;

/**
 * .
 */
public abstract class Pessoa {
  protected String nome;

  public Pessoa(String nome2) {
    // TODO Auto-generated constructor stub
    this.setNome(nome2);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
