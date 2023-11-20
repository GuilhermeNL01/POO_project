// CharacterView.java
package View;

import Model.Character;

public class CharacterView {
    public void printCharacterDetails(Character character) {
        System.out.println("Detalhes do Personagem:");
        System.out.println("ID: " + character.getId());
        System.out.println("Nome: " + character.getNome());
        System.out.println("Força: " + character.getForca());
        System.out.println("Destreza: " + character.getDestreza());
        System.out.println("Constituição: " + character.getConstituicao());
        System.out.println("Sabedoria: " + character.getSabedoria());
        System.out.println("Inteligência: " + character.getInteligencia());
        System.out.println("Carisma: " + character.getCarisma());
        System.out.println("Raça: " + character.getRaceName());
    }
}



