package main;

/*Criar uma classe pai que siga a seguinte regra de negócio

1 - O salarioBruto não pode ser menor do que o salário minimo (1302)

2 - Os descontos não podem ser maiores do que o sálario bruto

3 - O bonus não deve ser superior a 1000

Criar pelo menos 1 exemplo de classe filha que não viole o principio da substituição de LISKOV

Criar pelo menos 1 exemplo de clase filha que viole a substituição de LISKOV*/

import main.calculadoras.CalculadoraDeSalario;
import main.calculadoras.CalculadoraDeSalarioPessoaFisica;
import main.calculadoras.CalculadoraDeSalarioPessoaJuridica;

public class Main {
    public static void main(String[] args) {
        Double salarioBrutoValido = 5000., bonusValido = 900., descontosValido = 700.;
        Double salarioBrutoInvalido = 1000., bonusInvalido = 2000., descontosInvalido = 3000.;
        CalculadoraDeSalario calculadoraDeSalario = new CalculadoraDeSalario();
        System.out.println(calculadoraDeSalario.calcular(salarioBrutoValido, descontosValido, bonusValido));
        System.out.println(calculadoraDeSalario.calcular(salarioBrutoInvalido, descontosValido, bonusValido));
        System.out.println(calculadoraDeSalario.calcular(salarioBrutoValido,descontosInvalido,bonusValido));
        System.out.println(calculadoraDeSalario.calcular(salarioBrutoValido,descontosValido,bonusInvalido));
        // não viola o principio da substituição de LISKOV
        CalculadoraDeSalarioPessoaFisica calculadoraDeSalarioPessoaFisica = new CalculadoraDeSalarioPessoaFisica();
        calculadoraDeSalarioPessoaFisica.setImpostoRenda(1000);
        System.out.println(calculadoraDeSalarioPessoaFisica.calcular(salarioBrutoValido, descontosValido, bonusValido));
        System.out.println(calculadoraDeSalarioPessoaFisica.calcular(salarioBrutoInvalido, descontosValido, bonusValido));
        System.out.println(calculadoraDeSalarioPessoaFisica.calcular(salarioBrutoValido,descontosInvalido,bonusValido));
        System.out.println(calculadoraDeSalarioPessoaFisica.calcular(salarioBrutoValido,descontosValido,bonusInvalido));

        calculadoraDeSalarioPessoaFisica.setImpostoRenda(-100);
        System.out.println(calculadoraDeSalarioPessoaFisica.calcular(salarioBrutoValido, descontosValido, bonusValido));

        // viola a substituição de LISKOV
        CalculadoraDeSalarioPessoaJuridica calculadoraDeSalarioPessoaJuridica = new CalculadoraDeSalarioPessoaJuridica();
        Double imposto1 = 1000., imposto2 = 100000.;
        calculadoraDeSalarioPessoaJuridica.setImpostos(imposto1);
        System.out.println(calculadoraDeSalarioPessoaJuridica.calcular(salarioBrutoValido, descontosValido, bonusValido));
        System.out.println(calculadoraDeSalarioPessoaJuridica.calcular(salarioBrutoInvalido, descontosValido, bonusValido));
        System.out.println(calculadoraDeSalarioPessoaJuridica.calcular(salarioBrutoValido,descontosInvalido,bonusValido));
        System.out.println(calculadoraDeSalarioPessoaJuridica.calcular(salarioBrutoValido,descontosValido,bonusInvalido));
        calculadoraDeSalarioPessoaJuridica.setImpostos(null);
        System.out.println(calculadoraDeSalarioPessoaJuridica.calcular(salarioBrutoValido, descontosValido, bonusValido));
        System.out.println(calculadoraDeSalarioPessoaJuridica.calcular(salarioBrutoInvalido, descontosValido, bonusValido));
        System.out.println(calculadoraDeSalarioPessoaJuridica.calcular(salarioBrutoValido,descontosInvalido,bonusValido));
        System.out.println(calculadoraDeSalarioPessoaJuridica.calcular(salarioBrutoValido,descontosValido,bonusInvalido));

    }
}
