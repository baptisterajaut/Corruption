package Modele;

import Modele.Cartes.Abstacts.Carte;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bapti on 08/03/2017.
 */
public class ListeCarte {
    private ArrayList<Carte> liste;

    public ListeCarte() {
        this.liste=new ArrayList<>();
    }

    public ArrayList<Carte> getListe() {
        return liste;
    }
    public Carte draw(){
        return liste.remove(liste.size()-1);
    }
    public void melanger(){
        Collections.shuffle(liste);
    }
}
