package jatekter;

/**
 * Fo osztaly - a jatek bemutatasa.
 */
public class Main {

    public static void main(String[] args) {

        // --- Karakterek letrehozasa ---
        Harcos h1 = new Harcos("Aragorn", 100, 25, 8, "kard");
        Harcos h2 = new Harcos("Gimli",   90,  30, 5, "balta");
        Varazslo v1 = new Varazslo("Gandalf", 80, 35, 6, 100, 10);
        Varazslo v2 = new Varazslo("Saruman", 75, 40, 5,  80, 12);

        // --- Karakterek kiirasa ---
        System.out.println("=== KARAKTEREK ===");
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(v1);
        System.out.println(v2);

        // --- equals / hashCode demo ---
        System.out.println("\n=== EQUALS / HASHCODE ===");
        Harcos hCopy = new Harcos("Aragorn", 100, 25, 8, "kard");
        System.out.println("h1.equals(hCopy): " + h1.equals(hCopy));   // true
        System.out.println("h1.equals(h2):    " + h1.equals(h2));      // false
        System.out.println("h1 hashCode: " + h1.hashCode());
        System.out.println("hCopy hashCode: " + hCopy.hashCode());

        // --- Jatekter letrehozasa: 3 kor, 2 helyszin ---
        Jatekter jt = new Jatekter("Kozepfold Arena", 3, 2);
        System.out.println("\n=== JATEKTER ===");
        System.out.println(jt);

        // --- Karakterek elhelyezese a helyszineken ---
        // Helyszin 0: Aragorn vs Gimli
        jt.karakterElhelyez(0, h1, h2);
        // Helyszin 1: Gandalf vs Saruman
        jt.karakterElhelyez(1, v1, v2);

        System.out.println();
        jt.arenaAllapot();

        // --- Jatek inditasa ---
        System.out.println();
        jt.jatekIndit();

        // --- Jatekter equals demo ---
        System.out.println("\n=== JATEKTER EQUALS ===");
        Jatekter jt2 = new Jatekter("Kozepfold Arena", 3, 2);
        System.out.println("jt.equals(jt2): " + jt.equals(jt2)); // false (aktKor kulonbozik)
    }
}
