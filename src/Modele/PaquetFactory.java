package Modele;

import Modele.Cartes.Corruption.*;

/**
 * Created by bapti on 08/03/2017.
 */
public class PaquetFactory {
    public static ListeCarte testDeck(Partie p){
        ListeCarte ret=new ListeCarte();
        ret.getListe().add(new ChefDeGang(p));
        ret.getListe().add(new ChefDeGang(p));
        ret.getListe().add(new BureauDePropagande(p));
        ret.getListe().add(new BureauDePropagande(p));
        ret.getListe().add(new BureauDePropagande(p));
        ret.getListe().add(new BureauDePropagande(p));
        ret.getListe().add(new BureauDePropagande(p));
        //ret.getListe().add(new Assasinat(p));
        ret.getListe().add(new CaptiaineJackTamo(p));
        ret.getListe().add(new CargoRenegat(p));
        ret.getListe().add(new CargoRenegat(p));
        ret.getListe().add(new CargoRenegat(p));
        return ret;
    }
}
