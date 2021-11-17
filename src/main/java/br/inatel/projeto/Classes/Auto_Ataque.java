package br.inatel.projeto.Classes;

import br.inatel.projeto.Personagem;

public class Auto_Ataque extends Personagem implements Atirador{

    @Override
    public void atirador() {
        System.out.println("Causa muito dano utilizando seus ataques básicos");
    }
}
