public class Sumatoria6 {

    public static void main(String[] args) {
        final int N = 10000;
        double resultado = 0;

        for (int n = 1; n <= N; n++) {
            // double termino = (double) (1 / Math.pow(Math.E, n)) + (1 / (n * (n + 1)));
            double termino = (1.0 / Math.pow(Math.E, n)) + 1.0 / (n * (n + 1.0));
            resultado += termino;
            System.out.println(resultado);
        }

        double limite = (1 / Math.pow(Math.E, N)) + ((1) / (N * (N + 1)));
        if (Math.abs(limite) <= 1e-10 || Double.isNaN(limite) || Double.isInfinite(limite)) {
            System.out.println("La serie es convergente.");
        } else {
            System.out.println("La serie es divergente.");
        }

    }
}