
public class Seance implements Comparable<Seance>{

    /**
     * champ le creneau representant le creneau sur lequelle la seance se deroule
     */
    protected Creneau leCreneau;

    /**
     * chmap representant le nombre de places vendues a tarif normal
     */
    protected int nbPlacesVenduesTarifNormal;

    /**
     * Constructeur de la classe
     * @param leCreneau le creneau de la seance
     * @param nbPlacesVenduesTarifNormal le nombre de places vendues a tarif normal
     */
    public Seance(Creneau leCreneau, int nbPlacesVenduesTarifNormal) {
        this.leCreneau = leCreneau;
        this.nbPlacesVenduesTarifNormal = nbPlacesVenduesTarifNormal;
    }

    /**
     * getteur du creneau
     * @return le creneau
     */
    public Creneau getLeCreneau() {
        return leCreneau;
    }

    /**
     * getteur du nombres de places vendues a tarif normal
     * @return le nombre de places vendues
     */
    public int getNbPlacesVenduesTarifNormal() {
        return nbPlacesVenduesTarifNormal;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "leCreneau=" + leCreneau +
                ", nbPlacesVenduesTarifNormal=" + nbPlacesVenduesTarifNormal +
                '}';
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    // test d'églité
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return this.leCreneau.equals(seance.leCreneau);
    }


    /**
     *
     * @param seance
     * @return
     */
    @Override
    //Compare les séances entre elles afin de les ordonné par jour puis par horraire
    public int compareTo(Seance seance) {
        if (this.leCreneau.getJour() < seance.leCreneau.getJour()) {
            return -1;
        } else if (this.leCreneau.getJour() > seance.leCreneau.getJour()) {
            return 1;
        } else {
            if (this.leCreneau.getHeureDebut().getHeures() == seance.leCreneau.getHeureFin().getHeures()) {
                if (this.leCreneau.getHeureDebut().getMinutes() >= seance.leCreneau.getHeureFin().getMinutes()) {
                    return -1;
                } else return 0;
            } else if (this.leCreneau.getHeureFin().getHeures() == seance.leCreneau.getHeureDebut().getHeures()) {
                if (this.leCreneau.getHeureFin().getMinutes() <= seance.leCreneau.getHeureDebut().getMinutes()) {
                    return 1;
                } else return 0;
            } else if (this.leCreneau.getHeureDebut().getHeures() > seance.leCreneau.getHeureFin().getHeures()) {
                return -1;

            } else if (this.leCreneau.getHeureFin().getHeures() < seance.leCreneau.getHeureDebut().getHeures()) {
                return 1;

            } else return 0;


        }

    }

    /**
     *
     * @return 0
     */
    public double tauxRemplissage() {
        return 0;
    }

    /**
     *
     * @return 0
     */
    public double chiffreAffaire(){
        return 0;
    }
}
