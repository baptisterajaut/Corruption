package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Card;
import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class CargoRenegat extends Character {
    public CargoRenegat(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Cargo renegat";
    }

    @Override
    protected int declareTurnTime() {
        return 3;
    }

    @Override
    protected int declareAppreciationMalus() {
        return 1;
    }

    @Override
    protected String declareDescription() {
        return "-1 de credit par tour. Va chercher Jack Tamo";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        for(Card c : partie.getPaquet().getListe()){
            if(c instanceof CaptiaineJackTamo) {
                partie.getPaquet().removeCarte(c);
                c.onArrive();
                partie.getCardsToAdd().getListe().add(c);
                return;
            }
        }
    }

    @Override
    protected void onTimeEffect() {
        partie.editCreditsMod(-1);

    }

    @Override
    protected void onLeaveEffect() {

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }

}
