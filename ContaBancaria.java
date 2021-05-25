package br.com.letscode;

import java.math.BigDecimal;

public class ContaBancaria {
    private TipoConta tipoConta;
    private double saldo;

    public ContaBancaria() {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public ContaBancaria(TipoConta tipoConta, double saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static void abrirConta(ContaBancaria[] novasContas, Cliente[] novosClientes) {
        System.out.println("➽Iniciando abertura de contas;");
        for (int i = 0; i < novasContas.length; i++) {
            System.out.printf("%s, sua conta %s foi aberta com sucesso!\n", novosClientes[i].getNome(), novasContas[i].getTipoConta());
            if (novosClientes[i].getTipoCliente() == TipoCliente.PJ) {
                System.out.printf("%s, as contas PJ são cobradas uma taxa de 0.5%% por saque e transferência e as " +
                        "suas contas Investimento rendem 2%% a mais.\n", novosClientes[i].getNome());
            }
        }
    }

    public static void depositar(ContaBancaria[] novasContas, Cliente[] novosClientes, double[] aDepositar) {
        System.out.println("➽Iniciando depósitos nas contas;");
        for (int i = 0; i < novasContas.length; i++) {
            novasContas[i].setSaldo(novasContas[i].getSaldo() + aDepositar[i]);
            System.out.printf("%s, você depositou R$%.2f na sua conta %s com sucesso!\n", novosClientes[i].getNome(), aDepositar[i],
                    novasContas[i].getTipoConta());
        }
    }

    public static void sacar(ContaBancaria[] novasContas, Cliente[] novosClientes, double[] aSacar) {
        System.out.println("➽Iniciando saques nas contas;");
        for (int i = 0; i < novasContas.length; i++) {
            if (novosClientes[i].getTipoCliente() == TipoCliente.PF && novasContas[i].getSaldo() >= aSacar[i]) {
                novasContas[i].setSaldo(novasContas[i].getSaldo() - aSacar[i]);
                System.out.printf("%s, você sacou R$%.2f da sua conta %s com sucesso!\n", novosClientes[i].getNome(), aSacar[i],
                        novasContas[i].getTipoConta());
            }
            double saquePJ = (aSacar[i] + (aSacar[i] * 0.5 / 100));
            if (novosClientes[i].getTipoCliente() == TipoCliente.PJ && novasContas[i].getSaldo() >= saquePJ) {
                novasContas[i].setSaldo(novasContas[i].getSaldo() - saquePJ);
                System.out.printf("%s, você sacou R$%.2f da sua conta %s com 0.5%% de taxa com sucesso!\n", novosClientes[i].getNome(), saquePJ,
                        novasContas[i].getTipoConta());
            }
            if (novasContas[i].getSaldo() < (aSacar[i] + (aSacar[i] * 0.5 / 100)) || novasContas[i].getSaldo() < aSacar[i]) {
                System.out.printf("%s, o seu saldo é insuficiente para realizar um saque na conta %s.\n", novosClientes[i].getNome(),
                        novasContas[i].getTipoConta());
            }
        }
    }

    public static void transferir(ContaBancaria[] novasContas, Cliente[] novosClientes, double[] aTransferir) {
        System.out.println("➽Iniciando transferências nas contas;");
        for (int i = 0; i < novasContas.length; i++) {
            if (novosClientes[i].getTipoCliente() == TipoCliente.PF && novasContas[i].getSaldo() >= aTransferir[i]) {
                novasContas[i].setSaldo(novasContas[i].getSaldo() - aTransferir[i]);
                System.out.printf("%s, você transferiu R$%.2f da sua conta %s com sucesso!\n", novosClientes[i].getNome(), aTransferir[i],
                        novasContas[i].getTipoConta());
            }
            double transferenciaPJ = (aTransferir[i] + (aTransferir[i] * 0.5 / 100));
            if (novosClientes[i].getTipoCliente() == TipoCliente.PJ && novasContas[i].getSaldo() >= transferenciaPJ) {
                novasContas[i].setSaldo(novasContas[i].getSaldo() - transferenciaPJ);
                System.out.printf("%s, você transferiu R$%.2f da sua conta %s com 0.5%% de taxa com sucesso!\n", novosClientes[i].getNome(), transferenciaPJ,
                        novasContas[i].getTipoConta());
            }
            if (novasContas[i].getSaldo() < transferenciaPJ || novasContas[i].getSaldo() < aTransferir[i]) {
                System.out.printf("%s, o seu saldo é insuficiente para realizar uma transferência na conta %s.\n", novosClientes[i].getNome(),
                        novasContas[i].getTipoConta());
            }
        }
    }

    public static void investir(ContaBancaria[] novasContas, Cliente[] novosClientes, double[] aInvestir) {
        System.out.println("➽Iniciando investimentos;");
        for (int i = 0; i < novasContas.length; i++) {
            if(novasContas[i].getSaldo() < aInvestir[i]) {
                System.out.printf("%s, o seu saldo é insuficiente para realizar investimento na conta INVESTIMENTO.\n", novosClientes[i].getNome());
            }
            if (novasContas[i].getSaldo() >= aInvestir[i]) {
                novasContas[i].setSaldo(novasContas[i].getSaldo() - aInvestir[i]);
            }
            if (novasContas[i].getTipoConta() == TipoConta.INVESTIMENTO) {
                novasContas[i].setSaldo(novasContas[i].getSaldo() + aInvestir[i]);
                System.out.printf("%s, o dinheiro que você deseja investir já está na sua conta INVESTIMENTO.\n", novosClientes[i].getNome(), aInvestir[i]);
            }
            if (novasContas[i].getTipoConta() != TipoConta.INVESTIMENTO) {
            novasContas[i].setSaldo(novasContas[i].getSaldo() + aInvestir[i]);
            System.out.printf("%s, crie uma conta INVESTIMENTO para investir o seu dinheiro.\n", novosClientes[i].getNome());
            }
        }
    }


       public static void consultarSaldo(ContaBancaria[] novasContas, Cliente[] novosClientes) {
        System.out.println("➽Iniciando consulta de saldo;");
        for (int i = 0; i < novasContas.length; i++) {
            if (novasContas[i].getTipoConta() != TipoConta.INVESTIMENTO && novosClientes[i].getTipoCliente() != TipoCliente.PJ) {
                System.out.printf("%s, seu saldo na conta %s é: R$%.2f.\n", novosClientes[i].getNome(), novasContas[i].getTipoConta(), novasContas[i].getSaldo());
            }
            if (novasContas[i].getTipoConta() == TipoConta.INVESTIMENTO && novosClientes[i].getTipoCliente() == TipoCliente.PJ) {
                novasContas[i].setSaldo(novasContas[i].getSaldo() + (novasContas[i].getSaldo() * 2 / 100));
                System.out.printf("%s, seu saldo na conta %s é: R$%.2f.\n", novosClientes[i].getNome(), novasContas[i].getTipoConta(), novasContas[i].getSaldo());
            }
        }

    }
}