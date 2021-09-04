# PruebaEndCom

Ing. Jesús Ramón Chavez Quiroz
jesus.r.chavez.q.94@gmail.com
7442077733

Para trabajar solo requiere configurar la base de datos con el siguiente parámetro y debería de funcionar.

spring.mvc.view.prefix=WEB-INF/vistas/
spring.mvc.view.suffix=.jsp

spring.datasource.url=jdbc:h2:mem:testdb
#spring.datasource.driverClassName=org.h2.Driver
#spring.datasource.username=sa
spring.h2.console.enabled=true
spring.h2.console.path=/h2
