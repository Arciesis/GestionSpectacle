import java.util.SortedMap;

public class Salle {
    /**
     * attribues de la classe salle
     */

    protected static int numeroSuvivant;
    protected int numéro;
    protected String nom;
    protected int places;
    protected float tarif;
    protected Map <Integer,set<Creneau>> LesCreneauxOccupes;

    //auto incrémentation du numéro de salle
    static {numeroSuvivant=10;}
    {this.numéro=numeroSuvivant; numeroSuvivant+=10;}


    public Salle(String nom, int places, float tarif) {
        this.nom = nom;
        this.places = places;
        this.tarif = tarif;
        LesCreneauxOccupes = new SortedMap<Integer,set<Creneau>>();
    }

    public boolean estDisponible(Creneau c){



    }

}
