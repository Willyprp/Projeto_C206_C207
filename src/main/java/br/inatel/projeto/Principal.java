package br.inatel.projeto;

import br.inatel.projeto.Classes.*;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataBase database = new DataBase();
        int escolha;
        boolean flag = true;
        boolean cadastrado = false;
        System.out.println("Bem vindo!");
        while(flag){
            System.out.println();
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastro jogador:");
            System.out.println("2 - Busca de personagem:");
            System.out.println("3 - Seleção de personagem:");
            System.out.println("4 - Informações sobre as classes:");
            System.out.println("5 - Sair");
            escolha = sc.nextInt();
            switch (escolha){
                case 1:
                    sc.nextLine();
                    System.out.println("Entre com seu nome:");
                    String nome = sc.nextLine();
                    System.out.println("Entre com seu email:");
                    String email = sc.nextLine();
                    System.out.println("Entre com seu telefone:");
                    String telefone = sc.nextLine();
                    Jogador jogador = new Jogador(nome,email,telefone);
                    database.connect();
                    cadastrado = database.insertJogador(jogador);
                    break;

                case 2:
                    if(cadastrado){
                        int rota;
                        int classe;
                        String classebd = "";
                        String rotabd = "";
                        System.out.println("Escolha sua rota:");
                        System.out.println("1 - Topo");
                        System.out.println("2 - Caçador");
                        System.out.println("3 - Meio");
                        System.out.println("4 - Atirador");
                        System.out.println("5 - Suporte");
                        rota = sc.nextInt();
                        switch (rota){
                            case 1:
                                rotabd = "topo";
                                break;
                            case 2:
                                rotabd = "selva";
                                break;
                            case 3:
                                rotabd = "meio";
                                break;
                            case 4:
                                rotabd = "atirador";
                                break;
                            case 5:
                                rotabd = "suporte";
                                break;
                            default:
                                System.out.println("Valor inválido");
                            break;
                        }
                        System.out.println("Escolha sua classe");
                        System.out.println("1 - Artilharia");
                        System.out.println("2 - Assassino");
                        System.out.println("3 - Auto Ataque");
                        System.out.println("4 - Burst");
                        System.out.println("5 - Caster");
                        System.out.println("6 - Encantador");
                        System.out.println("7 - Tanque");
                        classe = sc.nextInt();
                        switch(classe){
                            case 1:
                                classebd = "artilharia";
                                break;
                            case 2:
                                classebd = "assassino";
                                break;
                            case 3:
                                classebd = "auto_ataque";
                                break;
                            case 4:
                                classebd = "burst";
                                break;
                            case 5:
                                classebd = "caster";
                                break;
                            case 6:
                                classebd = "encantador";
                                break;
                            case 7:
                                classebd = "tanque";
                                break;
                            default:
                                System.out.println("Valor inválido");
                                break;
                        }
                        database.researchPersonagem(classebd,rotabd);
                        break;
                    }
                    else{
                        System.out.println("Realize o cadastro antes de prosseguir!");
                        break;
                    }
                case 3:
                    if(cadastrado) {
                        String pNome;
                        String jogar;
                        sc.nextLine();
                        System.out.println("Entre com o nome do personagem desejado: ");
                        pNome = sc.nextLine();
                        database.escolhaPersonagem(pNome);
                        System.out.println("Deseja jogar com este personagem? (S/N)");
                        jogar = sc.nextLine();
                        if (jogar.equals("S")) {
                            database.updateJogador(pNome);
                        }
                        break;
                    }
                    else{
                        System.out.println("Realize o cadastro antes de prosseguir!");
                        break;
                    }

                case 4:
                    int explicacao;
                    System.out.println("1 - Artilharia");
                    System.out.println("2 - Assassino");
                    System.out.println("3 - Auto Ataque");
                    System.out.println("4 - Burst");
                    System.out.println("5 - Caster");
                    System.out.println("6 - Encantador");
                    System.out.println("7 - Tanque");
                    System.out.println("8 - Sair");
                    explicacao = sc.nextInt();
                    switch (explicacao){
                        case 1:
                            Artilharia artilharia = new Artilharia();
                            artilharia.info();
                            artilharia.mago();
                            break;
                        case 2:
                            Assassino assassino = new Assassino();
                            assassino.info();
                            break;
                        case 3:
                            Auto_Ataque auto = new Auto_Ataque();
                            auto.info();
                            auto.atirador();
                            break;
                        case 4:
                            Burst burst = new Burst();
                            burst.info();
                            burst.mago();
                            break;
                        case 5:
                            Caster caster = new Caster();
                            caster.info();
                            caster.atirador();
                            break;
                        case 6:
                            Encantador encantador = new Encantador();
                            encantador.info();
                            break;
                        case 7:
                            Tanque tanque = new Tanque();
                            tanque.info();
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Valor Inválido.");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Obrigado pela participação!");
                    flag = false;
                    break;
                default:
                    System.out.println("Valor incorreto");
                    break;
            }

        }
    }
}
