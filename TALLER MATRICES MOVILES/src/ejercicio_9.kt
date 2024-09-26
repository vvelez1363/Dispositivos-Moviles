import java.util.Scanner

fun ejercicio_9() {
    val scanner = Scanner(System.`in`)

    // Leer N (número de sucursales)
    println("Ingrese el número de sucursales (N):")
    val N = scanner.nextInt()

    if (N <= 0) {
        println("N debe ser un número positivo.")
        return
    }

    // Crear la matriz de ventas N x 12
    val ventas = Array(N) { DoubleArray(12) }
    for (i in 0 until N) {
        println("Ingrese las ventas de la sucursal ${i + 1} para los 12 meses:")
        for (j in 0 until 12) {
            print("Mes ${j + 1}: ")
            ventas[i][j] = scanner.nextDouble()
        }
    }

    // a) Calcular el total de ventas de la compañía
    var totalVentas = 0.0
    for (i in 0 until N) {
        for (j in 0 until 12) {
            totalVentas += ventas[i][j]
        }
    }
    println("\nTotal de ventas de la compañía: $totalVentas")

    // b) Calcular el total de ventas por cada sucursal
    val totalVentasSucursal = DoubleArray(N)
    for (i in 0 until N) {
        var sumaSucursal = 0.0
        for (j in 0 until 12) {
            sumaSucursal += ventas[i][j]
        }
        totalVentasSucursal[i] = sumaSucursal
        println("Total de ventas de la sucursal ${i + 1}: $sumaSucursal")
    }

    // c) Encontrar la sucursal que más vendió durante el año
    var maxVentas = totalVentasSucursal[0]
    var sucursalMaxVentas = 0
    for (i in 1 until N) {
        if (totalVentasSucursal[i] > maxVentas) {
            maxVentas = totalVentasSucursal[i]
            sucursalMaxVentas = i
        }
    }
    println("La sucursal que más vendió durante el año es la sucursal ${sucursalMaxVentas + 1} con ventas de $maxVentas")

    // d) Encontrar el mes que menos vendió la compañía
    val ventasPorMes = DoubleArray(12)
    for (j in 0 until 12) {
        var sumaMes = 0.0
        for (i in 0 until N) {
            sumaMes += ventas[i][j]
        }
        ventasPorMes[j] = sumaMes
    }

    var minVentasMes = ventasPorMes[0]
    var mesMinVentas = 0
    for (j in 1 until 12) {
        if (ventasPorMes[j] < minVentasMes) {
            minVentasMes = ventasPorMes[j]
            mesMinVentas = j
        }
    }
    println("El mes que menos vendió la compañía es el mes ${mesMinVentas + 1} con ventas de $minVentasMes")
}

/*+-----------------------------+
| Inicio                      |
+-----------------------------+
| Leer N                      |
| Crear matriz N x 12         |
| Leer ventas de cada sucursal|
+-----------------------------+
|
+-----------------------------+
| Calcular total de ventas    |
| de la compañía              |
+-----------------------------+
|
+-----------------------------+
| Calcular total de ventas    |
| por cada sucursal           |
+-----------------------------+
|
+-----------------------------+
| Encontrar sucursal que más  |
| vendió durante el año       |
+-----------------------------+
|
+-----------------------------+
| Encontrar mes que menos     |
| vendió la compañía          |
+-----------------------------+
|
+-----------------------------+
| Imprimir resultados         |
+-----------------------------+
| Fin                         |
+-----------------------------+
*/