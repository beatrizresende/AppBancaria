package br.com.letscode;

public class Cliente {
    private String nome;
    private String senha;
    private TipoCliente tipoCliente;

    public Cliente() {
        this.nome = nome;
        this.senha = senha;
        this.tipoCliente = tipoCliente;
    }

    public Cliente (String nome, String senha, TipoCliente tipoCliente) {
        this.nome = nome;
        this.senha = senha;
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
