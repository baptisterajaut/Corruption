package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class BaronDeLaPegre extends Character {
    public BaronDeLaPegre(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Baron de la pegre";
    }

    @Override
    protected int declareTurnTime() {
        return 3;
    }

    @Override
    protected int declareAppreciationMalus() {
        return 3;
    }

    @Override
    protected String declareDescription() {
        return "Unique, -3 credits par tour";
    }

    @Override
    protected void onArriveEffect() throws Defaite {

    }

    @Override
    protected void onTimeEffect() throws Defaite {
        partie.editCreditsMod(-3);

    }

    @Override
    protected void onLeaveEffect() {

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }

}
