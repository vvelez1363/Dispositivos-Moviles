import java.util.Scanner

fun ejercicio_7() {
    val scanner = Scanner(System.`in`)

    // Leer N y M (validar que sean positivos)
    println("Ingrese el valor de N (filas):")
    val N = scanner.nextInt()
    println("Ingrese el valor de M (columnas):")
    val M = scanner.nextInt()

    if (N <= 0 || M <= 0) {
        println("N y M deben ser números positivos.")
        return
    }

    // Crear y leer la matriz
    val matriz = leerMatriz(N, M, scanner)

    // Leer x (fila a modificar)
    println("Ingrese el número de fila (x) a modificar (0 hasta ${N - 1}):")
    val filaX = scanner.nextInt()
    if (filaX < 0 || filaX >= N) {
        println("Fila inválida. Debe estar entre 0 y ${N - 1}.")
        return
    }

    // Leer (columna a modificar)
    println("Ingrese el número de columna (y) a modificar (0 hasta ${M - 1}):")
    val columnaY = scanner.nextInt()
    if (columnaY < 0 || columnaY >= M) {
        println("Columna inválida. Debe estar entre 0 y ${M - 1}.")
        return
    }

    // a) Eliminar la fila x
    val matrizSinFilaX = eliminarFila(matriz, filaX)
    println("\nMatriz sin la fila $filaX:")
    mostrarMatriz_4(matrizSinFilaX)

    // b) Eliminar la columna y
    val matrizSinColumnaY = eliminarColumna(matriz, columnaY)
    println("\nMatriz sin la columna $columnaY:")
    mostrarMatriz_4(matrizSinColumnaY)

    // c) Insertar una nueva fila en x
    val nuevaFila = leerNuevaFila(M, scanner)
    val matrizConNuevaFila = insertarFila(matriz, filaX, nuevaFila)
    println("\nMatriz con la nueva fila en posición $filaX:")
    mostrarMatriz_4(matrizConNuevaFila)

    // d) Insertar una nueva columna en y
    val nuevaColumna = leerNuevaColumna(N, scanner)
    val matrizConNuevaColumna = insertarColumna(matriz, columnaY, nuevaColumna)
    println("\nMatriz con la nueva columna en posición $columnaY:")
    mostrarMatriz_4(matrizConNuevaColumna)
}

// Función para leer la matriz desde el input
fun leerMatriz(filas: Int, columnas: Int, scanner: Scanner): Array<DoubleArray> {
    println("Ingrese los elementos de la matriz:")
    val matriz = Array(filas) { DoubleArray(columnas) }
    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            print("Matriz[$i][$j]: ")
            matriz[i][j] = scanner.nextDouble()
        }
    }
    return matriz
}

// Función para eliminar una fila de la matriz
fun eliminarFila(matriz: Array<DoubleArray>, fila: Int): Array<DoubleArray> {
    return matriz.filterIndexed { index, _ -> index != fila }.toTypedArray()
}

// Función para eliminar una columna de la matriz
fun eliminarColumna(matriz: Array<DoubleArray>, columna: Int): Array<DoubleArray> {
    return matriz.map { it.filterIndexed { index, _ -> index != columna }.toDoubleArray() }.toTypedArray()
}

// Función para leer una nueva fila desde el input
fun leerNuevaFila(columnas: Int, scanner: Scanner): DoubleArray {
    println("Ingrese los elementos de la nueva fila:")
    val nuevaFila = DoubleArray(columnas)
    for (j in 0 until columnas) {
        print("NuevoFila[$j]: ")
        nuevaFila[j] = scanner.nextDouble()
    }
    return nuevaFila
}

// Función para leer una nueva columna desde el input
fun leerNuevaColumna(filas: Int, scanner: Scanner): DoubleArray {
    println("Ingrese los elementos de la nueva columna:")
    val nuevaColumna = DoubleArray(filas)
    for (i in 0 until filas) {
        print("NuevoColumna[$i]: ")
        nuevaColumna[i] = scanner.nextDouble()
    }
    return nuevaColumna
}

// Función para insertar una nueva fila en la matriz
fun insertarFila(matriz: Array<DoubleArray>, fila: Int, nuevaFila: DoubleArray): Array<DoubleArray> {
    return matriz.toMutableList().apply { add(fila, nuevaFila) }.toTypedArray()
}

// Función para insertar una nueva columna en la matriz
fun insertarColumna(matriz: Array<DoubleArray>, columna: Int, nuevaColumna: DoubleArray): Array<DoubleArray> {
    return matriz.mapIndexed { index, row ->
        row.toMutableList().apply { add(columna, nuevaColumna[index]) }.toDoubleArray()
    }.toTypedArray()
}

// Función para mostrar la matriz en consola
fun mostrarMatriz_4(matriz: Array<DoubleArray>) {
    for (fila in matriz) {
        println(fila.joinToString(" "))
    }
}