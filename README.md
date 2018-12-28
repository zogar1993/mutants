# Mutants

[![Travis CI Build Status](https://travis-ci.org/zogar1993/mutants.svg?branch=master)](https://travis-ci.org/zogar1993/mutants)
[![Coverage Status](https://img.shields.io/coveralls/github/zogar1993/mutants.svg)](https://coveralls.io/github/zogar1993/mutants?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9c2049c7f9154d86b5ebcf2b75c01787)](https://www.codacy.com/app/zogar1993/mutants?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zogar1993/mutants&amp;utm_campaign=Badge_Grade)

- - -

Hosteado en http://mutants-meli.appspot.com

Expone los servicios:
- POST -> http://mutants-meli.appspot.com/mutant
- GET -> http://mutants-meli.appspot.com/stats

- - -

## Enunciado

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar
contra los X-Men.

Te ha contratado a ti para que desarrolles un proyecto que detecte si un
humano es mutante basándose en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En
alguno de los siguiente lenguajes: Java / Golang / C-C++ / Javascript (node) / Python / Ruby):

    boolean isMutant(String[] dna) // Ejemplo Java

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales​, de forma oblicua, horizontal o vertical.

Ejemplo (Caso mutante):

    String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    
En este caso el llamado a la función isMutant(dna) devuelve “true”.

Desarrolla el algoritmo de la manera más eficiente posible.

#### Desafíos:

##### Nivel 1:

Programa (en cualquier lenguaje de programación) que cumpla con el método pedido por
Magneto.

##### Nivel 2:

Crear una API REST, hostear esa API en un cloud computing libre (Google App Engine,
Amazon AWS, etc), crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:

    POST → /mutant/
    {
        “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
    }
    
En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un
403-Forbidden

##### Nivel 3:

Anexar una base de datos, la cual guarde los ADN’s verificados con la API.

Solo 1 registro por ADN.

Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}
Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1
millón de peticiones por segundo).
Entregar:

- Instrucciones de funcionamiento (Libre, todas las que quiera)
- Código Fuente (En el formato que quiera, lo más estándar posible).
- Además del código fuente, cualquier pieza adicional que consideres aporta a la calidad
del software construido.
- URL de la API (Nivel 2 y 3)