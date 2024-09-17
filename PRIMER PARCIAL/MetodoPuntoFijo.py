import math

def punto_fijo(g, x0, max_iter=100, tol=1e-6):
    for i in range(max_iter):
        x1 = g(x0)
        if abs(x1) > 1e10:
            print(f"Valor excesivo alcanzado: x = {x1}. Abandonando la iteración.")
            return None, i+1
        if abs(x1 - x0) < tol:
            return x1, i+1
        x0 = x1
    return None, max_iter

def g_cubica(a, b, c, d):
    return lambda x: x - (a*x**3 + b*x**2 + c*x + d) / (3*a*x**2 + 2*b*x + c)

def main():
    a = 1
    b = 1.11
    c = -19.6282
    d = 20.22744
    g = g_cubica(a, b, c, d)
    
    soluciones = []
    valores_iniciales = [-5.5, 3, 1.5]
    
    for x0 in valores_iniciales:
        sol, iteraciones = punto_fijo(g, x0)
        if sol is not None:
            soluciones.append(sol)
            print(f"Solución aproximada: {sol} en {iteraciones} iteraciones")
        else:
            print("El método no convergió.")
    
    print(f"Raíces aproximadas: {soluciones}")

if __name__ == "__main__":
    main()
