package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class SombreConseiller extends Character {
    public SombreConseiller(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Sombre Conseiller";
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
        return "+1 point d'influence. -3 credits par tour";
    }

    @Override
    protected void onArriveEffect() throws Defaite {

    }

    @Override
    protected void onTimeEffect() {
        partie.editInfluenceMod(1);
        partie.editCreditsMod(-3);

    }

    @Override
    protected void onLeaveEffect() {

    }
}
