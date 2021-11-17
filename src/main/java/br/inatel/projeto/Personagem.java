package br.inatel.projeto;

import br.inatel.projeto.Jogador;

public abstract class Personagem {
    private Jogador jogador;
    private String nome;
    private String rota;
    //private String classe;
    //private Item[6] itens;
    private int vida;
    private int mana;
    private int dano_ataque;
    private int armadura;
    private int resistencia_magica;

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

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

    public int getDano_ataque() {
        return dano_ataque;
    }

    public void setDano_ataque(int dano_ataque) {
        this.dano_ataque = dano_ataque;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getResistencia_magica() {
        return resistencia_magica;
    }

    public void setResistencia_magica(int resistencia_magica) {
        this.resistencia_magica = resistencia_magica;
    }
}
