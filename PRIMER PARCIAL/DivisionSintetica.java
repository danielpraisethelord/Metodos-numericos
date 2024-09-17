import java.util.*;

public class DivisionSintetica {

    public static void main(String[] args) {
        List<Double> coeficientes = new ArrayList<>();
        int gradoPolinomio;
        System.out.println("Ingrese el grado del polinomio: ");
        Scanner scanner = new Scanner(System.in);
        gradoPolinomio = scanner.nextInt();
        for (int i = gradoPolinomio; i >= 0; i--) {
            System.out.println("Ingrese el coeficiente de x^" + i + ": ");
            double coeficiente = scanner.nextDouble();
            coeficientes.add(coeficiente);
        }

        Set<Double> divisores = divisoresRacionales(coeficientes);
        List<Double> raices = divisionSintetica(divisores, coeficientes);
        raices.forEach(System.out::println);
    }

    public static Set<Double> divisoresRacionales(List<Double> coeficientes) {
        Set<Double> divisoresP = new HashSet<>();
        Set<Double> divisoresQ = new HashSet<>();

        int primerTermino = coeficientes.get(0).intValue();
        int ultimoTermino = coeficientes.get(coeficientes.size() - 1).intValue();

        for (int i = 1; i <= Math.abs(ultimoTermino); i++) {
            if (ultimoTermino % i == 0) {
                divisoresP.add((double) i);
                divisoresP.add((double) -i);
            }
        }

        for (int i = 1; i <= Math.abs(primerTermino); i++) {
            if (primerTermino % i == 0) {
                divisoresQ.add((double) i);
                divisoresQ.add((double) -i);
            }
        }

        Set<Double> divisoresRacionales = new HashSet<>();
        for (double p : divisoresP) {
            for (double q : divisoresQ) {
                divisoresRacionales.add(p / q);
            }
        }

        return divisoresRacionales;
    }

    public static List<Double> divisionSintetica(Set<Double> divisoresRacionales, List<Double> coeficientes) {

        List<Double> raices = new ArrayList<>();
        List<Double> divisoresRacionalesList = new ArrayList<>(divisoresRacionales);

        // Probar cada divisor racional
        for (Double divisor : divisoresRacionalesList) {
            List<Double> resultadoDivision = new ArrayList<>();
            resultadoDivision.add(coeficientes.get(0)); // Primer coeficiente

            // Realizar la división sintética
            for (int i = 1; i < coeficientes.size(); i++) {
                double nuevoValor = coeficientes.get(i) + divisor * resultadoDivision.get(i - 1);
                resultadoDivision.add(nuevoValor);
            }

            // Si el último valor de la división es 0, entonces divisor es una raíz
            if (Math.abs(resultadoDivision.get(resultadoDivision.size() - 1)) < 1e-6) {
                raices.add(divisor); // Agregar la raíz
                coeficientes = resultadoDivision.subList(0, resultadoDivision.size() - 1); // Reducir el polinomio
            }

            // Si el polinomio se reduce a grado 2, aplicar la fórmula general
            if (coeficientes.size() == 3) {
                raices.addAll(resolverPolinomioCuadratico(coeficientes));
                break; // Ya hemos encontrado todas las raíces
            }
        }

        return raices;
    }

    public static List<Double> resolverPolinomioCuadratico(List<Double> coeficientes) {
        List<Double> raices = new ArrayList<>();
        double a = coeficientes.get(0);
        double b = coeficientes.get(1);
        double c = coeficientes.get(2);

        // Calcular el discriminante
        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            // Dos raíces reales
            double root1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            raices.add(limpiarCero(root1));
            raices.add(limpiarCero(root2));
        } else if (discriminante == 0) {
            // Una raíz real
            double root = -b / (2 * a);
            raices.add(limpiarCero(root));
        } else {
            // Raíces complejas
            System.out.println("Raíces complejas:");
            double real = -b / (2 * a);
            double imaginaria = Math.sqrt(-discriminante) / (2 * a);
            System.out.println(limpiarCero(real) + " + " + imaginaria + "i");
            System.out.println(limpiarCero(real) + " - " + imaginaria + "i");
        }

        return raices;
    }

    public static double limpiarCero(double valor) {
        // Si el valor es muy cercano a 0, lo convertimos a 0.0 para evitar -0.0
        if (Math.abs(valor) < 1e-6) {
            return 0.0;
        }
        return valor;
    }

}
