package com.mycompany.mainn;

public class Pessoa {

    private int id;
    private String sexo;
    private int idade;
    private boolean gestante;
    private boolean lactante;
    private boolean necessidadeEspecial;

    public Pessoa(int id, String sexo, int idade, boolean gestante, boolean lactante, boolean necessidadeEspecial) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isGestante() {
        return gestante;
    }

    public void setGestante(boolean gestante) {
        this.gestante = gestante;
    }

    public boolean isLactante() {
        return lactante;
    }

    public void setLactante(boolean lactante) {
        this.lactante = lactante;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public void setNecessidadeEspecial(boolean necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }

}
