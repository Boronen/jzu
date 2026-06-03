package jatekter;

import java.util.Objects;
public class Harcos extends Karakter {

    private String fegyver;

    public Harcos(String nev, int hp, int dmg, int speed, String fegyver) {
        super(nev, hp, dmg, speed);
        this.fegyver = fegyver;
    }

    public String getFegyver() {
        return fegyver;
    }

    public void setFegyver(String fegyver) {
        this.fegyver = fegyver;
    }
    @Override
    public void tamad(Karakter cel) {
        System.out.println(getNev() + " (Harcos) kozeli tamadast indit " + cel.getNev()
                + " ellen " + fegyver + "-vel! Sebzes: " + getDmg());
        cel.setHp(cel.getHp() - getDmg());
        System.out.println(cel.getNev() + " HP-je: " + cel.getHp());
    }

    @Override
    public String toString() {
        return "Harcos [nev=" + getNev()
                + ", hp=" + getHp()
                + ", dmg=" + getDmg()
                + ", speed=" + getSpeed()
                + ", fegyver=" + fegyver + "]";
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Harcos h = (Harcos) o;
        return Objects.equals(fegyver, h.fegyver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fegyver);
    }
}
