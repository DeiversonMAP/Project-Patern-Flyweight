package org.example.flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MesaImpressaoTest {

    private FabricaModelos fabrica;
    private MesaImpressao mesa;

    @BeforeEach
    void montarMesa() {
        fabrica = new FabricaModelos();
        mesa = new MesaImpressao(fabrica);
        mesa.adicionar("Chaveiro", "PLA", 12, 0, 0);
        mesa.adicionar("Chaveiro", "PLA", 12, 20, 0);
        mesa.adicionar("Chaveiro", "PLA", 12, 40, 0);
        mesa.adicionar("Busto", "PLA", 50, 0, 30);
    }

    @Test
    void deveContarTodasAsPecasDaMesa() {
        assertEquals(4, mesa.getTotalPecas());
    }

    @Test
    void deveCriarApenasUmModeloPorTipoDePeca() {
        assertEquals(2, fabrica.getTotalModelos());
    }

    @Test
    void copiasDoMesmoTipoDevemCompartilharOMesmoModelo() {
        PecaPosicionada primeira = mesa.getPecas().get(0);
        PecaPosicionada segunda = mesa.getPecas().get(1);
        PecaPosicionada busto = mesa.getPecas().get(3);

        assertSame(primeira.getModelo(), segunda.getModelo());
        assertNotSame(primeira.getModelo(), busto.getModelo());
    }

    @Test
    void deveSomarGramasDeTodasAsCopias() {
        // 3 x 12 + 50
        assertEquals(86, mesa.getGramasTotais());
    }

    @Test
    void deveImprimirCadaPecaNaPropriaPosicao() {
        assertEquals(
                Arrays.asList(
                        "Imprimindo Chaveiro (PLA, 12 g) em (0, 0)",
                        "Imprimindo Chaveiro (PLA, 12 g) em (20, 0)",
                        "Imprimindo Chaveiro (PLA, 12 g) em (40, 0)",
                        "Imprimindo Busto (PLA, 50 g) em (0, 30)"
                ),
                mesa.imprimirTudo()
        );
    }

    @Test
    void naoDevePermitirDuasPecasNaMesmaPosicao() {
        IllegalStateException excecao = assertThrows(
                IllegalStateException.class,
                () -> mesa.adicionar("Busto", "PLA", 50, 20, 0)
        );

        assertEquals("Posicao ocupada", excecao.getMessage());
        assertEquals(4, mesa.getTotalPecas());
    }

    @Test
    void listaDePecasNaoDeveSerModificavelPorFora() {
        assertThrows(UnsupportedOperationException.class, () -> mesa.getPecas().clear());
    }
}
