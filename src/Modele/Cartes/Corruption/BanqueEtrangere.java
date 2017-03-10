package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Building;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class BanqueEtrangere extends Building {
    public BanqueEtrangere(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Banque Etrangere";
    }

    @Override
    protected int declareAppreciationMalus() {
        return 2;
    }

    @Override
    protected String declareDescription() {
        return "-1 de crédit par tour";
    }

    @Override
    protected void onArriveEffect() throws Defaite {

    }

    @Override
    protected void onTimeEffect() throws Defaite {
        partie.editCreditsMod(-1);

    }

    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }
}
