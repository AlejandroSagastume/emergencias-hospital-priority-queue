package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Programa principal que simula la atención de pacientes en una sala de emergencias
 * utilizando la implementación de PriorityQueue del Java Collection Framework.
 * 
 * Lee los datos de pacientes desde un archivo 'pacientes.txt',
 * los inserta en la PriorityQueue y atiende a los pacientes según su prioridad.
 * 
 * @author Alejandro Sagastume
 * @version 1.0
 */
public class HospitalEmergencias {

    /**
     * Carga los pacientes desde el archivo pacientes.txt
     * @param cola La cola de prioridad donde se insertan los pacientes
     * @return Número de pacientes cargados
     */
    public static int cargarPacientes(PriorityQueue<Paciente> cola) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    char prioridad = partes[2].trim().charAt(0);
                    Paciente paciente = new Paciente(nombre, sintoma, prioridad);
                    cola.add(paciente);
                    contador++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo pacientes.txt: " + e.getMessage());
        }
        return contador;
    }

    /**
     * Método principal que ejecuta el sistema de emergencia
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaPacientes = new PriorityQueue<>();

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE ATENCIÓN DE EMERGENCIAS - HOSPITAL║");
        System.out.println("║      (Usando Java Collection Framework)       ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // Cargar pacientes del archivo
        int pacientesLados = cargarPacientes(colaPacientes);
        System.out.println("Se cargaron " + pacientesLados + " pacientes del archivo.\n");

        if (colaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para atender.");
            return;
        }

        System.out.println("Pacientes en la cola (en orden de prioridad):");
        System.out.println("─────────────────────────────────────────────────\n");

        Scanner scanner = new Scanner(System.in);
        int pacienteAtendido = 0;

        while (!colaPacientes.isEmpty()) {
            System.out.println("Pacientes pendientes: " + colaPacientes.size());
            System.out.print("Presiona ENTER para atender al siguiente paciente...");
            scanner.nextLine();

            Paciente siguiente = colaPacientes.poll();
            pacienteAtendido++;

            System.out.println("\nPACIENTE " + pacienteAtendido + " ");
            System.out.println("│ Nombre:   " + siguiente.getNombre());
            System.out.println("│ Síntoma:  " + siguiente.getSintoma());
            System.out.println("│ Prioridad: " + siguiente.getCodigoEmergencia());
        }

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║ Todos los pacientes han sido atendidos.     ║");
        System.out.println("║ Total atendidos: " + pacienteAtendido);
        System.out.println("╚════════════════════════════════════════════════╝");

        scanner.close();
    }
}