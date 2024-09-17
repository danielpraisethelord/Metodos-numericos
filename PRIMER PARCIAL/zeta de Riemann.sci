s = 2;

n = 10000;

suma = 0;

for i = 1:n
    termino = 1 / (i^s);
    suma = suma + termino;
end

zeta_s = suma;

zeta_exacto = %pi^2 / 6;

error_absoluto = abs(zeta_exacto - zeta_s);

disp(msprintf("Aproximación de zeta(s=2): %.7f", zeta_s));
disp(msprintf("Error absoluto: %.5f", error_absoluto));
