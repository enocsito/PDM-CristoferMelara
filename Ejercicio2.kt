package com.example.ejercicio2
import java.util.Scanner
class Calculadora(
    val marca: String = "Casio",
    val aniosVida: Int = 10,
    var precio: Double = 100.0
) {
    fun sumar(a: Double, b: Double): Double {
        return a + b
    }
    fun restar(a: Double, b: Double): Double {
        return a - b
    }
    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }
    fun dividir(a: Double, b: Double): Double {
        if (b != 0.0) {
            return a / b
        } else {
            throw IllegalArgumentException("No se puede dividir por cero")
        }
    }
}

fun main(){
    val calculadora = Calculadora()
    var opcion: Int = 0
    val scanner = Scanner(System.`in`)
    do {
        println("Que deseas hacer?\n" +
                "1. Sumar\n" +
                "2. Restar\n" +
                "3. Multiplicar\n" +
                "4. Dividir\n" +
                "5. Info de la calculadora\n" +
                "6. Salir\n" +
                "Opcion: ")
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt()
            scanner.nextLine()
        } else {
            println("Entrada no valida.")
            scanner.next()
            continue
        }

        when (opcion) {
            1 -> {
                print("Ingrese el primer numero: ")
                val num1 = if (scanner.hasNextDouble()) scanner.nextDouble() else 0.0
                if (scanner.hasNextLine()) scanner.nextLine()
                print("Ingrese el segundo numero: ")
                val num2 = if (scanner.hasNextDouble()) scanner.nextDouble() else 0.0
                if (scanner.hasNextLine()) scanner.nextLine()
                println("La suma es: ${calculadora.sumar(num1, num2)}")
            }
            2 -> {
                print("Ingrese el primer numero: ")
                val num1 = if (scanner.hasNextDouble()) scanner.nextDouble() else 0.0
                if (scanner.hasNextLine()) scanner.nextLine()
                print("Ingrese el segundo numero: ")
                val num2 = if (scanner.hasNextDouble()) scanner.nextDouble() else 0.0
                if (scanner.hasNextLine()) scanner.nextLine()
                println("La resta es: ${calculadora.restar(num1, num2)}")
            }
            3 -> {
                print("Ingrese el primer numero: ")
                val num1 = if (scanner.hasNextDouble()) scanner.nextDouble() else 0.0
                if (scanner.hasNextLine()) scanner.nextLine()
                print("Ingrese el segundo numero: ")
                val num2 = if (scanner.hasNextDouble()) scanner.nextDouble() else 0.0
                if (scanner.hasNextLine()) scanner.nextLine()
                println("El producto es: ${calculadora.multiplicar(num1, num2)}")
            }
            4 -> {
                print("Ingrese el primer numero: ")
                val num1 = if (scanner.hasNextDouble()) scanner.nextDouble() else 0.0
                if (scanner.hasNextLine()) scanner.nextLine()
                print("Ingrese el segundo numero: ")
                val num2 = if (scanner.hasNextDouble()) scanner.nextDouble() else 0.0
                if (scanner.hasNextLine()) scanner.nextLine()
                println("La division es: ${calculadora.dividir(num1, num2)}")
            }
            5 -> {
                println("Marca: ${calculadora.marca}")
                println("Anios de vida: ${calculadora.aniosVida}")
                println("Precio: ${calculadora.precio}")
            }
            6 -> {
                println("Saliendo...")
            }
        }
    } while (opcion != 6)
}
