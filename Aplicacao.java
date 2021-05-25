package br.com.letscode;

import java.math.BigDecimal;

public class Aplicacao {

    public static void main(String[] args) {
Cliente[] novosClientes = {new Cliente("Larissa", "1234", TipoCliente.PF), new Cliente("Caio",
        "6543", TipoCliente.PF), new Cliente("Let's Code", "7890", TipoCliente.PJ)};

ContaBancaria[] novasContas = {new ContaBancaria(TipoConta.POUPANÇA, 0), new ContaBancaria(TipoConta.CORRENTE, 0),
        new ContaBancaria(TipoConta.INVESTIMENTO, 0)};

double[] aDepositar = {2000, 5000, 1000000};

        double[] aSacar = {500, 2000, 10000};

        double[] aTransferir = {100, 1000, 100};

        double[] aInvestir = {1000, 1000, 500000};

ContaBancaria.abrirConta(novasContas, novosClientes);
ContaBancaria.depositar(novasContas, novosClientes, aDepositar);
ContaBancaria.sacar(novasContas, novosClientes, aSacar);
ContaBancaria.transferir(novasContas,novosClientes,aTransferir);
ContaBancaria.investir(novasContas,novosClientes,aInvestir);
ContaBancaria.consultarSaldo(novasContas, novosClientes);
    }
}
