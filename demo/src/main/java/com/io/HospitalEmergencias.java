package com.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;


/**
 * Programa principal para simular la atención de pacientes en una sala de emergencias
 * utilizando una cola de prioridad basada en la clase Paciente.
 * 
 * Lee los datos de pacientes desde un archivo de texto 'pacientes.txt', 
 * los inserta en la PriorityQueue y atiende a los pacientes según su prioridad.
 * 
 * @author Alejadro Sagastume
 * @version 1.0
 */
public class HospitalEmergencias {
    /**
     * Método principal que ejecuta el sistema de emergencia.
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaPacientes = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    char prioridad = partes[2].trim().charAt(0);
                    Paciente paciente = new Paciente(nombre, sintoma, prioridad);
                    colaPacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("\n== Orden de atención de pacientes ==");
        while (!colaPacientes.isEmpty()) {
            Paciente siguiente = colaPacientes.poll();
            System.out.println(siguiente);
        }
    }
}