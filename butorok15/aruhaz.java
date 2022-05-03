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

    private String knev, fnev;
    private static ArrayList<Karpitozottbutorok> kbutor = new ArrayList<>();
    private static ArrayList<Fabutorok> fbutor = new ArrayList<>();

    public aruhaz(String knev, String fnev, String kf, String ff) {
        this.knev = knev;
        this.fnev = fnev;
        Karpbfajlbol_be(ff);
        Fabfajlbol_be(kf);
    }

    public String Getknev() {
        return knev;
    }

    public String Getfnev() {
        return fnev;
    }

    public static void ujKarpitozottbutor(Karpitozottbutorok kb, String kf) {
        kbutor.add(kb);
        mentesKarpb(kf);
    }

    public static void ujFabutor(Fabutorok fb, String ff) {
        fbutor.add(fb);
        mentesFab(ff);
    }

    public ArrayList<Karpitozottbutorok> getKarpitozottbutorok_ertekszerint() {
        Collections.sort(kbutor,
                (Karpitozottbutorok elso, Karpitozottbutorok masodik)
                -> elso.Getertek() < masodik.Getertek() ? -1 : (elso.Getertek() > masodik.Getertek()) ? 1 : 0);
        return kbutor;
    }

    public ArrayList<Fabutorok> getFabutorok_ertekszerint() {
        Collections.sort(fbutor,
                (Fabutorok elso, Fabutorok masodik)
                -> elso.Getertek() < masodik.Getertek() ? -1 : (elso.Getertek() > masodik.Getertek()) ? 1 : 0);
        return fbutor;
    }

    static boolean vanementettKarpbfajl(String kf) {
        if (kf == null || kf.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean vanementettFabfajl(String ff) {
       if (ff == null || ff.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    //bútorok fajta szerint külön .bin fájlban vannak.
    public static void mentesKarpb(String kf) {
        try (FileOutputStream fileos = new FileOutputStream(kf)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fileos)) {
                oos.writeObject(kbutor);
                oos.flush();
                oos.close();
            }
            fileos.flush();
            fileos.close();
            System.out.println("Sikeres mentés -> " + kf);

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.toString());
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }

    public static void mentesFab(String ff) {
        try (FileOutputStream fileos = new FileOutputStream(ff)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fileos)) {
                oos.writeObject(fbutor);
                oos.flush();
                oos.close();
            }
            fileos.flush();
            fileos.close();
            System.out.println("Sikeres mentés -> " + ff);

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.toString());
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
    }

    public static void Karpbfajlbol_be(String kf) {
        if (vanementettKarpbfajl(kf)) {
            try {
                FileInputStream fis = new FileInputStream(kf);
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
            try {
                FileInputStream fis = new FileInputStream(ff);
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
