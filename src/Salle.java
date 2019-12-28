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
     * le nom de la salle
     */
    protected String nom;

    /**
     * champ nombre de places dans la salle
     */
    protected int places;

    /**
     * champ tarif generale des places de la salle
     */
    protected double tarif;

    /**
     * champ  SortedMap LesCreneauxOccupes representant l'ensembles des crenaux pour chaques
     * jour de la semaine
     */
    protected SortedMap<Integer, Set<Creneau>> lesCreneauxOccupes;


    //auto incrémentation du numéro de salle
    static {
        numeroSuvivant = 10;
    }

    {
        this.numéro = numeroSuvivant;
        numeroSuvivant += 10;
    }

    /**
     * constructeur de la salle
     *
     * @param nom
     * @param places
     * @param tarif
     */
    public Salle(String nom, int places, double tarif) {
        this.nom = nom;
        this.places = places;
        this.tarif = tarif;
        lesCreneauxOccupes = new TreeMap<Integer, Set<Creneau>>();
    }


    /**
     * @return numero
     */
    public int getNuméro() {
        return numéro;
    }

    /**
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return place
     */
    public int getPlaces() {
        return places;
    }

    /**
     * @return tarif
     */
    public double getTarif() {
        return tarif;
    }

    /**
     * @return LesCreneauOccupes
     */
    public SortedMap<Integer, Set<Creneau>> getLesCreneauxOccupes() {
        return lesCreneauxOccupes;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param places
     */
    public void setPlaces(int places) {
        this.places = places;
    }

    /**
     * @param tarif
     */
    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "\nnuméro=" + numéro +
                " \nnom='" + nom + '\'' +
                " \nplaces=" + places +
                " \ntarif=" + tarif +
                " \nLesCreneauxOccupes=" + lesCreneauxOccupes +
                '}';
    }

    /**
     * test si la salle est disponible sur le creneau passé en paramètre
     *
     * @param c
     * @return false si le créneau n'est pas placable et true sinon
     */
    public boolean estDisponible(Creneau c) {

        //on cree un iterateur pour iterer sur les keys
        Iterator<Integer> it = lesCreneauxOccupes.keySet().iterator();
        while (it.hasNext()) {
            int jour = it.next();

            //on test si la clé jour du TreeMap correspond au jour du créneau
            if (jour == c.getJour()) {

                // on récupère la valeur de la clé si celle ci correspond au jour
                Set<Creneau> listeCreneauJourJ = lesCreneauxOccupes.get(jour);

                // on itère sur la valeur de la clé afin de consulter l'ensemble des créneaux
                Iterator<Creneau> itCreneaux = listeCreneauJourJ.iterator();

                // on itère sur les différents créneau du "Set<Creneau>"
                while (itCreneaux.hasNext()) {
                    Creneau CreneauxDeLaListe = itCreneaux.next();


                    // on test si le créneau n'est pas placable
                    if (c.compareTo(CreneauxDeLaListe) == 0) {
                        return false;

                    }
                }

            }
        }
        return true;
    }

    /**
     * Retourne true si la sortedMap contient l'entier
     *
     * @param jour le jour a tester
     * @return true si il n'y a pas de creneau ce jour et false sinon
     */
    public boolean pasDeCreneauCeJour(int jour) {

        // récupération des clé desCreneauOccupes
        Set<Integer> myKeys = this.lesCreneauxOccupes.keySet();

        // vérification de la contenance du jour passé en paramètre
        if (myKeys.contains(jour)) {

            // récupération de la valeur de la clé
            Set<Creneau> myValues = this.lesCreneauxOccupes.get(jour);

            // test si le jour ne contient pas de créneau
            if (myValues.isEmpty())
                return true;
            return false;
        } else {
            return true;
        }

    }

    /**
     * permet l'ajout d'un créneau
     *
     * @param c
     * @return true si le créneau est ajouté , false sinon
     */
    public boolean ajouterCreneau(Creneau c) {

        // récupération des clés desCreneauOccupes
        Set<Integer> mykey = this.lesCreneauxOccupes.keySet();

        // vérification de la contenance du jour passé en paramètre
        if (mykey.contains(c.getJour())) {

            // test si le créneau est disponible et l'ajoute si oui
            if (estDisponible(c)) {
                Set<Creneau> myValues = this.lesCreneauxOccupes.get(c.getJour());
                return myValues.add(c);
            } else {
                return false;
            }
        } else {
            //sinon créer une nouvelle ligne dans lesCreneauOccupes avec le jour en clé et le créneau en valeur
            Set<Creneau> mySet = new TreeSet<Creneau>();
            mySet.add(c);
            lesCreneauxOccupes.put(c.getJour(), mySet);
            return true;
        }
    }
}
