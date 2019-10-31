# Busqueda por transformacion de claves o Hash

* Permite tener acceso directamente a los datos.
* Se utilizan funciones Hash para calcular el índice en el cual vamos a almacenar el dato y posteriormente buscarlo.
* Se utiliza un método para solucionar colisiones, una colisión se genera cuando se trata de insertar en un índice que se encuentra ocupado.

## Funciones Hash

Es importante seleccionar una buena funcion Hash, a continuacion se presentan algunas.

* Funcion Modulo (Por division)

``` 
H(k) = (k mod N) + 1

K=clave a transformar
N=cantidad de elemento
H(k)=indice que se genera.
Ejemplo: N=100, k1=7259 y k2=9359
H(k1)=(7259 mod 100)+1 = 60
H(k2)=(9359 mod 100)+1=60
```

* Funcion Cuadrado

``` 
H(k)=digitos_centrales(k^2)+1
Ejemplo: n=100,k=7259
K^2=52,693,081
H(k)=dig_centrales(52,693,081)+1=94
```

* Funcion Plegamiento

``` 
H(k)=digmenosig((d1…di)+(di_+1…dj)…+(dl…dn))+1
Ejemplo: valores anteriores
H(k)=digmenosig(72+59)+1=digmenosig(131)+1=32
```

* Funcion Truncamiento

Tome algunos dígitos de la clave y forme con ellos un índice

``` 
H(k)=elegirdigitos(d1,d2,…dn)+1
```

*Ejemplo:*

``` 
H(k)=elegirdigitos(7259)+1=76
```

Se eligió el primer y tercer dígito, también se puede hacer lo mismo con claves alfabéticas o alfanuméricas

## Solucion de Colisiones

Una colisión ocurre cuando se generan dos índices iguales con diferentes claves. Los métodos para solucionar colisiones se clasifican en:

* Reasignación
* Arreglos Anidados
* Encadenamiento

### Reasignacion

* Prueba lineal.- una vez detectada la colisión recorre el arreglo en forma secuencial, a partir del punto de la colisión, buscando el elemento, en caso que se este insertando, buscando la siguiente localidad vacía.

* Prueba Cuadrática.- Es similar a la prueba lineal pero las direcciones se generan como 

``` 
D+1, D+4, D+9, …, D+I^2
```

* Doble Dirección Hash.-Una vez detectada la colisión, se genera otra dirección hash pero ahora como clave la dirección anterior, el proceso termina cuando se halla el dato, o se encuentra una posición vacía.

### Arreglos anidados

Consiste en que cada elemento del arreglo contenga otro arreglo, con las claves colisionadas. Esto puede ser sencillo, pero definitivamente poco práctico.

### Encadenamiento

Consiste en que cada elemento del arreglo contiene un apuntador a una lista ligada, la lista ligada contendrá los valores colisionados. Una desventaja es que ocupa espacio adicional al del vector, e implica el manejo de listas ligadas, y si las listas crecen demasiado, se perderá la facilidad de acceso.

