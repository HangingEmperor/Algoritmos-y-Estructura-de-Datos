# Busqueda Binaria
Esta búsqueda consiste en dividir el intervalo de búsqueda en dos partes, comparando el elemento buscado con el central. En caso de no ser iguales se redefinen los extremos del intervalo.

> [!NOTE]
> Esta búsqueda consiste en dividir el intervalo de búsqueda en dos partes, comparando el elemento buscado con el central. En caso de no ser iguales se redefinen los extremos del intervalo.

## Algoritmo

```java
Binaria(v,n,x) //busca el elemento x en el vector v de n componentes
1.- Hacer izq=1,der=n y b=0
2.- repetir mientras(izq<=der) y (b=0)
	hacer cen=parte_entera(izq+der)/2
	2.1 Si x=v[cen]
		entonces
			hacer b=1
		sino //redefinir intervalo de busqueda
		2.1.1 Si x>v[cen]
			entonces hacer izq=cen+1
			sino der=cen-1
		2.1.2 //fin de 2.1.1
	2.2//fin de 2.1.
3.- //fin de ciclo 2
4.- Si b=1
 	entonces	Escribir “El elemento esta en cen”
	sino		Escribir “El elemento no esta en el arrglo”
5.-//fin de 4
```

