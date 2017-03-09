package Modele.Cartes.Abstacts;

import Modele.Defaite;
import Modele.Partie;
import Modele.TypeCarte;

/**
 * Created by bapti on 08/03/2017.
 */
public abstract class Carte {
    private TypeCarte type;
    protected Partie partie;
    private boolean disable;
    private int tourMod = 0;
    private int tour;
    private String nom = this.getClass().toString();
    private String description;
    private int appreciaitionMalus;

    public Carte(Partie partie) {
        this.partie = partie;
        this.disable = false;
        this.type = declareType();
        this.tour = declareTurnTime();
        this.description = declareDescription();
        this.appreciaitionMalus = declareAppreciationMalus();

    }

    public void applyTour() {
        if (type == TypeCarte.Personnage) {
            tourMod--;
            if (getTourRemaining() <= 0) {
                onLeave();
                partie.getActiveCards().getListe().remove(partie.getActiveCards().getListe().indexOf(this));
            }
        }
    }

    public void onArrive() throws Defaite {
        if (!disable)
            onArriveEffect();
    }

    public int getTourRemaining() {
        return tour+tourMod;
    }

    protected abstract int declareTurnTime();

    protected abstract int declareAppreciationMalus();

    protected abstract String declareDescription();

    abstract TypeCarte declareType();

    protected abstract void onArriveEffect() throws Defaite;

    public void onTime() {
        if (!disable) {
            partie.editAppreciationMod(appreciaitionMalus);
            onTimeEffect();
        }
    }

    protected abstract void onTimeEffect();

    public void disable() {
        this.disable = true;
    }

    public void enable() {
        this.disable = false;
    }

    public void onLeave() {
        if (!disable)
            onLeaveEffect();
    }

    protected abstract void onLeaveEffect();

    public String getNom() {
        return this.nom;
    }

    public TypeCarte getType() {
        return type;
    }

    public String descibe() {
        return describe(false);
    }

    public String describe(boolean longdesc) {
        StringBuilder sb = new StringBuilder();
        sb.append(nom);
        if (longdesc) {
            sb.append(" : ").append(type.name());
            if (type == TypeCarte.Personnage)
                sb.append(" : ").append(tour).append(" tours");
            if (description.length() > 0)
                sb.append(" - ").append(description);
            if (appreciaitionMalus > 0)
                sb.append(" - ").append("-").append(appreciaitionMalus).append(" influence");
        }
        return sb.toString();
    }
}

