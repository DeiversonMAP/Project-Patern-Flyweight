package org.example.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaModelos {

    private final Map<String, ModeloPeca> modelos = new HashMap<>();

    public ModeloPeca getModelo(String nome, String material, int gramas) {
        String chave = nome + "|" + material + "|" + gramas;
        ModeloPeca modelo = modelos.get(chave);
        if (modelo == null) {
            modelo = new ModeloPeca(nome, material, gramas);
            modelos.put(chave, modelo);
        }
        return modelo;
    }

    public int getTotalModelos() {
        return modelos.size();
    }
}
