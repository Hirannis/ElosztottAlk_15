package butorok15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class aruhaz implements Serializable, aruhazInterface {

    public static ArrayList<Karpitozottbutorok> kbutor = new ArrayList<>();
    public static ArrayList<Fabutorok> fbutor = new ArrayList<>();
    private String knev, fnev;

    public aruhaz(String knev,String fnev) {
        this.knev = knev;
        this.fnev = fnev;
        Karpbfajlbol_be(knev);
        Karpbfajlbol_be(fnev);
    }
    public String getknev(){
        return knev;
    }
    public String getfnev(){
        return fnev;
    }
    public static void ujKarpitozottbutor(Karpitozottbutorok kb) {
        kbutor.add(kb);
        
    }

    public static void ujFabutor(Fabutorok fb) {
        fbutor.add(fb);
    }
//érték szerinti rendezések.
    public static ArrayList<Karpitozottbutorok> getKarpitozottbutorok_ertekszerint() {
        Collections.sort(kbutor,(Karpitozottbutorok elso, Karpitozottbutorok masodik)-> elso.Getertek() < masodik.Getertek() ? -1 : (elso.Getertek() > masodik.Getertek()) ? 1 : 0);
        return kbutor;
    }
    public static ArrayList<Fabutorok> getFabutorok_ertekszerint() {
        Collections.sort(fbutor,(Fabutorok elso, Fabutorok masodik)-> elso.Getertek() < masodik.Getertek() ? -1 : (elso.Getertek() > masodik.Getertek()) ? 1 : 0);
        return fbutor;
    }
//Van már metett fájlunk?
    static boolean vanementettKarpbfajl(String kf) {
        if (kf == null || kf.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    static boolean vanementettFabfajl(String ff) {
       if (ff == null || ff.trim().isEmpty()) {
            return false;
        }
        return true;
    }

//bútorok fajta szerint külön .bin fájlban vannak.
    public static void mentesKarpb(String kf) {
        try(FileOutputStream fileos = new FileOutputStream(kf)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fileos)) {
                oos.writeObject(kbutor);
                oos.flush();
            }
            fileos.flush();
            fileos.close();
            System.out.println("Sikeres mentés -> " + kf);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }

    public static void mentesFab(String ff) {
        try(FileOutputStream fileos = new FileOutputStream(ff)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fileos)) {
                oos.writeObject(fbutor);
                oos.flush();
            }
            fileos.flush();
            fileos.close();
            System.out.println("Sikeres mentés -> " + ff);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }

    public static void Karpbfajlbol_be(String kf) {
        if (vanementettKarpbfajl(kf)) {
            try (FileInputStream fis = new FileInputStream(kf)){
                try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                    try {

                        kbutor = (ArrayList<Karpitozottbutorok>) ois.readObject();
                        ois.close();
                        fis.close();
                        System.out.println("Sikeres betöltés -> " + kf);

                    } catch (ClassNotFoundException c) {
                        System.out.println(c.toString());
                    }
                } catch (FileNotFoundException fnf) {
                    System.out.println(fnf.toString());
                }
            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            }
        }

    }

    public static void Fabfajlbol_be(String ff) {
        if (vanementettFabfajl(ff)) {
            try (FileInputStream fis = new FileInputStream(ff)){
                try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                    try {

                        fbutor = (ArrayList<Fabutorok>) ois.readObject();
                        ois.close();
                        fis.close();
                        System.out.println("Sikeres betöltés -> " + ff);

                    } catch (ClassNotFoundException c) {
                        System.out.println(c.toString());
                    }
                } catch (FileNotFoundException fnf) {
                    System.out.println(fnf.toString());
                }
            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            }
        }

    }

}

