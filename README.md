# AE3.JPA


 

 

 

### Asignatura	: 	Acceso a Datos 
 
### Grupo		:	8 

### Integrantes	:	
                  Cristian Quiceno Laverde 

                  Gabriela Prieto Herrera 

                  Libertad Gamarra La Rosa 

 
### Repositorio Git: https://github.com/GabrielaPrietoH/AE3.JPA.git 

 

## Metodología:  

En esta actividad, cada miembro del grupo trabajó individualmente en la elaboración completa del proyecto. En el Requerimiento 1, se creó un proyecto para gestionar una cadena de librerías. En el Requerimiento 2, cada integrante eligió una empresa y utilizó JPA (Java Persistence API) para diseñar un modelo de datos que incluyera relaciones 1 a 1, 1 a N y N a M. 
Posteriormente, en una reunión conjunta, se integraron los modelos individuales, se identificaron y corrigieron posibles errores en las relaciones, y se configuraron las anotaciones de JPA en cada entidad para establecer relaciones bidireccionales de manera efectiva. 
En una fase posterior, se incorporó JAXB (Java Architecture for XML Binding) para cumplir con el Requerimiento 3, serializando una lista de 3 artículos a XML mediante las anotaciones de JAXB implementadas en la clase 'Articulo'. 
En cuanto a las pruebas, cada integrante realizó consultas específicas a las entidades diseñadas utilizando EntityManager, documentando tanto el modelo de datos final como las consultas realizadas. Aunque Cristian y Gabriela lograron completar exitosamente sus implementaciones, Libertad enfrentó dificultades técnicas que le impidieron realizar las pruebas adecuadamente. Se subieron los trabajos individuales al repositorio en GitHub compartido del grupo. Finalmente, el equipo tomó la decisión de presentar la actividad final basada en el trabajo de Cristian, considerando la calidad del código y la coherencia del modelo de datos integrado. 

## Enunciado: 

Aprender a manejar JPA y JAXB en una aplicación de gestión de librería. 

Requerimiento 1 

La idea de esta aplicación será la de generar un modelo de datos para gestionar una cadena de librerías. Se pide diseñar el programa mediante JPA que cumpla con, al menos, los siguientes requisitos y entidades. Autor, tendrá un id, un nombre, unos apellidos y una fecha de nacimiento. Un autor podrá escribir muchos libros. Editorial, tendrá un id, un nombre y una dirección. También tendrá una colección de libros publicados por la editorial.Libro, tendrá un id, un título, un precio, una editorial y un autor.Librería, tendrá un id, un nombre, un nombre del dueño, una dirección y una colección de libros. Además, hay que tener en cuenta que un libro puede estar en diferentes librerías.Todas estas entidades tendrán relaciones bidireccionales.Una vez diseñado el modelo de datos y creadas las tablas se pide hacer las siguientes operaciones (los valores serán elegidos por el alumno, pero deberán de tener sentido). 

Dar de alta 3 autores 

Dar de alta 2 editoriales 

Dar de alta 8 libros, cada libro será escrito por uno de los autores dados de alta previamente y pertenecerá a uno de los editoriales dados de alta previamente.2 librerías, cada librería tendrá 4 libros dados de alta previamente. Además, se pide realizar las siguientes consultas y mostrarlas por pantalla, cada una debe de ser independiente: 

Mostrar todos los libros dados de alta, con su editorial y su autor 

Mostrar todos los autores dados de alta, con sus libros asociados 

Mostrar todas las librerías, con solamente sus libros asociados 

Mostrar todos los libros dados de alta, y en la librería en la que están. 

Requerimiento 2 

Se pide realizar un nuevo modelo de datos que cubra todos los tipos de relaciones visto en clase, esto es, 1 a 1, 1 a N y N a M. El modelo tendrá las entidades necesarias para realizar dichas relaciones y será inventado por los alumnos, es decir, será un trabajo original. Se piden hacer las entidades y las anotaciones en cada entidad para realizar el modelo de datos de JPA.Se recomienda que cada integrante del equipo realice un modelo nuevo para practicar y entender JPA.Por ejemplo, se podría hacer un modelo de datos de una empresa de coches, que tuviera una lista de empleados asociados y una dirección asociada. 

Requerimiento 3 

Aplicando JAXB, coger la clase ‘Articulo’ de la actividad 1 y serializar una lista con 3 artículos a XML. Para ello se deberán de usar las anotaciones de JAXB correspondientes. 

## Contenido

