package main.calculadoras;

public class CalculadoraDeSalarioPessoaJuridica extends CalculadoraDeSalario {
    private Double impostos = null;
    public void setImpostos(Double impostos) {
        this.impostos = impostos;
    }
    @Override
    public Double calcular(Double salarioBruto, Double descontos, Double bonus) {
        return super.calcular(salarioBruto, descontos, bonus) - impostos;
    }
}
