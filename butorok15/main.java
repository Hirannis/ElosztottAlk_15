package butorok15;
import java.util.ArrayList;
/*Egy bútor lehet kárpitozott vagy tömör fa. 
Mindegyiket fel lehet újítani, ilyenkor az értékük csökken 15% -kal.
A bútor értékét, ha nem adjuk meg, akkor alapértelmezetten 50 000. 
A fa bútoroknak van súlya, a kárpitozottnak anyaga (pl.: szövet, bőr, stb.). 
Ezeket a jellemzőket meg kell adni, a kárpit bevonata változhat később. 
A bútorokat egy áruház tárolja. Egy bútor legyen másolható.
Az áruház tudja listázni a bútorait érték szerinti rendezésben.
Az áruház tudja exportálni a raktárkészletét egy bináris állományba.
Amikor „létrejön” egy áruház, akkor aktualizálja magát, ha van létező bináris állomány.*/
public class main {

    static String kn = "Karpitozott", fn = "Fa";
    static String kf = "Karpitozott.bin", ff = "Fa.bin";

    public static void main(String[] args) {

        aruhaz butorok = new aruhaz(kn, fn, kf, ff);
//Új 
        aruhaz.ujKarpitozottbutor(new Karpitozottbutorok("kanape", 80000, "Barsony"), kf);
        aruhaz.ujKarpitozottbutor(new Karpitozottbutorok("fotel", 35000, "Barsony"), kf);
        aruhaz.ujFabutor(new Fabutorok("etkezoasztal", 100000, 36), ff);
        aruhaz.ujFabutor(new Fabutorok("szekreny", 50), ff);
        
//Listázás
        ArrayList<Karpitozottbutorok> kbutorok = butorok.getKarpitozottbutorok_ertekszerint();
        ArrayList<Fabutorok> fbutorok = butorok.getFabutorok_ertekszerint();
        System.out.println("Kárpitozott bútorok:");
        for (int i = 0; i < kbutorok.size(); i++) {
            System.out.println(kbutorok.get(i).toString());
        }
        System.out.println("Fa bútorok:");
        for (int i = 0; i < fbutorok.size(); i++) {
            System.out.println(fbutorok.get(i).toString());
        }
        //fbutorok.get(1).felujit();
        // kbutorok.get(0).felujit();
        kbutorok.get(0).felujitanyagis("Vaszon");
    }

}
