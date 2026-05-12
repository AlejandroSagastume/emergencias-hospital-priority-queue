package com.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas unitarias para la clase VectorHeap.
 * Evalúa la inserción y extracción de pacientes según prioridad.
 */
public class VectorHeapTest {
    private VectorHeap<Paciente> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    public void testAddAndRemove() {
        Paciente p1 = new Paciente("Juan Perez", "fractura de pierna", 'C');
        Paciente p2 = new Paciente("Maria Ramirez", "apendicitis", 'A');
        Paciente p3 = new Paciente("Lorenzo Toledo", "chikunguya", 'E');
        Paciente p4 = new Paciente("Carmen Sarmientos", "dolores de parto", 'B');

        heap.add(p1);
        heap.add(p2);
        heap.add(p3);
        heap.add(p4);

        assertEquals("Maria Ramirez", heap.remove().getNombre());
        assertEquals("Carmen Sarmientos", heap.remove().getNombre());
        assertEquals("Juan Perez", heap.remove().getNombre());
        assertEquals("Lorenzo Toledo", heap.remove().getNombre());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testPeek() {
        Paciente p1 = new Paciente("Paciente Uno", "sintoma1", 'D');
        Paciente p2 = new Paciente("Paciente Dos", "sintoma2", 'B');

        heap.add(p1);
        heap.add(p2);

        assertEquals("Paciente Dos", heap.peek().getNombre());
        assertEquals(2, heap.size());
    }

    @Test
    public void testEmptyHeap() {
        assertNull(heap.remove());
        assertNull(heap.peek());
        assertTrue(heap.isEmpty());
    }
}