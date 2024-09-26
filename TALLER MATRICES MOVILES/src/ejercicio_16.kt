import java.util.Scanner

fun ejercicio_16() {
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

    // Crear la matriz de NxN
    val matriz = Array(N) { IntArray(N) }

    // Llenar la diagonal principal con la secuencia de números
    for (i in 0 until N) {
        matriz[i][i] = i + 1
    }

    // Continuar la secuencia en las diagonales superiores
    var num = N + 1
    for (d in 1 until N) {
        var i = 0
        var j = d
        while (j < N) {
            matriz[i][j] = num
            num++
            i++
            j++
        }
    }

    // Llenar con 0 los elementos debajo de la diagonal principal
    for (i in 1 until N) {
        for (j in 0 until i) {
            matriz[i][j] = 0
        }
    }

    // Imprimir la matriz alineada
    for (i in 0 until N) {
        for (j in 0 until N) {
            print("${matriz[i][j]}\t")
        }
        println()
    }
}
