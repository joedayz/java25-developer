module com.joedayz.pagos.yape {
    requires com.joedayz.pagos.api;
    provides com.joedayz.pagos.api.MedioPago
        with com.joedayz.pagos.yape.FabricaYape;
}
