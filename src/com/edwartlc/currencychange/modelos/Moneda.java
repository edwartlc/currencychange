package com.edwartlc.currencychange.modelos;

public record Moneda(String base_code,
                     String target_code,
                     double conversion_rate) {
}
