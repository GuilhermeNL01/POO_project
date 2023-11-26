package poo;

import poo.dao.CharacterDAO;
import poo.model.Character;

public class Main {
    public static void main(String[] args) {
        CharacterDAO characterDAO = new CharacterDAO();

        characterDAO.listar();

    }
}
