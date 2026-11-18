package org.example.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PecaPosicionadaTest {

    @Test
    void deveGuardarModeloEPosicao() {
        ModeloPeca modelo = new FabricaModelos().getModelo("Chaveiro", "PLA", 12);
        PecaPosicionada peca = new PecaPosicionada(modelo, 10, 20);

        assertSame(modelo, peca.getModelo());
        assertEquals(10, peca.getX());
        assertEquals(20, peca.getY());
    }

    @Test
    void deveImprimirUsandoOModeloEAPropriaPosicao() {
        ModeloPeca modelo = new FabricaModelos().getModelo("Chaveiro", "PLA", 12);
        PecaPosicionada peca = new PecaPosicionada(modelo, 10, 20);

        assertEquals("Imprimindo Chaveiro (PLA, 12 g) em (10, 20)", peca.imprimir());
    }
}
