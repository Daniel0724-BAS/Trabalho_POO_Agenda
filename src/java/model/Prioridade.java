package model;

public enum Prioridade {

    BAIXA(1, "Baixa"),
    MEDIA(2, "Média"),
    ALTA(3, "Alta");

    private final int peso;
    private final String rotulo;

    Prioridade(int peso, String rotulo) {
        this.peso = peso;
        this.rotulo = rotulo;
    }

    public int getPeso() {
        return peso;
    }
    public String getRotulo() {
        return rotulo;
    }
}
