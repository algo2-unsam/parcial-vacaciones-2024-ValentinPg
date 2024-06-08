
## Parcial Vacaciones

[Link al enunciado](https://docs.google.com/document/d/12UdyTUUs1gVHc4ukTujKgsb6D86y5vfyiDiEuA_AQ-8/edit?usp=sharing)

## Diagrama

[solucion](diagrama/pracial-ValentinPugliese.png)

## Soluciones

Punto 1:
Utilicé una superclase abstracta (ya que tiene estado, por lo tanto no puedo usar Interface) que a su vez tiene un template method en el cual redefino en cada subclase el comportamiento de la condicion para que un lugar sea divertido.

No utilicé Interface porque tiene estado y esta solucion con un template method abstracto me obliga a redefinirlo en cada clase que herede de Lugar


Punto 2:
Para definir la preferencia de cada persona utilicé un stretegy, de esta forma obtengo facilidad para cambiar de preferencia. Utilizar ifs, por ejemplo, hace que mi diseño sea rigído y menos cohesivo.

Tambien implementé composite en el combinador, de esta forma puedo anidar todas las preferencias que quiera.

Punto 3:
En este caso opté por una clase maestra que sea armado de tours, que implementa todas las funcionalidades que definí antes, permitiendome controlar el proceso de elegir los tours para cada persona de manera clara y delegando las responsabilidaddes e manera más equitativa entre todos.

Punto 4:
A la hora de confirmar decidí implementar un patrón de observers que me va a permitir flexibilidad a la hora de agragar y sacar acciones que se ejecuten a la hora de confirmar. Este caso era ideal para usar observers ya que todas las cosas que tiene que hacer el progrma no tienen un impacto "inmediato"  o directo sobre los tours, por lo que son acciones pasivas que impactan en otras secciones del código

## Corrección

10 (diez), muy buen examen

- Ya veo que es un patrón de todo el grupo, entregar usando varios archivos, lo cual dificulta seriamente la corrección
- Punto 1: ok
- Punto 2: ok
- Punto 3: ok
- Punto 4: ok
- Las flechas de asociación del diagrama de clases no son las correctas