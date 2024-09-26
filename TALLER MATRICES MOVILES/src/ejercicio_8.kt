import java.util.Scanner

// Función general que realiza todas las operaciones sobre la matriz
fun ejercicio_8() {
    val scanner = Scanner(System.`in`)

    // Leer N (validar que sea positivo)
    println("Ingrese el valor de N:")
    val N = scanner.nextInt()

    if (N <= 0) {
        println("N debe ser un número positivo.")
        return
    }

    // Crear y leer la matriz
    val matriz = leerMatriz(N, scanner)

    // Mostrar la matriz original
    println("\nMatriz original:")
    mostrarMatriz_5(matriz)

    // Reemplazar los números negativos por cero y los positivos por nueve
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (matriz[i][j] < 0) {
                matriz[i][j] = 0
            }else {
                matriz[i][j] = 9
            }
        }
    }

    // Mostrar la matriz original y cambiada (como es la misma matriz, el resultado es el mismo)
    println("\nMatriz cambiada:")
    mostrarMatriz_5(matriz)
}

// Función para leer la matriz desde la entrada del usuario
fun leerMatriz(N: Int, scanner: Scanner): Array<IntArray> {
    println("Ingrese los elementos de la matriz:")
    val matriz = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        for (j in 0 until N) {
            print("Matriz[$i][$j]: ")
            matriz[i][j] = scanner.nextInt()
        }
    }
    return matriz
}

// Función para mostrar la matriz en consola
fun mostrarMatriz_5(matriz: Array<IntArray>) {
    for (fila in matriz) {
        for (elemento in fila) {
            print("$elemento\t")
        }
        println()
    }
}