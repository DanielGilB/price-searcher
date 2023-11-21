## Contexto
A la hora de leer el código, hay que ser consciente de que no es un proyecto listo para producción.
Se han dejado comentarios por el código para explicar algunas decisiones tomadas y falta de implementaciones.

No se han implementado todos los test unitarios. Creo que con los que hay se entiende el concepto y no es necesario implementarlos todos.
Tampoco se ha hecho una división de test unitarios y de integración de modo que faciliten la ejecución de la *suite* de tests unitarios.

Faltan implemtanciones que considero *boilerplate* y que están fuera del objetivo de la prueba, pero deberían de tenerlas un proyecto real como por ejemplo:

- *Error handler*
- *Heath check* (actuator por ejemplo)
- *Pipelines* (github actions por ejemplo)
- Migraciones en la base de datos (liquibase por ejemplo)
- Documentación (se podría haber usado swagger o asciidoctor por ejemplo)

# Decisiones técnicas

### Arquitectura Hexagonal
Se ha usado arquitectura hexagonal, por el hecho de que es una arquitectura fácil escalar y mantener. Pienso que para una prueba de concepto es intersante ya que puede dar lugar a bastantes discusiones.

Se han implementado algunos *value objects* y validaciones simples de los mismos. Pero no se ha llegado a hacer un modelado completo del dominio. 
Creo que con lo que hay es suficiente para que se entienda el dominio.

Nota: Si el caso de uso fuese real y fuese nuevo e independiente, hubiese sido más pragmático en las decisiones tomadas y no hubiese usado esta arquitectura para este problema tan simple.

### JPA
He usado JPA ya que se requería crear una base de datos, y JPA permite crear el schema de una manera muy fácil.
Si fuese un caso de uso real, habría usado una solución para generar migraciones en vez de JPA, pero creo que no es el objectivo de la prueba, y esta era una solución más rápida.
Aprovechando que he usado JPA, he usado un *JPA repository* para generar la consulta a base de datos, pero siendo pragmático, para este caso habría usado una simple query SQL.