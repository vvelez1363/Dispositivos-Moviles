val A = 3 // Filas de la matriz
val B = 4 // Columnas de la matriz

fun mostrarMatriz_2(matriz: Array<IntArray>) {
    for (fila in matriz) {
        for (elemento in fila) {
            print("$elemento\t")
        }
        println()
    }
}

fun transponerMatriz(matriz: Array<IntArray>): Array<IntArray> {
    val filas = matriz.size
    val columnas = matriz[0].size
    val matrizTranspuesta = Array(columnas) { IntArray(filas) }

    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            matrizTranspuesta[j][i] = matriz[i][j]
        }
    }

    return matrizTranspuesta
}

fun ejercicio_3(A: Int, B: Int) {
    // Crear y llenar la matriz X
    val matrizX = Array(A) { IntArray(B) }
    for (i in 0 until A) {
        for (j in 0 until B) {
            matrizX[i][j] = (i + j) // Llenar con valores incrementales
        }
    }

    // Mostrar la matriz X original
    println("Matriz Original:")
    mostrarMatriz_2(matrizX)

    // Calcular y mostrar la matriz transpuesta
    val matrizTranspuesta = transponerMatriz(matrizX)
    println("\nMatriz transpuesta:")
    mostrarMatriz_2(matrizTranspuesta)
}