
fun ejercicio_10() {
    // Supongamos que tienes una matriz de calificaciones (M x 6)
    val calificaciones: Array<DoubleArray> = arrayOf(
        doubleArrayOf(4.5, 3.2, 2.8, 4.0, 3.7, 3.9),
        doubleArrayOf(3.0, 3.5, 3.8, 2.5, 4.2, 3.6),
        doubleArrayOf(2.9, 4.1, 3.3, 3.6, 2.8, 4.0),
        doubleArrayOf(3.7, 2.6, 4.0, 3.5, 3.1, 3.8),
        doubleArrayOf(4.2, 3.9, 3.1, 2.7, 4.5, 3.3),
    )

    // a) Calcular la nota promedio de cada estudiante
    val promediosEstudiantes = calcularPromedioEstudiantes(calificaciones)
    println("Nota promedio de cada estudiante:")
    promediosEstudiantes.forEachIndexed { i, promedio ->
        println("Estudiante ${i + 1}: $promedio")
    }

    // b) Número de estudiantes que aprobaron cada materia
    val aprobadosPorMateria = contarAprobadosPorMateria(calificaciones)
    println("\nNúmero de estudiantes que aprobaron cada materia:")
    aprobadosPorMateria.forEachIndexed { j, aprobados ->
        println("Materia ${j + 1}: $aprobados estudiantes")
    }

    // c) Número de estudiantes que reprobaron cada materia
    val reprobadosPorMateria = contarReprobadosPorMateria(calificaciones)
    println("\nNúmero de estudiantes que reprobaron cada materia:")
    reprobadosPorMateria.forEachIndexed { j, reprobados ->
        println("Materia ${j + 1}: $reprobados estudiantes")
    }

    // d) Nota promedio de cada materia
    val promediosMaterias = calcularPromedioMaterias(calificaciones)
    println("\nNota promedio de cada materia:")
    promediosMaterias.forEachIndexed { j, promedio ->
        println("Materia ${j + 1}: $promedio")
    }
}

fun calcularPromedioEstudiantes(calificaciones: Array<DoubleArray>): DoubleArray {
    val promedios = DoubleArray(calificaciones.size)
    for (i in calificaciones.indices) {
        val sumaCalificaciones = calificaciones[i].sum()
        promedios[i] = sumaCalificaciones / calificaciones[i].size
    }
    return promedios
}

fun contarAprobadosPorMateria(calificaciones: Array<DoubleArray>): IntArray {
    val aprobadosPorMateria = IntArray(calificaciones[0].size)
    for (j in calificaciones[0].indices) {
        aprobadosPorMateria[j] = calificaciones.count { it[j] >= 3.0 }
    }
    return aprobadosPorMateria
}

fun contarReprobadosPorMateria(calificaciones: Array<DoubleArray>): IntArray {
    val reprobadosPorMateria = IntArray(calificaciones[0].size)
    for (j in calificaciones[0].indices) {
        reprobadosPorMateria[j] = calificaciones.count { it[j] < 3.0 }
    }
    return reprobadosPorMateria
}

fun calcularPromedioMaterias(calificaciones: Array<DoubleArray>): DoubleArray {
    val promediosMaterias = DoubleArray(calificaciones[0].size)
    for (j in calificaciones[0].indices) {
        val sumaCalificacionesMateria = calificaciones.map { it[j] }.sum()
        promediosMaterias[j] = sumaCalificacionesMateria / calificaciones.size
    }
    return promediosMaterias
}
