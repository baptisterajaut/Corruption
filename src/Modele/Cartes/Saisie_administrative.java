package Modele.Cartes;

import Modele.Cartes.Abstacts.Carte;
import Modele.Cartes.Abstacts.Evennement;
import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public class Saisie_administrative extends Evennement {
    public Saisie_administrative(Partie partie) {
        super(partie);
    }



    @Override
    protected String declareDescription() {
        return "Perdez 1 point d'influence";
    }

    @Override
    protected void onArriveEffect() {
        partie.editPermanentInfluence(-1);
    }


}
