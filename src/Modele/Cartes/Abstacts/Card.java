package Modele.Cartes.Abstacts;

import Modele.Defaite;
import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public abstract class Card {
    private TypeCarte type;
    protected Partie partie;
    private boolean disable;
    private boolean insurmontable;
    private int tourMod = 0;
    private int tour;
    private String nom;
    private String description;
    private int appreciaitionMalus;

    public Card(Partie partie) {
        this.partie = partie;
        this.disable = false;
        this.type = declareType();
        this.tour = declareTurnTime();
        this.description = declareDescription();
        this.appreciaitionMalus = declareAppreciationMalus();
        this.nom=declareName();
        insurmontable=this.declareIsInsurmontable();

    }

    public void applyTour() {
        enable();
        if (type == TypeCarte.Personnage) {
            tourMod--;
            if (getTourRemaining() <= 0) {
                onLeave();
                partie.getActiveCards().removeCarte(this);
            }
        }
    }

    public void onArrive() throws Defaite {
            System.out.println(nom+" arrive sur le terrain");
            onArriveEffect();
    }

    public int getTourRemaining() {
        return tour+tourMod;
    }



    protected abstract String declareName();

    protected abstract int declareTurnTime();

    protected abstract int declareAppreciationMalus();

    protected abstract String declareDescription();

    abstract TypeCarte declareType();

    protected abstract void onArriveEffect() throws Defaite;

    public void onTime() {
        if (!disable) {
            partie.editAppreciationMod(-appreciaitionMalus);

        }
        onTimeEffect();
    }

    protected abstract void onTimeEffect();

    public void disable() {
        this.disable = true;
    }

    public void enable() {
        this.disable = false;
    }

    public void onLeave() {
            onLeaveEffect();
    }

    protected abstract void onLeaveEffect();

    protected abstract boolean declareIsInsurmontable();

    protected String getNom() {
        return this.nom;
    }

    public boolean isDisable() {
        return disable;
    }

    public TypeCarte getType() {
        return type;
    }

    public String descibe() {
        return describe(false);
    }

    public boolean isInsurmontable() {
        return insurmontable;
    }

    public String describe(boolean longdesc) {
        StringBuilder sb = new StringBuilder();
        sb.append(nom);
        if (longdesc) {
            sb.append(" : ").append(type.name());
            if (type == TypeCarte.Personnage) {
                sb.append(" : ").append(tour).append(" tours");
                sb.append("( ").append(getTourRemaining()).append(" tours restants ) ");
            }
            if (description.length() > 0)
                sb.append(" : ").append(description);
            if (appreciaitionMalus > 0)
                sb.append(", - ").append(appreciaitionMalus).append(" influence");
        }
        return sb.toString();
    }
}

