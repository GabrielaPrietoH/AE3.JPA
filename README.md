# AE3.JPA

 ![1](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/7f6d7bb8-4f43-43dc-8cc3-28dd72079027)
 
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

![2](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/89f809ab-27b6-4e20-a4be-f0434fcb6ad4)


![1](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/7f6d7bb8-4f43-43dc-8cc3-28dd72079027)


![3](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/dd79749a-7ff2-494b-b5bc-4f5f61d51703)


![4](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/7dbcafd9-8c69-4b48-9484-f86399daf9f3)


![5](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/745f0249-2656-4692-84cc-5f94e2259aec)


![6](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/4b0ad2eb-6fac-4cb4-a775-27ae73e4664a)


![7](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/6f9fa58f-be4b-41b8-b5ed-ef59ee05ff46)


![8](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/6f6352b9-8178-4d88-ada9-f9ae25e907ca)


![9](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/2704344d-ff42-4c43-8b97-bbbe775cc628)


![10](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/acef4d00-4cd8-4706-a02a-1436f3170083)


![11](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/9d6fc14e-2442-4dcb-b6d7-047339383e29)


![12](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/4b1051de-c15a-4338-a685-59b9f8364976)


![13](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/e1231429-c020-4da1-99d7-6a1d6be3a134)


![14](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/e44778c3-3002-49f6-b38c-ef364b304741)


![15](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/1099a1d1-0950-41f7-9fc7-18b1fb8ae3fe)


![16](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/ea2fc661-247f-4eb7-b569-0aa326697b75)


![17](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/fdd858e1-3af7-4b0a-9bc3-d5aaa885b353)


![18](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/5d9a7593-948a-4fec-9aae-ac9f6ff581b3)


![19](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/d05aa707-3d3a-426e-96b8-4070153b9860)


![20](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/016155f5-d187-44cf-bdb0-07c1beae7c96)


![21](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/5c96e9ea-61c4-44dd-8037-b562ca0dce59)


![22](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/1331d304-6d86-4cec-84de-da5dfa5233fe)


![23](https://github.com/GabrielaPrietoH/AE3.JPA/assets/124418682/04253c26-9720-4719-afee-7978befe994b)


## Conclusión 

En conclusión, la actividad proporcionó a cada miembro del grupo la oportunidad de aplicar y consolidar sus conocimientos en el desarrollo de aplicaciones Java utilizando JPA y JAXB. El diseño e implementación de modelos de datos complejos, la configuración de relaciones bidireccionales y la realización de consultas a través de EntityManager ofrecieron un sólido ejercicio práctico. 
La colaboración durante la integración de los modelos individuales permitió identificar y abordar desafíos en las relaciones, promoviendo el aprendizaje conjunto y la resolución efectiva de problemas. Aunque surgen dificultades técnicas para algunos integrantes, la toma de decisiones en equipo, como la elección de presentar el trabajo de Cristian, demuestra una gestión eficiente de recursos y una orientación hacia la entrega de resultados de calidad.La actividad también destacó la importancia de la documentación clara y detallada, tanto en el código como en las consultas realizadas, facilitando la comprensión y revisión del trabajo por parte de los demás miembros del grupo. 
En resumen, la actividad fortaleció la comprensión y aplicación de conceptos clave en el desarrollo de aplicaciones Java empresariales y fomentó la colaboración efectiva en la resolución de desafíos técnicos. 

