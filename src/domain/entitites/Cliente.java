package domain.entitites;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String sobrenome;
    private String email;

    //private String nomeCompleto = getNome() + " " + getSobrenome();

    private List<Cliente> clientes = new ArrayList<Cliente>();

    public Cliente(String nome, String sobrenome, String email){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public String getEmail(){
        return email.toLowerCase();
    }

    public String getNomeCompleto(){
        String nomeCompleto = nome + " " + sobrenome;
        return nomeCompleto.toUpperCase();
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

}
