public class SeanceTheatre extends  Seance{

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
     * @param leCreneau le creneau sur lequel la seance est prevue
     * @param nbPlacesVenduesTarifNormal le nombre de place a tarif normal vendues
     * @param laSalleTheatre la salle de theatre ou se deroule la piece
     * @param fauteuilsVendues le nombre de fauteuils vendues
     */
    public SeanceTheatre(Creneau leCreneau, int nbPlacesVenduesTarifNormal, SalleTheatre laSalleTheatre, int fauteuilsVendues) {
        super(leCreneau, nbPlacesVenduesTarifNormal);
        this.laSalleTheatre = laSalleTheatre;
        this.fauteuilsVendues = fauteuilsVendues;
    }


    /**
     * getteur de la salle de theatre
     * @return la salle de theatre
     */
    public SalleTheatre getLaSalleTheatre() {
        return laSalleTheatre;
    }

    /**
     * getteur du nombre de fauteuils vendues
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
     * @return le taux de remplissage du film
     */
    public double tauxRemplissage(){
        if (super.nbPlacesVenduesTarifNormal + this.fauteuilsVendues != 0)
            return this.laSalleTheatre.places / (super.nbPlacesVenduesTarifNormal + this.fauteuilsVendues);
        else
            return 0.0;
    }

    /**
     * methode permettant de vendre des laces
     * @param nbre le nombre de places a vendre
     */
    public void vendrePlacesTN(int nbre){
        if (laSalleTheatre.places - (super.nbPlacesVenduesTarifNormal + this.fauteuilsVendues) >= nbre){
            super.nbPlacesVenduesTarifNormal += nbre;
        }
    }

    /**
     * methide permettant de vendre des fauteuils
     * @param nbre le nombre de fauteuils a vendre
     */
    public void vendrePlacesFauteuils(int nbre){
        if (laSalleTheatre.places - (super.nbPlacesVenduesTarifNormal + this.fauteuilsVendues) >= nbre){
            this.fauteuilsVendues += nbre;
        }
    }
}
