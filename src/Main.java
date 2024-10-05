abstract class Pedido {
    public final void procesarPedido() {
        verificarInventario();
        procesarPago();
        prepararPaquete();
        enviar();
    }

    private void verificarInventario() {
        System.out.println("Verificando inventario...");
    }

    private void prepararPaquete() {
        System.out.println("Preparando el paquete...");
    }

    protected abstract void procesarPago();
    protected abstract void enviar();
}

class PedidoEstandar extends Pedido {
    @Override
    protected void procesarPago() {
        System.out.println("Procesando pago estándar...");
    }

    @Override
    protected void enviar() {
        System.out.println("Enviando con servicio postal estándar...");
    }
}

class PedidoExpress extends Pedido {
    @Override
    protected void procesarPago() {
        System.out.println("Procesando pago prioritario...");
    }

    @Override
    protected void enviar() {
        System.out.println("Enviando con servicio de entrega urgente...");
    }
}

class PedidoInternacional extends Pedido {
    @Override
    protected void procesarPago() {
        System.out.println("Procesando pago internacional con tasas aduaneras...");
    }

    @Override
    protected void enviar() {
        System.out.println("Enviando con servicio internacional...");
    }
}

class PedidoConRegalo extends Pedido {
    @Override
    protected void procesarPago() {
        System.out.println("Procesando pago de pedido con envoltorio de regalo...");
    }

    @Override
    protected void enviar() {
        System.out.println("Enviando con envoltorio de regalo especial...");
    }
}

class GestorPedidos {
    public void gestionarPedido(Pedido pedido) {
        pedido.procesarPedido();
    }
}

public class Main {
    public static void main(String[] args) {
        Pedido pedidoEstandar = new PedidoEstandar();
        Pedido pedidoExpress = new PedidoExpress();
        Pedido pedidoInternacional = new PedidoInternacional();
        Pedido pedidoConRegalo = new PedidoConRegalo();

        GestorPedidos gestor = new GestorPedidos();

        System.out.println("Procesando Pedido Estándar:");
        gestor.gestionarPedido(pedidoEstandar);

        System.out.println("\nProcesando Pedido Express:");
        gestor.gestionarPedido(pedidoExpress);

        System.out.println("\nProcesando Pedido Internacional:");
        gestor.gestionarPedido(pedidoInternacional);

        System.out.println("\nProcesando Pedido con Regalo:");
        gestor.gestionarPedido(pedidoConRegalo);
    }
}
