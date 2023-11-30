package poo;

import poo.dao.CharacterDAO;
import poo.model.Character;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CharacterDAO characterDAO = new CharacterDAO();

        

        System.out.println("bem vindo usuário, o que você deseja hoje?\n\n");
        System.out.println("1. Criar\n");
        System.out.println("2. Atualizar\n");
        System.out.println("3. Listar\n");
        System.out.println("4. Deletar\n");
        System.out.println("5. Filtar personagem\n");
        Scanner choice = new Scanner(System.in);
        int escolha = choice.nextInt();

        
        switch (escolha) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
              characterDAO.listar();  
                break;
            case 4:
                
                break;
            case 5:
                
                break;
        
            default: System.out.println("erro, por favor selecionar um dos números");
                break;
        }
        

    }
}
