package com.Bgrupo4.hospitalupskill.domain;


import java.sql.Date;

public class User {
    private String nome;
    private String userName;
    private int nUtente;
    private String morada;
    private String localidade;
    private String email;
    private int telemovel;
    private Date dataDeNascimento;
    private String password;
    private String passwordRepeat;
    private boolean condicao;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public boolean isCondicao() {
        return condicao;
    }

    public void setCondicao(boolean condicao) {
        this.condicao = condicao;
    }

    public int getnUtente() {
        return nUtente;
    }

    public void setnUtente(int nUtente) {
        this.nUtente = nUtente;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", userName='" + userName + '\'' +
                ", nUtente=" + nUtente +
                ", morada='" + morada + '\'' +
                ", localidade='" + localidade + '\'' +
                ", email='" + email + '\'' +
                ", telemovel=" + telemovel +
                ", dataDeNascimento=" + dataDeNascimento +
                ", password='" + password + '\'' +
                ", passwordRepeat='" + passwordRepeat + '\'' +
                ", condicao=" + condicao +
                '}';
    }
}
