n = 100000;

suma = 0;

aproximacion_pi = zeros(1, n);
error_absoluto = zeros(1, n);

pi_exacto = %pi;

for i = 1:n
    termino = (-1)^(i+1) / (2*i - 1);
    suma = suma + termino;
    
    aproximacion_pi(i) = 4 * suma;
    
    error_absoluto(i) = abs(pi_exacto - aproximacion_pi(i));
end

disp("Aproximación de pi: " + string(aproximacion_pi($)));
disp("Error absoluto: " + string(error_absoluto($)));
