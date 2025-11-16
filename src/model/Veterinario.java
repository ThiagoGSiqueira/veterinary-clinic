package model;

public class Veterinario {

    private int idVet;
    private String nome;
    private String crmv;
    private String telefone;

    public Veterinario(String nome, String crmv, String telefone) {
        this.nome = nome;
        this.crmv = crmv;
        this.telefone = telefone;
    }

    public Veterinario(String nome, String crmv, String telefone, int idVet) {
        this(nome, crmv, telefone);
        this.idVet = idVet;
    }

    public int getIdVet() {
        return idVet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
