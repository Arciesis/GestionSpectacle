import java.util.*;

public class Salle {

    /**
     * numeroSuivant qui indique de la salle le numero suivant et s'auto incremente
     */
    protected static int numeroSuvivant;

    /**
     * champ numero de la salle
     */
    protected int numéro;

    /**
     * champ nom de la salle
     */
    protected String nom;

    /**
     * champ nombre de places dans la salle
     */
    protected int places;

    /**
     * champ tarif generale des places de la salle
     */
    protected float tarif;

    /**
     * champ  SortedMap LesCreneauxOccupes representant l'ensembles des crenaux pour chaques
     * jour de la semaine
     */
    protected SortedMap<Integer, Set<Creneau>> LesCreneauxOccupes;


    //auto incrémentation du numéro de salle
    static {numeroSuvivant=10;}
    {this.numéro=numeroSuvivant; numeroSuvivant+=10;}

    /**
     * constructeur de la salle
     * @param nom
     * @param places
     * @param tarif
     */
    public Salle(String nom, int places, float tarif) {
        this.nom = nom;
        this.places = places;
        this.tarif = tarif;
        LesCreneauxOccupes = new TreeMap<Integer, Set<Creneau>>();
    }


    /**
     *
     * @return numero
     */
    public int getNuméro() {
        return numéro;
    }

    /**
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public int getPlaces() {
        return places;
    }

    public float getTarif() {
        return tarif;
    }

    public SortedMap<Integer, Set<Creneau>> getLesCreneauxOccupes() {
        return LesCreneauxOccupes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "numéro=" + numéro +
                ", nom='" + nom + '\'' +
                ", places=" + places +
                ", tarif=" + tarif +
                ", LesCreneauxOccupes=" + LesCreneauxOccupes +
                '}';
    }

    /**
     * test si la salle est disponible sur le creneau passé en paramètre
     * @param c
     * @return
     */
//    public boolean estDisponible(Creneau c) {
//
//
//    }
}
