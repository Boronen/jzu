package Osztalyok;

import java.util.Objects;
public class Jatekter {

    private String nev;
    private int korokSzama;
    private int aktKor;     
    private Helyszin[] helyszinek;

    public Jatekter(String nev, int korokSzama, int helyszinekSzama) {
        this.nev = nev;
        this.korokSzama = korokSzama;
        this.aktKor = 1;
        this.helyszinek = new Helyszin[helyszinekSzama];
        for (int i = 0; i < helyszinekSzama; i++) {
            helyszinek[i] = new Helyszin("Helyszin-" + (i + 1));
        }
    }

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


    public Helyszin getHelyszin(int index) {
        if (index < 0 || index >= helyszinek.length) {
            throw new ArrayIndexOutOfBoundsException("Ervenytelen helyszin index: " + index);
        }
        return helyszinek[index];
    }

    /**
     * @param helyszinIndex
     * @param k1
     * @param k2
     */
    public void karakterElhelyez(int helyszinIndex, Karakter k1, Karakter k2) {
        Helyszin h = getHelyszin(helyszinIndex);
        h.setKarakter1(k1);
        h.setKarakter2(k2);
        System.out.println("Elhelyezve: " + h.helyszinAllapot() + " -> " + h.getNev());
    }


    public void korLejaszik() {
        if (aktKor > korokSzama) {
            System.out.println("A jatek veget ert! Osszes kor lejatszva.");
            return;
        }

        System.out.println("\n========== " + nev + " - " + aktKor + ". KOR ==========");

        for (Helyszin h : helyszinek) {
            Karakter k1 = h.getKarakter1();
            Karakter k2 = h.getKarakter2();

            System.out.println("\n[" + h.getNev() + "] Allap: " + h.helyszinAllapot());

            if (k1 == null || k2 == null) {
                System.out.println("  -> Ures helyszin, nincs harc.");
                continue;
            }

            if (k1.elEMeg()) {
                k1.tamad(k2);
            }

            if (k2.elEMeg()) {
                k2.tamad(k1);
            } else {
                System.out.println(k2.getNev() + " legyozetek!");
            }

            if (!k1.elEMeg()) {
                System.out.println(k1.getNev() + " legyozetek!");
            }
        }

        aktKor++;
    }

    public void jatekIndit() {
        System.out.println("*** " + nev + " JATEK INDUL! Osszes kor: " + korokSzama + " ***");
        while (aktKor <= korokSzama) {
            korLejaszik();
        }
        System.out.println("\n*** JATEK VEGE ***");
        arenaAllapot();
    }


    public void arenaAllapot() {
        System.out.println("\n--- ARENA ALLAPAT [" + nev + "] ---");
        for (Helyszin h : helyszinek) {
            System.out.println(h.getNev() + ": " + h.helyszinAllapot());
        }
    }

    @Override
    public String toString() {
        return "Jatekter [nev=" + nev
                + ", korokSzama=" + korokSzama
                + ", aktKor=" + aktKor
                + ", helyszinekSzama=" + helyszinek.length + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jatekter j = (Jatekter) o;
        return korokSzama == j.korokSzama
                && aktKor == j.aktKor
                && Objects.equals(nev, j.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, korokSzama, aktKor);
    }
}
