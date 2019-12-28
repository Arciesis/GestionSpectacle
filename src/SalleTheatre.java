public class SalleTheatre extends Salle{

    /**
     * le nombre de fauteuils de la salle de theatre
     */
    private int nbFauteuils;

    /**
     * le tarif superieur normal de la salle de theatre
     */
    private double tarifSuperieur;


    /**
     * Constructreur de la classe
     * @param nom nom de la salle de theatre
     * @param tarif le tarif normal de la salle de theatre
     * @param places le nombre de place normale
     * @param nbFauteuils le nombre de place a pris superieur
     * @param tarifSuperieur le tarif des places superieur
     */
    public SalleTheatre(String nom, int places, double tarif, int nbFauteuils, double tarifSuperieur) {
        super(nom, places, tarif);
        this.nbFauteuils = nbFauteuils;
        this.tarifSuperieur = tarifSuperieur;
    }

    /**
     * getteur du nombre de fauteuils
     * @return le nombre de fauteuil
     */
    public int getNbFauteuils() {
        return nbFauteuils;
    }

    /**
     * getteur du tarif superieur
     * @return le tarif des fauteuils
     */
    public double getTarifSuperieur() {
        return tarifSuperieur;
    }


    @Override
    public String toString() {
        return "SalleTheatre{" +
                "nbFauteuils=" + nbFauteuils +
                ", tarifSuperieur=" + tarifSuperieur +
                ", numéro=" + numéro +
                ", nom='" + nom + '\'' +
                ", places=" + places +
                ", tarif=" + tarif +
                ", lesCreneauxOccupes=" + lesCreneauxOccupes +
                '}';
    }
}
