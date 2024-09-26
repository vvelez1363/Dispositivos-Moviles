import kotlin.random.Random

fun ejercicio_2(n: Int) {
    val matriz = generarMatrizAleatoria(n)

    println("Matriz completa:")
    mostrarMatriz(matriz)

    mostrarElementos(matriz)
}

fun generarMatrizAleatoria(n: Int): Array<IntArray> {
    val matriz = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            matriz[i][j] = Random.nextInt(1, 100)
        }
    }
    return matriz
}

fun mostrarMatriz(matriz: Array<IntArray>) {
    for (fila in matriz) {
        for (elemento in fila) {
            print("$elemento ")
        }
        println()
    }
}

fun mostrarElementos(matriz: Array<IntArray>) {
    val n = matriz.size

    // Diagonal principal
    val diagonalPrincipal = IntArray(n) { matriz[it][it] }
    println("\nDiagonal principal: ${diagonalPrincipal.joinToString(", ")}")

    // Diagonal secundaria
    val diagonalSecundaria = IntArray(n) { matriz[it][n - it - 1] }
    println("\nDiagonal secundaria: ${diagonalSecundaria.joinToString(", ")}")

    // Matriz triangular superior
    println("\nMatriz triangular superior:")
    for (i in 0 until n) {
        for (j in i until n) {
            print("${matriz[i][j]} ")
        }
        println()
    }

    // Matriz triangular inferior
    println("\nMatriz triangular inferior:")
    for (i in 0 until n) {
        for (j in 0..i) {
            print("${matriz[i][j]} ")
        }
        println()
    }
}