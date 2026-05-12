package com.io;
/**
 * Clase Paciente que representa la ficha de atención de un paciente
 * en la sala de emergencias. Implementa Comparable para ser usado 
 * en una estructura de datos de cola de prioridad (PriorityQueue).
 * 
 * @author Alejadro Sagastume
 * @version 1.0
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia; // A, B, C, D, E

    /**
     * Constructor de la clase Paciente
     * @param nombre Nombre del paciente
     * @param sintoma Descripción del síntoma
     * @param codigoEmergencia Código de emergencia ('A'-'E'), donde 'A' es la mayor prioridad
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Obtiene el nombre del paciente
     * @return Nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción del síntoma
     * @return Síntoma
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el código de emergencia
     * @return Código de emergencia ('A'-'E')
     */
    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    /**
     * Compara pacientes según el código de emergencia.
     * Un código de emergencia menor indica mayor prioridad.
     * @param otro El otro paciente a comparar
     * @return Número negativo si este paciente tiene mayor prioridad, positivo si menor, cero si igual
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    /**
     * Devuelve una representación en texto del paciente
     * @return Cadena con nombre, síntoma y código de emergencia separados por coma
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}