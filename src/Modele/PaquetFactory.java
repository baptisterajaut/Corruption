package Modele;

import Modele.Cartes.Assasinat;
import Modele.Cartes.Bureau_de_propagande;
import Modele.Cartes.Chef_de_gang;
import Modele.Cartes.Saisie_administrative;

/**
 * Created by bapti on 08/03/2017.
 */
public class PaquetFactory {
    public static ListeCarte testDeck(Partie p){
        ListeCarte ret=new ListeCarte();
        ret.getListe().add(new Chef_de_gang(p));
        ret.getListe().add(new Chef_de_gang(p));
        ret.getListe().add(new Bureau_de_propagande(p));
        ret.getListe().add(new Saisie_administrative(p));
        ret.getListe().add(new Saisie_administrative(p));
        ret.getListe().add(new Assasinat(p));
        return ret;
    }
}
