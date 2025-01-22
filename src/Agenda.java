import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos;
    public Agenda() {
        contatos = new ArrayList<>();
    }
    public void adicionarContato(Contato contato){
        contatos.add(contato);
    }
    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }
    public boolean removerContato(String nome){
        for(Contato contato:contatos){
            if(contato.getNome().equalsIgnoreCase(nome)){
                contatos.remove(contato);
                return true;
            }
        }
        return false;
    }
    public void buscarContato(String nome) {
        for(Contato contato: contatos){
            if (contato.getNome().equalsIgnoreCase(nome)){
                System.out.println(contato);
            }
        }
    }

    public void salvarContatos(String arquivo){
        try(FileWriter writer = new FileWriter(arquivo)){
            for(Contato contato: contatos){
                writer.write(contato.getNome()+"," + contato.getEmail()+"," + contato.getTelefone()+"\n");
            }
            System.out.println("Seus contatos foram salvos com sucesso");
        }
        catch (IOException e){
            System.out.println("Erro ao salvar contatos " + e.getMessage());
        }
    }

    public void carregarContatos(String arquivo){
        try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    String nome = partes[0];
                    String telefone = partes[1];
                    String email = partes[2];
                    Contato contato = new Contato(nome, telefone, email);
                    contatos.add(contato);
                }
            }
            System.out.println("Seus contatos foram carregados com sucesso");
        }
        catch (IOException e){
            System.out.println("Erro ao carregar os contatos " + e.getMessage());

        }
    }



}
