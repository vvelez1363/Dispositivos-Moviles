import java.util.Scanner

fun ejercicio_5() {
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
    val matriz = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        for (j in 0 until M) {
            println("Ingrese el valor para la posición ($i, $j):")
            matriz[i][j] = scanner.nextInt()
        }
    }

    // Verificar si la matriz es "rala"
    var esRala = true
    for (i in 0 until N) {
        var contadorUno = 0
        for (j in 0 until M) {
            if (matriz[i][j] == 1) {
                contadorUno++
            } else if (matriz[i][j] != 0) {
                esRala = false
                break
            }
        }
        if (contadorUno != 1) {
            esRala = false
            break
        }
    }

    // Mostrar el resultado
    if (esRala) {
        println("La matriz es rala.")
    } else {
        println("La matriz no es rala.")
    }
}

/*+-------------------+
| Inicio            |
+-------------------+
| Leer N, M         |
| Crear matriz      |
| (N x M)           |
+-------------------+
|
+-------------------+
| Para cada fila i: |
+-------------------+
|   ContadorUno = 0 |
|   Para cada j:    |
|     Leer elemento |
|     Si elemento = 1|
|       ContadorUno++|
|     Si elemento != 0|
|       EsRala = false|
+-------------------+
|
+-------------------+
| Para cada columna j:|
+-------------------+
|   ContadorUno = 0 |
|   Para cada i:    |
|     Si elemento = 1|
|       ContadorUno++|
|     Si elemento != 0|
|       EsRala = false|
+-------------------+
|
+-------------------+
| Si EsRala = true  |
|   Mostrar "La matriz es rala."|
| Si no             |
|   Mostrar "La matriz no es rala."|
+-------------------+
| Fin               |
+-------------------+
*/