

void main(){
    Locale pe = Locale.of("es", "PE");
    String patron = "{0}, precio {1}, cantidad {2}, vence el {3}";

    var moneda = NumberFormat.getCurrencyInstance(pe);
    var fecha = DateTimeFormatter.ofPattern("dd MMM yyyy", pe);

    String texto = MessageFormat.format(patron,
            "Galleta",
            moneda.format(new BigDecimal("2.99")),
            4,
            LocalDate.of(2026, 7, 28).format(fecha));
    IO.println(texto);


}
