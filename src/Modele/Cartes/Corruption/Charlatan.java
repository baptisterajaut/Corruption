package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class Charlatan extends Character {
    public Charlatan(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Charlatan";
    }

    @Override
    protected int declareTurnTime() {
        return 1;
    }

    @Override
    protected int declareAppreciationMalus() {
        return 0;
    }

    @Override
    protected String declareDescription() {
        return "- 2 points d’influence";
    }

    @Override
    protected void onArriveEffect() throws Defaite {

    }

    @Override
    protected void onTimeEffect() throws Defaite {
        partie.editInfluenceMod(-2);

    }

    @Override
    protected void onLeaveEffect() {

    }

    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }
}
