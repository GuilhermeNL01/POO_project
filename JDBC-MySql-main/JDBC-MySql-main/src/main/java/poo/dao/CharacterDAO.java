package poo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CharacterDAO {
    public static Connection conectaDB() {
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin@123");
        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conexao;
    }

    public static Connection listar() {
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin@123");

            ResultSet characters = conexao.createStatement().
                    executeQuery("SELECT * FROM RPG.Character");
            while (characters.next()) {
                System.out.println(characters.getInt("id") + " " + characters.getString("nome"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }
}
