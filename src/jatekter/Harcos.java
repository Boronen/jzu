package jatekter;

import java.util.Objects;

/**
 * Harcos osztaly - kozeli (melee) tamado karakter.
 */
public class Harcos extends Karakter {

    // --- Adatmezo (Harcos-specifikus) ---
    private String fegyver; // pl. "kard", "balta"

    // --- Konstruktor ---
    public Harcos(String nev, int hp, int dmg, int speed, String fegyver) {
        super(nev, hp, dmg, speed);
        this.fegyver = fegyver;
    }

    // --- Getter es Setter ---
    public String getFegyver() {
        return fegyver;
    }

    public void setFegyver(String fegyver) {
        this.fegyver = fegyver;
    }

    // --- Tamadas implementalasa (melee) ---
    @Override
    public void tamad(Karakter cel) {
        System.out.println(getNev() + " (Harcos) kozeli tamadast indit " + cel.getNev()
                + " ellen " + fegyver + "-vel! Sebzes: " + getDmg());
        cel.setHp(cel.getHp() - getDmg());
        System.out.println(cel.getNev() + " HP-je: " + cel.getHp());
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Harcos [nev=" + getNev()
                + ", hp=" + getHp()
                + ", dmg=" + getDmg()
                + ", speed=" + getSpeed()
                + ", fegyver=" + fegyver + "]";
    }

    // --- equals ---
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Harcos h = (Harcos) o;
        return Objects.equals(fegyver, h.fegyver);
    }

    // --- hashCode ---
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fegyver);
    }
}
