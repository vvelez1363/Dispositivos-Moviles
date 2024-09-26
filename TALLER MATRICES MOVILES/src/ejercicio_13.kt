
fun ejercicio_13(N: Int) {
    if (N % 2 == 0 || N <= 3) {
        println("N debe ser un número impar mayor que 3")
        return
    }

    val matrix = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        for (j in 0 until N) {
            // Establecer 1 en los bordes y 0 en el resto
            matrix[i][j] = if (i == 0 || i == N - 1 || j == 0 || j == N - 1) 1 else 0
        }
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            print("${matrix[i][j]} ")
        }
        println()
    }
}