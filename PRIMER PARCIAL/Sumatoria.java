public class Sumatoria {
    public static void main(String[] args) {
        final int N = 1000;
        double resultado = 0;

        for (int n = 1; n <= N; n++) {
            double termino = (Math.pow(n, 3)) / Math.pow(2, n);
            resultado += termino;
            System.out.println(n + ". " + termino + " | Suma acumulada: " + resultado);
        }

        double limite = (Math.pow(N, 3)) / Math.pow(2, N);
        if (limite == 0) {
            System.out.println("La serie es divergente.");
        } else {
            System.out.println("La serie es convergente.");
        }
    }
}
