package br.inatel.projeto;

import br.inatel.projeto.Classes.Artilharia;
import br.inatel.projeto.Classes.Atirador;
import br.inatel.projeto.Classes.Auto_Ataque;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    Connection connection;   // objeto responsável por fazer a conexão com o servidor do MySQL
    Statement statement;     // objeto responsável por preparar consultas "SELECT"
    ResultSet result;        // objeto responsável por executar consultas "SELECT"
    PreparedStatement pst;   // objeto responsável por preparar querys de manipulação dinâmicas (INSERT, UPDATE, DELETE)
    static final String user = "root";            // usuário da instância local do servidor
    static final String password = "Ab140204";    // senha do usuário da instância local do servidor
    static final String database = "projeto";     // nome do banco de dados a ser utilizado
    // string com URL de conexão com servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private boolean check = false;       // variável interna para confirmação de métodos do CRUD
    public void connect(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso: "+ connection);
        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean insertJogador(Jogador jogador){
        connect();
        String sql = "INSERT INTO Jogador(nome, email, telefone, personagem) VALUES(?, ?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, jogador.getNome());      // concatena nome na primeira ? do comando
            pst.setString(2, jogador.getEmail());        // concatena nome na segunda ? do comando
            pst.setString(3, jogador.getTelefone());
            pst.setString(4, jogador.getPersonagem().getNome());
            pst.execute();                           // executa o comando
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
    // ----------------------------BUSCANDO TODOS REGISTROS----------------------------
    public ArrayList<Jogador> researchJogador(){
        connect();
        ArrayList<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM Jogador";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Jogador jogadorTemp = new Jogador(result.getString("nome"), result.getString("email"), result.getString("telefone"));
                jogadorTemp.setNome(result.getString("nome"));
                System.out.println("Nome = " + jogadorTemp.getNome());
                System.out.println("Email = " + jogadorTemp.getEmail());
                System.out.println("Telefone = " + jogadorTemp.getTelefone());
                System.out.println("------------------------------");
                jogadores.add(jogadorTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return jogadores;
    }
    // ----------------------------BUSCANDO REGISTRO PELO EMAIL----------------------------
    public ArrayList<Jogador> researchUserEmail(String email){
        connect();
        ArrayList<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM Jogador WHERE email = '" + email + "'";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Jogador jogadorTemp = new Jogador(result.getString("nome"), result.getString("email"),  result.getString("telefone"));
                jogadorTemp.setNome(result.getString("nome"));
                System.out.println("Nome = " + jogadorTemp.getNome());
                System.out.println("Email = " + jogadorTemp.getEmail());
                System.out.println("Telefone = " + jogadorTemp.getTelefone());
                System.out.println("------------------------------");
                jogadores.add(jogadorTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return jogadores;
    }

    // ----------------------------EXCLUINDO REGISTRO----------------------------
    public boolean deleteJogador(String email) {
        connect();
        String sql = "DELETE FROM jogador WHERE email=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, email);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    // ----------------------------BUSCANDO TODOS REGISTROS----------------------------
    public ArrayList<Personagem> researchPersonagem(int classe, int rota){
        connect();
        ArrayList<Personagem> personagens = new ArrayList<>();
        if(classe == 3 && rota == 4) {
            String sql = "SELECT p.nome FROM Classe as c, Rota as r, Personagem as p WHERE c.nome = 'auto_ataque' AND r.nome = 'atirador'";

            try {
                statement = connection.createStatement();
                result = statement.executeQuery(sql);
                while (result.next()) {
                    Personagem atiradorTemp = new Auto_Ataque(result.getString("nome"));
                    atiradorTemp.setNome(result.getString("nome"));
                    System.out.println("Nome = " + atiradorTemp.getNome());
                    System.out.println("------------------------------");
                    personagens.add(atiradorTemp);
                }
            } catch (SQLException e) {
                System.out.println("Erro de operação: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                    statement.close();
                    result.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
            return personagens;
    }
}