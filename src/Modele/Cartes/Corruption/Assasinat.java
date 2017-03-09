package Modele.Cartes.Corruption;

import Modele.Cartes.Abstacts.Event;
import Modele.Defaite;
import Modele.Partie;

import java.util.Random;

/**
 * Created by bapti on 08/03/2017.
 */
public class Assasinat extends Event {
    public Assasinat(Partie partie) {
        super(partie);
    }


    @Override
    protected String declareName() {
        return "Assasinat";
    }

    @Override
    protected String declareDescription() {
        return "Assasinat une chance sur deux";
    }


    @Override
    protected void onArriveEffect() throws Defaite {
        System.out.println("On vous tire dessus!");
        if (new Random().nextInt(1)==0){
            System.out.println("Vous mourrez sur le coup.");
            throw new Defaite();
        }
        System.out.println("Vous survivez !");


    }

    @Override
    protected boolean declareIsInsurmontable() {
        return false;
    }


}

