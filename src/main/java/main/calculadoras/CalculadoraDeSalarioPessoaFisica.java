package main.calculadoras;

public class CalculadoraDeSalarioPessoaFisica extends CalculadoraDeSalario {
    private double impostoRenda = 0.;
    public double getImpostoRenda() {
        return impostoRenda;
    }
    public void setImpostoRenda(double impostoRenda) {
        if (impostoRenda > 0) {
            this.impostoRenda = impostoRenda;
        } else if (impostoRenda < 0) {
            this.impostoRenda = impostoRenda * -1;
        }
    }
    @Override
    public Double calcular(Double salarioBruto, Double descontos, Double bonus) {
        Double salarioLiquido = super.calcular(salarioBruto, descontos, bonus) - impostoRenda;
        if (salarioLiquido > 0) {
            return salarioLiquido;
        } else {
            System.out.println("Imposto de renda inválido!");
            return super.calcular(salarioBruto, descontos, bonus);
        }
    }
}
