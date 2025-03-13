import kotlin.math.*
typealias Vector = List<Double>
typealias Matrix = List<List<Double>>
fun factorial(n: Int): Double = if (n <= 1) 1.0 else (2..n).fold(1.0) { acc, i -> acc * i }
fun integrationScalingMatrix(n: Int, size: Int): Matrix {
    return List(size) { i ->
        List(size) { j ->
            if (i == j) factorial(j).div(factorial(j + n)) else 0.0
        }
    }
}
fun multiplyMatrixVector(matrix: Matrix, vector: Vector): Vector {
    return matrix.map { row -> row.zip(vector).sumOf { (a, b) -> a * b } }
}
fun shiftCoefficientsRight(coeffs: Vector, n: Int): Vector {
    return List(n) { 0.0 } + coeffs
}
fun Vector.printPolynomial(label: String = "f(x)") {
    val terms = this.mapIndexedNotNull { index, coeff ->
        if (coeff == 0.0) null
        else when (index) {
            0 -> "%.4f".format(coeff)
            1 -> "%.4f·x".format(coeff)
            else -> "%.4f·x^$index".format(coeff)
        }
    }
    println("$label = ${terms.joinToString(" + ")}")
}
