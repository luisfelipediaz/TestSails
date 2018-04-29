let snail = function (array: any[][]) {
    debugger;
    const arrReturn = [...new Array(array.length * array.length)];
    let posiciones = {
        x: 0,
        y: 0
    };

    let eje = 'y';

    let maximos = {
        x: {
            min: 0,
            max: array.length - 1
        },
        y: {
            min: 0,
            max: array.length - 1
        }

    };

    let aumentador = 1;

    let iteraciones = 0;

    let minOmax = 'max';

    let maxY = array.length;
    arrReturn.forEach((item, index) => {
        arrReturn[index] = array[posiciones.x][posiciones.y];

        if (posiciones[eje] === maximos[eje][minOmax]) {

            iteraciones++;
            eje = eje === 'y' ? 'x' : 'y';

            if (iteraciones === 1) {
                maximos[eje]['min']++;
            }else {
                maximos[eje]['max']--;
            }
            

            if (iteraciones === 2) {
                iteraciones = 0;
                aumentador *= -1;
                minOmax = minOmax === 'min' ? 'max' : 'min'
            }
        }

        posiciones[eje] += aumentador;
    });
}