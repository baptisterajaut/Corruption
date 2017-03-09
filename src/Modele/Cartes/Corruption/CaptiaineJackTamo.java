package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Card;
import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

import java.util.ArrayList;

/**
 * Created by bapti on 09/03/2017.
 */
public class CaptiaineJackTamo extends Character {
    public CaptiaineJackTamo(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Capitaine Jack Tamo";
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
        return "Unique. Appelle les cargos !";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        System.out.println("Jack Tamo : Quelle ville minable ! Apportez moi du rhum!");
        for(Card c : new ArrayList<>(partie.getPaquet().getListe())){
            if(c instanceof CargoRenegat) {
                partie.getPaquet().removeCarte(c);
                c.onArrive();
                partie.getCardsToAdd().getListe().add(c);
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
