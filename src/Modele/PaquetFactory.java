package Modele;

import Modele.Cartes.Corruption.*;

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
}
