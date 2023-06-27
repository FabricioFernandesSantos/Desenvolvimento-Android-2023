package br.com.fstech.view;

public class JavaOperadoresAritimeticos {
    public static void main(String[] args) {

        byte valorByteA = 1;
        byte valorByteB = 2;

        int somaBite = valorByteA + valorByteB;

        int subtracaoBite = valorByteA - valorByteB;
        int multiplicacaoBite = valorByteA * valorByteB;
        float divisaoByteFloat = (float) valorByteA/valorByteB;
        double divisaoByteDouble = (double) valorByteA/valorByteB;

        System.out.println("Operações aritiméticas com byte:\n");
        System.out.println("(+): "+somaBite);
        System.out.println("(-): "+subtracaoBite);
        System.out.println("(*): "+multiplicacaoBite);
        System.out.println("(/): "+divisaoByteFloat);
        System.out.println("(/): "+divisaoByteDouble);

    }
}
