public class SeanceFilm extends Seance {

    /**
     * champ representant la salle de projection du film
     */
    private Salle laSalle;

    /**
     * champ representant le nombre de places vendues a tarif reduit
     */
    private int nbplacesTarifReduit;


    /**
     * Constructeur de la classe
     *
     * @param leCreneau                  le creneau du film
     * @param nbPlacesVenduesTarifNormal le nombre de places vendu au tarif normal
     * @param laSalle                    la salle de projection
     * @param nbplacesTarifReduit        le nombre de places vendu a tarid reduit
     */
    public SeanceFilm(Creneau leCreneau, int nbPlacesVenduesTarifNormal, Salle laSalle, int nbplacesTarifReduit) {
        super(leCreneau, nbPlacesVenduesTarifNormal);
        this.laSalle = laSalle;
        this.nbplacesTarifReduit = nbplacesTarifReduit;
    }

    /**
     * getteur de la salle
     *
     * @return la salle de projection du film
     */
    public Salle getLaSalle() {
        return laSalle;
    }

    /**
     * getteur du nombre de place vendu a tarif reduit
     *
     * @return le nombre de place vendu a tarif reduit
     */
    public int getNbplacesTarifReduit() {
        return nbplacesTarifReduit;
    }

    @Override
    public String toString() {
        return "SeanceFilm{" +
                "laSalle=" + laSalle +
                ", nbplacesTarifReuit=" + nbplacesTarifReduit +
                ", leCreneau=" + leCreneau +
                ", nbPlacesVenduesTarifNormal=" + nbPlacesVenduesTarifNormal +
                '}';
    }

    /**
     * Calcul le taux de remplissage d'une seance de film
     *
     * @return le taux de remplissage du film
     */
    public double tauxRemplissage() {
        if (super.nbPlacesVenduesTarifNormal + this.nbplacesTarifReduit != 0)
            return this.laSalle.places / (super.nbPlacesVenduesTarifNormal + this.nbplacesTarifReduit);
        else
            return 0.0;
    }

    /**
     * methode permettant de vendre des laces
     *
     * @param nbre le nombre de places a vendre
     */
    public void vendrePlacesTN(int nbre) throws ArithmeticException {
        if (laSalle.places - (super.nbPlacesVenduesTarifNormal + this.nbplacesTarifReduit) >= nbre) {
            super.nbPlacesVenduesTarifNormal += nbre;
        } else
            throw new ArithmeticException("nombre de places insuffisantes");
    }


    /**
     * methode permettant de vendre des places a tarif reduit
     *
     * @param nbre le nombre de places a vendre
     */
    public void vendrelacesTR(int nbre) throws ArithmeticException{
        if (laSalle.places - (super.nbPlacesVenduesTarifNormal + this.nbplacesTarifReduit) >= nbre) {
            this.nbplacesTarifReduit += nbre;
        } else
            throw new ArithmeticException("nombre de places insuffisantes");
    }
}
