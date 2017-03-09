package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class BoursierCorrompu extends Character{
    public BoursierCorrompu(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Boursier Corrompu";
    }

    @Override
    protected int declareTurnTime() {
        return 3;
    }

    @Override
    protected int declareAppreciationMalus() {
        return 2;
    }

    @Override
    protected String declareDescription() {
        return "-2 credits par tour";
    }

    @Override
    protected void onArriveEffect() throws Defaite {

    }

    @Override
    protected void onTimeEffect() {
        partie.editCreditsMod(-2);
    }

    @Override
    protected void onLeaveEffect() {

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }

}
