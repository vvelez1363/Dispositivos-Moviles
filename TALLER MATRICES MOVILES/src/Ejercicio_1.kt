// Variables globales
val rows = 4
val cols = 4
val k = 2

fun ejercicio_1() {
    val arr = Array(rows) { r -> IntArray(cols) { c -> r + c } }
    // El valor en cada posición de la matriz es la suma del índice de la fila y el índice de la columna.

    println("Matriz Original: ")
    for (row in arr) {
        println(row.contentToString())
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            arr[r][c] *= k
        }
    }

    println("\nMatriz Multiplicada por K:")
    for (row in arr) {
        println(row.contentToString())
    }
}