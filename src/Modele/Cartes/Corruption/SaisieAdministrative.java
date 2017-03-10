package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Event;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 08/03/2017.
 */
public class SaisieAdministrative extends Event {
    public SaisieAdministrative(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Saisie Administrative";
    }


    @Override
    protected String declareDescription() {
        return "Perdez 1 point d'influence";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        partie.editPermanentInfluence(-1);
    }

    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }


}
