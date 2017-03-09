package Modele;

import Modele.Cartes.Abstacts.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bapti on 08/03/2017.
 */
public class ListeCarte implements Cloneable{
    private ArrayList<Card> liste;

    public ListeCarte() {
        this.liste=new ArrayList<>();
    }

    public ArrayList<Card> getListe() {
        return liste;
    }
    public Card draw(){
        return liste.remove(liste.size()-1);
    }
    public void melanger(){
        Collections.shuffle(liste);
    }
    public Card removeCarte(Card c){
        return liste.remove(liste.indexOf(c));
    }
    public ListeCarte clone(){
     ListeCarte ret=new ListeCarte();
        ret.liste=new ArrayList<>(this.liste);
        return ret;
    }
}
