fun ejercicio_17() {
    var N: Int? = null

    while (N == null || N % 2 == 0 || N <= 3) {
        println("Ingrese el tamaño de la matriz (debe ser impar y mayor que 3):")
        val input = readLine()
        N = input?.toIntOrNull()
        if (N == null || N % 2 == 0 || N <= 3) {
            println("Entrada inválida. N debe ser un número impar y mayor que 3.")
        }
    }

    // Crear la matriz de NxN
    val matriz = Array(N) { IntArray(N) }

    // Llenar la fila superior e inferior con 1
    for (i in 0 until N) {
        matriz[0][i] = 1
        matriz[N - 1][i] = 1
    }

    // Llenar la diagonal desde la esquina inferior izquierda con 1
    for (i in 0 until N) {
        matriz[N - 1 - i][i] = 1
    }

    // Imprimir la matriz
    for (fila in matriz) {
        println(fila.joinToString(" "))
    }
}
