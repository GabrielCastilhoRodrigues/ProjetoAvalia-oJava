package com.gabrielcastilho.projetoavaliacao.model;

import java.time.LocalDate;

/**
 * @author gabri
 * 
 * Definição dos atributos e métodos da classe Pessoa.
 */
public class Pessoa {
    protected String nome;
    protected LocalDate dataNascimento;

    /**
     * Construtor da classe Pessoa.
     * 
     * @param nome
     *    Nome da Pessoa.
     * @param dataNascimento
     *    Data de Nascimento da Pessoa.
     */
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {        
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
