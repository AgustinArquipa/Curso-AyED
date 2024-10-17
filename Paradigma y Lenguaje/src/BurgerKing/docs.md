## Explicación:
1. Clase Pedido: Se agregaron los getters y setters para cada atributo (fechaIni, formateador, cantidad, cliente, y oferta). Esto permite acceder y modificar estos valores de forma controlada.

2. Clase Cliente:

 * Tiene una lista de pedidos (List<Pedido> pedidos) que se inicializa en el constructor.
 * El método agregarPedido(Pedido pedido) permite agregar un nuevo pedido a la lista y contabilizarlo.
 * El método cantidadPedidosRealizados() devuelve la cantidad total de pedidos realizados por el cliente,   utilizando el tamaño de la lista de pedidos (pedidos.size()).

Cada vez que se agregue un pedido a un cliente, el método agregarPedido se encargará de mantener esa lista actualizada, y cantidadPedidosRealizados podrá ser llamado para obtener el número total de pedidos realizados por dicho cliente.