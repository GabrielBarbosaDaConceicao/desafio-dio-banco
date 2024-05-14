package domain.entitites;

public class ContaCorrente extends Conta{

    private final Double TAXA_SAQUE = 5.0;

    public ContaCorrente(double depositoInicial, Cliente cliente) {
        super(depositoInicial, cliente);
    }

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void saque(double valor) throws Exception {
        saldo -= valor + TAXA_SAQUE;
    }
}
