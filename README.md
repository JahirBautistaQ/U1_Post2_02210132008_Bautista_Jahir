# U1_Post2_02210132008_Bautista_Jahir

Actividad de PostContenido 2 - Unidad 1

Este proyecto consiste en un sistema de e-commerce básico desarrollado en Java. El programa permite crear productos, aplicar descuentos y gestionar pedidos, además de enviar notificaciones cuando el estado de un pedido cambia. Para lograr un diseño más ordenado y fácil de mantener, se implementaron tres patrones de diseño: Observer, Factory Method y Strategy.

Patrón Observer — Notificaciones de pedidos

El patrón Observer se usa para avisar automáticamente a varios componentes cuando ocurre un cambio en el sistema. En este caso, cuando el estado de un pedido cambia (por ejemplo, de CREATED a SHIPPED), todos los observadores suscritos reciben una notificación.

Se implementaron tres tipos de notificación:

- EmailNotifier → simula el envío de correo
- SMSNotifier → simula un mensaje de texto
- LogNotifier → muestra el cambio en consola con fecha y hora

La ventaja de este patrón es que el sistema no necesita saber cómo funciona cada tipo de notificación. Solo avisa que ocurrió un cambio y cada observador decide qué hacer. Esto permite agregar nuevos tipos de notificación sin modificar el código principal.

Patrón Factory Method — Creación de productos

El Factory Method se utilizó para crear los productos sin instanciarlos directamente con new en el código principal. El sistema maneja tres tipos de productos:

- Electronics
- Clothing
- Food

Todos heredan de una clase base llamada Product, pero cada uno tiene su propia forma de calcular envío y mostrar descripción.
La fábrica (ProductFactory) recibe el tipo de producto y devuelve el objeto correspondiente.
Esto evita que el programa dependa de clases concretas y facilita agregar nuevos productos en el futuro.

Patrón Strategy — Cálculo de descuentos

El patrón Strategy permite aplicar distintos tipos de descuento sin cambiar el código del sistema. Se implementaron varias estrategias de precio:

- RegularPricing → precio normal
- MemberPricing → 10% de descuento
- BlackFridayPricing → 30% de descuento
- BulkPricing → descuento por cantidad

Cada estrategia tiene su propia fórmula. El sistema solo usa la estrategia seleccionada en ese momento. Esto es útil porque las reglas de negocio pueden cambiar frecuentemente, por ejemplo en promociones o temporadas especiales.

Integración del sistema

El servicio principal del pedido combina los tres patrones:

- Usa Factory para crear productos
- Usa Strategy para calcular el precio final
- Usa Observer para enviar notificaciones cuando cambia el estado

De esta forma, cada parte del sistema cumple una función específica y no se mezclan responsabilidades.

Conclusión

El uso de estos patrones permite que el sistema sea más organizado, flexible y fácil de ampliar. Si en el futuro se necesitan nuevos productos, descuentos o formas de notificación, se pueden agregar sin modificar la lógica principal.

Además, el código queda más claro y cada clase tiene una responsabilidad definida.




