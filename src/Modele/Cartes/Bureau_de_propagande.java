package Modele.Cartes;

import Modele.Cartes.Abstacts.Batiment;
import Modele.Defaite;
import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public class Bureau_de_propagande extends Batiment {
    public Bureau_de_propagande(Partie partie) {
        super(partie);
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

}

