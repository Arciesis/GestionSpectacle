import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Main {
    public static void main(String args[]) {

        // write your code here
       GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
       gps.ajouterFilm("le titre d'un film","J.J Abrams", 150);
       gps.ajouterFilm("un autre titre", "Cristopher Nolan", 184);


        gps.ajouterInterprete(100, "JeNeSaisPlus");
        gps.ajouterInterprete(101, "bah la nonplus");

        gps.ajouterPiece("les fourberies de scapin", "didier",2);
        gps.ajouterPiece("Romeo et Juliette", "didier",2);

        /*
        Spectacle lordOfRings = new Film("Le Seignieur des Anneaux", 180, "peter Jackson", "Vigo");
        Salle A=new Salle("A1",500,10.70);
        ((Film) lordOfRings).ajouterSeanceFilm(new SeanceFilm(new Creneau(1,new Horaire(13,00),new Horaire(14,00)),A,200,80));
        ((Film) lordOfRings).ajouterSeanceFilm(new SeanceFilm(new Creneau(1,new Horaire(10,00),new Horaire(13,00)),A,200,80));
        SalleTheatre B=new SalleTheatre("B1",500,15.0,250,18.50);
        Spectacle LesMiserables = new PieceTheatre("les miserables","hugo",2,"rose","paul");
        ((PieceTheatre) LesMiserables).ajouterSeanceTheatre(new SeanceTheatre(new Creneau(1,new Horaire(13,00),new Horaire(14,00)),200,B,80));
        ((PieceTheatre) LesMiserables).ajouterSeanceTheatre(new SeanceTheatre(new Creneau(2,new Horaire(10,00),new Horaire(12,00)),100,B,80));
        */

        //deja tester
        System.out.println(gps.lesFilms());
        System.out.println(gps.lesPieces());
        System.out.println(gps.lesSallesFilm());
        System.out.println(gps.lesSallesTheatre());
        System.out.println("");


        //a tester en ajoutant des seance aux film et pièce créer precédament avec la methode "ajouterSeance..." de gps
        System.out.println(gps.lesSeancesFilm(103));
        System.out.println(gps.lesSeancesTheatre(103));

        gps.ajouterPiece("Mon cul lulu", "J'en connais pas dsl",4);
        System.out.println(gps.toString());
        gps.ajouterInterprete(1000,"JEAN JACQUES DE MON miraille");
        System.out.println(gps.rechercherPiece("Mon cul lulu","'en connais pas dsl"));

    }

}
