import java.util.Objects;

public class Horaire {

    /**
     * Champ minutes de la classe Horaire representant les minutes de l'Horaire
     */
    private int minutes;

    /**
     *  Champ minutes de la classe Horaire representant les heures de l'Horaire
     */
    private int heures;

    /**
     * Constructeur de la classe
     * @param minutes les minutes de l'horaire
     * @param heures les heures de l'horaire
     */
    public Horaire(int minutes, int heures){
        this.minutes=minutes;
        this.heures=heures;
    }

    /**
     * getter des minutes
     * @return les minutes de l'horaire
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * getter des heures
     * @return les heures de l'horaire
     */
    public int getHeures() {
        return heures;
    }


    @Override
    public String toString() {
        return "Horaire{" +
                "minutes=" + minutes +
                ", heures=" + heures +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horaire horaire = (Horaire) o;
        return minutes == horaire.minutes &&
                heures == horaire.heures;
    }

}
