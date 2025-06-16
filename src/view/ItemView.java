package view;

import console.Console;
import controller.ItemController;
import java.util.List;
import model.Filme;
import model.Item;
import model.Livro;

public class ItemView {

    private ItemController controller = new ItemController();

    private void exibirMenu() {

        System.out.println("\n=====LOCADORA=====\n");
        System.out.println("1.Cadastrar Item");
        System.out.println("2.Listar Itens");
        System.out.println("3.Listar Livros");
        System.out.println("4.Listar Filmes");
        System.out.println("5.Remover Item");
        System.out.println("6.Realizar Empréstimo");
        System.out.println("7.Devolver Item");
        System.out.println("8.Meus Empréstimos");
        System.out.println("0.Sair");

    }

    private void verificarOp(int op) {

        switch (op) {

            case 1:
                cadastrarItem();
                break;

            case 2:
                listarItens();
                break;

            case 3:
                listarLivros();
                break;

            case 4:
                listarFilmes();
                break;

            case 5:
                removerItem();
                break;

            case 6:
                realizarEmprestimo();
                break;

            case 7:
                devolverItemView();
                break;

            case 8:
                controller.listarEmprestimos();
                break;

            case 0:
                System.out.println("Sistema Finalizado!");
                break;

            default:
                System.out.println("Opção Inválida! Tente Novamente");
        }

    }

    private void cadastrarItem() {
        int tipo;

        while (true) {
            System.out.println("\nO que deseja cadastrar?");
            System.out.println("1. Livro");
            System.out.println("2. Filme");
            System.out.print(": ");
            tipo = Console.lerInt();

            if (tipo == 1 || tipo == 2) {
                break;
            }

            System.out.println("\nOpção inválida! Tente novamente");
        }

        System.out.println("\nInforme os Dados:");

        System.out.print("Título: ");
        String titulo = Console.lerString();

        System.out.print("Código: ");
        String codigo = Console.lerString();

        if (tipo == 1) {
            System.out.print("Autor: ");
            String autor = Console.lerString();

            System.out.print("Gênero: ");
            String genero = Console.lerString();

            System.out.print("ISBN: ");
            String isbn = Console.lerString();

            controller.salvarItem(new Livro(titulo, codigo, false, autor, genero, isbn));
            System.out.println("\nLivro cadastrado com sucesso!");
        } else {
            System.out.print("Diretor: ");
            String diretor = Console.lerString();

            System.out.print("Gênero: ");
            String genero = Console.lerString();

            System.out.print("Duração (em horas): ");
            float duracao = Console.lerFloat();

            controller.salvarItem(new Filme(titulo, codigo, false, diretor, duracao, genero));
            System.out.println("\nFilme cadastrado com sucesso!");
        }
    }

    private void listarItens() {

        List<Item> lista = controller.getListaItens();

        if (lista == null) {
            System.out.println("\nNão há itens cadastrados!");
            return;
        }

        System.out.println("\n====Itens Cadastrados====");
        for (Item tempItem : lista) {
            System.out.println(tempItem);

        }
    }

    private void listarLivros() {

        List<Item> lista = controller.getListaItens();

        if (lista == null || lista.isEmpty()) {
            System.out.println("\nNão há livros cadastrados!");
            return;
        }

        boolean encontrou = false;
        System.out.println("\n====Livros Cadastrados====");
        for (Item tempItem : lista) {
            if (tempItem instanceof Livro) {
                System.out.println(tempItem);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("\nNão há livros cadastrados!");
        }
    }

    private void listarFilmes() {

        List<Item> lista = controller.getListaItens();

        if (lista == null || lista.isEmpty()) {
            System.out.println("\nNão há filmes cadastrados!");
            return;
        }

        boolean encontrou = false;
        System.out.println("\n====Filmes Cadastrados====");
        for (Item tempItem : lista) {
            if (tempItem instanceof Filme) {
                System.out.println(tempItem);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("\nNão há filmes cadastrados!");
        }
    }

    private void removerItem() {

        System.out.print("\nDigite o código do item que deseja remover: ");
        String codigo = Console.lerString();

        boolean removido = controller.removerItem(codigo);

        if (removido) {
            System.out.println("\nItem removido com sucesso!");
        } else {
            System.out.println("\nItem não encontrado.");
        }
    }

    private void realizarEmprestimo() {
        int tipo;

        while (true) {
            System.out.println("\nQue tipo de item deseja emprestar?");
            System.out.println("1. Livro");
            System.out.println("2. Filme");
            System.out.print(": ");
            tipo = Console.lerInt();

            if (tipo == 1 || tipo == 2) {
                break;
            }

            System.out.println("\nOpção inválida! Tente novamente");
        }

        if (tipo == 1) {
            emprestimoLivro();
        } else {
            emprestimoFilme();
        }
    }

    private void emprestimoLivro() {

        List<Item> lista = controller.getListaItens();

        if (lista == null || lista.isEmpty()) {
            System.out.println("\nNão há livros cadastrados!");
            return;
        }

        boolean encontrou = false;

        System.out.println("\n====Livros disponíveis para empréstimo====");
        for (Item tempItem : lista) {
            if (tempItem instanceof Livro && !tempItem.isEmprestado()) {
                System.out.println(tempItem);
                encontrou = true;
            }

        }

        if (!encontrou) {
            System.out.println("\nNão há livros disponíveis no momento...");
            return;
        }

        System.out.print("\nDigite o código do livro que deseja emprestar: ");
        String codigo = Console.lerString();

        for (Item item : lista) {
            if (item instanceof Livro && item.getCodigo().equalsIgnoreCase(codigo)) {
                if (item.isEmprestado()) {
                    System.out.println("\nEste livro já está emprestado.");
                } else {
                    item.setEmprestado(true);
                    System.out.println("\nEmpréstimo de livro realizado com sucesso!");
                }
                return;
            }
        }

        System.out.println("\nLivro não encontrado.");
    }

    private void emprestimoFilme() {

        List<Item> lista = controller.getListaItens();

        if (lista == null || lista.isEmpty()) {
            System.out.println("\nNão há filmes cadastrados!");
            return;
        }

        boolean encontrou = false;

        System.out.println("\n====Filmes disponíveis para empréstimo====");
        for (Item tempItem : lista) {
            if (tempItem instanceof Filme && !tempItem.isEmprestado()) {
                System.out.println(tempItem);
                encontrou = true;
            }

        }

        if (!encontrou) {
            System.out.println("\nNão há filmes disponíveis no momento...");
        }

        System.out.print("\nDigite o código do filme que deseja emprestar: ");
        String codigo = Console.lerString();

        for (Item item : lista) {
            if (item instanceof Filme && item.getCodigo().equalsIgnoreCase(codigo)) {
                if (item.isEmprestado()) {
                    System.out.println("\nEste filme já está emprestado.");
                } else {
                    item.setEmprestado(true);
                    System.out.println("\nEmpréstimo de filme realizado com sucesso!");
                }
                return;
            }
        }

        System.out.println("\nFilme não encontrado.");
    }

    private void devolverItemView() {

        System.out.print("\nDigite o código do item que deseja devolver: ");
        String codigo = Console.lerString();

        boolean sucesso = controller.devolverItem(codigo);

        if (sucesso) {
            System.out.println("\nItem devolvido com sucesso!");
        } else {
            System.out.println("\nItem não encontrado ou não está emprestado.");
        }
    }

    public void iniciar() {

        int op;
        controller.lerDoArquivo();

        do {

            exibirMenu();
            System.out.print(": ");
            op = Console.lerInt();
            verificarOp(op);

        } while (op != 0);
    }

}
