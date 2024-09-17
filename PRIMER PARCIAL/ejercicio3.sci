vector = [1, 2, 3, 4, 5];

combinaciones = perms(vector);

numeros_combinaciones = combinaciones(:,1) * 10000 + combinaciones(:,2) * 1000 + combinaciones(:,3) * 100 + combinaciones(:,4) * 10 + combinaciones(:,5);

[_, indices_orden] = gsort(numeros_combinaciones, "g", "i");

combinaciones_ordenadas = combinaciones(indices_orden, :);

disp(combinaciones_ordenadas);
