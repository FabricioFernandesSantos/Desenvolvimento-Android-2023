package br.com.fstech.view;

import java.io.IOException;

public class JavaControleDeFluxoGame {
    public static void main(String[] args) throws IOException {

        System.out.print("Digite uma das letras da palavra APLICATIVO: --->");

        int codigoASCII;
        try {
            codigoASCII = System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        switch ((char)codigoASCII){
            case 'A':
            case 'p':
            case 'l':
            case 'i':
            case 'c':
            case 'a':
            case 't':
            case 'v':
            case 'o':
            case 's':
                System.out.println("Código da tecla: "+codigoASCII);
                System.out.println("Letra digitada: "+(char) codigoASCII);
                break;
            default:
                System.out.println("Letra não pertence a palavra");

        }


    }
}
