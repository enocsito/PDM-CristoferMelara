package com.example.lib

import java.util.Scanner

class Computadora(
    val procesador: String = "Intel Core i9 14900",
    val tarjetaGrafica: String = "Nvidia RTX 4090",
    var sistemaOperativo: String = "Windows 11",
    var ramGB: Int = 32,
    var almacenamientoGB: Int = 2048
) {
    var estadoEncendido: Boolean = false
    val programas: List<String> = listOf(
        "Word 2025",
        "Excel 2024",
        "Facebook 2026",
        "Instagram 2026",
        "Visual Studio 2023"
    )

    fun encender() {
        if (!estadoEncendido) {
            estadoEncendido = true
            println("La computadora se ha encendido")
        } else {
            println("La computadora ya se encuentra encendida")
        }
    }

    fun apagar() {
        if (estadoEncendido) {
            estadoEncendido = false
            println("La computadora se ha apagado")
        } else {
            println("La computadora ya se encuentra apagada")
        }
    }

    fun expandirRam(cantidadGB: Int) {
        ramGB += cantidadGB
        println("Se han agregado $cantidadGB GB de RAM a la computadora")
    }

    fun expandirAlmacenamiento(cantidadGB: Int) {
        almacenamientoGB += cantidadGB
        println("Se han agregado $cantidadGB GB de almacenamiento a la computadora")
    }

    fun actualizarOS(nuevoSistemaOperativo: String) {
        sistemaOperativo = nuevoSistemaOperativo
        println("El sistema operativo de la computadora ha sido actualizado a $nuevoSistemaOperativo")
    }

    fun mostrarInformacion() {
        println("Procesador: $procesador")
        println("Tarjeta Grafica: $tarjetaGrafica")
        println("Sistema Operativo: $sistemaOperativo")
        println("RAM: $ramGB GB")
        println("Almacenamiento: $almacenamientoGB GB")
        println("Programas : $programas")
    }
}

fun main() {
    val computadora = Computadora()
    val scanner = Scanner(System.`in`)
    var opcion: Int = 0

    do {
        println(
            "\nQue deseas hacer?\n 1. Encender la computadora\n " +
                    "2. Apagar la computadora\n " +
                    "3. Mostrar informacion de la computadora\n " +
                    "4. Actualizar el sistema operativo\n " +
                    "5. Expandir la RAM\n " +
                    "6. Expandir el almacenamiento\n " +
                    "7. Filtrar programas del anio 2026\n " +
                    "8. Salir\n "
                    + "Opcion: "
        )

        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt()
            scanner.nextLine()
        } else {
            println("Entrada no valida.")
            scanner.next()
            continue
        }

        when (opcion) {
            1 -> computadora.encender()
            2 -> computadora.apagar()
            3 -> computadora.mostrarInformacion()
            4 -> {
                print("Ingrese el nuevo sistema operativo: ")
                val nuevoSistemaOperativo = scanner.nextLine()
                computadora.actualizarOS(nuevoSistemaOperativo)
            }

            5 -> {
                print("Ingrese la cantidad de GB a agregar a la RAM: ")
                val cantidadGB = if (scanner.hasNextInt()) scanner.nextInt() else 0
                if (scanner.hasNextLine()) scanner.nextLine()
                computadora.expandirRam(cantidadGB)
            }

            6 -> {
                print("Ingrese la cantidad de GB a agregar al almacenamiento: ")
                val cantidadGB = if (scanner.hasNextInt()) scanner.nextInt() else 0
                if (scanner.hasNextLine()) scanner.nextLine()
                computadora.expandirAlmacenamiento(cantidadGB)
            }

            7 -> {
                println("Programas del anio 2026")
                val filtrados = computadora.programas.filter { it.contains("2026") }
                if (filtrados.isEmpty()) {
                    println("No hay programas de 2026.")
                } else {
                    filtrados.forEach { println(" - $it") }
                }
            }

            8 -> println("Saliendo...")
            else -> println("Opcion invalida")
        }
    } while (opcion != 8)
}
