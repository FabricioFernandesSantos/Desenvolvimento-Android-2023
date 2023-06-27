package model;

public class Professor extends Pessoa{
    private String titulo;

    @Override
    public String falarIdioma() {
        return "Tri legal, thê!";
    }

    @Override
    public String toString() {
        return getTitulo();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
