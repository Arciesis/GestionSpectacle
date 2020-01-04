
public class Main {
    public static void main(String args[]) {

        // write your code here
        GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
        gps.ajouterFilm("le titre d'un film", "J.J Abrams", 150);
        gps.ajouterFilm("un autre titre", "Cristopher Nolan", 184);


        gps.ajouterInterprete(100, "JeNeSaisPlus");
        gps.ajouterInterprete(101, "bah la nonplus");
        gps.ajouterSeanceFilm(100, 1, new Horaire(14, 30), 10);
        gps.ajouterSeanceFilm(100, 1, new Horaire(14, 30), 20);


        gps.ajouterPiece("les fourberies de scapin", "didier", 2);
        gps.ajouterPiece("Romeo et Juliette", "didier", 2);
        gps.ajouterSeanceTheatre(1001, 4, new Horaire(20, 5), 70);
        gps.ajouterSeanceTheatre(1001, 4, new Horaire(20, 5), 80);


        gps.vendrePlaceFilmTN(100, 1, new Horaire(14, 30), 46);
        System.out.println(gps.getNbPlacesDispo(100, 1, 14, 30));
        gps.vendrePlaceFilmTR(100, 1, new Horaire(14, 30), 25);
        System.out.println(gps.getNbPlacesDispo(100, 1, 14, 30));

        gps.vendrePlacePieceTN(1001, 4, 10);
        gps.vendrePlaceFauteuilPiece(1001,4,160);
        System.out.println(gps.getNbPlacesDispo(1001, 4, 18, 5));


        /*System.out.println("");


        System.out.println(gps.lesSeancesFilm(100));
        System.out.println("");

        System.out.println(gps.lesSeancesTheatre(1001));*/


    }

}
