package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Character;
import Modele.Cartes.Abstacts.Event;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class MauvaisContrat extends Event {
    public MauvaisContrat(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Mauvais Contrat";
    }

    @Override
    protected String declareDescription() {
        return "+3 credit, Vous perdez 1 d'influence et 2 d'appreciation";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        partie.editPermanentCredits(3);
        partie.editPermanentInfluence(-1);
        partie.editPermanentAppreciation(-2);

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }

}
