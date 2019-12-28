public class Seance {

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
}
