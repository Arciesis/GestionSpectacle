import java.util.*;

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


        this.lesSalles = new TreeMap<Integer, Salle>();
        this.lesSallesTheatres = new TreeMap<Integer, SalleTheatre>();
        this.lesFilms = new TreeMap<Integer, Film>();
        this.lesPieces = new TreeMap<Integer, PieceTheatre>();

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
            if (rechercherFilm(titre, realisateur) == null) {
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
                return lesPieces.get(lIdDeLaPiece);
            }
        }
        return null;
    }

    @Override
    public void ajouterPiece(String titre, String metteurEnScene, int nbEntractes) throws IllegalArgumentException {
        PieceTheatre p = new PieceTheatre(titre, metteurEnScene, nbEntractes);
        try {
            if (rechercherPiece(titre, metteurEnScene) == null) {
                lesPieces.put(p.getIdPieceTheatre(), p);
            } else
                throw new IllegalArgumentException("Le film existe deja");
        } catch (ClassCastException | NullPointerException e1) {
            e1.getMessage();
        }
    }


    /**
     * Calcule de l'horraire de fin d'un film ou pièce de theatre par rapport à une horraire de début donnée, un jour et une durée
     *
     * @param debut
     * @return un creneau correspondant au , jour , horraire de début et fin
     */
    public Creneau CalculHeurreFin(int jour, Horaire debut, int duree) {
        int h = duree / 60;
        int m = duree % 60;
        int heureFin = debut.getHeures() + h;
        int minuteFin = debut.getMinutes() + m;

        if (minuteFin > 59) {
            heureFin += 1;
            minuteFin = minuteFin - 60;


            if (heureFin > 23) {
                jour += 1;
                heureFin = heureFin - 24;
            }
        }

        Horaire horaireFin = new Horaire(heureFin, minuteFin);
        Creneau c = new Creneau(jour, debut, horaireFin);
        return c;
    }

    @Override
    public void ajouterSeanceFilm(int idFilm, int jour, Horaire debut, int idSalle) throws IllegalArgumentException, IllegalStateException {

        // on test l'existnce du film
        Set<Integer> myKeys = this.lesFilms.keySet();
        if (myKeys.contains(idFilm)) {
            Film film = this.lesFilms.get(idFilm);

            //on recupère ici le Creneau avec l'horraire de fin (et le jour ex:  horaireDebut=22h30 , horaireFin=00h30 on est plus sur le meme jour)
            // il faut que le créneau reste sur le meme jour
            int duree = this.dureeFilm(idFilm);
            Creneau c = (this.CalculHeurreFin(jour, debut, duree));

            if (c.getJour() != jour) {
                throw new IllegalStateException("Créneau indisponible");
            } else {
                //test si la salle existe bien, si oui on ajoute la séance à l'ensemble des séance du film avec la salle corespondante et on bloque également le créneau sur la salle si possible
                // "ajouterSeanceFilm" se charge déja de blouer le créneaux pour la salle passer en parametre
                Set<Integer> myKeys2 = this.lesSalles.keySet();
                if (myKeys2.contains(idSalle)) {
                    Salle salle = this.lesSalles.get(idSalle);
                    if (salle.estDisponible(c)) {
                        film.ajouterSeanceFilm(new SeanceFilm(c, salle, 0, 0));
                    } else {
                        throw new IllegalStateException("Créneau indisponible");
                    }
                } else {
                    throw new IllegalArgumentException("Salle inexistante");
                }
            }
        } else {
            throw new IllegalArgumentException("Film inexistant");
        }

    }

    @Override
    public boolean existeSeanceCeJour(int idPiece, int jour) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesPieces.keySet();
        if (myKeys.contains(idPiece)) {
            PieceTheatre p = lesPieces.get(idPiece);

            Iterator<Seance> it = p.GestionSeanceSpectacle.iterator();
            while (it.hasNext()) {
                Seance s = it.next();
                if (s.leCreneau.getJour() == jour) {
                    return true;
                }
            }
        } else {
            throw new IllegalArgumentException("Piece inexistante");
        }
        return false;
    }

    @Override
    public void ajouterSeanceTheatre(int idPiece, int jour, Horaire debut, int idSalle) throws IllegalArgumentException, IllegalStateException {

        // on test l'existnce de la pièce
        Set<Integer> myKeys = this.lesPieces.keySet();
        if (myKeys.contains(idPiece)) {
            PieceTheatre pieceTheatre = this.lesPieces.get(idPiece);

            //on recupère ici le Creneau avec l'horraire de fin (et le jour ex:  horaireDebut=22h30 , horaireFin=01h30 on est plus sur le meme jour)
            // il faut que le créneau reste sur le meme jour
            Creneau c = new Creneau(jour, debut, new Horaire(debut.getHeures() + 3, debut.getMinutes()));
            if (c.getHeureFin().getHeures() > 23) {
                throw new IllegalStateException("Créneau indisponible");
            } else {
                //test si la salle existe bien, si oui on ajoute la séance à l'ensemble des séance du film avec la salle corespondante et on bloque également le créneau sur la salle si possible
                // "ajouterSeanceFilm" se charge déja de blouer le créneaux pour la salle passer en parametre
                Set<Integer> myKeys2 = this.lesSallesTheatres.keySet();
                if (myKeys2.contains(idSalle)) {
                    SalleTheatre salle = this.lesSallesTheatres.get(idSalle);

                    //test si le jour est deja une clé dans l'ensemble des créneaux de la salle et si il sagit de la meme salle, si oui alors c'est qu'il y a deja un créneau pour ce jour dans la salle
                    //il ne peut y avoir qu'un seul créneau par jour de 3h
                    if (salle.lesCreneauxOccupes.containsKey(jour)) {
                        throw new IllegalStateException("Créneau indisponible pour dans cette salle");
                    } else {
                        pieceTheatre.ajouterSeanceTheatre(new SeanceTheatre(c, 0, salle, 0));
                    }
                } else {
                    throw new IllegalArgumentException("Salle inexistante");
                }
            }
        } else {
            throw new IllegalArgumentException("Film inexistant");
        }

    }

    @Override
    public double chiffreAffaires(int numSpectacle) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesFilms.keySet();
        Set<Integer> myKeys2 = this.lesPieces.keySet();

        if (myKeys.contains(numSpectacle)) {
            Film spectacle = lesFilms.get(numSpectacle);
            return spectacle.ChiffreAffaire();

        } else if (myKeys2.contains(numSpectacle)) {
            Iterator<Integer> itPiece = lesPieces.keySet().iterator();
            PieceTheatre spectacle2 = lesPieces.get(numSpectacle);
            return spectacle2.ChiffreAffaire();
        } else {
            throw new IllegalArgumentException("Spectacle inexistant");
        }

    }

    @Override
    public double getTauxRemplissage(int numSpectacle) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesFilms.keySet();
        Set<Integer> myKeys2 = this.lesPieces.keySet();

        if (myKeys.contains(numSpectacle)) {
            Film spectacle = lesFilms.get(numSpectacle);
            return spectacle.tauxRemplissageMoyenSpectacle();

        } else if (myKeys2.contains(numSpectacle)) {
            Iterator<Integer> itPiece = lesPieces.keySet().iterator();
            PieceTheatre spectacle2 = lesPieces.get(numSpectacle);
            return spectacle2.tauxRemplissageMoyenSpectacle();
        } else {
            throw new IllegalArgumentException("Spectacle inexistant");
        }
    }

    @Override
    public void vendrePlaceFilmTN(int idFilm, int jour, Horaire debut, int nbPlacesTN) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesFilms.keySet();
        boolean trouve = false;

        //test l'existence du film
        if (myKeys.contains(idFilm)) {
            Film f = this.lesFilms.get(idFilm);
            Iterator<Seance> it = f.GestionSeanceSpectacle.iterator();

            //regarde pour chaque seance si tout correspond et si oui vend le nombre de placesTN
            //trouve= true pour indiquer que la séance a bien été trouvée
            while (it.hasNext()) {
                SeanceFilm seanceFilm = (SeanceFilm) it.next();
                if (seanceFilm.leCreneau.getJour() == jour) {
                    if (seanceFilm.leCreneau.getHeureDebut().getHeures() == debut.getHeures() && seanceFilm.leCreneau.getHeureDebut().getMinutes() == debut.getMinutes()) {
                        seanceFilm.vendrePlacesTN(nbPlacesTN);
                        trouve = true;
                    }
                }
            }

            if (trouve == false) {
                throw new IllegalArgumentException("jour ou horaire inexistant");
            }

        } else {
            throw new IllegalArgumentException("Film inexistant");
        }
    }

    @Override
    public void vendrePlaceFilmTR(int idFilm, int jour, Horaire debut, int nbPlacesTR) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesFilms.keySet();
        boolean trouve = false;

        //test l'existence du film
        if (myKeys.contains(idFilm)) {
            Film f = this.lesFilms.get(idFilm);
            Iterator<Seance> it = f.GestionSeanceSpectacle.iterator();

            //regarde pour chaque seance si tout correspond et si oui vend le nombre de placesTR
            //trouve= true pour indiquer que la séance a bien été trouvée
            while (it.hasNext()) {
                SeanceFilm seanceFilm = (SeanceFilm) it.next();
                if (seanceFilm.leCreneau.getJour() == jour) {
                    if (seanceFilm.leCreneau.getHeureDebut().getHeures() == debut.getHeures() && seanceFilm.leCreneau.getHeureDebut().getMinutes() == debut.getMinutes()) {
                        seanceFilm.vendrePlacesTR(nbPlacesTR);
                        trouve = true;
                    }
                }
            }

            if (trouve == false) {
                throw new IllegalArgumentException("jour ou horaire inexistant");
            }

        } else {
            throw new IllegalArgumentException("Film inexistant");
        }
    }

    @Override
    public void vendrePlacePieceTN(int idPiece, int jour, int nbPlacesTN) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesPieces.keySet();
        boolean trouve = false;

        //test l'existence de la pièce
        if (myKeys.contains(idPiece)) {
            PieceTheatre pieceTheatre = this.lesPieces.get(idPiece);
            Iterator<Seance> it = pieceTheatre.GestionSeanceSpectacle.iterator();

            //regarde pour chaque seance si le jour correspond et si oui vend le nombre de placesTN
            //trouve= true pour indiquer que la séance a bien été trouvée
            while (it.hasNext()) {
                SeanceTheatre seanceTheatre = (SeanceTheatre) it.next();
                if (seanceTheatre.leCreneau.getJour() == jour) {
                    seanceTheatre.vendrePlacesTN(nbPlacesTN);
                    trouve = true;
                }
            }


            if (trouve == false) {
                throw new IllegalArgumentException("jour inexistant");
            }

        } else {
            throw new IllegalArgumentException("Pièce inexistante");
        }
    }

    @Override
    public void vendrePlaceFauteuilPiece(int idPiece, int jour, int nbFauteuils) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesPieces.keySet();
        boolean trouve = false;

        //test l'existence de la pièce
        if (myKeys.contains(idPiece)) {
            PieceTheatre pieceTheatre = this.lesPieces.get(idPiece);
            Iterator<Seance> it = pieceTheatre.GestionSeanceSpectacle.iterator();

            //regarde pour chaque seance si le jour correspond et si oui vend le nombre de fauteuils nbFauteuils
            //trouve= true pour indiquer que la séance a bien été trouvée
            while (it.hasNext()) {
                SeanceTheatre seanceTheatre = (SeanceTheatre) it.next();
                if (seanceTheatre.leCreneau.getJour() == jour) {
                    seanceTheatre.vendrePlacesTN(nbFauteuils);
                    trouve = true;
                }
            }
        }


    }

    @Override
    public String lesFilms() {
        StringBuilder nomFilms = new StringBuilder("Les films présents sont : { ");
        Iterator<Integer> itFilm = this.lesFilms.keySet().iterator();
        while (itFilm.hasNext()) {
            int idfilm = itFilm.next();
            Film film = this.lesFilms.get(idfilm);
            nomFilms.append(film.titre).append(" ; ");
        }
        nomFilms.append("}");
        return nomFilms.toString();
    }

    @Override
    public String lesPieces() {
        StringBuilder nomPieces = new StringBuilder("Les Pièces de théatre présentes sont : { ");
        Iterator<Integer> itPiece = this.lesPieces.keySet().iterator();
        while (itPiece.hasNext()) {
            int idPiece = itPiece.next();
            PieceTheatre Piece = this.lesPieces.get(idPiece);
            nomPieces.append(Piece.getTitre()).append(" ; ");
        }
        nomPieces.append("}");
        return nomPieces.toString();
    }

    @Override
    public String lesSallesFilm() {
        String nomSalle = "Les Salles présentes sont : { ";
        Iterator<Integer> itSalle = lesSalles.keySet().iterator();
        while (itSalle.hasNext()) {
            int idSalle = itSalle.next();
            Salle salle = this.lesSalles.get(idSalle);
            nomSalle = nomSalle + salle.getNom() + " ; ";
        }
        nomSalle += "}";
        return nomSalle;
    }

    @Override
    public String lesSallesTheatre() {
        String nomSalleTheatre = "Les Salles de théatre présentes sont : { ";
        Iterator<Integer> itSalletheatre = lesSallesTheatres.keySet().iterator();
        while (itSalletheatre.hasNext()) {
            int idSalletheatre = itSalletheatre.next();
            SalleTheatre salletheatre = this.lesSallesTheatres.get(idSalletheatre);
            nomSalleTheatre = nomSalleTheatre + salletheatre.getNom() + " ; ";
        }
        nomSalleTheatre += "}";
        return nomSalleTheatre;
    }

    @Override
    public String lesSeancesTheatre(int idPiece) throws IllegalArgumentException {
        String SeanceTheatre = "Les séances de théatre présentes sont : {    ";
        Set<Integer> myKeys = this.lesPieces.keySet();

        if (myKeys.contains(idPiece)) {
            PieceTheatre pieceTheatre = this.lesPieces.get(idPiece);
            for (Seance s : pieceTheatre.GestionSeanceSpectacle) {
                SeanceTheatre = SeanceTheatre + s.toString() + " ; ";
            }
            SeanceTheatre += "   }";
            return SeanceTheatre;
        } else {
            throw new IllegalArgumentException("Pièce inéxistante");
        }
    }

    @Override
    public String lesSeancesFilm(int idFilm) throws IllegalArgumentException {
        String SeanceFlim = "Les séances de films présentes sont : {    ";
        Set<Integer> myKeys = this.lesFilms.keySet();

        if (myKeys.contains(idFilm)) {
            Film film = this.lesFilms.get(idFilm);
            for (Seance s : film.GestionSeanceSpectacle) {
                SeanceFlim = SeanceFlim + s.toString() + " ; ";
            }
            SeanceFlim += "   }";
            return SeanceFlim;
        } else {
            throw new IllegalArgumentException("Film inéxistant");
        }
    }

    @Override
    public int getNbPlacesDispo(int numSpectacle, int jour, int heures, int minutes) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesFilms.keySet();
        Set<Integer> myKeys2 = this.lesPieces.keySet();

        if (myKeys.contains(numSpectacle)) {
            // initialisation de la seance que l'on cherche, est egal a null si il n'y a pas de correspondance
            SeanceFilm maSeanace = (SeanceFilm) this.lesFilms.get(numSpectacle).rechercheSeance(jour, new Horaire(heures, minutes));

            // Recherche si la seance existe bel et bien
            if (maSeanace != null) {
                int nbPlacesTotal = maSeanace.getLaSalle().getPlaces();
                int nbPLacesVendues = maSeanace.getNbPlacesVenduesTarifNormal() + maSeanace.getNbplacesTarifReduit();
                return nbPlacesTotal - nbPLacesVendues;

            } else throw new IllegalArgumentException("Seance inexistante");
        } else if (myKeys2.contains(numSpectacle)) {
            return this.getNbPlacesDispo(numSpectacle, jour);

        } else throw new IllegalArgumentException("Spectacle inexistant");
    }

    @Override
    public boolean existeFilm(int idFilm) {
        if (lesFilms.containsKey(idFilm)) {
            return true;
        } else return false;
    }

    @Override
    public boolean existePiece(int idPiece) {
        if (lesPieces.containsKey(idPiece))
            return true;
        else return false;
    }

    @Override
    public boolean existeSeanceFilm(int idFilm, int jour, int heures, int minutes) throws IllegalArgumentException {
        if (lesFilms.containsKey(idFilm)) {
            Film s = lesFilms.get(idFilm);
            for (Seance item :
                    s.getGestionSeanceSpectacle()) {

//                Horaire hd = new Horaire(heures, minutes);
//                Creneau c = new Creneau(jour,hd,)

                if (item.getLeCreneau().getJour() == jour){
                    if (item.getLeCreneau().getHeureDebut().getHeures() == heures){
                        if (item.getLeCreneau().getHeureDebut().getMinutes() == minutes){
                            return true;
                        }
                    }
                }
            }
            return false;
        } else throw new IllegalArgumentException("film inexistant");

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
    public int dureeFilm(int idFilm) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesFilms.keySet();
        if (myKeys.contains(idFilm)) {
            return lesFilms.get(idFilm).getDuree();
        } else {
            throw new IllegalArgumentException(" Film inexistant ");
        }

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
    public int getNbPlacesDispo(int idPiece, int jour) throws IllegalArgumentException {
        Set<Integer> myKeys = this.lesPieces.keySet();
        SeanceTheatre maSeance = null;

        if (!this.lesPieces.get(idPiece).rechercheListeSeance(jour).isEmpty()) {

            //On ne recupere qu'une seule seance car c'est une piece de theatre
            maSeance = (SeanceTheatre) this.lesPieces.get(idPiece).rechercheListeSeance(jour).get(0);
        } else throw new IllegalArgumentException("Seance inexistante ce jour ci");


        // test si la piece existe
        if (myKeys.contains(idPiece)) {

            //test si la seance existe
            if (this.existeSeanceCeJour(idPiece, jour)) {

                int nbPlacesTotal = maSeance.getLaSalleTheatre().places;
                int placesVendues = maSeance.getNbPlacesVenduesTarifNormal();
                return nbPlacesTotal - placesVendues;

            } else throw new IllegalArgumentException("Seance inexistante");
        } else throw new IllegalArgumentException("Piece inexistante");
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
