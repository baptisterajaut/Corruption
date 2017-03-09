package Modele.Cartes.Abstacts;

import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public abstract class Event extends Card {
    public Event(Partie partie) {
        super(partie);
    }

    @Override
    protected int declareTurnTime() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected int declareAppreciationMalus() {
        return 0;
    }

    @Override
    TypeCarte declareType() {
        return TypeCarte.Evennement;
    }

    @Override
    protected void onTimeEffect() {

    }

    @Override
    protected void onLeaveEffect() {

    }
}
