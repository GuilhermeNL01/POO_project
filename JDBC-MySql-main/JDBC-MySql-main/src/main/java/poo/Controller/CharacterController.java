// CharacterController.java
package Controller;

import model.Character;
import view.CharacterView;

public class CharacterController {
    private Character character;
    private CharacterView characterView;

    public CharacterController(Character character, CharacterView characterView) {
        this.character = character;
        this.characterView = characterView;
    }

    public void updateView() {
        characterView.printCharacterDetails(character);
    }
}


