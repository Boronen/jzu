package jatekter;

import java.util.Objects;

/**
 * Jatekter osztaly - az arena vezerloje.
 * Tartalmaz helyszineket (tombot) es koroket.
 */
public class Jatekter {

    // --- Adatmezok ---
    private String nev;
    private int korokSzama;        // osszes kor szama
    private int aktKor;            // jelenlegi kor
    private Helyszin[] helyszinek; // helyszinek tombje

    // --- Konstruktor ---
    public Jatekter(String nev, int korokSzama, int helyszinekSzama) {
        this.nev = nev;
        this.korokSzama = korokSzama;
        this.aktKor = 1;
        this.helyszinek = new Helyszin[helyszinekSzama];
        // Inicializalunk ures helyszineket
        for (int i = 0; i < helyszinekSzama; i++) {
            helyszinek[i] = new Helyszin("Helyszin-" + (i + 1));
        }
    }

    // --- Getterek es Setterek ---
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getKorokSzama() {
        return korokSzama;
    }

    public void setKorokSzama(int korokSzama) {
        this.korokSzama = korokSzama;
    }

    public int getAktKor() {
        return aktKor;
    }

    public void setAktKor(int aktKor) {
        this.aktKor = aktKor;
    }

    public Helyszin[] getHelyszinek() {
        return helyszinek;
    }

    public void setHelyszinek(Helyszin[] helyszinek) {
        this.helyszinek = helyszinek;
    }

    /**
     * Egy adott helyszint visszaad index alapjan.
     */
    public Helyszin getHelyszin(int index) {
        if (index < 0 || index >= helyszinek.length) {
            throw new ArrayIndexOutOfBoundsException("Ervenytelen helyszin index: " + index);
        }
        return helyszinek[index];
    }

    /**
     * Karaktereket elhelyez egy adott helyszinen.
     */
    public void karakterElhelyez(int helyszinIndex, Karakter k1, Karakter k2) {
        Helyszin h = getHelyszin(helyszinIndex);
        h.setKarakter1(k1);
        h.setKarakter2(k2);
        System.out.println("Elhelyezve: " + h.helyszinAllapot() + " -> " + h.getNev());
    }

    /**
     * Egy kor lejatszasa: minden helyszinen az 1. karakter tamadja a 2.-at,
     * majd a 2. visszatamad (ha meg el).
     * A kor utan noveljuk az aktKor-t.
     */
    public void korLejaszik() {
        if (aktKor > korokSzama) {
            System.out.println("A jatek veget ert! Osszes kor lejatszva.");
            return;
        }

        System.out.println("\n========== " + nev + " - " + aktKor + ". KOR ==========");

        for (int i = 0; i < helyszinek.length; i++) {
            Helyszin h = helyszinek[i];
            Karakter k1 = h.getKarakter1();
            Karakter k2 = h.getKarakter2();

            System.out.println("\n[" + h.getNev() + "] Allap: " + h.helyszinAllapot());

            if (k1 == null || k2 == null) {
                System.out.println("  -> Ures helyszin, nincs harc.");
                continue;
            }

            // k1 tamad
            if (k1.elEMeg()) {
                k1.tamad(k2);
            }

            // k2 visszatamad, ha meg el
            if (k2.elEMeg()) {
                k2.tamad(k1);
            } else {
                System.out.println(k2.getNev() + " legyozetek!");
            }

            // Ellenorizzuk k1-et is
            if (!k1.elEMeg()) {
                System.out.println(k1.getNev() + " legyozetek!");
            }
        }

        aktKor++;
    }

    /**
     * Az osszes kor lejatszasa.
     */
    public void jatekIndit() {
        System.out.println("*** " + nev + " JATEK INDUL! Osszes kor: " + korokSzama + " ***");
        while (aktKor <= korokSzama) {
            korLejaszik();
        }
        System.out.println("\n*** JATEK VEGE ***");
        arenaAllapot();
    }

    /**
     * Kiirja az arena jelenlegi allapotat.
     */
    public void arenaAllapot() {
        System.out.println("\n--- ARENA ALLAPAT [" + nev + "] ---");
        for (Helyszin h : helyszinek) {
            System.out.println(h.getNev() + ": " + h.helyszinAllapot());
        }
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Jatekter [nev=" + nev
                + ", korokSzama=" + korokSzama
                + ", aktKor=" + aktKor
                + ", helyszinekSzama=" + helyszinek.length + "]";
    }

    // --- equals ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jatekter j = (Jatekter) o;
        return korokSzama == j.korokSzama
                && aktKor == j.aktKor
                && Objects.equals(nev, j.nev);
    }

    // --- hashCode ---
    @Override
    public int hashCode() {
        return Objects.hash(nev, korokSzama, aktKor);
    }
}
