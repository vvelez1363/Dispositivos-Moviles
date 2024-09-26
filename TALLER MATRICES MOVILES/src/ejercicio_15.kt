fun ejercicio_15(N: Int) {
    if (N % 2 == 0 || N <= 3) {
        println("N debe ser un número impar mayor que 3")
        return
    }

    val matriz = Array(N) { IntArray(N) }
    var num = 1

    // Llenar la matriz en diagonal alternando direcciones
    for (d in 0 until 2 * N - 1) {
        if (d % 2 == 0) { // Diagonales de arriba hacia abajo
            var row = if (d < N) d else N - 1
            var col = if (d < N) 0 else d - N + 1

            while (row >= 0 && col < N) {
                matriz[row][col] = num++
                row--
                col++
            }
        } else { // Diagonales de abajo hacia arriba
            var row = if (d < N) 0 else d - N + 1
            var col = if (d < N) d else N - 1

            while (row < N && col >= 0) {
                matriz[row][col] = num++
                row++
                col--
            }
        }
    }

    // Imprimir la matriz
    for (i in 0 until N) {
        for (j in 0 until N) {
            print("${matriz[i][j]} \t")
        }
        println()
    }
}