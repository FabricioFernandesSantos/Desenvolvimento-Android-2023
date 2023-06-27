package br.com.fstech.view;

public class JavaRepedicaoWhile {
    public static void main(String[] args) {

        int valor = 0;
        int valorMaximo = 5;

        while (valor != valorMaximo){
            System.out.println("Entrou");
            valor++;
        }

        do {
            System.out.println("Entrou");
            valor++;
        } while (valor != valorMaximo);

    }
}
