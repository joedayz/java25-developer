// No compila: java.base exporta java.util.Date y java.sql exporta java.sql.Date
import module java.base;
import module java.sql;

void main() {
    Date d = new Date();
    IO.println(d);
}
