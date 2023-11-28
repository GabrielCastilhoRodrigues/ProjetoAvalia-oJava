package com.gabrielcastilho.projetoavaliacao.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author gabri
 * 
 * Definição dos atributos e métodos da classe Funcionario.
 */
public class Funcionario extends Pessoa{
    protected BigDecimal salario;
    protected String funcao;
    
    /**
     * Construtor da classe Funcionario.
     * 
     * @param nome
     *   Nome do funcionário.
     * @param dataNascimento
     *   Data de Nascimento do funcionário.
     * @param salario
     *   Salário do Funcionário.
     * @param funcao
     *   Função do Funcionário.
     */
    public Funcionario(String nome, LocalDate dataNascimento, 
                       BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }   

    /**
     * Retorna os dados do Funcionario, com as formatações solicitadas.
     * Exercício 3.3
     * 
     * @return 
     *   O salário do funcionário.
     */
    public String retornaDataNascimento() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        return dtf.format(dataNascimento);
    }
    
    /**
     * Retorna os dados do Funcionario, com as formatações solicitadas.
     * Exercício 3.3
     * 
     * @return 
     *   O salário do funcionário.
     */
    public String retornaSalario(){
        Locale brasil = new Locale("pt", "BR");
        DecimalFormat df = new DecimalFormat("#,##0.00", 
                                             new DecimalFormatSymbols(brasil));
        df.setParseBigDecimal(true);
        
        return df.format(salario);
    }
}
