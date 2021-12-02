package br.inatel.projeto;

import br.inatel.projeto.Jogador;

public abstract class Personagem {
    private String nome;
    private String rota;
    private int vida;
    private int mana;
    private int danoAtaque;
    private int armadura;
    private int resistenciaMagica;

    public Personagem(String nome, int vida, int mana, int danoAtaque, int armadura, int resistenciaMagica) {
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.danoAtaque = danoAtaque;
        this.armadura = armadura;
        this.resistenciaMagica = resistenciaMagica;
    }

    public Personagem(String nome){
        this.nome = nome;
    }

    public Personagem() {
    }

    public abstract void info();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDanoAtaque() {
        return danoAtaque;
    }

    public void setDanoAtaque(int danoAtaque) {
        this.danoAtaque = danoAtaque;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getResistenciaMagica() {
        return resistenciaMagica;
    }

    public void setResistenciaMagica(int resistenciaMagica) {
        this.resistenciaMagica = resistenciaMagica;
    }
}
