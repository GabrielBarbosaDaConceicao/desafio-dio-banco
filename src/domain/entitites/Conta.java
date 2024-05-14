package domain.entitites;

import domain.enuns.TipoOperacao;
import domain.exceptions.DomainException;
import domain.util.Message;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    protected Integer numero = 1;
    protected Double depositoInicial;
    protected Double saldo = 0.0;

    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.numero = numero + 1;
        this.cliente = cliente;
        this.depositoInicial = 0.0;
    }
    public Conta(double depositoInicial, Cliente cliente){
        this.numero = numero++;
        deposito(depositoInicial);
        this.cliente = cliente;
    }

    public int getNumero(){
        return numero;
    }
    public double getSaldo(){
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void deposito(double valor){
        saldo += valor;
        Message.depositoSucesso();
    }

    public void saque(double valor) throws Exception {
        if (saldo < valor){
            throw new Exception("Saldo insuficiente. O valor do saldo é inferior ao valor solicitado Saldo atual: [" + String.format("%.2f", getSaldo()) + " ]");
        }
        saldo -= valor;
        Message.saqueSucesso();
    }

    public void transferencia(double valor, Conta conta) throws Exception {
        if (saldo < valor){
            throw new Exception("Saldo insuficiente para realizar transferência. Saldo atual: [" + String.format("%.2f", getSaldo()) + " ]");
        }
        saque(valor);
        conta.deposito(valor);
        Message.transferenciaSucesso();
    }

    @Override
    public String toString() {
        return " ========= Extrato ========= \n"
                + "* Cliente: " + getCliente().getNomeCompleto()
                + "\n* Email: " + getCliente().getEmail()
                + "\n* Numero Conta: [ " + getNumero() + " ]"
                + "\n** Saldo Atual: " + String.format("%.2f", getSaldo())
                + "\n*****************************";
    }
}
