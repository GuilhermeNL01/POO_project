// Main.java
import model.Character;
import view.CharacterView;
import controller.CharacterController;

public class Main {
    public static void main(String[] args) {
        // Criar instâncias de modelo, visualização e controlador
        Character character = new Character();
        CharacterView characterView = new CharacterView();
        CharacterController characterController = new CharacterController(character, characterView);

        // Atualizar e exibir detalhes do personagem
        CharacterController.updateView();
    }
}
