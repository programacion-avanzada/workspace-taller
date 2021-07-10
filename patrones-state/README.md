## Patrón State 

### Explicación

El patrón de diseño State resulta muy útil cuando necesitamos que un objeto actúe de diferente forma según el estado interno del mismo.

### Ventajas y Desventajas

Algunas de las ventajas que presenta este patrón de diseño son:

- Se localizan fácilmente las responsabilidades de los estados específicos, dado que se encuentran en las clases que corresponden a cada estado. Esto brinda una mayor claridad en el desarrollo y el mantenimiento posterior. Esta facilidad la brinda el hecho que los diferentes estados están representados por un único atributo (state) y no envueltos en diferentes variables y grandes condicionales.
- Hace los cambios de estado explícitos puesto que en otros tipos de implementación los estados se cambian modificando valores en variables, mientras que aquí al estar representado cada estado.
- Facilita la ampliación de estados.
- Permite a un objeto cambiar de clase en tiempo de ejecución dado que al cambiar sus responsabilidades por las de otro objeto de otra clase la herencia y responsabilidades del primero han cambiado por las del segundo.

No obstante, State tiene la siguiente desventaja:

- Se incrementa el número de subclases.

### Ejemplo

Por ejemplo, tenemos el objeto MarioBros que actuará diferente ante el ataque de un enemigo; si MarioBros está en estado “Piromaniaco” o “Grande” este pasará a ir a un estado “Chiquito”, pero en cambio si MarioBros está en estado “Chiquito”, esté pasará a estar a un estado “Muerto”.<br>
Siguiendo este mismo ejemplo, se mostrará como sería el diagrama de UML de un patrón State:

![diagrama-uml](https://user-images.githubusercontent.com/63320772/125171950-581f0b80-e18d-11eb-8faa-db3fd11e7fa5.png)

En este diagrama podemos ver que todos los estados que extienden de la clase “Estado” tienen el método implementado esAtacado() el cual devolverá, dependiendo su estado actual, otra instancia de otro estado diferente.<br><br>
Con el siguiente diagrama de estado también se podrá como el objeto MarioBross pasa por los diferentes diagramas de Estados.

![image](https://user-images.githubusercontent.com/63320772/124196554-0dbdd080-daa3-11eb-8d2e-3ab4dd7982fa.png)

<br>

![image](https://user-images.githubusercontent.com/63320772/124196600-2201cd80-daa3-11eb-9350-d9d4a8f58ff3.png)
