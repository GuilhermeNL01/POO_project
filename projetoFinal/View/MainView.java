package main.java;

import java.util.Scanner;
import Controller.CharacterController;
import Controller.MainController;
import model.Character;
import model.Class;
import model.Race;
import model.Specialization;
import view.CharacterView;
import view.MainView;

public class MainView {
    public void displayMainMenu() {
        System.out.println("===== Menu Principal =====");
        System.out.println("1. Criar Novo Personagem");
        System.out.println("2. Consultar Personagem");
        System.out.println("3. Atualizar Personagem");
        System.out.println("4. Excluir Personagem");
        System.out.println("0. Sair");
        System.out.println("==========================");
    }
}