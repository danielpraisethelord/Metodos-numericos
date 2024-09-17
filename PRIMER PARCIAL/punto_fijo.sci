function fixed_point_method(a, b, c, d)
    // Definir función f(x) según el tipo de ecuación
    if a == 0 then
        if b == 0 then
            // Caso lineal: cx + d = 0
            deff('y = f(x)', 'y = -d/c');
        else
            // Caso cuadrático: bx^2 + cx + d = 0
            deff('y = f1(x)', 'y = -d/c - (b/c)*x^2');  // Despeje 1
            deff('y = f2(x)', 'y = sqrt(-d/b - (c/b)*x)');  // Despeje 2
        end
    else
        // Caso cúbico: ax^3 + bx^2 + cx + d = 0
        deff('y = f1(x)', 'y = (-d/c - (b/c)*x^2 - (a/c)*x^3)');  // Despeje 1
        deff('y = f2(x)', 'y = ((-d/a)^(1/3) - (b/a)*x - (c/a))');  // Despeje 2
        deff('y = f3(x)', 'y = (-d/c - (a/c)*x^3 - (b/c)*x^2)');  // Despeje 3
    end
    
    // Valor inicial
    Xn = -0.5;
    max_iter = 100;  // Máximo número de iteraciones
    tol = 1e-15;  // Tolerancia para considerar el error como cero
    
    // Mostrar encabezado
    disp("ITERACION\tXn\t\tf(Xn)\t\tError");
    
    for iter = 0:max_iter
        // Evaluar función en Xn
        if a == 0 & b == 0 then
            Xn1 = f(Xn);
        elseif a == 0 then
            if modulo(iter, 2) == 0 then
                Xn1 = f1(Xn);
            else
                Xn1 = f2(Xn);
            end
        else
            if modulo(iter, 3) == 0 then
                Xn1 = f1(Xn);
            elseif modulo(iter, 3) == 1 then
                Xn1 = f2(Xn);
            else
                Xn1 = f3(Xn);
            end
        end
        
        fx = a*Xn^3 + b*Xn^2 + c*Xn + d;  // Calcular f(Xn)
        
        // Calcular error
        if iter == 0 then
            err = "";
        else
            err = abs((Xn1 - Xn)/Xn1);
        end
        
        // Mostrar resultados
        if err == "" then
            printf("%d\t\t%.9f\t%.9f\t\n", iter, Xn, fx);
        else
            printf("%d\t\t%.9f\t%.9f\t%.9f\n", iter, Xn, fx, err);
        end
        
        // Condición de paro
        if abs(fx) < tol then
            break;
        end
        
        // Actualizar Xn
        Xn = Xn1;
    end
end

// Ejemplo de uso:
// Resolver la ecuación x^2 - 4x - 3 = 0
fixed_point_method(0, 1, -4, -3);
