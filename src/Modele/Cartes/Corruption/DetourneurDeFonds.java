package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class DetourneurDeFonds extends Character {
    public DetourneurDeFonds(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Detourneur de fonds";
    }

    @Override
    protected int declareTurnTime() {
        return 3;
    }

    @Override
    protected int declareAppreciationMalus() {
        return 0;
    }

    @Override
    protected String declareDescription() {
        return "-4 de credits par tour";
    }

    @Override
    protected void onArriveEffect() throws Defaite {

    }

    @Override
    protected void onTimeEffect() {
        partie.editCreditsMod(-4);

    }

    @Override
    protected void onLeaveEffect() {

    }

    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }
}
