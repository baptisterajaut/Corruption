package Modele;

import Modele.Cartes.Abstacts.Carte;
import Modele.Cartes.Abstacts.Evennement;
import Modele.Cartes.Abstacts.Personnage;

/**
 * Created by bapti on 08/03/2017.
 */
public class Partie {
    private int influence;
    private int influenceMod = 0;


    private int appreciationMalus = 0;
    private int credits;
    private int creditsMod = 2;
    private int appreciation;
    private int tours;
    private boolean batimentsEnabled;

    private ListeCarte activeCards;
    private ListeCarte paquet;

    public Partie(int tours) {
        activeCards=new ListeCarte();
        this.influence = 3;
        this.appreciation = 20;
        this.credits = 20;
        this.tours = tours;
        paquet=PaquetFactory.testDeck(this);
        paquet.melanger();
    }


    private void run() {
        try {
            for (int ktours = 0; ktours < tours; ktours++) {
                for (Carte c : activeCards.getListe()) {
                    c.onTime();
                }
                int apr = appreciation - appreciationMalus;
                int infl = influence + influenceMod;

                checkDefaite();
                if(activeCards.getListe().size()!=0){
                    StringBuilder sb=new StringBuilder();
                    sb.append("Vous avez ").append(apr).append(" points d'appreciation (").append(appreciation).append(" - ").append(appreciationMalus).append(")\n");
                    sb.append("Vous avez ").append(infl).append(" points d'influence (").append(influence).append(" - ").append(influenceMod).append(")\n");
                    sb.append("Vous avez ").append(credits).append(" credits (").append(creditsMod).append(" par tour)\n");
                    sb.append("Vous avez sur le terrain :\n");
                    for(Carte c : activeCards.getListe()){
                        sb.append(c.describe(true));
                        if(c instanceof Personnage)
                            sb.append("( ").append(c.getTourRemaining()).append(" tours restants)");
                        sb.append("\n");
                    }
                    System.out.print(sb.toString());

                }
                ListeCarte choisies=new ListeCarte();
                choisies.getListe().add(paquet.draw());
                for(int i=1;i<influence+influenceMod;i++)
                    choisies.getListe().add(paquet.draw());
                System.out.println("Choisisez une carte :");
                for(int i=0;i<choisies.getListe().size();i++)
                    System.out.println((i+1)+" : "+choisies.getListe().get(i).describe(true));
                int choix=1;
                Carte choisie=choisies.getListe().remove(choix-1);
                paquet.getListe().addAll(choisies.getListe());
                paquet.melanger();
                choisie.onArrive();
                for(Carte c :  activeCards.getListe()){
                    c.applyTour();
                }
                if (batimentsEnabled) {
                    System.out.println("Editez vos batiments");
                }
                else
                    System.out.println("Batiments non modifiables !");
                credits+=creditsMod;
                if(!(choisie instanceof Evennement))
                    activeCards.getListe().add(choisie);
                batimentsEnabled=true;
            }
            System.out.println("Vous avez survecu");
        }
        catch (Defaite d){
            System.out.println("Vous avez perdu!");
        }
    }

    private void checkDefaite() throws Defaite{
        if(appreciation+ appreciationMalus <=0)
            throw new Defaite();
    }
    public void editCreditsMod(int creditsMod) {
        this.creditsMod += creditsMod;
    }

    public void editInfluenceMod(int influenceMod) {
        this.influenceMod += influenceMod;
    }

    public void editAppreciationMod(int appreciationMod) {
        this.appreciationMalus += appreciationMod;
    }

    public void disableBatiments() {
        this.batimentsEnabled = false;
    }

    public void editPermanentInfluence(int influence) {
        this.influence += influence;
    }

    public void editPermanentCredits(int credits) {
        this.credits += credits;
    }

    public void editPermanentAppreciation(int appreciation) {
        this.appreciation = appreciation;
    }

    public ListeCarte getActiveCards() {
        return activeCards;
    }
    public static void main (String[] args){
        new Partie(4).run();
    }

}

