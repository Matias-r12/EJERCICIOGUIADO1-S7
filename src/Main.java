public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIO DE PRUEBAS DEL CARRITO ===");

        // 1. Carrito vacío
        Carrito carrito = new Carrito();
        System.out.println("\n[Prueba 1] Carrito recién creado:");
        System.out.println("Cantidad de items: " + carrito.obtenerCantidadItems());
        System.out.println(carrito.mostrarResumen());

        // Creación de productos independientes
        Producto p1 = new Producto("P01", "Mouse", 25.50);
        Producto p2 = new Producto("P02", "Teclado", 40.00);
        Producto p3 = new Producto("P03", "Monitor", 200.00);

        // 2 y 3. Agregar productos y cantidad 2 para uno de ellos
        carrito.agregarProducto(p1, 2); // Subtotal: 51.0
        carrito.agregarProducto(p2, 1); // Subtotal: 40.0

        System.out.println("\n[Prueba 2 & 3] Después de agregar productos normales:");
        System.out.println(carrito.mostrarResumen());

        // 4. Calcular total
        System.out.println("\n[Prueba 4] Total general calculado: $" + carrito.calcularTotal());

        // Prueba del Desafío: Intentar agregar cantidades <= 0
        System.out.println("\n[Prueba Desafío A] Intentando agregar cantidades inválidas (0 y negativas):");
        carrito.agregarProducto(p3, 0);
        carrito.agregarProducto(p3, -2);

        // Agregar un producto con mayor subtotal para probar la búsqueda
        carrito.agregarProducto(p3, 1); // Subtotal: 200.0 (Este será el mayor)
        System.out.println(carrito.mostrarResumen());

        // Prueba del Desafío: Obtener el ítem con mayor subtotal
        System.out.println("\n[Prueba Desafío B] Ítem con mayor subtotal:");
        ItemCarrito mayor = carrito.obtenerItemMayorSubtotal();
        if (mayor != null) {
            System.out.println(mayor.mostrarInformacion());
        }

        // 5. Eliminar posición válida (0)
        System.out.println("\n[Prueba 5] Eliminando posición válida (0):");
        carrito.eliminarItem(0);
        System.out.println(carrito.mostrarResumen());

        // 6. Intentar eliminar posición inválida (5)
        System.out.println("\n[Prueba 6] Intentando eliminar posición inválida (5):");
        boolean resultadoEliminacion = carrito.eliminarItem(5);
        System.out.println("¿Se eliminó en posición 5?: " + resultadoEliminacion);

        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }
}