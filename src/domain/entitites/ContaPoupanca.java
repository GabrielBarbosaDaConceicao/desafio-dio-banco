package domain.entitites;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(double depositoInicial, Cliente cliente) {
        super(depositoInicial, cliente);
    }

    public ContaPoupanca( Cliente cliente) {
        super(cliente);
    }
}
