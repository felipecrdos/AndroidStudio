package com.udemy.androidhttp;

import android.graphics.Bitmap;
public class Pessoa {

    private String nome;
    private String sobrenome;
    private String email;
    private String cidade;
    private String estado;
    private Bitmap avatar;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }
}
