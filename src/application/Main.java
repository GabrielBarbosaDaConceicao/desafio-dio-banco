package application;

import domain.entitites.Cliente;
import domain.entitites.Conta;
import domain.entitites.ContaCorrente;
import domain.entitites.ContaPoupanca;
import domain.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Conta conta;

        System.out.println();
        System.out.println("======= Criar conta ======");
        System.out.print("Informe o nome: ");
        String nome = sc.nextLine();

        System.out.print("Informe o sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Informe o email: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, email);
        cliente.adicionarCliente(cliente);

        System.out.println();
        System.out.println("==========================");
        System.out.print("Deseja fazer um deposito inicial (s/n)? ");
        char ch = sc.next().charAt(0);

        System.out.println();
        if (ch == 's'){
            System.out.print("Informe o valor do deposito inicial: ");
            double depositoInicial = sc.nextDouble();

            conta = new ContaCorrente(depositoInicial, cliente);
        }else{
            conta = new ContaCorrente(cliente);
        }

        System.out.println();
        System.out.println(conta);

        try{
            System.out.print("Informe o valor para saque: ");
            double valor = sc.nextDouble();
            conta.saque(valor);

            System.out.println();
            System.out.println("Dados atualizados:");
            System.out.println(conta);

            sc.nextLine();
            System.out.print("Informe o nome: ");
            nome = sc.nextLine();

            System.out.print("Informe o sobrenome: ");
            sobrenome = sc.nextLine();

            System.out.print("Informe o email: ");
            email = sc.nextLine();

            Cliente cliente2 = new Cliente(nome, sobrenome, email);


            System.out.println();
            System.out.print("Informe o valor de transferênca: ");
            double valorTransferencia = sc.nextDouble();

            Conta contaPoupanca = new ContaPoupanca(cliente2);
            conta.transferencia(valorTransferencia, contaPoupanca);

            System.out.println();
            System.out.println(contaPoupanca);

        }catch (Exception e){
            System.out.println("ERRO: " + e.getMessage());
        }

        sc.close();
    }
}
