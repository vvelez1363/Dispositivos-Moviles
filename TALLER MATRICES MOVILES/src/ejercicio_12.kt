fun ejercicio_12() {
    var n: Int?

    do {
        println("Ingrese el tamaño de la matriz (debe ser impar y mayor que 3):")
        n = readLine()?.toIntOrNull()

        if (n == null || n % 2 == 0 || n <= 3) {
            println("El tamaño de la matriz debe ser impar y mayor que 3. Inténtelo de nuevo.")
        }
    } while (n == null || n % 2 == 0 || n <= 3)

    val matrix = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            matrix[i][j] = if ((i == 0 || i == n - 1) && (j > 0 && j < n - 1)) 1
            else if ((i == 1 || i == n - 2) && (j == n / 2)) 1
            else 4
        }
    }

    // Imprimir la matriz
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}