package com.edwartlc.currencychange.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GuardaConversion {
    private List<String> listaDeConversiones;
    String registro = "";

    public GuardaConversion() {
        this.listaDeConversiones = new ArrayList<>();
    }

    public void guardarConversion(Conversion conversion) {
        registro = conversion.base_code() + " a " +
                conversion.target_code() + " - Fecha/hora consulta: " +
                LocalDateTime.now();
        this.listaDeConversiones.add(registro);
    }

    public List<String> getListaDeConversiones() {
        return listaDeConversiones;
    }
}
