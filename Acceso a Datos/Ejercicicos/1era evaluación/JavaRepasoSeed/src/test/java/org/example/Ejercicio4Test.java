package org.example;

import org.junit.Test;

import static org.example.Ejercicio4.calcularGolpes;
import static org.junit.Assert.assertEquals;

/**
 * TEST - EJERCICIO 4
 */
public class Ejercicio4Test
{

    @Test
    public void testcalcularGolpes() {
        assertEquals(3, calcularGolpes(16,5));
        assertEquals(1, calcularGolpes(15,8));
        assertEquals(1, calcularGolpes(2,2));
        assertEquals(4, calcularGolpes(12,3));
        assertEquals(3, calcularGolpes(17,5));
        assertEquals(1, calcularGolpes(18,10));
        assertEquals(3, calcularGolpes(9,3));
        assertEquals(1, calcularGolpes(14,8));
        assertEquals(2, calcularGolpes(10,5));
        assertEquals(3, calcularGolpes(17,5));
        assertEquals(2, calcularGolpes(12,5));
        assertEquals(3, calcularGolpes(6,2));
        assertEquals(0, calcularGolpes(5,7));
        assertEquals(1, calcularGolpes(4,4));
        assertEquals(14, calcularGolpes(14,1));
        assertEquals(4, calcularGolpes(13,3));
        assertEquals(1, calcularGolpes(5,4));
        assertEquals(5, calcularGolpes(10,2));
        assertEquals(2, calcularGolpes(15,6));
        assertEquals(2, calcularGolpes(20,8));
        assertEquals(0, calcularGolpes(5,7));
        assertEquals(2, calcularGolpes(19,9));
        assertEquals(1, calcularGolpes(17,10));
        assertEquals(19, calcularGolpes(19,1));
        assertEquals(0, calcularGolpes(5,8));
        assertEquals(2, calcularGolpes(17,8));
        assertEquals(1, calcularGolpes(3,3));
        assertEquals(2, calcularGolpes(17,8));
        assertEquals(1, calcularGolpes(13,8));
        assertEquals(0, calcularGolpes(1,2));
        assertEquals(0, calcularGolpes(3,8));
        assertEquals(0, calcularGolpes(3,6));
        assertEquals(9, calcularGolpes(19,2));
        assertEquals(0, calcularGolpes(1,6));
        assertEquals(1, calcularGolpes(5,3));
        assertEquals(1, calcularGolpes(11,6));
        assertEquals(1, calcularGolpes(19,10));
        assertEquals(0, calcularGolpes(7,9));
        assertEquals(3, calcularGolpes(9,3));
        assertEquals(0, calcularGolpes(1,8));
        assertEquals(1, calcularGolpes(10,7));
        assertEquals(0, calcularGolpes(2,6));
        assertEquals(1, calcularGolpes(10,8));
        assertEquals(6, calcularGolpes(20,3));
        assertEquals(18, calcularGolpes(18,1));
        assertEquals(6, calcularGolpes(19,3));
        assertEquals(2, calcularGolpes(20,7));
        assertEquals(0, calcularGolpes(3,7));
        assertEquals(0, calcularGolpes(9,10));
        assertEquals(2, calcularGolpes(8,4));
        assertEquals(2, calcularGolpes(5,2));
        assertEquals(0, calcularGolpes(7,8));
        assertEquals(3, calcularGolpes(19,5));
        assertEquals(0, calcularGolpes(1,9));
        assertEquals(0, calcularGolpes(5,10));
        assertEquals(6, calcularGolpes(19,3));
        assertEquals(0, calcularGolpes(6,7));
        assertEquals(1, calcularGolpes(10,10));
        assertEquals(1, calcularGolpes(9,7));
        assertEquals(0, calcularGolpes(2,3));
        assertEquals(0, calcularGolpes(1,2));
        assertEquals(6, calcularGolpes(13,2));
        assertEquals(0, calcularGolpes(4,8));
        assertEquals(1, calcularGolpes(4,3));
        assertEquals(5, calcularGolpes(11,2));
        assertEquals(1, calcularGolpes(6,5));
        assertEquals(1, calcularGolpes(16,9));
        assertEquals(0, calcularGolpes(7,8));
        assertEquals(4, calcularGolpes(4,1));
        assertEquals(12, calcularGolpes(12,1));
        assertEquals(3, calcularGolpes(19,5));
        assertEquals(2, calcularGolpes(18,8));
        assertEquals(0, calcularGolpes(1,4));
        assertEquals(2, calcularGolpes(17,8));
        assertEquals(2, calcularGolpes(13,6));
        assertEquals(2, calcularGolpes(14,5));
        assertEquals(1, calcularGolpes(16,10));
        assertEquals(2, calcularGolpes(18,7));
        assertEquals(0, calcularGolpes(2,7));
        assertEquals(2, calcularGolpes(19,7));
        assertEquals(3, calcularGolpes(18,6));
        assertEquals(2, calcularGolpes(9,4));
        assertEquals(1, calcularGolpes(15,10));
        assertEquals(2, calcularGolpes(16,7));
        assertEquals(1, calcularGolpes(5,5));
        assertEquals(1, calcularGolpes(5,4));
        assertEquals(3, calcularGolpes(6,2));
        assertEquals(2, calcularGolpes(20,9));
        assertEquals(2, calcularGolpes(16,8));
        assertEquals(2, calcularGolpes(6,3));
        assertEquals(8, calcularGolpes(8,1));
        assertEquals(1, calcularGolpes(13,9));
        assertEquals(1, calcularGolpes(12,9));
        assertEquals(2, calcularGolpes(6,3));
        assertEquals(2, calcularGolpes(17,8));
        assertEquals(13, calcularGolpes(13,1));
        assertEquals(0, calcularGolpes(4,7));
        assertEquals(1, calcularGolpes(9,6));
        assertEquals(2, calcularGolpes(2,1));
        assertEquals(9, calcularGolpes(19,2));
    }
}
