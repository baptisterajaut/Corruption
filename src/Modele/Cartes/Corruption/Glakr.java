package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

import java.util.Random;

/**
 * Created by bapti on 11/03/2017.
 */
public class Glakr extends Character {
    public Glakr(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Glakr";
    }

    @Override
    protected int declareTurnTime() {
        return 4;
    }

    @Override
    protected int declareAppreciationMalus() {
        return 0;
    }

    @Override
    protected String declareDescription() {
        return "Dure de 1 a 4 tours. -1 a 4 points d'appreciation.";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        setTour( new Random().nextInt(4)+1);

    }

    @Override
    protected void onTimeEffect() throws Defaite {
        partie.editAppreciationMod(new Random().nextInt(4)+1);

    }

    @Override
    protected void onLeaveEffect() {

    }

    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }
}
