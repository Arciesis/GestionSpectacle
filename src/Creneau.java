import java.time.LocalDateTime;
import java.util.Objects;

public class Creneau {

    /**
     * jour de la semaine compris entre 1 et 7
     * respectivement 1 = lundi etc...
     */
    private int jour;

    /**
     * Champ representant l'horaire de fin du creneau
     */
    private Horaire heureFin;

    /**
     * Champ representant l'Horaire de Debut
     */
    private Horaire heureDebut;

    /**
     * Constructeur de laq classe Creneau
     *
     * @param jour       le jour de la semaine compris entre 1 et 7
     * @param heureDebut l'heure de debut du creneau
     * @param heureFin   l'heure de fin du creneau
     */
    public Creneau(int jour, Horaire heureDebut, Horaire heureFin) {
        assert jour >= 1 && jour <= 7;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    /**
     * getter du champ jour
     *
     * @return le jour du creneau
     */
    public int getJour() {
        return jour;
    }

    /**
     * getter du champ HeureFin
     *
     * @return l'oraire de fin du creneau
     */
    public Horaire getHeureFin() {
        return heureFin;
    }

    /**
     * getter du champ heureDebut
     *
     * @return l'Horaire de debut du creneau
     */
    public Horaire getHeureDebut() {
        return heureDebut;
    }

    @Override
    public String toString() {
        return "Creneau{" +
                "jour=" + jour +
                ", heureFin=" + heureFin +
                ", heureDebut=" + heureDebut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creneau creneau = (Creneau) o;
        return jour == creneau.jour &&
                heureFin.equals(creneau.heureFin) &&
                heureDebut.equals(creneau.heureDebut);
    }


    /**
     * Methode de calcul de la duree du creneau
     *
     * @return un Integer du nombre de minutes du Creneau
     */
    public int calculerDuree() {
        return ((this.heureFin.getHeures() - this.heureDebut.getHeures()) * 60 + this.heureFin.getMinutes() -
                this.heureDebut.getMinutes());
    }

}
