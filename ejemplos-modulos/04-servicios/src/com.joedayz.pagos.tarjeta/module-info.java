/// Proveedor: implementa el servicio. No exporta nada.
module com.joedayz.pagos.tarjeta {
    requires com.joedayz.pagos.api;
    provides com.joedayz.pagos.api.MedioPago
        with com.joedayz.pagos.tarjeta.PagoTarjeta;
}
