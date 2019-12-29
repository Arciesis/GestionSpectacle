import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class GestionProgrammationSemaine implements IProgrammationSemaine {

    /**
     * champ representant la liste des salles standards
     */
    private SortedMap<Integer, Salle> lesSalles;

    /**
     * champ representant la liste des salles de theatre
     */
    private SortedMap<Integer, SalleTheatre> lesSallesTheatres;

    /**
     * champ representant la liste des films
     */
    private SortedMap<Integer, Film> lesFilms;

    /**
     * chmap representant la liste des piceces de theatre
     */
    private SortedMap<Integer, PieceTheatre> lesPieces;

    /**
     * Constructeur de la classe
     * Initialise 4 salles standards et 4 salle de theatre
     */
    public GestionProgrammationSemaine() {
        Salle s1 = new Salle("salle n1", 250, 10.70);
        Salle s2 = new Salle("salle n2", 250, 10.70);
        Salle s3 = new Salle("salle n3", 250, 10.70);
        Salle s4 = new Salle("salle n4", 250, 10.70);

        SalleTheatre st1 = new SalleTheatre("teatre n1", 170, 30.5, 35, 50.0);
        SalleTheatre st2 = new SalleTheatre("teatre n2", 170, 30.5, 35, 50.0);
        SalleTheatre st3 = new SalleTheatre("teatre n3", 170, 30.5, 35, 50.0);
        SalleTheatre st4 = new SalleTheatre("teatre n4", 170, 30.5, 35, 50.0);


        this.lesSalles = new TreeMap<>();
        this.lesSallesTheatres = new TreeMap<>();
        this.lesFilms = new TreeMap<>();
        this.lesPieces = new TreeMap<>();

        lesSalles.put(s1.numéro, s1);
        lesSalles.put(s2.numéro, s2);
        lesSalles.put(s3.numéro, s3);
        lesSalles.put(s4.numéro, s4);

        lesSallesTheatres.put(st1.numéro, st1);
        lesSallesTheatres.put(st2.numéro, st2);
        lesSallesTheatres.put(st3.numéro, st3);
        lesSallesTheatres.put(st4.numéro, st4);

    }

    @Override
    public Film rechercherFilm(String titre, String realisateur) {
        Iterator<Integer> it = lesFilms.keySet().iterator();
        while (it.hasNext()) {
            int lIdDuFilm = it.next();

            if (lesFilms.get(lIdDuFilm).titre == titre && lesFilms.get(lIdDuFilm).getRealisateur() == realisateur) {
                return lesFilms.get(lIdDuFilm);
            }
        }
        return null;
    }

    @Override
    public void ajouterFilm(String titre, String realisateur, int duree) throws IllegalArgumentException {
        Film f = new Film(titre, realisateur, duree);
        try {
            if (!lesFilms.containsKey(f.getIdFilm())) {
                lesFilms.put(f.getIdFilm(), f);
            } else
                throw new IllegalArgumentException("Le film existe deja");
        } catch (ClassCastException | NullPointerException e1) {
            e1.getMessage();
        }
    }

    @Override
    public void ajouterInterprete(int numSpectacle, String interprete) throws IllegalArgumentException {
        Iterator<Integer> itFilm = lesFilms.keySet().iterator();
        boolean estFilm = true;
        boolean estPiece = true;

        // On itere sur les films pour tester l'existance de l'id du film
        while (itFilm.hasNext()) {
            int lIdDuFilm = itFilm.next();
            if (lIdDuFilm == numSpectacle) {
                lesFilms.get(lIdDuFilm).lesInterpretes.ajouterEnFin(interprete);
                // On modifie le boolean si on a trouve une concordance
                estFilm = false;
            }
        }

        Iterator<Integer> itPiece = lesPieces.keySet().iterator();

        // On itere sur les pieces pour tester l'existance de l'id de la piece
        // on test egalement si on a deja trouve une concordance, si c'est le cas on entre pas
        while (itPiece.hasNext() && estFilm) {
            int lIdDeLaPiece = itPiece.next();
            if (lIdDeLaPiece == numSpectacle) {
                lesPieces.get(lIdDeLaPiece).lesInterpretes.ajouterEnFin(interprete);
                // On modifie le boolean si on a trouve une concordance
                estPiece = false;
            }
        }

        // On teste si aucune concordance n'a ete trouve et si c'est le cas on leve nu Exception
        if (estFilm && estPiece) {
            throw new IllegalArgumentException("Spectacle inexistant");
        }
    }

    @Override
    public PieceTheatre rechercherPiece(String titre, String metteurEnScene) {
        Iterator<Integer> it = lesPieces.keySet().iterator();
        while (it.hasNext()) {
            int lIdDeLaPiece = it.next();

            if (lesPieces.get(lIdDeLaPiece).titre == titre && lesPieces.get(lIdDeLaPiece).getMetteurEnScene() == metteurEnScene) {
                return lesFilms.get(lIdDeLaPiece);
            }
        }
        return null;
    }

    @Override
    public void ajouterPiece(String titre, String metteurEnScene, int nbEntractes) {

    }

    @Override
    public void ajouterSeanceFilm(int idFilm, int jour, Horaire debut, int idSalle) {

    }

    @Override
    public boolean existeSeanceCeJour(int idPiece, int jour) {
        return false;
    }

    @Override
    public void ajouterSeanceTheatre(int idPiece, int jour, Horaire debut, int idSalle) {

    }

    @Override
    public double chiffreAffaires(int numSpectacle) {
        return 0;
    }

    @Override
    public double getTauxRemplissage(int numSpectacle) {
        return 0;
    }

    @Override
    public void vendrePlaceFilmTN(int idFilm, int jour, Horaire debut, int nbPlacesTN) {

    }

    @Override
    public void vendrePlaceFilmTR(int idFilm, int jour, Horaire debut, int nbPlacesTR) {

    }

    @Override
    public void vendrePlacePieceTN(int idPiece, int jour, int nbPlacesTN) {

    }

    @Override
    public void vendrePlaceFauteuilPiece(int idPiece, int jour, int nbFauteuils) {

    }

    @Override
    public String lesFilms() {
        return null;
    }

    @Override
    public String lesPieces() {
        return null;
    }

    @Override
    public String lesSallesFilm() {
        return null;
    }

    @Override
    public String lesSallesTheatre() {
        return null;
    }

    @Override
    public String lesSeancesTheatre(int idPiece) {
        return null;
    }

    @Override
    public String lesSeancesFilm(int idFilm) {
        return null;
    }

    @Override
    public int getNbPlacesDispo(int numSpectacle, int jour, int heures, int minutes) {
        return 0;
    }

    @Override
    public boolean existeFilm(int idFilm) {
        return false;
    }

    @Override
    public boolean existePiece(int idPiece) {
        return false;
    }

    @Override
    public boolean existeSeanceFilm(int idFilm, int jour, int heures, int minutes) {
        return false;
    }

    @Override
    public boolean existeSalleFilm(int idSalle) {
        return false;
    }

    @Override
    public boolean existeSalleTheatre(int idSalle) {
        return false;
    }

    @Override
    public int dureeFilm(int idFilm) {
        return 0;
    }

    @Override
    public boolean salleStandardDisponible(int jour, Horaire debut, int duree, int idSalle) {
        return false;
    }

    @Override
    public void reinitialiserProgrammation() {

    }

    @Override
    public int getNbFauteuilsDispo(int idPiece, int jour) {
        return 0;
    }

    @Override
    public int getNbPlacesDispo(int idPiece, int jour) {
        return 0;
    }

    @Override
    public boolean estUnFilm(int numSpectacle) {
        return false;
    }

    @Override
    public boolean estUnePiece(int numSpectacle) {
        return false;
    }

    @Override
    public Spectacle getSpectacle(int numSpectacle) {
        return null;
    }

    @Override
    public String toString() {
        return "GestionProgrammationSemaine{" +
                "lesSalles=" + lesSalles +
                ", lesSallesTheatres=" + lesSallesTheatres +
                ", lesFilms=" + lesFilms +
                ", lesPieces=" + lesPieces +
                '}';
    }
}
