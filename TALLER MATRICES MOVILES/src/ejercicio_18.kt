import java.util.Scanner

fun ejercicio_18() {
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

    // Llenar la matriz con 0
    for (i in 0 until N) {
        for (j in 0 until N) {
            matriz[i][j] = 0
        }
    }

    // Llenar la secuencia comenzando desde la esquina inferior derecha
    var num = 1
    for (i in N - 1 downTo 0) {
        matriz[i][i] = num
        num++
    }

    // Continuar la secuencia en las diagonales superiores
    for (d in 1 until N) {
        var i = N - 1
        var j = N - 1 - d
        while (j >= 0) {
            matriz[i][j] = num
            num++
            i--
            j--
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

