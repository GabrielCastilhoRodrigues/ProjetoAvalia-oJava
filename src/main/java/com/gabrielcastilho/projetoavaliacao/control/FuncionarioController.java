package com.gabrielcastilho.projetoavaliacao.control;

import com.gabrielcastilho.projetoavaliacao.model.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gabri
 * 
 * Controle das operações que devem ser realizadas pela classe Funcionario.
 */
public class FuncionarioController {
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private Period maiorIdade;
    private Funcionario funcionarioMaiorIdade;
    
    /**
     * Cadastro o funcionário com base das informações adicionadas, depois 
     * vincula com a listagem presente.
     * 
     * @param nome     
     *   Nome do funcionário.
     * @param dataNascimento     
     *   Data de Nascimento do funcionário.
     * @param salario     
     *   Salário do funcionário.
     * @param funcao     
     *   Função do funcionário.
     */
    protected void cadastraFuncionario(String nome, LocalDate dataNascimento, 
                                       BigDecimal salario, String funcao){
        funcionarios.add(new Funcionario(nome, dataNascimento, salario,funcao));
    }
    
    /**
     * Arredonda o valor BigDecimal para 2 casas decimais.
     * 
     * @param valor
     *   Valor que será feito o arredondamento
     * @return 
     *   Valor com o arredondamento.
     */
    protected BigDecimal retornaValorArredondado(BigDecimal valor){
        valor = valor.setScale(2, BigDecimal.ROUND_HALF_UP);
        
        return valor;
    }
    
    /**
     * Realiza a inserção dos funcionários esperados para o exercicio.
     * Exercício 3.1
     * 
     * @return 
     *   Lista de funcionarios.
     */
    public List<Funcionario> insereFuncionariosQuestao(){        
        cadastraFuncionario("Maria", 
                            LocalDate.of(2000, 10, 18),
                            retornaValorArredondado(new BigDecimal(2009.44)), 
                            "Operador");
        
        cadastraFuncionario("João", 
                            LocalDate.of(1990, 5, 12),
                            retornaValorArredondado(new BigDecimal(2284.38)), 
                            "Operador");
        
        cadastraFuncionario("Caio", 
                            LocalDate.of(1961, 5, 2),
                            retornaValorArredondado(new BigDecimal(9836.14)), 
                            "Coordenador");
        
        cadastraFuncionario("Miguel", 
                            LocalDate.of(1988, 10, 14),
                            retornaValorArredondado(new BigDecimal(19119.88)), 
                            "Diretor");
        
        cadastraFuncionario("Alice", 
                            LocalDate.of(1995, 1, 5),
                            retornaValorArredondado(new BigDecimal(2234.68)),
                            "Recepcionista");
        
        cadastraFuncionario("Heitor", 
                            LocalDate.of(1999, 11, 19),
                            retornaValorArredondado(new BigDecimal(1582.72)), 
                            "Operador");
        
        cadastraFuncionario("Arthur", 
                            LocalDate.of(1993, 3, 31),
                            retornaValorArredondado(new BigDecimal(4071.84)), 
                            "Contador");
        
        cadastraFuncionario("Laura", 
                            LocalDate.of(1994, 7, 8),
                            retornaValorArredondado(new BigDecimal(3017.45)), 
                            "Gerente");
        
        cadastraFuncionario("Heloísa", 
                            LocalDate.of(2003, 5, 24),
                            retornaValorArredondado(new BigDecimal(1606.85)), 
                            "Eletricista");
        
        cadastraFuncionario("Helena", 
                            LocalDate.of(1996, 9, 2),
                            retornaValorArredondado(new BigDecimal(2799.93)), 
                            "Gerente");
        
        return funcionarios;
    }
    
    /**
     * Remove da listagem de Funcionarios, o Funcionario com nome "João".
     * Exercício 3.2
     * 
     * @return 
     *   Lista de funcionários, sem o "João".
     */
    public List<Funcionario> removeFuncionarioJoao(){
        if (!funcionarios.isEmpty()){
            funcionarios.removeIf(
                    funcionario -> funcionario.getNome().equals("João"));
        }
        
        return funcionarios;
    }
    
    /**
     * Realiza o retorno da listagem de Funcionários.
     * 
     * @return     
     *   Lista de funcionários.
     */
    public List<Funcionario> retornaFuncionarios(){
        return funcionarios;
    }
    
