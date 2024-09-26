import java.util.Scanner

fun ejercicio_4() {
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

    // Crear la matriz y leer los valores
    val matriz = Array(N) { DoubleArray(M) }
    for (i in 0 until N) {
        for (j in 0 until M) {
            println("Ingrese el valor para la posición ($i, $j):")
            matriz[i][j] = scanner.nextDouble()
        }
    }

    // a) Verificar si la matriz es cuadrada
    val esCuadrada = N == M
    if (esCuadrada) {
        println("La matriz es cuadrada.")
    } else {
        println("La matriz no es cuadrada.")
    }

    // b) Calcular y mostrar el promedio de los N x M números
    val totalElementos = N * M
    var sumaTotal = 0.0
    for (i in 0 until N) {
        for (j in 0 until M) {
            sumaTotal += matriz[i][j]
        }
    }
    val promedioTotal = sumaTotal / totalElementos
    println("Promedio total de los números: $promedioTotal")

    // c) Calcular y mostrar el promedio por fila
    for (i in 0 until N) {
        val promedioFila = matriz[i].average()
        println("Promedio fila $i: $promedioFila")
    }

    // d) Calcular y mostrar el promedio por columna
    for (j in 0 until M) {
        val columna = matriz.map { it[j] }
        val promedioColumna = columna.average()
        println("Promedio columna $j: $promedioColumna")
    }
}