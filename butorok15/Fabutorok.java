package butorok15;
import static butorok15.main.ffajlneve;
import java.io.Serializable;

public class Fabutorok implements Serializable, FaInterface {

    private String neve;
    private double ertek=50000, suly;

    public Fabutorok(String neve, double suly) {
        this.neve = neve;
        this.suly = suly;
        this.ertek = ertek;
    }
    public Fabutorok(String neve, double ertek, double suly) {
        this.neve = neve;
        this.ertek = ertek;
        this.suly = suly;
    }

    public void felujit() {
        this.ertek = (ertek * 0.85);
        aruhaz.mentesFab(ffajlneve);
    }

    public String Getneve() {
        return neve;
    }

    public double Getertek() {
        return ertek;
    }

    public double Getsuly() {
        return suly;
    }

    @Override
    public String toString() {
        //return "nev=" + neve + ", ar=" + ertek + ", suly=" + suly;
        return neve+"    "+ertek+"   "+suly+"\n";
    }
}
