package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Card;
import Modele.Cartes.Abstacts.Event;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class BavurePoliciere extends Event {
    public BavurePoliciere(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Bavure Policiere";
    }

    @Override
    protected String declareDescription() {
        return "Insurmontable. Vous perdez 2 points d’appreciation. Si vous avez moins de 6 d’appreciation, prend un evennement aléatoire du paquet et le déclenche.";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        partie.editPermanentAppreciation(-2);
        if(partie.getTotalAppreciation()<6){
            System.out.println("Emeute !");
            for(Card c : partie.getPaquet().getListe()){
                if(c instanceof Event){
                    partie.getPaquet().removeCarte(c);
                    c.onArrive();
                }
            }
        }


    }

    @Override
    protected boolean declareIsInsurmontable() {
        return true;
    }
}
