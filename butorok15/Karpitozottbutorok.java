package butorok15;
import static butorok15.main.kf;
import java.io.Serializable;


public class Karpitozottbutorok implements Serializable, KarpitozottInterface {

    private String neve;
    private double ertek;
    private String anyag;
    private int felujitdb=0;

    public Karpitozottbutorok() {
        this.ertek = 50000;
    }
    public Karpitozottbutorok(String neve, String anyag) {
        super();
        this.neve = neve;
        this.anyag = anyag;
    }
    public Karpitozottbutorok(String neve, int ertek, String anyag) {
        super();
        this.neve = neve;
        this.ertek = ertek;
        this.anyag = anyag;
    }

    public void felujit() {
        this.ertek = (ertek * 0.85);
        aruhaz.mentesKarpb(kf);
    }

    public void felujitanyagis( String anyag) {
        if(this.anyag!=anyag){
        this.ertek = (ertek * 0.85);
        this.anyag = anyag;
        aruhaz.mentesKarpb(kf);
        }
    }

    public String Getneve() {
        return neve;
    }

    public double Getertek() {
        return ertek;
    }

    public String Getanyag() {
        return anyag;
    }

    @Override
    public String toString() {
        return "nev=" + neve + ", ar=" + ertek + ", anyaga=" + anyag ;
    }
}
