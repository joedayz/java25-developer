package pe.joedayz.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    static void main() {
        List<String> list = new ArrayList<>();

        Comparator<String> sortText = (s1, s2) -> s1.compareTo(s2);

        list.removeIf((final String s) -> s.equals("remove me"));

        list.removeIf((final var s) -> s.equals("remove me"));

        list.removeIf(s -> s.equals("remove me"));

        list.sort((s1, s2) -> {
            return s1.compareTo(s2);
        });

        Collections.sort(list, sortText);
    }
}
