import java.util.Scanner

fun ejercicio_19() {
    val scanner = Scanner(System.`in`)
    var N: Int

    // Función para validar que N es impar y mayor que 3
    fun validarN(n: Int): Boolean {
        return n > 3 && n % 2 != 0
    }

    // Solicitar el tamaño de la matriz al usuario hasta que ingrese un valor válido
    while (true) {
        println("Ingrese el tamaño de la matriz (debe ser impar y mayor que 3):")
        N = scanner.nextInt()
        if (validarN(N)) {
            break
        } else {
            println("El valor ingresado no es válido. Inténtelo de nuevo.")
        }
    }

    // Crear la matriz NxN
    val matriz = Array(N) { IntArray(N) }

    // Coordenadas iniciales en el centro de la matriz
    var x = N / 2
    var y = N / 2

    // Contador que llenará la matriz
    var contador = 1

    // Movimientos en espiral: arriba, derecha, abajo, izquierda
    val movimientos = arrayOf(
        Pair(-1, 0), // arriba
        Pair(0, 1),  // derecha
        Pair(1, 0),  // abajo
        Pair(0, -1)  // izquierda
    )

    var pasos = 1 // Cantidad de pasos que se moverá en cada dirección
    var direccion = 0 // Índice para acceder al movimiento actual

    // Llenado de la matriz
    while (contador <= N * N) {
        // Dos veces para moverse en la misma cantidad de pasos (uno por eje x, otro por eje y)
        for (i in 0 until 2) {
            for (j in 0 until pasos) {
                // Evitar indexar fuera de la matriz
                if (x in 0 until N && y in 0 until N) {
                    matriz[x][y] = contador
                    contador++
                }
                // Actualizamos las coordenadas según la dirección
                x += movimientos[direccion].first
                y += movimientos[direccion].second
            }
            // Cambiamos la dirección de movimiento
            direccion = (direccion + 1) % 4
        }
        // Aumentamos los pasos en cada iteración
        pasos++
    }

    // Imprimir la matriz alineada
    for (fila in matriz) {
        for (num in fila) {
            print(String.format("%4d", num))
        }
        println()
    }
}
