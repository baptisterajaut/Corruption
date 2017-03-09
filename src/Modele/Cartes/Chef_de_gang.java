package Modele.Cartes;

import Modele.Cartes.Abstacts.Personnage;
import Modele.Partie;

/**
 * Created by bapti on 08/03/2017.
 */
public class Chef_de_gang extends Personnage {
    public Chef_de_gang(Partie partie) {
        super(partie);
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
}
