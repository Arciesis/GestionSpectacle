import java.util.*;

public class Spectacle {
    protected int idSpectacle;
    protected String titre;
    protected Interpretes lesInterpretes;

    protected SortedSet<Seance> GestionSeanceSpectacle;

    /**
     * Constructeur de la classe
     *
     * @param titre          le titre du spectacle
     * @param lesInterpretes la liste des interpretes du spectacle
     */
    public Spectacle(String titre, String... lesInterpretes) {
        this.titre = titre;
        this.lesInterpretes = new Interpretes();
        GestionSeanceSpectacle = new TreeSet<Seance>();

        for (String item :
                lesInterpretes) {
            this.lesInterpretes.ajouterEnFin(item);
        }
    }

    /**
     *
     * @param jour
     * @param HoraireDebut
     * @return s, la séance correspondante si elle est présente
     */
    public Seance rechercheSeance(int jour, Horaire HoraireDebut) {
        for (Seance s : GestionSeanceSpectacle) {
            if ((s.leCreneau.getJour() == jour) && (s.leCreneau.getHeureDebut().equals(HoraireDebut))) {
                return s;
            }
        }
        return null;
    }

    /**
     *
     * @param jour
     * @return listeSeance , la liste des séance ppréente ce jour
     */
    public ArrayList<Seance> rechercheListeSeance(int jour) {
        ArrayList<Seance> listeSeances = new ArrayList<Seance>();
        for (Seance s : GestionSeanceSpectacle) {
            if (s.leCreneau.getJour() == jour) {
                listeSeances.add(s);
            }
        }
        return listeSeances;
    }


}
