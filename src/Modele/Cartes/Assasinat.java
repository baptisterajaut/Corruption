package Modele.Cartes;

import Modele.Cartes.Abstacts.Carte;
import Modele.Cartes.Abstacts.Evennement;
import Modele.Defaite;
import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public class Assasinat extends Evennement {
    public Assasinat(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareDescription() {
        return "Assasinat";
    }


    @Override
    protected void onArriveEffect() throws Defaite {
        throw new Defaite();

    }


}

