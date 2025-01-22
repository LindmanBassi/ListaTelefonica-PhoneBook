import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("\n--- Agenda de Contatos ---");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Remover Contato");
            System.out.println("4. Buscar Contato");
            System.out.println("5. Salvar Contatos");
            System.out.println("6. Carregar Contatos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.println("Email: ");
                    String email = sc.nextLine();
                    agenda.adicionarContato(new Contato(nome,telefone,email));
                    break;
                case 2:
                    agenda.listarContatos();
                    break;
                case 3:
                    System.out.println("Qual o nome do contato que deseja excluir: ");
                    String nomeRemove = sc.nextLine();
                    boolean removido = agenda.removerContato(nomeRemove);
                    if(removido ==true) {
                        System.out.println("Contato removido com sucesso");
                    }
                    else {
                        System.out.println("Contato não econtrado/ nao existe");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do contato");
                    String nomeBuscado = sc.nextLine();
                    agenda.buscarContato(nomeBuscado);
                    break;
                case 5:
                    System.out.println("Digite o caminho do arquivo em que deseja salvar os contatos: ");
                    String caminho = sc.nextLine();
                    agenda.salvarContatos(caminho);
                    break;
                case 6:
                    System.out.println("Digite o caminho do arquivo: ");
                    String caminhoMostrar = sc.nextLine();
                    agenda.carregarContatos(caminhoMostrar);
                case 7:
                    break;
                default:
                    System.out.println("Essa opção nao existe");
            }
        }while(opcao !=7);


        sc.close();


    }
}