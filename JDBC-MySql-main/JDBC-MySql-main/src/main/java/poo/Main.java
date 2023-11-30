package poo;

import poo.dao.CharacterDAO;
import poo.dao.ClassDAO;
import poo.dao.RaceDAO;
import poo.dao.SpecializationDAO;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CharacterDAO characterDAO = new CharacterDAO();
        RaceDAO raceDAO = new RaceDAO();
        ClassDAO classDAO = new ClassDAO();
        SpecializationDAO specializationDAO = new SpecializationDAO();
        

boolean loop = true;
            

         while (loop) {

        System.out.println("\nBem vindo usuário, o que você deseja hoje?\n\n");
        System.out.println("1. Criar\n");
        System.out.println("2. Atualizar\n");
        System.out.println("3. Listar\n");
        System.out.println("4. Deletar\n");
        System.out.println("5. Filtar personagem\n");
        Scanner choice = new Scanner(System.in);
        int escolha = choice.nextInt();

        switch (escolha) {
            case 1:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o nome: ");
                String nome = scanner.nextLine();

                System.out.println("\nDigite a força: ");
                int forca = scanner.nextInt();

                System.out.println("\nDigite a destreza: ");
                int destreza = scanner.nextInt();

                System.out.println("\nDigite a constituicao: ");
                int constituicao = scanner.nextInt();

                System.out.println("\nDigite a sabedoria: ");
                int sabedoria = scanner.nextInt();

                System.out.println("\nDigite a inteligencia: ");
                int inteligencia = scanner.nextInt();

                System.out.println("\nDigite a carisma: ");
                int carisma = scanner.nextInt();

                System.out.println("\nDigite o nome da raca: ");
                String raca = scanner.next();

                characterDAO.inserirPersonagem(nome, forca, destreza, constituicao, sabedoria, inteligencia, carisma, raca);
                nome = "";
                forca = 0;
                destreza = 0;
                constituicao = 0;
                sabedoria  = 0;
                inteligencia = 0;
                carisma = 0;
                raca = "";
                scanner.close();
                break;
            case 2:
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Digite o nome do personagem que deseja atualizar: ");
                String nome2 = scanner2.nextLine();
                System.out.println("Digite o novo nome do personagem: ");
                String novoNome = scanner2.nextLine();

                characterDAO.atualizarPersonagem(nome2, novoNome);
                nome = "";
                novoNome = "";
                break;
            case 3:
              System.out.println("\nEscolha qual listagem deseja realizar:\n\n");
              System.out.println("1. Fichas\n");
              System.out.println("2. Raça\n");
              System.out.println("3. Classe\n");
              System.out.println("4. Especializações\n");
              Scanner choice2 = new Scanner(System.in);
              int escolha2 = choice2.nextInt();
              switch (escolha2) {
                case 1:
                    characterDAO.listar();
                    break;
                case 2:
                    raceDAO.listar();
                    break;
                case 3:
                    classDAO.listar(); 
                    break;
                case 4:
                    specializationDAO.listar();
                    break;
                
              
                default: System.out.println("Por favor, selecione uma escolha válida\n");
                    break;
              }
                break;
            case 4:
            Scanner scanner4 = new Scanner(System.in);
                String nome4 = scanner4.nextLine();
                characterDAO.deletarPersonagem(nome4);
                break;
            case 5:
                Scanner scanner5 = new Scanner(System.in);
                String nome5 = scanner5.nextLine();
                characterDAO.listarPorNome(nome5);
                break;
        
            default: System.out.println("erro, por favor selecionar um dos números\n");
                break;
        }
    }

    }
}
