package jatekter;

import java.util.Objects;

/**
 * Absztrakt alap osztaly a karakterekhez.
 */
public abstract class Karakter {

    // --- Adatmezok ---
    private String nev;
    private int hp;
    private int dmg;
    private int speed;

    // --- Konstruktor ---
    public Karakter(String nev, int hp, int dmg, int speed) {
        this.nev = nev;
        this.hp = hp;
        this.dmg = dmg;
        this.speed = speed;
    }

    // --- Getterek es Setterek ---
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // --- Absztrakt metodus ---
    /**
     * A karakter tamadasa a masik karakterre.
     * @param cel A celpont karakter.
     */
    public abstract void tamad(Karakter cel);

    /**
     * Ellenorzi, hogy a karakter el-e meg.
     * @return true, ha hp > 0
     */
    public boolean elEMeg() {
        return this.hp > 0;
    }

    // --- toString ---
    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " [nev=" + nev
                + ", hp=" + hp
                + ", dmg=" + dmg
                + ", speed=" + speed + "]";
    }

    // --- equals ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karakter k = (Karakter) o;
        return hp == k.hp
                && dmg == k.dmg
                && speed == k.speed
                && Objects.equals(nev, k.nev);
    }

    // --- hashCode ---
    @Override
    public int hashCode() {
        return Objects.hash(nev, hp, dmg, speed);
    }
}
