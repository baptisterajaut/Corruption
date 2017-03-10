package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Building;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class StripClub extends Building {
    public StripClub(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Strip-Club";
    }

    @Override
    protected int declareAppreciationMalus() {
        return 8;
    }

    @Override
    protected String declareDescription() {
        return "+2 credits par tour";
    }

    @Override
    protected void onArriveEffect() throws Defaite {

    }

    @Override
    protected void onTimeEffect() throws Defaite {
        partie.editCreditsMod(2);

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }

}
