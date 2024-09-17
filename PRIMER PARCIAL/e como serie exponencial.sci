n = 10000;

suma = 0;

for i = 0:n
    termino = 1 / factorial(i);
    suma = suma + termino;
end

e_aprox = suma;

e_exacto = exp(1);

error_absoluto = abs(e_exacto - e_aprox);

disp(msprintf("Aproximación de e: %.7f", e_aprox));
disp(msprintf("Error absoluto: %.10f", error_absoluto));
