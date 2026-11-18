package org.example.flyweight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MesaImpressao {

    private final FabricaModelos fabrica;
    private final List<PecaPosicionada> pecas = new ArrayList<>();

    public MesaImpressao(FabricaModelos fabrica) {
        this.fabrica = fabrica;
    }

    public void adicionar(String nome, String material, int gramas, int x, int y) {
        for (PecaPosicionada existente : pecas) {
            if (existente.getX() == x && existente.getY() == y) {
                throw new IllegalStateException("Posicao ocupada");
            }
        }
        ModeloPeca modelo = fabrica.getModelo(nome, material, gramas);
        pecas.add(new PecaPosicionada(modelo, x, y));
    }

    public int getTotalPecas() {
        return pecas.size();
    }

    public int getGramasTotais() {
        int total = 0;
        for (PecaPosicionada peca : pecas) {
            total += peca.getModelo().getGramas();
        }
        return total;
    }

    public List<String> imprimirTudo() {
        List<String> linhas = new ArrayList<>();
        for (PecaPosicionada peca : pecas) {
            linhas.add(peca.imprimir());
        }
        return linhas;
    }

    public List<PecaPosicionada> getPecas() {
        return Collections.unmodifiableList(pecas);
    }
}
