package com.edwartlc.currencychange.modelos;

public record Conversion(String base_code,
                         String target_code,
                         double conversion_rate) {
}
