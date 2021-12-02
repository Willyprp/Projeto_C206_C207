package br.inatel.projeto.Classes;

import br.inatel.projeto.Personagem;

public class Auto_Ataque extends Personagem implements Atirador{

    public Auto_Ataque(String nome, int vida, int mana, int danoAtaque, int armadura, int resistenciaMagica) {
        super(nome, vida, mana, danoAtaque, armadura, resistenciaMagica);
    }
    public Auto_Ataque(String nome){
        super(nome);
    }

    public Auto_Ataque(){
    }

    @Override
    public void atirador() {
        System.out.println("Causa muito dano utilizando seus ataques básicos");
        System.out.println("Precisa ter itens de dano e velocidade de ataque para que seu dano seja relevante");
    }

    @Override
    public void info() {
        System.out.println("Geralmente começa a ter impacto no jogo após 3 itens finalizados");
    }
}
