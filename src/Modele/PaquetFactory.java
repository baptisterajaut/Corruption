package Modele;

import Modele.Cartes.Abstacts.Card;
import Modele.Cartes.Corruption.*;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by bapti on 08/03/2017.
 */
public class PaquetFactory {
    public static ListeCarte testDeck(Partie p){
        ListeCarte ret=new ListeCarte();
        ret.getListe().add(new BureauDePropagande(p));
        ret.getListe().add(new BureauDePropagande(p));
        ret.getListe().add(new BureauDePropagande(p));
        ret.getListe().add(new Taxe(p));
        ret.getListe().add(new Taxe(p));
        ret.getListe().add(new Taxe(p));
        ret.getListe().add(new BoursierCorrompu(p));
        ret.getListe().add(new BoursierCorrompu(p));
        ret.getListe().add(new BoursierCorrompu(p));
        ret.getListe().add(new SecretaireDeviante(p));
        ret.getListe().add(new SecretaireDeviante(p));
        ret.getListe().add(new SecretaireDeviante(p));
        ret.getListe().add(new SaisieAdministrative(p));
        ret.getListe().add(new SaisieAdministrative(p));
        ret.getListe().add(new SaisieAdministrative(p));
        ret.getListe().add(new Assasinat(p));
        ret.getListe().add(new ChefDeGang(p));
        ret.getListe().add(new ChefDeGang(p));
        ret.getListe().add(new BanqueEtrangere(p));
        ret.getListe().add(new BanqueEtrangere(p));
        ret.getListe().add(new BanqueEtrangere(p));
        ret.getListe().add(new PlanqueDeMafieux(p));
        ret.getListe().add(new PlanqueDeMafieux(p));
        ret.getListe().add(new PlanqueDeMafieux(p));
        ret.getListe().add(new DetourneurDeFonds(p));
        ret.getListe().add(new DetourneurDeFonds(p));
        ret.getListe().add(new DetourneurDeFonds(p));
        return ret;
    }
    public static boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static ListeCarte createDeckFromFile(Partie p, String file) {
        ListeCarte ret=new ListeCarte();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                for (String line; (line = br.readLine()) != null; ) {
                    String[] params = line.split(",");
                    int nb = 0;
                    String name;
                    if (isNumeric(params[0])) {
                        nb = Integer.parseInt(params[0]);
                        name = params[1];
                    }
                    else {
                        nb=1;
                        name=params[0];
                    }
                    Class cl = Class.forName("Modele.Cartes.Corruption." + name);

                    java.lang.reflect.Constructor constructor =
                            cl.getConstructor
                                    (new Class[]{Partie.class});
                    for(int i =0;i<nb;i++) {
                        ret.getListe().add((Card)constructor.newInstance
                                (new Partie[]{p}));
                    }
                }
                // line is not visible here.
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
