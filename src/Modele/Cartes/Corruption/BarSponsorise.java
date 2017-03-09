package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Building;
import Modele.Cartes.Abstacts.Card;
import Modele.Cartes.Abstacts.Character;
import Modele.Defaite;
import Modele.Partie;

import java.util.ArrayList;

/**
 * Created by bapti on 09/03/2017.
 */
public class BarSponsorise extends Building {
    public BarSponsorise(Partie partie) {
        super(partie);
    }

    @Override
    protected String declareName() {
        return "Bar Sponsorise";
    }

    @Override
    protected int declareAppreciationMalus() {
        return 3;
    }

    @Override
    protected String declareDescription() {
        return "Prend un personnage aléatoire du paquet et le déclenche";
    }

    @Override
    protected void onArriveEffect() throws Defaite {
        for(Card c : new ArrayList<>(partie.getPaquet().getListe())){
            if(c instanceof Character){
                partie.getPaquet().removeCarte(c);
                c.onArrive();
                partie.getCardsToAdd().getListe().add(c);
                return;
            }
        }

    }

    @Override
    protected void onTimeEffect() {

    }
    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }

}
