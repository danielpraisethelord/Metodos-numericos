public class Sumatoria4 {
    public static void main(String[] args) {
        final int N = 100;
        double resultado = 0;

        for (int n = 1; n <= N; n++) {
            double termino = (Math.pow(3, 4 * n) * Math.pow(8, 1 - 2 * n));
            resultado += termino;
            if (Double.isNaN(resultado)) {
                System.out.println("Termino " + n + " es NaN");
                break;
            }
            System.out.println(n + ". " + termino + " | Suma acumulada: " + resultado);
        }
        double limite = (Math.pow(3, 4 * N) * Math.pow(8, 1 - 2 * N));
        if (Math.abs(limite) <= 1e-10 || Double.isNaN(limite) || Double.isInfinite(limite)) {
            System.out.println("La serie es convergente.");
        } else {
            System.out.println("La serie es divergente.");
        }
    }
}
