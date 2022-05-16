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

    static String kfajlneve = "Karpitozott.bin", ffajlneve = "Fa.bin";

    public static void main(String[] args) {

        aruhaz Aruhaz = new aruhaz( kfajlneve, ffajlneve);
//Új elem hozzáadása
        aruhaz.ujKarpitozottbutor(new Karpitozottbutorok("kanape", 80000, "Barsony"));
        aruhaz.ujKarpitozottbutor(new Karpitozottbutorok("kanape", 90000, "Vaszon"));
        aruhaz.ujKarpitozottbutor(new Karpitozottbutorok("szék", 70000, "Barsony"));
        aruhaz.ujKarpitozottbutor(new Karpitozottbutorok("fotel", 35000, "Barsony"));
        aruhaz.ujFabutor(new Fabutorok("etkezoasztal", 100000, 36));
        aruhaz.ujFabutor(new Fabutorok("szekreny", 50));
        aruhaz.mentesKarpb(kfajlneve);
        aruhaz.mentesFab(ffajlneve);
        
//Listázás
      //  readFromFile(kfajlneve);
     //   readFromFile(ffajlneve);
        ArrayList<Karpitozottbutorok> kbutorok = aruhaz.getKarpitozottbutorok_ertekszerint();
        ArrayList<Fabutorok> fbutorok = aruhaz.getFabutorok_ertekszerint();
        System.out.println("        -Kárpitozott bútorok-\n");
        for (int i = 0; i < kbutorok.size(); i++) {
            System.out.println(kbutorok.get(i).toString());
        }
        System.out.println("        -Fa bútorok-\n");
        for (int i = 0; i < fbutorok.size(); i++) {
            System.out.println(fbutorok.get(i).toString());
        }
//Felújítás +utána érték csökkenés
        fbutorok.get(1).felujit();
        fbutorok.get(0).felujit();
        kbutorok.get(0).felujitanyagis("Vaszon");
        System.out.println(fbutorok.get(1)+"\n"+fbutorok.get(0)+"\n"+kbutorok.get(0));
    }
}

