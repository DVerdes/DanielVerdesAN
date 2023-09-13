package org.example;

import org.junit.Test;

import static org.example.Ejercicio3.calcularHabitaciones;
import static org.junit.Assert.assertEquals;

/**
 * TEST - EJERCICIO 3
 */
public class Ejercicio3Test
{

    @Test
    public void testContarNumerosQueCumplen() {
        assertEquals(3, calcularHabitaciones(4,12,7));
        assertEquals(5, calcularHabitaciones(2,16,4));
        assertEquals(3, calcularHabitaciones(9,17,9));
        assertEquals(3, calcularHabitaciones(12,4,10));
        assertEquals(3, calcularHabitaciones(7,11,10));
        assertEquals(4, calcularHabitaciones(2,15,7));
        assertEquals(4, calcularHabitaciones(4,18,7));
        assertEquals(2, calcularHabitaciones(7,9,10));
        assertEquals(3, calcularHabitaciones(10,1,8));
        assertEquals(3, calcularHabitaciones(11,6,9));
        assertEquals(5, calcularHabitaciones(14,20,7));
        assertEquals(4, calcularHabitaciones(2,14,6));
        assertEquals(9, calcularHabitaciones(11,13,3));
        assertEquals(5, calcularHabitaciones(18,10,7));
        assertEquals(6, calcularHabitaciones(5,14,4));
        assertEquals(4, calcularHabitaciones(1,18,6));
        assertEquals(3, calcularHabitaciones(8,1,6));
        assertEquals(2, calcularHabitaciones(2,7,10));
        assertEquals(4, calcularHabitaciones(6,15,7));
        assertEquals(4, calcularHabitaciones(9,13,7));
        assertEquals(4, calcularHabitaciones(11,9,7));
        assertEquals(3, calcularHabitaciones(4,8,4));
        assertEquals(5, calcularHabitaciones(10,15,7));
        assertEquals(3, calcularHabitaciones(3,8,5));
        assertEquals(3, calcularHabitaciones(2,11,10));
        assertEquals(5, calcularHabitaciones(10,16,6));
        assertEquals(4, calcularHabitaciones(1,19,9));
        assertEquals(5, calcularHabitaciones(12,20,8));
        assertEquals(3, calcularHabitaciones(19,5,10));
        assertEquals(4, calcularHabitaciones(16,12,9));
        assertEquals(3, calcularHabitaciones(9,5,5));
        assertEquals(3, calcularHabitaciones(6,1,4));
        assertEquals(4, calcularHabitaciones(10,6,5));
        assertEquals(5, calcularHabitaciones(1,16,5));
        assertEquals(4, calcularHabitaciones(5,17,7));
        assertEquals(4, calcularHabitaciones(2,16,7));
        assertEquals(2, calcularHabitaciones(1,6,10));
        assertEquals(5, calcularHabitaciones(4,20,5));
        assertEquals(8, calcularHabitaciones(10,20,4));
        assertEquals(5, calcularHabitaciones(17,12,6));
        assertEquals(7, calcularHabitaciones(17,19,6));
        assertEquals(3, calcularHabitaciones(12,6,9));
        assertEquals(6, calcularHabitaciones(8,7,3));
        assertEquals(6, calcularHabitaciones(13,7,4));
        assertEquals(4, calcularHabitaciones(14,13,7));
        assertEquals(3, calcularHabitaciones(8,13,8));
        assertEquals(5, calcularHabitaciones(19,11,8));
        assertEquals(6, calcularHabitaciones(7,9,3));
        assertEquals(4, calcularHabitaciones(8,8,5));
        assertEquals(8, calcularHabitaciones(15,13,4));
        assertEquals(3, calcularHabitaciones(11,4,6));
        assertEquals(4, calcularHabitaciones(19,18,10));
        assertEquals(3, calcularHabitaciones(6,11,8));
        assertEquals(3, calcularHabitaciones(5,12,10));
        assertEquals(5, calcularHabitaciones(16,11,7));
        assertEquals(2, calcularHabitaciones(3,1,10));
        assertEquals(3, calcularHabitaciones(3,10,7));
        assertEquals(5, calcularHabitaciones(1,10,3));
        assertEquals(5, calcularHabitaciones(10,2,3));
        assertEquals(5, calcularHabitaciones(14,18,7));
        assertEquals(4, calcularHabitaciones(11,4,5));
        assertEquals(3, calcularHabitaciones(12,2,6));
        assertEquals(8, calcularHabitaciones(20,18,5));
        assertEquals(4, calcularHabitaciones(10,10,9));
        assertEquals(9, calcularHabitaciones(9,18,3));
        assertEquals(3, calcularHabitaciones(5,15,9));
        assertEquals(6, calcularHabitaciones(13,13,6));
        assertEquals(2, calcularHabitaciones(3,6,8));
        assertEquals(5, calcularHabitaciones(6,9,3));
        assertEquals(3, calcularHabitaciones(11,1,9));
        assertEquals(2, calcularHabitaciones(5,3,9));
        assertEquals(4, calcularHabitaciones(20,7,9));
        assertEquals(2, calcularHabitaciones(5,6,9));
        assertEquals(4, calcularHabitaciones(12,1,4));
        assertEquals(7, calcularHabitaciones(19,15,6));
        assertEquals(9, calcularHabitaciones(19,6,3));
        assertEquals(11, calcularHabitaciones(13,16,3));
        assertEquals(7, calcularHabitaciones(7,11,3));
        assertEquals(6, calcularHabitaciones(14,12,5));
        assertEquals(3, calcularHabitaciones(16,6,8));
        assertEquals(5, calcularHabitaciones(11,16,7));
        assertEquals(3, calcularHabitaciones(5,15,10));
        assertEquals(4, calcularHabitaciones(9,10,5));
        assertEquals(3, calcularHabitaciones(3,16,10));
        assertEquals(8, calcularHabitaciones(10,11,3));
        assertEquals(3, calcularHabitaciones(18,4,9));
        assertEquals(4, calcularHabitaciones(10,8,7));
        assertEquals(2, calcularHabitaciones(1,2,3));
        assertEquals(8, calcularHabitaciones(9,18,4));
        assertEquals(2, calcularHabitaciones(2,3,4));
        assertEquals(3, calcularHabitaciones(18,2,9));
        assertEquals(3, calcularHabitaciones(12,4,6));
        assertEquals(9, calcularHabitaciones(4,20,3));
        assertEquals(4, calcularHabitaciones(9,13,7));
        assertEquals(6, calcularHabitaciones(15,17,6));
        assertEquals(4, calcularHabitaciones(5,7,4));
        assertEquals(4, calcularHabitaciones(13,1,5));
        assertEquals(12, calcularHabitaciones(18,16,3));
        assertEquals(5, calcularHabitaciones(17,2,5));
        assertEquals(5, calcularHabitaciones(2,12,3));
    }
}
