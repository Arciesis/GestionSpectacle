import java.util.*;

public class Salle {

    /**
     * numéroSuivant qui indique le numéro suivant de la salle et s'auto incremente
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
     * @return place
     */
    public int getPlaces() {
        return places;
    }

    /**
     *
     * @return tarif
     */
    public float getTarif() {
        return tarif;
    }

    /**
     *
     * @return LesCreneauOccupes
     */
    public SortedMap<Integer, Set<Creneau>> getLesCreneauxOccupes() {
        return LesCreneauxOccupes;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param places
     */
    public void setPlaces(int places) {
        this.places = places;
    }

    /**
     *
     * @param tarif
     */
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
    public boolean estDisponible(Creneau c){

        //on creer un iterateur pour iterer sur les keys
        Iterator<Integer> it = LesCreneauxOccupes.keySet().iterator();
        while(it.hasNext()){
            int jour= it.next();

            //on test si la clé jour du TreeMap correspond au jour du créneau
            if(jour==c.getJour()){

                // on récupère la valeur de la clé si celle ci correspond au jour
                Set<Creneau> listeCreneauJourJ = LesCreneauxOccupes.get(jour);

                // on itère sur la valeur de la clé afin de consulter l'ensemble des créneaux
                Iterator<Creneau> itCreneaux = listeCreneauJourJ.iterator();

                // on itère sur les différents créneau du "Set<Creneau>"
                while (itCreneaux.hasNext()){
                    Creneau CreneauxDeLaListe = itCreneaux.next();


                    // on test si les le créneau n'est pas placable
                    if (!c.estPlacable(CreneauxDeLaListe)){
                        return false;

                    }
                }

            }
        }
        return true;
    }
}

