# SISTEMA DE ATENCIÓN DE EMERGENCIAS - HOSPITAL

Sistema de colas con prioridad para atender pacientes en la sección de Emergencias de un hospital, implementado en Java.

## Descripción

Este proyecto implementa:
- **ADT Priority Queue** con dos implementaciones:
  - `VectorHeap<E>` - Implementación personalizada basada en Heap con Vector
  - `java.util.PriorityQueue<E>` - Implementación del Java Collection Framework
- **Clase Paciente** - Ficha de atención con código de emergencia
- **Sistema de atención interactivo** que evalúa pacientes por prioridad
- **Niveles de prioridad**: A (máxima) a E (mínima)
- **Manejo de errores**: Lectura de archivos, validación de datos

## Estructura del Proyecto
```
emergencias-hospital-priority-queue/
├── README.md
├── .gitignore
└── demo/                           ← TRABAJAR SIEMPRE DESDE AQUÍ
    ├── pom.xml
    ├── pacientes.txt
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/io/
    │   │   │       ├── Paciente.java
    │   │   │       ├── VectorHeap.java
    │   │   │       ├── HospitalEmergenciasPropio.java
    │   │   │       └── HospitalEmergencias.java
    │   │   └── resources/
    │   │       └── pacientes.txt
    │   └── test/
    │       └── java/
    │           └── com/io/
    │               └── VectorHeapTest.java
    └── target/
        └── classes/
```
## Requisitos

- **Java 17 o superior**
- **Maven 3.6+** (recomendado)

## Instalación

### 1. Clonar el repositorio

git clone https://github.com/AlejandroSagastume/emergencias-hospital-priority-queue
cd emergencias-hospital-priority-queue

### 2. Verificar instalación de Java

java -version

Debe mostrar Java 17 o superior.

### 3. Instalación de Maven

cd demo
mvn clean install

## Compilación y Ejecución

### Opción 1: Con Maven (Recomendado)

1. Ve a la carpeta demo: cd demo
2. Compila el proyecto: mvn clean install
3. Ejecuta la versión con VectorHeap: mvn exec:java -Dexec.mainClass="com.io.HospitalEmergenciasPropio"
4. O ejecuta la versión con Java Collection Framework: mvn exec:java -Dexec.mainClass="com.io.HospitalEmergencias"

### Opción 2: Sin Maven

1. Ve a la carpeta demo
2. Compila el código: javac -d out src/main/java/com/io/*.java
3. Ejecuta: java -cp out com.io.HospitalEmergenciasPropio

## Archivo de Datos

El programa lee pacientes desde `src/main/resources/pacientes.txt`. Formato: Nombre, síntoma, código de prioridad separados por comas. Un paciente por línea. Códigos de prioridad: A (máxima) a E (mínima).

Ejemplo:
Juan Perez, fractura de pierna, C
Maria Ramirez, apendicitis, A
Lorenzo Toledo, chikunguya, E
Carmen Sarmientos, dolores de parto, B
Pedro Martinez, quemadura severa, A
Ana Lopez, migraña fuerte, D
Carlos Ruiz, intoxicación, B

## Orden de Atención

Los pacientes serán atendidos en el siguiente orden (de máxima a mínima prioridad):
1. Maria Ramirez - apendicitis - A
2. Pedro Martinez - quemadura severa - A
3. Carmen Sarmientos - dolores de parto - B
4. Carlos Ruiz - intoxicación - B
5. Juan Perez - fractura de pierna - C
6. Ana Lopez - migraña fuerte - D
7. Lorenzo Toledo - chikunguya - E

## Pruebas JUnit

Ejecutar todas las pruebas: cd demo y mvn test. Pruebas incluidas: VectorHeapTest.java - Pruebas del ADT Priority Queue con VectorHeap (testAddAndRemove, testPeek, testEmptyHeap). Resultado esperado: ✅ 3/3 tests pasando.

## Dependencias

El proyecto utiliza las siguientes librerías (gestionadas automáticamente por Maven):
- JUnit 4.13.2 - Framework de pruebas unitarias

## Clases Principales

### Paciente
Representa la ficha de atención de un paciente. Atributos: nombre, sintoma, codigoEmergencia. Métodos clave: compareTo(Paciente otro), toString().

### VectorHeap<E extends Comparable<E>>
Implementación personalizada de Priority Queue usando un heap mínimo. Métodos principales: add(E value), remove(), peek(), isEmpty(), size(), percolateUp(), percolateDown().

### HospitalEmergenciasPropio
Programa interactivo que utiliza VectorHeap<Paciente>. Lee pacientes desde pacientes.txt, usa la implementación personalizada VectorHeap, atiende pacientes de forma interactiva.

### HospitalEmergencias
Programa interactivo que utiliza java.util.PriorityQueue<Paciente>. Lee pacientes desde pacientes.txt, usa java.util.PriorityQueue del JCF, atiende pacientes de forma interactiva.

## Solución de Problemas

### Error: "pacientes.txt (El sistema no puede encontrar el archivo)"
Solución: Asegúrate de que el archivo está en demo/src/main/resources/pacientes.txt o demo/pacientes.txt y ejecuta desde la raíz del proyecto.

### Error: "cannot find symbol"
Solución: Compila con Maven: cd demo y mvn clean install.

## Tecnologías Utilizadas

- Java 17 - Lenguaje de programación
- Maven - Gestión de dependencias y construcción
- JUnit 4 - Pruebas unitarias
- Git/GitHub - Control de versiones

## Comparación de Implementaciones

### VectorHeap (Implementación propia)
- Basada en heap mínimo manual
- Usa Vector<T> internamente
- Demuestra la comprensión de estructuras de datos

### java.util.PriorityQueue (JCF)
- Implementación estándar de Java
- Optimizada y ampliamente probada
- Base de comparación y validación

## Autores

Alejandro Sagastume - sag25257@uvg.edu.gt

## Curso

CC2003 - Algoritmos y Estructura de Datos
Semestre I – 2020
Universidad del Valle de Guatemala
Hoja de Trabajo No. 8
