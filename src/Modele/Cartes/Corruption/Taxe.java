package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Card;
import Modele.Cartes.Abstacts.Event;
import Modele.Defaite;
import Modele.Partie;

/**
 * Created by bapti on 09/03/2017.
 */
public class Taxe extends Event {
    public Taxe(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Taxe";
    }

    @Override
    protected String declareDescription() {
        return "Insurmontable. Payez 5 crédits. Si vous n’avez pas assez perdez tous vos crédits et déclenchez la prochaine carte.";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        System.out.println("Salutations... vous nous devez 5 credits ( vous en avez "+partie.getTotalCredits()+" )");
        if(partie.getTotalCredits()>=5){
            System.out.println("Bon vous pouvez payer... Vous avez de la chance.");
            partie.editPermanentCredits(-5);
        }
        else{
            System.out.println("Hmmm? Pas assez d'argent a ce que je vois... Jolis meubles...");
            partie.editPermanentCredits(-partie.getTotalCredits());
            Card next = partie.getPaquet().draw();
            next.onArrive();
            partie.getCardsToAdd().getListe().add(next);
        }

    }

    @Override
    protected boolean declareIsInsurmontable() {
        return true;
    }
}
