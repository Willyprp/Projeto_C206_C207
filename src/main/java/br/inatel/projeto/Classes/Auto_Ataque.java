package br.inatel.projeto.Classes;

import br.inatel.projeto.Personagem;

public class Auto_Ataque extends Personagem implements Atirador{

    public Auto_Ataque(String nome, int vida, int mana, int danoAtaque, int armadura, int resistenciaMagica) {
        super(nome, vida, mana, danoAtaque, armadura, resistenciaMagica);
    }
    public Auto_Ataque(String nome){
        super(nome);
    }

    @Override
    public void atirador() {
        System.out.println("Causa muito dano utilizando seus ataques básicos");
    }

    @Override
    public void info() {
        atirador();
    }
}
