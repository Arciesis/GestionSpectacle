import java.security.InvalidParameterException;

public class Creneau implements Comparable<Creneau> {

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
    public Creneau(int jour, Horaire heureDebut, Horaire heureFin) throws InvalidParameterException {
        if (jour >= 1 && 7 >= jour){
            this.jour = jour;
        } else throw new InvalidParameterException("Jour de la semaine non compris entre 1 et 7");
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
        int duree=0;
        if (! (heureDebut.getHeures() > heureFin.getHeures())) {
            duree = ((this.heureFin.getHeures() - this.heureDebut.getHeures()) * 60
                    + this.heureFin.getMinutes() - this.heureDebut.getMinutes());
        } else {
            duree = (24 - heureDebut.getHeures() - (0 - heureDebut.getMinutes())
                    + heureFin.getHeures() + heureFin.getMinutes());
        }
        return duree;

    }

    @Override
    public int compareTo(Creneau o) {
        return 0;
    }
}
