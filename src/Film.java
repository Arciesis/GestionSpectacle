public class Film extends Spectacle {

    /**
     * L'id du film
     */
    private int idFilm;

    /**
     * Est utilise pour l'incrementation automatique du film
     */
    private static int idFilmSuivant;

    /**
     * Le realisateur du film
     */
    private String realisateur;

    /**
     * La duree du film
     */
    private int duree;

    /**
     * Constructeur de la classe Film
     * @param titre le titre du film
     * @param duree la duree du film
     * @param realisateur le realisateur du film
     * @param lesInterpretes la liste d'interprete du film
     */
    public Film(String titre, int duree, String realisateur, String... lesInterpretes) {
        super(titre, lesInterpretes);
        this.realisateur = realisateur;
        this.duree = duree;
    }

    public Film(String titre, String realisateur, int duree) {
        super(titre);
        this.realisateur = realisateur;
        this.duree = duree;
    }

    // Blocs d'initialisation de l'id du film
    // Commence a 100 et s'incremente de 1
    static {
        idFilmSuivant = 100;
    }

    {
        idSpectacle = idFilmSuivant;
        this.idFilm=idSpectacle;
        idFilmSuivant += 1;
    }

    /**
     * @return l'id du film
     */
    public int getIdFilm() {
        return idFilm;
    }

    /**
     * @return le realisateur du film
     */
    public String getRealisateur() {
        return realisateur;
    }

    /**
     * @return la duree du film
     */
    public int getDuree() {
        return duree;
    }


    /**
     *
     * @param s
     * @return true si l'on peut ajouter la séance au film false sinon
     */
    public boolean ajouterSeanceFilm (SeanceFilm s) {
        try{
            if (s.getLaSalle().estDisponible(s.leCreneau)){
                s.getLaSalle().ajouterCreneau(s.leCreneau);
                return GestionSeanceSpectacle.add(s);
            }
        }catch (ClassCastException | NullPointerException e1){
            e1.getMessage();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", realisateur='" + realisateur + '\'' +
                ", duree=" + duree +
                ", titre='" + titre + '\'' +
                ", lesInterpretes=" + lesInterpretes +
                ",\nGestionSeanceSpectacle=" + GestionSeanceSpectacle +
                '}';
    }
}
