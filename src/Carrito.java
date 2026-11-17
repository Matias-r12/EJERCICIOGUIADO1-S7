import java.util.ArrayList;

public class Carrito {
    private ArrayList<ItemCarrito> items;

    public Carrito() {
        items = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        // Desafío: Evita agregar cantidades menores o iguales a cero
        if (cantidad > 0) {
            ItemCarrito nuevoItem = new ItemCarrito(producto, cantidad);
            items.add(nuevoItem);
        } else {
            System.out.println("Aviso: Cantidad inválida (" + cantidad + ") para el producto '" + producto.getNombre() + "'. No se agregó.");
        }
    }

    public int obtenerCantidadItems() {
        return items.size();
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public boolean eliminarItem(int posicion) {
        if (posicion >= 0 && posicion < items.size()) {
            items.remove(posicion);
            return true;
        }
        return false;
    }

    // Desafío: Obtener el ítem de mayor subtotal
    public ItemCarrito obtenerItemMayorSubtotal() {
        if (items.isEmpty()) {
            return null;
        }

        ItemCarrito itemMayor = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            ItemCarrito actual = items.get(i);
            if (actual.calcularSubtotal() > itemMayor.calcularSubtotal()) {
                itemMayor = actual;
            }
        }
        return itemMayor;
    }

    public String mostrarResumen() {
        if (items.isEmpty()) {
            return "El carrito está vacío.";
        }

        String resumen = "=== Resumen del Carrito ===\n";
        for (int i = 0; i < items.size(); i++) {
            resumen += "Posición " + i + ": " + items.get(i).mostrarInformacion() + "\n";
        }
        resumen += "---------------------------\n" +
                "Total General: $" + calcularTotal();

        return resumen;
    }
}