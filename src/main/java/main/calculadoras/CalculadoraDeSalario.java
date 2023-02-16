package main.calculadoras;

import main.utils.VerificaBonus;
import main.utils.VerificaDescontos;
import main.utils.VerificaSalarioBruto;

public class CalculadoraDeSalario implements CalculadoraDeSalarioLiquido, VerificaDescontos, VerificaBonus, VerificaSalarioBruto {
    private final int salarioMinimo = 1302;
    private final int bonusMaximo = 1000;
    @Override
    public Double calcular(Double salarioBruto, Double descontos, Double bonus) {
        verificaSalarioBruto(salarioBruto);
        verificaDescontos(salarioBruto, descontos);
        verificaBonus(bonus);
        return salarioBruto + bonus - descontos;
    }
    @Override
    public void verificaSalarioBruto(Double salarioBruto) {
        try {
            if (salarioBruto < salarioMinimo) {
                throw new IllegalArgumentException("O salário bruto não pode ser menor que o salário mínimo!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
    @Override
    public void verificaDescontos(Double salarioBruto, Double descontos) {
        try {
            if (salarioBruto < descontos) {
                throw new IllegalArgumentException("Os decontos não podem ser maiores que o salário bruto!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
    @Override
    public void verificaBonus(Double bonus) {
        try {
            if (bonus > bonusMaximo) {
                throw new IllegalArgumentException("O bonus não pode ser maior que o bonus máximo!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
}
