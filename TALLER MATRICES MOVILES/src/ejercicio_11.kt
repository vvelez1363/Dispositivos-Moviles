
fun ejercicio_11() {

    val numEmpleados = 5
    val matrizEmpleados = Array(numEmpleados) { IntArray(3) }

    // Leemos los datos de cada empleado
    for (i in 0 until numEmpleados) {
        println("Ingrese los datos para el empleado ${i + 1}:")

        // Validamos que el código del empleado esté en el rango de 1 a 100
        var codigoEmpleado: Int
        do {
            print("Código del empleado (1 a 100): ")
            codigoEmpleado = readLine()?.toIntOrNull() ?: 0
            if (codigoEmpleado !in 1..100) {
                println("Error: El código debe estar entre 1 y 100. Inténtelo nuevamente.")
            }
        } while (codigoEmpleado !in 1..100)

        matrizEmpleados[i][0] = codigoEmpleado

        // Leemos las horas trabajadas en horario normal
        print("Horas trabajadas en horario normal: ")
        matrizEmpleados[i][1] = readLine()?.toIntOrNull() ?: 0

        // Leemos las horas trabajadas en sobre tiempo
        print("Horas trabajadas en sobre tiempo: ")
        matrizEmpleados[i][2] = readLine()?.toIntOrNull() ?: 0
    }

    // Calculamos los valores requeridos y emitimos el informe
    println("\nInforme de empleados:")
    for (i in 0 until numEmpleados) {
        val codigo = matrizEmpleados[i][0]
        val horasNormales = matrizEmpleados[i][1]
        val horasSobretiempo = matrizEmpleados[i][2]

        val sueldoNormal = horasNormales * 2350
        val sueldoSobretiempo = horasSobretiempo * 3500
        val sueldoTotal = sueldoNormal + sueldoSobretiempo

        println("Empleado $codigo:")
        println("Horas normales trabajadas: $horasNormales")
        println("Sueldo por horas normales: $$sueldoNormal")
        println("Horas de sobretiempo trabajadas: $horasSobretiempo")
        println("Sueldo por horas de sobretiempo: $$sueldoSobretiempo")
        println("Total sueldo del empleado: $$sueldoTotal\n")
    }
}