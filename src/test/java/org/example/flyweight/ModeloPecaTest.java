package org.example.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModeloPecaTest {

    private final ModeloPeca modelo = new ModeloPeca("Chaveiro", "PLA", 12);

    @Test
    void deveGuardarEstadoIntrinseco() {
        assertEquals("Chaveiro", modelo.getNome());
        assertEquals("PLA", modelo.getMaterial());
        assertEquals(12, modelo.getGramas());
    }

    @Test
    void deveUsarPosicaoRecebidaComoParametro() {
        assertEquals("Imprimindo Chaveiro (PLA, 12 g) em (10, 20)", modelo.imprimir(10, 20));
        assertEquals("Imprimindo Chaveiro (PLA, 12 g) em (0, 5)", modelo.imprimir(0, 5));
    }
}
