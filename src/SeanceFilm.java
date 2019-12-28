public class SeanceFilm extends Seance {

    /**
     * champ representant la salle de projection du film
     */
    private Salle laSalle;

    /**
     * champ representant le nombre de places vendu a tarif reduit
     */
    private int nbplacesTarifReuit;


    /**
     * Constructeur de la classe
     * @param leCreneau le creneau du film
     * @param nbPlacesVenduesTarifNormal le nombre de places vendu au tarif normal
     * @param laSalle la salle de projection
     * @param nbplacesTarifReuit le nombre de places vendu a tarid reduit
     */
    public SeanceFilm(Creneau leCreneau, int nbPlacesVenduesTarifNormal, Salle laSalle, int nbplacesTarifReuit) {
        super(leCreneau, nbPlacesVenduesTarifNormal);
        this.laSalle = laSalle;
        this.nbplacesTarifReuit = nbplacesTarifReuit;
    }

    /**
     * getteur de la salle
     * @return la salle de projection du film
     */
    public Salle getLaSalle() {
        return laSalle;
    }

    /**
     * getteur du nombre de place vendu a tarif reduit
     * @return le nombre de place vendu a tarif reduit
     */
    public int getNbplacesTarifReuit() {
        return nbplacesTarifReuit;
    }

    @Override
    public String toString() {
        return "SeanceFilm{" +
                "laSalle=" + laSalle +
                ", nbplacesTarifReuit=" + nbplacesTarifReuit +
                ", leCreneau=" + leCreneau +
                ", nbPlacesVenduesTarifNormal=" + nbPlacesVenduesTarifNormal +
                '}';
    }
}
