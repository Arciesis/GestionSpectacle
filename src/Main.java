import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Main {
    public static void main(String args[]) {

        // write your code here
       GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
       gps.ajouterFilm("le titre d'un film","J.J Abrams", 150);
       gps.ajouterFilm("un autre titre", "Cristopher Nolan", 184);

       gps.ajouterInterprete(100,"JeNeSaisPlus");
       gps.ajouterInterprete(101,"bah la nonplus");
       System.out.println(gps.toString());
       //gps.ajouterInterprete(102,"bah la idem");





    }

}
