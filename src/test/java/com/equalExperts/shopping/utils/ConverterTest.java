package com.equalExperts.shopping.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    void shouldSetTotalPriceRoundTo2DecimalPLaces() {
        assertEquals(12.12, Converter.roundDecimalTo2Points(12.123));
    }

    @Test
    void shouldSetTotalPriceRoundTo2DecimalPLacesUpperIf3rdValueGreaterThan5() {
        assertEquals(12.13, Converter.roundDecimalTo2Points(12.126));
    }

    @Test
    void shouldSetTotalPriceRoundTo2DecimalPLacesLowerIf3rdValueEqualTo5() {
        assertEquals(12.13, Converter.roundDecimalTo2Points(12.125));
    }

    @Test
    void shouldSetTotalPriceRoundTo2DecimalPLacesLowerIf3rdValueEqualTo5AndPreviousAre99() {
        assertEquals(13.00, Converter.roundDecimalTo2Points(12.995));
    }
}