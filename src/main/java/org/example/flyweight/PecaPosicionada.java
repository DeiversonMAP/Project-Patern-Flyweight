package org.example.flyweight;

public class PecaPosicionada {

    private final ModeloPeca modelo;
    private final int x;
    private final int y;

    public PecaPosicionada(ModeloPeca modelo, int x, int y) {
        this.modelo = modelo;
        this.x = x;
        this.y = y;
    }

    public ModeloPeca getModelo() {
        return modelo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String imprimir() {
        return modelo.imprimir(x, y);
    }
}
