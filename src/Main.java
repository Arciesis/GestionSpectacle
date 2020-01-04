import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Main {
    public static void main(String args[]) {

        // write your code here
        GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
        gps.ajouterFilm("le titre d'un film", "J.J Abrams", 150);
        gps.ajouterFilm("un autre titre", "Cristopher Nolan", 184);


        gps.ajouterInterprete(100, "JeNeSaisPlus");
        gps.ajouterInterprete(101, "bah la nonplus");
        gps.ajouterSeanceFilm(100,1,new Horaire(14,30),10);
        gps.ajouterSeanceFilm(100,2,new Horaire(14,30),20);



        gps.ajouterPiece("les fourberies de scapin", "didier",2);
        gps.ajouterPiece("Romeo et Juliette", "didier",2);
        gps.ajouterSeanceTheatre(1001,4,new Horaire(20,5),70);
        gps.ajouterSeanceTheatre(1001,5,new Horaire(20,5),80);





        System.out.println(gps.getNbPlacesDispo(100,1,14,30));
        System.out.println(gps.getNbPlacesDispo(100,2,14,30));

        System.out.println(gps.getNbPlacesDispo(1001,4,19,5));
        System.out.println(gps.getNbPlacesDispo(1001,5,18,5));


        /*System.out.println("");


        System.out.println(gps.lesSeancesFilm(100));
        System.out.println("");

        System.out.println(gps.lesSeancesTheatre(1001));*/



    }

}
