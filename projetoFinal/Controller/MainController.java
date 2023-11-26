// MainController.java
package Controller;

import View.MainView;
import java.sql.*;
import java.util.Scanner;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    public void handleUserInput(CharacterController characterController, Scanner scanner) {
        // Lógica para lidar com a entrada do usuário no menu principal
        int choice;

        do {
            mainView.displayMainMenu();
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Criar novo personagem
                    createCharacter(characterController, scanner);
                    break;
                case 2:
                    // Consultar personagem
                    System.out.print("Digite o ID do personagem: ");
                    int characterId = scanner.nextInt();
                    Character character = characterController.consultarPersonagem(characterId);
                    characterController.updateView(character);
                    break;
                case 3:
                    // Atualizar personagem
                    System.out.print("Digite o ID do personagem que deseja atualizar: ");
                    int updateCharacterId = scanner.nextInt();
                    Character updatedCharacter = characterController.consultarPersonagem(updateCharacterId);
                    if (updatedCharacter != null) {
                        updateCharacterDetails(updatedCharacter, scanner);
                        characterController.atualizarPersonagem(updatedCharacter);
                        System.out.println("Personagem atualizado com sucesso!");
                    } else {
                        System.out.println("Personagem não encontrado.");
                    }
                    break;
                case 4:
                    // Excluir personagem
                    System.out.print("Digite o ID do personagem que deseja excluir: ");
                    int deleteCharacterId = scanner.nextInt();
                    characterController.excluirPersonagem(deleteCharacterId);
                    System.out.println("Personagem excluído com sucesso!");
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (choice != 0);
    }

    private static void createCharacter(CharacterController characterController, Scanner scanner) {
        // Lógica para criar um novo personagem
        characterController.createCharacter(scanner);
    }

    private static void updateCharacterDetails(Character character, Scanner scanner) {
    // Lógica para atualizar detalhes do personagem
    System.out.println("Atualizando detalhes do personagem:");

    System.out.print("Novo nome do personagem (" + character.getNome() + "): ");
    String nome = scanner.next();
    if (!nome.isEmpty()) {
        character.setNome(nome);
    }

    System.out.print("Nova força (" + character.getForca() + "): ");
    String forcaInput = scanner.next();
    if (!forcaInput.isEmpty()) {
        int forca = Integer.parseInt(forcaInput);
        character.setForca(forca);
    }

    System.out.print("Nova destreza (" + character.getDestreza() + "): ");
    String destrezaInput = scanner.next();
    if (!destrezaInput.isEmpty()) {
        int destreza = Integer.parseInt(destrezaInput);
        character.setDestreza(destreza);
    }

    System.out.print("Nova constituição (" + character.getConstituicao() + "): ");
    String constituicaoInput = scanner.next();
    if (!constituicaoInput.isEmpty()) {
        int constituicao = Integer.parseInt(constituicaoInput);
        character.setConstituicao(constituicao);
    }

    System.out.print("Nova sabedoria (" + character.getSabedoria() + "): ");
    String sabedoriaInput = scanner.next();
    if (!sabedoriaInput.isEmpty()) {
        int sabedoria = Integer.parseInt(sabedoriaInput);
        character.setSabedoria(sabedoria);
    }

    System.out.print("Nova inteligência (" + character.getInteligencia() + "): ");
    String inteligenciaInput = scanner.next();
    if (!inteligenciaInput.isEmpty()) {
        int inteligencia = Integer.parseInt(inteligenciaInput);
        character.setInteligencia(inteligencia);
    }

    System.out.print("Novo carisma (" + character.getCarisma() + "): ");
    String carismaInput = scanner.next();
    if (!carismaInput.isEmpty()) {
        int carisma = Integer.parseInt(carismaInput);
        character.setCarisma(carisma);
    }

    System.out.print("Nova raça (" + character.getRaceName() + "): ");
    String raceName = scanner.next();
    if (!raceName.isEmpty()) {
        character.setRaceName(raceName);
    }
}

}
