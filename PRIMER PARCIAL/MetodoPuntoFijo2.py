import numpy as np

coeficientes = [1, 0, -80.5, 132, 374.0625]
soluciones = np.roots(coeficientes)
print(f"Raíces (incluyendo complejas): {soluciones}")