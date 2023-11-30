package poo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import poo.model.Class;

public class ClassDAO {
    public static Connection conectaDB() {
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPG", "root", "admin");
        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conexao;
    }

    public static List<Class> listar() {
        List<Class> classes = new ArrayList<>();
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPG", "root", "admin");

            ResultSet classResultSet = conexao.createStatement().executeQuery("SELECT * FROM RPG.Class");
            
            while (classResultSet.next()) {
                Class characterClass = new Class();
                characterClass.setClassName(classResultSet.getString("className"));
                characterClass.setLevel(classResultSet.getInt("level"));
                characterClass.setAbiCla(classResultSet.getString("abiCla"));
                classes.add(characterClass);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Problema no Driver" + e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return classes;
    }
}
