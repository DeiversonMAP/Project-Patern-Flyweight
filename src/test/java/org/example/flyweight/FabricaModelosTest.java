package org.example.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaModelosTest {

    @Test
    void deveComecarSemModelos() {
        assertEquals(0, new FabricaModelos().getTotalModelos());
    }

    @Test
    void deveReaproveitarOMesmoObjetoParaOsMesmosDados() {
        FabricaModelos fabrica = new FabricaModelos();

        ModeloPeca primeiro = fabrica.getModelo("Chaveiro", "PLA", 12);
        ModeloPeca segundo = fabrica.getModelo("Chaveiro", "PLA", 12);

        assertSame(primeiro, segundo);
        assertEquals(1, fabrica.getTotalModelos());
    }

    @Test
    void deveCriarOutroModeloQuandoQualquerDadoMuda() {
        FabricaModelos fabrica = new FabricaModelos();

        ModeloPeca base = fabrica.getModelo("Chaveiro", "PLA", 12);
        ModeloPeca outroMaterial = fabrica.getModelo("Chaveiro", "PETG", 12);
        ModeloPeca outroPeso = fabrica.getModelo("Chaveiro", "PLA", 15);
        ModeloPeca outroNome = fabrica.getModelo("Busto", "PLA", 12);

        assertNotSame(base, outroMaterial);
        assertNotSame(base, outroPeso);
        assertNotSame(base, outroNome);
        assertEquals(4, fabrica.getTotalModelos());
    }
}
