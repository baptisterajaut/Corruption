package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Character;
import Modele.Partie;

/**
 * Created by bapti on 08/03/2017.
 */
public class ChefDeGang extends Character {
    public ChefDeGang(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Chef de gang";
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
        return "Vous n'avez plus le controle de vos batiments";
    }

    @Override
    protected void onArriveEffect() {

    }

    @Override
    protected void onTimeEffect() {
        partie.disableBatiments();

    }

    @Override
    protected void onLeaveEffect() {

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }

}
