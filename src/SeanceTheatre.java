public class SeanceTheatre extends Seance implements Comparable<SeanceTheatre> {

    /**
     * champ represtant la salle de theatre
     */
    private SalleTheatre laSalleTheatre;

    /**
     * champ representant le nombre de fauteuils vendues
     */
    private int fauteuilsVendues;

    /**
     * Constructeur de la classe
     *
     * @param leCreneau                  le creneau sur lequel la seance est prevue
     * @param nbPlacesVenduesTarifNormal le nombre de place a tarif normal vendues
     * @param laSalleTheatre             la salle de theatre ou se deroule la piece
     * @param fauteuilsVendues           le nombre de fauteuils vendues
     */
    public SeanceTheatre(Creneau leCreneau, int nbPlacesVenduesTarifNormal, SalleTheatre laSalleTheatre, int fauteuilsVendues) {
        super(leCreneau, nbPlacesVenduesTarifNormal);
        this.laSalleTheatre = laSalleTheatre;
        this.fauteuilsVendues = fauteuilsVendues;
    }


    /**
     * getteur de la salle de theatre
     *
     * @return la salle de theatre
     */
    public SalleTheatre getLaSalleTheatre() {
        return laSalleTheatre;
    }

    /**
     * getteur du nombre de fauteuils vendues
     *
     * @return le nombre de fauteuils vendues
     */
    public int getFauteuilsVendues() {
        return fauteuilsVendues;
    }

    @Override
    public String toString() {
        return "SeanceTheatre{" +
                "laSalleTheatre=" + laSalleTheatre +
                ", fauteuilsVendues=" + fauteuilsVendues +
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
        if (super.nbPlacesVenduesTarifNormal + this.fauteuilsVendues != 0)
            return ((this.fauteuilsVendues + super.nbPlacesVenduesTarifNormal) * 100) / this.getLaSalleTheatre().getPlaces();
        else
            return 0.0;
    }

    /**
     *
     * @return le chiffre d'affaire de la séance
     */
    public double chiffreAffaire() {
        double CA = 0;
        CA = (fauteuilsVendues * (laSalleTheatre.getTarifSuperieur())) + (super.nbPlacesVenduesTarifNormal * (laSalleTheatre.getTarif()));
        return CA;

    }


    /**
     * methode permettant de vendre des laces
     *
     * @param nbre le nombre de places a vendre
     */
    public void vendrePlacesTN(int nbre) throws ArithmeticException {
        if (laSalleTheatre.places - (super.nbPlacesVenduesTarifNormal + this.fauteuilsVendues) >= nbre) {
            if (nbre <= ((this.getLaSalleTheatre().getPlaces() - this.getLaSalleTheatre().getNbFauteuils()) - super.nbPlacesVenduesTarifNormal)) {
                super.nbPlacesVenduesTarifNormal += nbre;
            }else{
                throw new ArithmeticException("nombre de place insufisantes");
            }
        } else
            throw new ArithmeticException("nombre de places insufisantes");
    }

    /**
     * methide permettant de vendre des fauteuils
     *
     * @param nbre le nombre de fauteuils a vendre
     */
    public void vendrePlacesFauteuils(int nbre) throws ArithmeticException {
        if (laSalleTheatre.places - (super.nbPlacesVenduesTarifNormal + this.fauteuilsVendues) >= nbre) {
            if (nbre <= (this.getLaSalleTheatre().getNbFauteuils() - this.getFauteuilsVendues())){
                this.fauteuilsVendues += nbre;
            } else throw new ArithmeticException("nombre de fauteuils insufisant");
        } else
            throw new ArithmeticException("nombre de places insuffisantes");
    }

    /**
     *
     * @param seanceTheatre
     * @return Compare les séanceTheatre entre elles
     */
    public int compareTo(SeanceTheatre seanceTheatre) {
        if (this.getLaSalleTheatre().getNuméro() != seanceTheatre.getLaSalleTheatre().getNuméro()) {
            return 1;
        } else {
            if (this.leCreneau.getJour() < seanceTheatre.leCreneau.getJour()) {
                return -1;
            } else if (this.leCreneau.getJour() > seanceTheatre.leCreneau.getJour()) {
                return 1;
            } else {
                if (this.leCreneau.getHeureDebut().getHeures() == seanceTheatre.leCreneau.getHeureFin().getHeures()) {
                    if (this.leCreneau.getHeureDebut().getMinutes() >= seanceTheatre.leCreneau.getHeureFin().getMinutes()) {
                        return -1;
                    } else return 0;
                } else if (this.leCreneau.getHeureFin().getHeures() == seanceTheatre.leCreneau.getHeureDebut().getHeures()) {
                    if (this.leCreneau.getHeureFin().getMinutes() <= seanceTheatre.leCreneau.getHeureDebut().getMinutes()) {
                        return 1;
                    } else return 0;
                } else if (this.leCreneau.getHeureDebut().getHeures() > seanceTheatre.leCreneau.getHeureFin().getHeures()) {
                    return -1;

                } else if (this.leCreneau.getHeureFin().getHeures() < seanceTheatre.leCreneau.getHeureDebut().getHeures()) {
                    return 1;

                } else return 0;


            }
        }


    }
}
