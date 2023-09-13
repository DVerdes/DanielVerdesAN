package org.example;

import static org.example.Ejercicio1.esMatriculaValida;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * TEST - EJERCICIO 1
 */
public class Ejercicio1Test
{

    @Test
    public void testMatriculaValida() {
        assertTrue(esMatriculaValida("13X111-22"));
        assertTrue(esMatriculaValida("24Z137-66"));
        assertTrue(esMatriculaValida("99B753-46"));
    }

    @Test
    public void testMatriculaInvalida() {
        assertFalse(esMatriculaValida("14X111-22"));
        assertFalse(esMatriculaValida("24Z127-66"));
        assertFalse(esMatriculaValida("99B753-76"));
        assertFalse(esMatriculaValida("123Y456-D"));
        assertFalse(esMatriculaValida("123E456-D"));
        assertFalse(esMatriculaValida("000A000-D"));
        assertFalse(esMatriculaValida("123X456H"));
        assertFalse(esMatriculaValida("ABCXDEFGH"));
        assertFalse(esMatriculaValida("23B517-6"));
        assertFalse(esMatriculaValida("23B517-651"));
        assertFalse(esMatriculaValida("23B517165"));
        assertFalse(esMatriculaValida("23B517H65"));
        assertFalse(esMatriculaValida("23A517-65"));
        assertFalse(esMatriculaValida("23E517-65"));
        assertFalse(esMatriculaValida("23I517-65"));
        assertFalse(esMatriculaValida("23O517-65"));
        assertFalse(esMatriculaValida("23U517-65"));
        assertFalse(esMatriculaValida("23Y517-65"));
        assertFalse(esMatriculaValida("2AB517-65"));
        assertFalse(esMatriculaValida("2AB517-65"));
    }
}
