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

public class Main {
    public static void main(String[] args) {
        // Inicializar controladores e visualizações
        Character character = new Character();
        CharacterView characterView = new CharacterView();
        CharacterController characterController = new CharacterController(character, characterView);

        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);

        // Menu principal
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            mainView.displayMainMenu();
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Lógica para criar um novo personagem
                    createCharacter(characterController, scanner);
                    break;
                case 2:
                    // Lógica para outra opção (tipo exclusão de char)
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 0);
        
        scanner.close();
    }

    private static void createCharacter(CharacterController characterController, Scanner scanner) {
      // Lógica para criar um novo personagem
      System.out.println("Criando um novo personagem:");
  
      // Preencher os detalhes do personagem (nome, atributos, raça, etc.)
      System.out.print("Nome do personagem: ");
      String nome = scanner.next();
      characterController.getCharacter().setNome(nome);
  
      System.out.print("Força: ");
      int forca = scanner.nextInt();
      characterController.getCharacter().setForca(forca);
  
      System.out.print("Destreza: ");
      int destreza = scanner.nextInt();
      characterController.getCharacter().setDestreza(destreza);
  
      System.out.print("Constituição: ");
      int constituicao = scanner.nextInt();
      characterController.getCharacter().setConstituicao(constituicao);
  
      System.out.print("Sabedoria: ");
      int sabedoria = scanner.nextInt();
      characterController.getCharacter().setSabedoria(sabedoria);
  
      System.out.print("Inteligência: ");
      int inteligencia = scanner.nextInt();
      characterController.getCharacter().setInteligencia(inteligencia);
  
      System.out.print("Carisma: ");
      int carisma = scanner.nextInt();
      characterController.getCharacter().setCarisma(carisma);
  
      // Escolha da raça
      System.out.print("Raça: ");
      String raceName = scanner.next();
      characterController.getCharacter().setRaceName(raceName);
  
      // Exibir os detalhes do personagem após a criação
      characterController.updateView();
  }
}
