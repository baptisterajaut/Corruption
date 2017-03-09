package Modele.Cartes.Abstacts;

import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public abstract class Building extends Card {
    public Building(Partie partie) {
        super(partie);
    }

    @Override
    protected int declareTurnTime() {
        return Integer.MAX_VALUE;
    }

    @Override
    TypeCarte declareType() {
        return TypeCarte.Batiment;
    }

    @Override
    protected void onLeaveEffect() {

    }

}
