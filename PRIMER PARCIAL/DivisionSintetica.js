const prompt = require('prompt-sync')();

function main() {
    let coeficientes = [];
    let gradoPolinomio = parseInt(prompt("Ingrese el grado del polinomio: "));

    for (let i = gradoPolinomio; i >= 0; i--) {
        let coeficiente = parseFloat(prompt("Ingrese el coeficiente de x^" + i + ": "));
        coeficientes.push(coeficiente);
    }

    console.log("Coeficientes:", coeficientes);

    let divisores = divisoresRacionales(coeficientes);
    console.log("Divisores racionales:", divisores);

    let raices = divisionSintetica(divisores, coeficientes);
    console.log("Raíces encontradas:", raices);
}

function divisoresRacionales(coeficientes) {
    let divisoresP = new Set();
    let divisoresQ = new Set();

    let primerTermino = Math.abs(coeficientes[0]);
    let ultimoTermino = Math.abs(coeficientes[coeficientes.length - 1]);

    for (let i = 1; i <= ultimoTermino; i++) {
        if (ultimoTermino % i === 0) {
            divisoresP.add(i);
            divisoresP.add(-i);
        }
    }

    for (let i = 1; i <= primerTermino; i++) {
        if (primerTermino % i === 0) {
            divisoresQ.add(i);
            divisoresQ.add(-i);
        }
    }

    let divisoresRacionales = new Set();
    divisoresP.forEach(p => {
        divisoresQ.forEach(q => {
            divisoresRacionales.add(p / q);
        });
    });

    return Array.from(divisoresRacionales);
}

function divisionSintetica(divisoresRacionales, coeficientes) {
    let raices = [];
    let gradoActual = coeficientes.length - 1;

    divisoresRacionales.forEach(divisor => {
        if (gradoActual <= 2) return;  // Evitar iterar si ya se ha alcanzado el grado 2 o 1

        let resultadoDivision = [coeficientes[0]];

        for (let i = 1; i < coeficientes.length; i++) {
            let nuevoValor = coeficientes[i] + divisor * resultadoDivision[i - 1];
            resultadoDivision.push(nuevoValor);
        }

        console.log("Resultado de la división sintética con divisor", divisor, ":", resultadoDivision);

        if (Math.abs(resultadoDivision[resultadoDivision.length - 1]) < 1e-6) {
            raices.push(divisor);
            coeficientes = resultadoDivision.slice(0, resultadoDivision.length - 1);
            gradoActual--;

            if (gradoActual === 2) {
                raices = raices.concat(resolverPolinomioCuadratico(coeficientes));
            } else if (gradoActual === 1) {
                let raiz = -coeficientes[1] / coeficientes[0];
                raices.push(raiz);
            }
        }
    });

    return raices;
}

function resolverPolinomioCuadratico(coeficientes) {
    let raices = [];
    let a = coeficientes[0];
    let b = coeficientes[1];
    let c = coeficientes[2];

    let discriminante = b * b - 4 * a * c;

    console.log("Discriminante:", discriminante);

    if (discriminante > 0) {
        let root1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        let root2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        raices.push(limpiarCero(root1));
        raices.push(limpiarCero(root2));
    } else if (discriminante === 0) {
        let root = -b / (2 * a);
        raices.push(limpiarCero(root));
    } else {
        let real = limpiarCero(-b / (2 * a));
        let imaginaria = Math.sqrt(-discriminante) / (2 * a);
        raices.push(`${real} + ${imaginaria}i`);
        raices.push(`${real} - ${imaginaria}i`);
    }

    return raices;
}

function limpiarCero(valor) {
    if (Math.abs(valor) < 1e-6) {
        return 0.0;
    }
    return valor;
}

main();
