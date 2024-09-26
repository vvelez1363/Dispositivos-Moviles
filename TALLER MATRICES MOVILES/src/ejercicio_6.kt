import java.util.Scanner

fun ejercicio_6() {
    val scanner = Scanner(System.`in`)

    // Leer N y M (validar que sean positivos)
    println("Ingrese el valor de N (filas):")
    val N = scanner.nextInt()
    println("\nIngrese el valor de M (columnas):")
    val M = scanner.nextInt()

    if (N <= 0 || M <= 0) {
        println("N y M deben ser números positivos.")
        return
    }

    // Crear y leer la primera matriz
    val matriz1 = leerMatriz(N, M, scanner, "Matriz 1 x ")

    // Crear y leer la segunda matriz
    val matriz2 = leerMatriz(N, M, scanner, "Matriz 2 ")

    // a) Suma de ambas matrices
    val matrizSuma = sumarMatrices(matriz1, matriz2)
    println("\nMatriz resultante (suma):")
    mostrarMatriz_3(matrizSuma)

    // b) Multiplicación de ambas matrices (si es posible)
    val matrizMultiplicacion = multiplicarMatrices(matriz1, matriz2)
    if (matrizMultiplicacion != null) {
        println("\nMatriz resultante (multiplicación):")
        mostrarMatriz_3(matrizMultiplicacion)
    } else {
        println("\nNo es posible multiplicar las matrices (número de columnas de la matriz 1 debe ser igual al número de filas de la matriz 2).")
    }
}

fun leerMatriz(filas: Int, columnas: Int, scanner: Scanner, nombre: String): Array<DoubleArray> {
    println("Ingrese los elementos de la $nombre:")
    val matriz = Array(filas) { DoubleArray(columnas) }
    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            print("$nombre[$i][$j]: ")
            matriz[i][j] = scanner.nextDouble()
        }
    }
    return matriz
}

fun sumarMatrices(matriz1: Array<DoubleArray>, matriz2: Array<DoubleArray>): Array<DoubleArray> {
    val filas = matriz1.size
    val columnas = matriz1[0].size
    val resultado = Array(filas) { DoubleArray(columnas) }

    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            resultado[i][j] = matriz1[i][j] + matriz2[i][j]
        }
    }
    return resultado
}

fun multiplicarMatrices(matriz1: Array<DoubleArray>, matriz2: Array<DoubleArray>): Array<DoubleArray>? {
    val filas1 = matriz1.size
    val columnas1 = matriz1[0].size
    val filas2 = matriz2.size
    val columnas2 = matriz2[0].size

    if (columnas1 != filas2) {
        return null // No se puede multiplicar
    }

    val resultado = Array(filas1) { DoubleArray(columnas2) }

    for (i in 0 until filas1) {
        for (j in 0 until columnas2) {
            var suma = 0.0
            for (k in 0 until columnas1) {
                suma += matriz1[i][k] * matriz2[k][j]
            }
            resultado[i][j] = suma
        }
    }
    return resultado
}

fun mostrarMatriz_3(matriz: Array<DoubleArray>) {
    for (fila in matriz) {
        for (elemento in fila) {
            print("$elemento\t")
        }
        println()
    }
}