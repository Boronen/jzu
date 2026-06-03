package Program;

import Osztalyok.Harcos;
import Osztalyok.Jatekter;
import Osztalyok.Varazslo;

public class Main {

    public static void main(String[] args) {

        // Karakterek letrehozasa
        Harcos h1 = new Harcos("Aragorn", 100, 25, 8, "kard");
        Harcos h2 = new Harcos("Gimli",   90,  30, 5, "balta");
        Varazslo v1 = new Varazslo("Gandalf", 80, 35, 6, 100, 10);
        Varazslo v2 = new Varazslo("Saruman", 75, 40, 5,  80, 12);

        // Karakterek kiirasa
        System.out.println("=== KARAKTEREK ===");
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(v1);
        System.out.println(v2);

        // Jatekter letrehozasa: 3 kor, 2 helyszin
        Jatekter jt = new Jatekter("Kozepfold Arena", 3, 2);
        System.out.println("\n=== JATEKTER ===");
        System.out.println(jt);

        // Karakterek helyszineken
        // 0: Aragorn vs Gimli
        jt.karakterElhelyez(0, h1, h2);
        // 1: Gandalf vs Saruman
        jt.karakterElhelyez(1, v1, v2);

        System.out.println();
        jt.arenaAllapot();

        // Jatek inditasa 
        System.out.println();
        jt.jatekIndit();
}
}
