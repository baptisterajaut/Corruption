package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Event;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class ShowPopulaire extends Event {
    public ShowPopulaire(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Show populaire";
    }

    @Override
    protected String declareDescription() {
        return "Perdez 3 points d'appreciation";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        partie.editPermanentAppreciation(-3);

    }
}
