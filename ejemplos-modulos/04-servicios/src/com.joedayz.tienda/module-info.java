/// Consumidor: conoce la interfaz, nunca a los proveedores.
module com.joedayz.tienda {
    requires com.joedayz.pagos.api;
    uses com.joedayz.pagos.api.MedioPago;
}
