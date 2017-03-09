package Modele.Cartes.Abstacts;

import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public abstract class Personnage extends Carte {
    public Personnage(Partie partie) {
        super(partie);
    }

    @Override
    TypeCarte declareType() {
        return TypeCarte.Personnage;
    }
}
