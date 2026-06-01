package jatekter;

import java.util.Objects;

/**
 * Helyszin osztaly - egy arenahelyet kepvisel.
 * Ket karakter allhat benne: karakter1 es karakter2.
 * Megjelenitese: karakter1_neve , karakter2_neve
 */
public class Helyszin {

    // --- Adatmezok ---
    private String nev;
    private Karakter karakter1;
    private Karakter karakter2;

    // --- Konstruktor ---
    public Helyszin(String nev) {
        this.nev = nev;
        this.karakter1 = null;
        this.karakter2 = null;
    }

    public Helyszin(String nev, Karakter karakter1, Karakter karakter2) {
        this.nev = nev;
        this.karakter1 = karakter1;
        this.karakter2 = karakter2;
    }

    // --- Getterek es Setterek ---
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Karakter getKarakter1() {
        return karakter1;
    }

    public void setKarakter1(Karakter karakter1) {
        this.karakter1 = karakter1;
    }

    public Karakter getKarakter2() {
        return karakter2;
    }

    public void setKarakter2(Karakter karakter2) {
        this.karakter2 = karakter2;
    }

    /**
     * Megmutatja a helyszin allapotat a feladat formatumaban:
     * karakter1_neve , karakter2_neve
     * Ures hely: _
     */
    public String helyszinAllapot() {
        String k1 = (karakter1 != null) ? karakter1.getNev() : "_";
        String k2 = (karakter2 != null) ? karakter2.getNev() : "_";
        return k1 + " , " + k2;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Helyszin [nev=" + nev
                + ", allapat=" + helyszinAllapot() + "]";
    }

    // --- equals ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Helyszin h = (Helyszin) o;
        return Objects.equals(nev, h.nev)
                && Objects.equals(karakter1, h.karakter1)
                && Objects.equals(karakter2, h.karakter2);
    }

    // --- hashCode ---
    @Override
    public int hashCode() {
        return Objects.hash(nev, karakter1, karakter2);
    }
}
