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
        System.out.println("Un policier tire sur la foule par erreur!");
        if(partie.getAppreciation()<6){
            System.out.println("Cela declenche une emeute !");
            for(Card c : partie.getPaquet().clone().getListe()){
                if(c instanceof Event){
                    partie.getPaquet().removeCarte(c);
                    System.out.println("L'emeute declence : "+c.descibe());
                    c.onArrive();
                    return;
                }
            }
            System.out.println("Le peuple s'est calme.");
        }


    }

    @Override
    protected boolean declareIsInsurmontable() {
        return true;
    }
}
