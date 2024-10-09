package com.edwartlc.currencychange.modelos;

import java.util.ArrayList;
import java.util.List;

public class GuardaConversion {
    private List<String> listaDeConversiones;

    public GuardaConversion() {
        this.listaDeConversiones = new ArrayList<>();
    }

    public void guardarConversion(String registro) {
        this.listaDeConversiones.add(registro);
    }

    public List<String> getListaDeConversiones() {
        return listaDeConversiones;
    }
}
