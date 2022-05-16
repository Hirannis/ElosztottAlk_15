package butorok15;
import static butorok15.main.kfajlneve;
import java.io.Serializable;


public class Karpitozottbutorok implements Serializable, KarpitozottInterface {

    private String neve;
    private double ertek;
    private String anyag;
    private int felujitdb=0;

    public Karpitozottbutorok(String neve, String anyag) {
        super();
        this.ertek = 50000;
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
        aruhaz.mentesKarpb(kfajlneve);
    }

    public void felujitanyagis( String anyag) {
        if(anyag!=this.anyag){
        this.ertek = (ertek * 0.85);
        this.anyag = anyag;
        aruhaz.mentesKarpb(kfajlneve);
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
       // return "nev=" + neve + ", ar=" + ertek + ", anyaga=" + anyag+"\n" ;
       return neve+"    "+ertek+"   "+anyag+"\n";
    }
}
