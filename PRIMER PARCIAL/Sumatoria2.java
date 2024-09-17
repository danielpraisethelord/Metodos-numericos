public class Sumatoria2 {
    public static void main(String[] args) {
        final int N = 800;
        double resultado = 0;
        boolean esDivergente = false;

        for (int n = 1; n <= N; n++) {
            double termino = (Math.pow(Math.E, n)) / (Math.pow(Math.E, n) + n);

            if (Double.isNaN(termino)) {
                esDivergente = true;
                System.out.println("Termino " + n + " es NaN. La serie es divergente.");
                break;
            }

            resultado += termino;
            System.out.println(n + ". " + termino + " | Suma acumulada: " + resultado);
        }

        if (esDivergente) {
            System.out.println("La serie es divergente debido a un desbordamiento numérico.");
        } else {
            double limite = (Math.pow(Math.E, N)) / (Math.pow(Math.E, N) + N);
            if (limite == 0) {
                System.out.println("La serie es convergente.");
            } else {
                System.out.println("La serie es divergente.");
            }
        }
    }
}
