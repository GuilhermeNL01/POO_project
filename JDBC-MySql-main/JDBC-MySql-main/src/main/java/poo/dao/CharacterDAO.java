package poo.dao;

import java.sql.*;



public class CharacterDAO {
    public static Connection conectaDB() {
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin");
        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conexao;
    }

    public void inserirPersonagem(String nome, Integer forca, Integer destreza, Integer constituicao, Integer sabedoria,
                                  Integer inteligencia, Integer carisma, String raceName){

        Connection conexao = null;

        try {
            // Faz a conexao do banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin");
            Statement conn = conexao.createStatement();

            // Ações da função
                    conn.executeUpdate("insert into RPG.`character` (nome, forca, destreza, constituicao, sabedoria, inteligencia, carisma, raceName)\n" +
                            "values ('" + nome + "', " + forca + ", " + destreza + ", " + constituicao + ", " + sabedoria + ", " + inteligencia + "" +
                            ", " + carisma + ", '" + raceName + "');");


        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
        }
    }

    public void listar() {
        Connection conexao = null;

        try {
            // Faz a conexao do banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin");

            // Ações da função
            ResultSet characters = conexao.createStatement().
                    executeQuery("SELECT * FROM RPG.`character`");
            while (characters.next()) {
                System.out.println("\nNome: " + characters.getString("nome") +
                        "\nForca: " + characters.getInt("forca") +
                        "\nDestreza: " + characters.getInt("destreza") +
                        "\nConstituicao: " + characters.getInt("constituicao") +
                        "\nSabedoria: " + characters.getInt("sabedoria") +
                        "\nInteligencia: " + characters.getInt("inteligencia") +
                        "\nCarisma: " + characters.getInt("carisma") +
                        "\nRaca: " + characters.getString("raceName"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarPorNome(String nome) {
        Connection conexao = null;

        try {
            // Faz a conexao do banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin");

            // Ações da função
            ResultSet characters = conexao.createStatement().
                    executeQuery("SELECT * FROM RPG.Character WHERE raceName = '" + nome + "' ");
            while (characters.next()) {
                System.out.println("\nID:" + characters.getInt("id") + "\n" +
                        "Nome: " + characters.getString("nome"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarPersonagem(String nome, String novoNome) {

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin");

            String sql = "update RPG.`character`\n" +
                    "set nome = '" + novoNome + "'\n" +
                    "where nome = '" + nome + "';";

            conexao.createStatement().executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarPersonagem(String nome) {

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin");


            String sql = "delete\n" +
                    "from RPG.`character`\n" +
                    "where nome = '" + nome + "';";

            conexao.createStatement().executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
