
public class Main {
    public static void main(String args[]) {

        // write your code here
//        GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
//        gps.ajouterFilm("le titre d'un film", "J.J Abrams", 150);
//        gps.ajouterFilm("un autre titre", "Cristopher Nolan", 184);
//
//
//        gps.ajouterInterprete(100, "JeNeSaisPlus");
//        gps.ajouterInterprete(101, "bah la nonplus");
//        gps.ajouterSeanceFilm(100, 1, new Horaire(14, 30), 10);
//        gps.ajouterSeanceFilm(100, 1, new Horaire(14, 30), 20);
//
//
//        gps.ajouterPiece("les fourberies de scapin", "didier", 2);
//        gps.ajouterPiece("Romeo et Juliette", "didier", 2);
//        gps.ajouterSeanceTheatre(1001, 4, new Horaire(20, 5), 70);
//        gps.ajouterSeanceTheatre(1001, 4, new Horaire(20, 5), 80);
//
//
//        gps.vendrePlaceFilmTN(100, 1, new Horaire(14, 30), 46);
//        System.out.println(gps.getNbPlacesDispo(100, 1, 14, 30));
//        gps.vendrePlaceFilmTR(100, 1, new Horaire(14, 30), 25);
//        System.out.println(gps.getNbPlacesDispo(100, 1, 14, 30));
//
//        gps.vendrePlacePieceTN(1001, 4, 10);
//        gps.vendrePlaceFauteuilPiece(1001,4,160);
//        System.out.println(gps.getNbPlacesDispo(1001, 4, 18, 5));


        /*System.out.println("");


        System.out.println(gps.lesSeancesFilm(100));
        System.out.println("");

        System.out.println(gps.lesSeancesTheatre(1001));*/
        GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
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

                    } catch (IllegalArgumentException e){
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
                    } catch (IllegalArgumentException e){
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
                        System.out.println("interprete ajoute");
                        System.out.println();
                    }catch (IllegalArgumentException e){
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 4:

                    try {
                        if (Console.affAjouterSeanceFilm(gps)){
                        System.out.println();
                        int idFilm = Console.saisieUtilisateurNumeric("idFilm: ");
                        int jour = Console.saisieUtilisateurNumeric("jour de diffusion: ");
                        int hd = Console.saisieUtilisateurNumeric("heure de debut: ");
                        int md = Console.saisieUtilisateurNumeric("minutes de debut: ");
                        int idSalle = Console.saisieUtilisateurNumeric("id de la salle: ");

                        gps.ajouterSeanceFilm(idFilm, jour, new Horaire(hd, md), idSalle);
                    } catch (IllegalArgumentException | IllegalStateException e){
                        System.out.println();
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
            }

        } while (choixUtilisateur != 9);


    }

}
