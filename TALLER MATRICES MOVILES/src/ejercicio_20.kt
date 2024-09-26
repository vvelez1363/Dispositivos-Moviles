fun ejercicio_20() {
    // Solicitar al usuario un valor de N
    println("Introduce el valor de N (debe ser impar y mayor a 3):")
    val n = readLine()?.toIntOrNull()

    // Validar que N sea impar y mayor que 3
    if (n != null && n > 3 && n % 2 != 0) {
        // Crear una matriz de tamaño N x N
        val matriz = Array(n) { IntArray(n) }

        var contador = 1
        var filaInicio = 0
        var filaFin = n - 1
        var columnaInicio = 0
        var columnaFin = n - 1

        // Llenado en espiral desde la esquina superior izquierda
        while (filaInicio <= filaFin && columnaInicio <= columnaFin) {
            // Llenar la fila superior (de izquierda a derecha)
            for (i in columnaInicio..columnaFin) {
                matriz[filaInicio][i] = contador++
            }
            filaInicio++

            // Llenar la columna derecha (de arriba a abajo)
            for (i in filaInicio..filaFin) {
                matriz[i][columnaFin] = contador++
            }
            columnaFin--

            // Llenar la fila inferior (de derecha a izquierda)
            if (filaInicio <= filaFin) {
                for (i in columnaFin downTo columnaInicio) {
                    matriz[filaFin][i] = contador++
                }
                filaFin--
            }

            // Llenar la columna izquierda (de abajo a arriba)
            if (columnaInicio <= columnaFin) {
                for (i in filaFin downTo filaInicio) {
                    matriz[i][columnaInicio] = contador++
                }
                columnaInicio++
            }
        }

        // Mostrar la matriz
        for (fila in matriz) {
            println(fila.joinToString(" "))
        }
    } else {
        println("Error: N debe ser un número impar mayor que 3.")
    }
}