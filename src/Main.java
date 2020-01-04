
public class Main {
    public static void main(String args[]) {
        1GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
        int choixUtilisateur = -1;
        do {
            Console.affMenu();
            choixUtilisateur = Console.validInteger();

            switch (choixUtilisateur) {
                case 0:
                    gps.reinitialiserProgrammation();
                    break;
                case 1:

                    try {
                        String titre = Console.saisieUtilisateur("titre: ");
                        String realisateur = Console.saisieUtilisateur("realisateur: ");
                        int duree = Console.saisieUtilisateurNumeric("duree: ");
                        gps.ajouterFilm(titre, realisateur, duree);
                        System.out.println();

                        System.out.println(gps.lesFilms());
                        System.out.println();

                    } catch (IllegalArgumentException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 2:
                    try {
                        String titre = Console.saisieUtilisateur("titre: ");
                        String metteurEnScene = Console.saisieUtilisateur("metteur en scene: ");
                        int nbEntreactes = Console.saisieUtilisateurNumeric("nombre d'entractes: ");
                        gps.ajouterPiece(titre, metteurEnScene, nbEntreactes);
                        System.out.println();
                        System.out.println(gps.lesPieces());
                        System.out.println();
                    } catch (IllegalArgumentException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 3:
                    try {
                        System.out.println(gps.lesPieces());
                        System.out.println(gps.lesFilms());
                        System.out.println();
                        String interprete = Console.saisieUtilisateur("interprete: ");
                        int numSpectacle = Console.saisieUtilisateurNumeric("numero du spectacle: ");
                        gps.ajouterInterprete(numSpectacle, interprete);

                        System.out.println();
                        System.out.println("interprete ajoute");
                        System.out.println();
                    } catch (IllegalArgumentException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 4:

                    try {
                        if (Console.affAjouterSeanceFilm(gps)) {
                            System.out.println();
                            int idFilm = Console.saisieUtilisateurNumeric("idFilm: ");
                            int jour = Console.saisieUtilisateurNumeric("jour de diffusion: ");
                            int hd = Console.saisieUtilisateurNumeric("heure de debut: ");
                            int md = Console.saisieUtilisateurNumeric("minutes de debut: ");
                            int idSalle = Console.saisieUtilisateurNumeric("id de la salle: ");

                            gps.ajouterSeanceFilm(idFilm, jour, new Horaire(hd, md), idSalle);
                            System.out.println("Seance ajoute");
                        }
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 5:
                    try {
                        if (Console.affAjouterSeancePieceTheatre(gps)) {
                            System.out.println();
                            int idPiece = Console.saisieUtilisateurNumeric("idPiece: ");
                            int jour = Console.saisieUtilisateurNumeric("jour de diffusion: ");
                            int hd = Console.saisieUtilisateurNumeric("heure de debut: ");
                            int md = Console.saisieUtilisateurNumeric("minutes de debut: ");
                            int idSalle = Console.saisieUtilisateurNumeric("id de la salle: ");

                            gps.ajouterSeanceTheatre(idPiece, jour, new Horaire(hd, md), idSalle);
                            System.out.println();
                            System.out.println("Seance ajoute");
                            System.out.println();
                        }
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 6:
                    try {
                        System.out.println(gps.lesFilms());
                        int idFilm = Console.saisieUtilisateurNumeric("idFilm: ");
                        String lesSeances = gps.lesSeancesFilm(idFilm);
                        if (lesSeances != null) {
                            System.out.println(lesSeances);

                            int jour = Console.saisieUtilisateurNumeric("jour: ");
                            int heures = Console.saisieUtilisateurNumeric("heures: ");
                            int minutes = Console.saisieUtilisateurNumeric("minutes: ");

                            System.out.println(gps.getNbPlacesDispo(idFilm, jour, heures, minutes));

                            int nbPlacesTN = Console.saisieUtilisateurNumeric("nombre de places tarif normal: ");
                            int mbPlacesTarifsReduit = Console.saisieUtilisateurNumeric("nombre de places tarif reduit: ");

                            gps.vendrePlaceFilmTN(idFilm, jour, new Horaire(heures, minutes), nbPlacesTN);
                            gps.vendrePlaceFilmTR(idFilm, jour, new Horaire(heures, minutes), nbPlacesTN);

                            System.out.println("Places achetees");

                        } else System.out.println("Aucune Seance");

                    } catch (IllegalArgumentException | ArithmeticException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 7:
                    try {
                        System.out.println(gps.lesPieces());
                        int idPiece = Console.saisieUtilisateurNumeric("idPiece: ");
                        String lesSeances = gps.lesSeancesTheatre(idPiece);
                        if (lesSeances != null) {
                            System.out.println(lesSeances);

                            int jour = Console.saisieUtilisateurNumeric("jour: ");

                            System.out.println("Nombre de places restantes" + gps.getNbPlacesDispo(idPiece, jour));

                            int nbPlacesTN = Console.saisieUtilisateurNumeric("nombre de places tarif normal: ");
                            int nbFauteuils = Console.saisieUtilisateurNumeric("nombre de fauteuils: ");

                            gps.vendrePlacePieceTN(idPiece, jour, nbPlacesTN);
                            gps.vendrePlaceFauteuilPiece(idPiece, jour, nbFauteuils);

                            System.out.println("Places achetees");

                        } else System.out.println("Aucune Seance");

                    } catch (IllegalArgumentException | ArithmeticException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 8:
                    try {
                        System.out.println(gps.lesFilms());
                        System.out.println();
                        System.out.println(gps.lesPieces());

                        int idSpectacle = Console.saisieUtilisateurNumeric("numero du spectacle: ");
                        System.out.println("chiffre d'affaire : " + gps.chiffreAffaires(idSpectacle));
                        System.out.println("taux de remaplissage" + gps.getTauxRemplissage(idSpectacle));

                    } catch (IllegalArgumentException e) {
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;

            }

        } while (choixUtilisateur != 9);


    }

}
