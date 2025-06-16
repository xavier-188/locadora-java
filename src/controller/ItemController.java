package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Item;

public class ItemController {

    private static final String ARQUIVO = "item.txt";
    private List<Item> listaItens;

    public ItemController() {
        listaItens = new ArrayList<>();
        lerDoArquivo();
    }

    public void salvarNoArquivo() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Item item : listaItens) {
                pw.println(item.toText());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar itens no arquivo: " + e.getMessage());
        }
    }

    public void lerDoArquivo() {
        listaItens.clear();

        File file = new File(ARQUIVO);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String itemAtual;

            while ((itemAtual = br.readLine()) != null) {
                Item i = Item.fromText(itemAtual);

                if (i != null) {
                    listaItens.add(i);
                }

            }

        } catch (IOException e) {
            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
        }
    }

    public void salvarItem(Item i) {
        listaItens.add(i);
        salvarNoArquivo();
    }

    public List<Item> getListaItens() {
        if (listaItens.isEmpty()) {
            return null;
        }
        return listaItens;
    }

    public boolean removerItem(String codigo) {
        boolean encontrou = false;

        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaItens.remove(i);
                encontrou = true;
                break;
            }
        }
        if (encontrou) {
            salvarNoArquivo();
            try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO))) {
                for (Item item : listaItens) {
                    pw.println(item.toText());
                }
            } catch (IOException e) {
                System.out.println("Erro ao atualizar o arquivo após remoção: " + e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean devolverItem(String codigo) {
        for (Item item : listaItens) {
            if (item.getCodigo().equalsIgnoreCase(codigo)) {
                if (item.isEmprestado()) {
                    item.setEmprestado(false);
                    salvarNoArquivo();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void listarEmprestimos() {
        boolean encontrou = false;
        System.out.println("\n====Itens Emprestados====");

        for (Item item : listaItens) {
            if (item.isEmprestado()) {
                System.out.println(item);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum item emprestado no momento.");
        }
    }

}
