package dto;

import enums.Cargo;

public class CriarContaUsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private Cargo cargo;

    public CriarContaUsuarioDTO(String nome, String email, String senha, Cargo cargo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Cargo getCargo() {
        return cargo;
    }

}
