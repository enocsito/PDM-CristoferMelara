package com.example.ejercicio3

import java.util.Scanner

class Estudiante(
    val nombre: String,
    val carnet: String,
    val asignatura: String
)

fun main() {
    val scanner = Scanner(System.`in`)
    val ciclo01 = listOf(
        Estudiante("Juan Perez", "00012323", "Programacion de Dispositivos Moviles"),
        Estudiante("Maria Lopez", "00045623", "Programacion de Dispositivos Moviles"),
        Estudiante("Carlos Ruiz", "00078923", "Programacion de Dispositivos Moviles"),
        Estudiante("Ana Garcia", "00011123", "Analisis numerico"),
        Estudiante("Luis Torres", "00022223", "Analisis numerico"),
        Estudiante("Elena Mejia", "00033323", "Analisis numerico"),
        Estudiante("Roberto Sosa", "00044423", "Analisis numerico")
    )

    var opcion: Int = 0
    do {
        println("1. Ver todos los estudiantes\n" +
                "2. Ver solo Programacion de Dispositivos Moviles\n" +
                "3. Ver solo Analisis numerico\n" +
                "4. Salir\n" +
                "Seleccione una opcion: ")

        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt()
            scanner.nextLine()
        } else {
            println("Entrada no valida. Por favor, ingrese un numero.")
            scanner.next()
            continue
        }

        when (opcion) {
            1 -> {
                println("\nLista completa de estudiantes:")
                ciclo01.forEach { println("- ${it.nombre} [${it.carnet}] | Asignatura: ${it.asignatura}") }
            }
            2 -> {
                println("\nEstudiantes de Programacion de Dispositivos Moviles")
                val dispositivos = ciclo01.filter { it.asignatura == "Programacion de Dispositivos Moviles" }
                if (dispositivos.isEmpty()) {
                    println("No hay estudiantes inscritos.")
                } else {
                    dispositivos.forEach { println("- ${it.nombre} (${it.carnet})") }
                }
            }
            3 -> {
                println("\nEstudiantes de Analisis numerico")
                val analisis = ciclo01.filter { it.asignatura == "Analisis numerico" }
                if (analisis.isEmpty()) {
                    println("No hay estudiantes inscritos.")
                } else {
                    analisis.forEach { println("- ${it.nombre} (${it.carnet})") }
                }
            }
            4 -> println("Saliendo del programa...")
            else -> println("Opcion no valida, intente de nuevo.")
        }
    } while (opcion != 4)
}
