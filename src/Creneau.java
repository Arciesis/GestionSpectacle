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
    private LocalDateTime heureFin;
    private LocalDateTime heureDebut;

    static {nextIdCreneau=1;}
    {idCreneau=nextIdCreneau; nextIdCreneau++;}


    /**
     * Constructeur de laq classe Creneau
     * @param jour
     * @param heureDebut
     * @param heureFin
     */
    public Creneau(int jour, LocalDateTime heureDebut, LocalDateTime heureFin){
        assert jour >= 1 && jour <= 7;
        this.jour=jour;
        this.heureDebut=heureDebut;
        this.heureFin=heureFin;
    }
}