    /**
     * Realiza a adição de 10% ao salário dos funcionários
     * Exercício 3.4
     * 
     * @return   
     *   Lista de funcionários com o salário atualizado.
     */
    public List<Funcionario> atualizaSalario(){
        funcionarios.forEach(funcionario -> {
            funcionario.setSalario(funcionario.getSalario().add(
                    funcionario.getSalario().multiply(new BigDecimal(0.1))));
        });
        
        return funcionarios;
    }
    
    /**
     * Realiza a ordenação dos funcionários, com base das suas funções.
     * Exercício 3.5 e 3.6
     * 
     * @return 
     *   Lista de funcionários ordenados por Função.
     */
    public List<Funcionario> ordenaFuncionarioPorFuncao(){
        Map<String, List<Funcionario>> funcionarioPorFuncao = 
            funcionarios.stream().collect(
                    Collectors.groupingBy(Funcionario::getFuncao));
        
        List<Funcionario> funcionariosOrdenados = new ArrayList<>();
        
        funcionarioPorFuncao.forEach((funcao, funcs) -> {
            for (Funcionario funcionario: funcs){
                funcionariosOrdenados.add(funcionario);
            }
        });
        
        return funcionariosOrdenados;
    }
    
    /**
     * Ajusta a listagem de funcionários para sua ordem original.
     * Exercício 3.3
     * 
     * @return 
     *   Lista dos funcionários inseridos.
     */
    public List<Funcionario> ordemPadraoFuncionarios(){
        return funcionarios;
    }
    
    /**
     * Gera lista de funcionários que fazem aniversário no mês 10 e 12.
     * Exercício 3.8
     * 
     * @return 
     *   Lista com os funcionários que fazem aniversário no mês 10 e 12.
     */
    public List<Funcionario> apresentaFuncionariosComBaseDoAniversario(){
        List<Funcionario> funcionariosComAniversarioEntreDatas = 
                new ArrayList<>();
        
        funcionarios.forEach(funcionario -> {
            if (funcionario.getDataNascimento().getMonthValue() == 10 ||
                funcionario.getDataNascimento().getMonthValue() == 12){
                funcionariosComAniversarioEntreDatas.add(funcionario);
            }
        });

        return funcionariosComAniversarioEntreDatas;
    }
    
    /**
     * Calcula qual o funcionário que possui a maior idade.
     * Exercício 3.9
     * 
     * @return 
     *   Funcionário com a maior idade.
     */
    public Funcionario funcionarioComMaiorIdade(){
        funcionarioMaiorIdade = null;
        
        maiorIdade = Period.between(
                     funcionarios.getFirst().getDataNascimento(), 
                     LocalDate.now()
                     );
        
        funcionarios.forEach(funcionario -> {
            Period idadeFuncionario = Period.between(
                                      funcionario.getDataNascimento(),
                                      LocalDate.now()
                                      );
            
            if (idadeFuncionario.getYears() > maiorIdade.getYears()){
                maiorIdade = idadeFuncionario;
                funcionarioMaiorIdade = funcionario;
            }
        });
        
        return funcionarioMaiorIdade;
    }
    
    /**
     * Realiza a soma dos salários dos funcionários
     * Exércicio 3.11
     * 
     * @return 
     *   Soma dos salários dos funcionários
     */
    public BigDecimal totalSalarioFuncionarios(){
        BigDecimal totalSalario = BigDecimal.ZERO;
        
        for (Funcionario funcionario: funcionarios){
            totalSalario = totalSalario.add(funcionario.getSalario());
        }
        
        return totalSalario;
    }
    
    /**
     * Calcula a proporção de quantidade de salário mínímos, com base do salário
     * do funcionário.
     * Exercicio 3.12
     * 
     * @param funcionario
     *   Funcionário que será calculado o salário.
     * @return 
     *   Quantidade de salário mínimo proporcional ao salário do Funcionário.
     */
    public BigDecimal retornaQuantidadeSalarioMinimo(Funcionario funcionario){
        BigDecimal qtdeSalarioMinimo = funcionario.getSalario()
                                       .divide(new BigDecimal(1212.00), 2, RoundingMode.HALF_UP);
        
        return qtdeSalarioMinimo;
    }
}
