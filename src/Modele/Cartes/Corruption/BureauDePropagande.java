package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Building;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 08/03/2017.
 */
public class BureauDePropagande extends Building {
    public BureauDePropagande(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Bureau de propagande";
    }

    @Override
    protected int declareAppreciationMalus() {
        return 4;
    }

    @Override
    protected String declareDescription() {
        return "";
    }

    @Override
    protected void onArriveEffect() throws Defaite {

    }

    @Override
    protected void onTimeEffect() {

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }


}

