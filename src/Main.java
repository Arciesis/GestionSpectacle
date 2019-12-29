import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Main {
    public static void main(String args[]) {

        // write your code here
       GestionProgrammationSemaine gps = new GestionProgrammationSemaine();
       gps.ajouterFilm("le titre d'un film","J.J Abrams", 150);
       System.out.println(gps.toString());


    }

}
