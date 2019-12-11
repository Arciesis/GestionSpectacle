import java.time.LocalDateTime;

public class Creneau {

    private static int nextIdCreneau;

    /**
     * initialiser a 1 et en autoincrementation de 1
     */
    private int idCreneau;

    /**
     * jour de la semaine compris entre 1 et 7
     * respectivement 1 = lundi etc...
     */
    private int jour;

    /**
     * Champ representant l'horaire de fin du creneau
     */
    private Horaire heureFin;

    /**
     * Champ representant l'Horaire de Debut
     */
    private Horaire heureDebut;

    static {nextIdCreneau=1;}
    {idCreneau=nextIdCreneau; nextIdCreneau++;}


    /**
     * Constructeur de laq classe Creneau
     * @param jour le jour de la semaine compris entre 1 et 7
     * @param heureDebut l'heure de debut du creneau
     * @param heureFin l'heure de fin du creneau
     */
    public Creneau(int jour, Horaire heureDebut, Horaire heureFin){
        assert jour >= 1 && jour <= 7;
        this.jour=jour;
        this.heureDebut=heureDebut;
        this.heureFin=heureFin;
    }
}
