package jatekter;

import java.util.Objects;

/**
 * Varazslo osztaly - tavoli (ranged) tamado karakter.
 */
public class Varazslo extends Karakter {

    // --- Adatmezok (Varazslo-specifikus) ---
    private int mana;
    private int tavolsag; // max tamadasi tavolsag

    // --- Konstruktor ---
    public Varazslo(String nev, int hp, int dmg, int speed, int mana, int tavolsag) {
        super(nev, hp, dmg, speed);
        this.mana = mana;
        this.tavolsag = tavolsag;
    }

    // --- Getterek es Setterek ---
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(int tavolsag) {
        this.tavolsag = tavolsag;
    }

    // --- Tamadas implementalasa (ranged / varazslas) ---
    @Override
    public void tamad(Karakter cel) {
        if (mana <= 0) {
            System.out.println(getNev() + " (Varazslo) elfogyott a manaja! Nem tud tamadni.");
            return;
        }
        int manakolt = 10;
        mana -= manakolt;
        System.out.println(getNev() + " (Varazslo) tavoli varazslatot szor " + cel.getNev()
                + " fele! Sebzes: " + getDmg() + ", maradek mana: " + mana);
        cel.setHp(cel.getHp() - getDmg());
        System.out.println(cel.getNev() + " HP-je: " + cel.getHp());
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Varazslo [nev=" + getNev()
                + ", hp=" + getHp()
                + ", dmg=" + getDmg()
                + ", speed=" + getSpeed()
                + ", mana=" + mana
                + ", tavolsag=" + tavolsag + "]";
    }

    // --- equals ---
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Varazslo v = (Varazslo) o;
        return mana == v.mana && tavolsag == v.tavolsag;
    }

    // --- hashCode ---
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mana, tavolsag);
    }
}
