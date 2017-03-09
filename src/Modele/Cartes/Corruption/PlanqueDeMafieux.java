package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Building;
import Modele.Cartes.Abstacts.Card;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class PlanqueDeMafieux extends Building {
    public PlanqueDeMafieux(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Planque de mafieux";
    }

    @Override
    protected int declareAppreciationMalus() {
        return 3;
    }

    @Override
    protected String declareDescription() {
        return "Si il y a un chef de gang dans le paquet : Le déclenche.";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        for(Card c : partie.getPaquet().getListe()){
            if(c instanceof ChefDeGang){
                partie.getPaquet().removeCarte(c);
                c.onArrive();
                partie.getCardsToAdd().getListe().add(c);
                return;
            }
        }
    }

    @Override
    protected void onTimeEffect() {

    }

    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }
}
