package Modele.Cartes.Abstacts;

import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public abstract class Character extends Card {
    public Character(Partie partie) {
        super(partie);
    }

    @Override
    TypeCarte declareType() {
        return TypeCarte.Personnage;
    }
}
