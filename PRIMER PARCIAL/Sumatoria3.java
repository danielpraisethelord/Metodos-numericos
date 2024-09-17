public class Sumatoria3 {
    public static void main(String[] args) {
        final int N = 1000;
        double resultado = 0;

        for (int n = 1; n <= N; n++) {
            double termino = (Math.pow(2, n) + Math.pow(3, n)) / Math.pow(6, n);
            resultado += termino;
            if (Double.isNaN(resultado)) {
                System.out.println("Termino " + n + " es NaN");
                break;
            }
            System.out.println(n + ". " + termino + " | Suma acumulada: " + resultado);

        }

        double limite = (Math.pow(2, N) + Math.pow(3, N)) / Math.pow(6, N);
        if (Math.abs(limite) <= 1e-10 || Double.isNaN(limite) || Double.isInfinite(limite)) {
            System.out.println("La serie es convergente.");
        } else {
            System.out.println("La serie es divergente.");
        }
    }
}
