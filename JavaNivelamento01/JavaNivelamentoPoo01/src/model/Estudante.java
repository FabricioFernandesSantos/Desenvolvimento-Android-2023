package model;

public class Estudante extends Pessoa{
    private int ra;
    private String curso;

    @Override
    public String falarIdioma() {
        return "Hola, que tal?";
    }

    @Override
    public String toString() {

        return getCurso();

    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
