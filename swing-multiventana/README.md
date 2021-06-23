# Cambio de ventana en Swing
Es frecuente ver aplicaciones que en vez de ejecutarse directamente usan un "launcher" o lanzador, el cual le da al usuario algún tipo de control sobre cómo quiere ejecutar
la aplicación, generalmente permitiendo elegir la resolución de la misma, el volumen de los sonidos, o incluso un menu sobre el cual elegir una sala para comenzar una partida
de un juego; entre otras cosas.
Algunos ejemplos son:


![EJ-1](https://user-images.githubusercontent.com/17636012/123115661-a35bbf00-d416-11eb-8761-0e18cecf1df4.png)

![EJ-2](https://user-images.githubusercontent.com/17636012/123116363-3ac11200-d417-11eb-9eee-10baedcab8a6.png)
***
Para recrear este comportamiento con Swing se puede usar un JFrame (supongamos "ventana host") que al hacer clic en un JButton instancie a otro JFrame, 
enviandole la información necesaria según la entrada del usuario, en nuestro ejemplo:

![image](https://user-images.githubusercontent.com/17636012/123117041-cc308400-d417-11eb-8132-f9cef13ba6cb.png)
***
Por lo tanto, tiene que existir un JFrame que reciba como parametros la resolución a la cuál debe mostrarse, y si debe reproducir o no sonido. Dicho JFrame va a ser 
instanciado por nuestra "ventana host", la cual luego puede cerrarse si es necesario.
Es importante notar que la instancia del nuevo JFrame tiene que correr en un hilo separado, ya que en caso contrario la ejecución de dicha instancia estaría atada a
nuestra "ventana host", lo que podría provocar problemas de concurrencia y comportamientos no deseados como que por ejemplo al cerrar la ventana host se cierre el 
JFrame instanciado.
