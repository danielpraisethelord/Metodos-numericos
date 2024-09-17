public class Sumatoria7 {
    public static void main(String[] args) {
        final int N = 1000;
        double resultado = 0;

        for (int n = 2; n <= N; n++) {
            // double termino = (double) (1 / Math.pow(Math.E, n)) + (1 / (n * (n + 1)));
            double termino = 2 / (Math.pow(n, 2) - 1);
            resultado += termino;
            System.out.println(resultado);
        }

        double limite = 2 / (Math.pow(N, 2) - 1);
        if (Math.abs(limite) <= 1e-10 || Double.isNaN(limite) || Double.isInfinite(limite)) {
            System.out.println("La serie es convergente.");
        } else {
            System.out.println("La serie es divergente.");
        }

    }
}
