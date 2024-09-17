public class PolinomioGrado4 {

    // Función principal
    public static void main(String[] args) {
        // Coeficientes del polinomio: x^4 - 80.5x^2 + 132x + 374.0625
        double[] coeficientes = { 1, 0, -80.5, 132, 374.0625 };

        // Llamada para encontrar las raíces
        double[] soluciones = resolverPolinomioGrado4(coeficientes);

        // Imprimir las soluciones
        System.out.println("Raíces del polinomio:");
        for (double solucion : soluciones) {
            System.out.println(solucion);
        }
    }

    // Método para resolver un polinomio de grado 4 utilizando el método de Bairstow
    public static double[] resolverPolinomioGrado4(double[] coef) {
        // Asegurarnos de que sea un polinomio de grado 4
        if (coef.length != 5) {
            throw new IllegalArgumentException("El polinomio debe ser de grado 4.");
        }

        // Aproximaciones iniciales para Bairstow
        double r = 1, s = 1; // Valores iniciales para r y s
        double tol = 1e-6; // Tolerancia para convergencia
        int maxIter = 1000; // Máximo número de iteraciones

        // Usamos Bairstow para encontrar pares cuadráticos
        double[] b = new double[coef.length];
        double[] c = new double[coef.length];

        for (int iter = 0; iter < maxIter; iter++) {
            // Realizar división sintética (descenso polinómico)
            b[4] = coef[4];
            b[3] = coef[3] + r * b[4];
            b[2] = coef[2] + r * b[3] + s * b[4];
            b[1] = coef[1] + r * b[2] + s * b[3];
            b[0] = coef[0] + r * b[1] + s * b[2];

            c[4] = b[4];
            c[3] = b[3] + r * c[4];
            c[2] = b[2] + r * c[3] + s * c[4];
            c[1] = b[1] + r * c[2] + s * c[3];

            // Calculamos el determinante
            double det = c[2] * c[2] - c[1] * c[3];
            if (Math.abs(det) < tol) {
                break; // Detener si el determinante es pequeño
            }

            // Corrección de r y s usando el método de Newton-Raphson
            double deltaR = (b[1] * c[2] - b[0] * c[3]) / det;
            double deltaS = (b[0] * c[2] - b[1] * c[1]) / det;

            r += deltaR;
            s += deltaS;

            if (Math.abs(deltaR) < tol && Math.abs(deltaS) < tol) {
                break; // Converge si los cambios son suficientemente pequeños
            }
        }

        // Encontramos las raíces del cuadrático obtenido
        double discriminante = r * r - 4 * s;
        double[] raices = new double[4];
        if (discriminante >= 0) {
            // Dos raíces reales
            raices[0] = (-r + Math.sqrt(discriminante)) / 2;
            raices[1] = (-r - Math.sqrt(discriminante)) / 2;
        } else {
            // Raíces complejas (descartadas en este código si se requieren reales)
            raices[0] = -r / 2;
            raices[1] = Math.sqrt(-discriminante) / 2; // Parte imaginaria
        }

        // Ahora, con el polinomio reducido, buscamos las otras raíces
        double[] nuevoCoef = { b[2], b[3], b[4] };
        double[] otrasRaices = resolverPolinomioGrado2(nuevoCoef);

        raices[2] = otrasRaices[0];
        raices[3] = otrasRaices[1];

        return raices;
    }

    // Método auxiliar para resolver un polinomio de grado 2
    public static double[] resolverPolinomioGrado2(double[] coef) {
        double a = coef[2];
        double b = coef[1];
        double c = coef[0];

        double discriminante = b * b - 4 * a * c;
        double[] raices = new double[2];

        if (discriminante >= 0) {
            raices[0] = (-b + Math.sqrt(discriminante)) / (2 * a);
            raices[1] = (-b - Math.sqrt(discriminante)) / (2 * a);
        } else {
            // Raíces complejas (en este caso, devuelve la parte real)
            raices[0] = -b / (2 * a);
            raices[1] = Math.sqrt(-discriminante) / (2 * a);
        }

        return raices;
    }
}