public class Sumatoria5 {
    public static void main(String[] args) {
        final int N = 10000;
        double resultado = 0;

        for (int n = 0; n <= N; n++) {
            double termino = (double) (n - 1) / (n + 1);
            resultado += termino;
            if (Double.isNaN(resultado)) {
                System.out.println("Termino " + n + " es NaN");
                break;
            }
            System.out.println(n + ". " + termino + " | Suma acumulada: " + resultado);
        }
        double limite = (double) (N - 1) / (N + 1);
        if (Math.abs(limite) <= 1e-10 || Double.isNaN(limite) || Double.isInfinite(limite)) {
            System.out.println("La serie es convergente.");
        } else {
            System.out.println("La serie es divergente.");
        }
    }
}
