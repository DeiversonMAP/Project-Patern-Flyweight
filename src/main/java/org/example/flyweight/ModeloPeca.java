package org.example.flyweight;

public final class ModeloPeca {

    private final String nome;
    private final String material;
    private final int gramas;

    ModeloPeca(String nome, String material, int gramas) {
        this.nome = nome;
        this.material = material;
        this.gramas = gramas;
    }

    public String getNome() {
        return nome;
    }

    public String getMaterial() {
        return material;
    }

    public int getGramas() {
        return gramas;
    }

    public String imprimir(int x, int y) {
        return "Imprimindo " + nome + " (" + material + ", " + gramas + " g) em (" + x + ", " + y + ")";
    }
}
