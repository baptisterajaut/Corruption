package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Event;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 08/03/2017.
 */
public class Assasinat extends Event {
    public Assasinat(Partie partie) {
        super(partie);
    }


    @Override
    protected String declareName() {
        return "Assasinat";
    }

    @Override
    protected String declareDescription() {
        return "Assasinat une chance sur deux";
    }


    @Override
    protected void onArriveEffect() throws Defaite {
        throw new Defaite();

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }



}

