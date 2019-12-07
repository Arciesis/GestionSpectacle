import java.util.ArrayList;

public class Interpretes {
    /**
     * Unique champ de la classe contenant les Interpretes
     */
    private ArrayList<String> listInterpretes;

    /**
     * Constructeur de la classe
     * Construit une liste vide
     */
    public Interpretes(){
        this.listInterpretes = new ArrayList<>();
    }

    /**
     * Ajoute un interprete a la liste des interpretes
     * Les doublons sont possibles
     *
     * @param inter
     * @return true comme specifie dans ArrayList.add(E e)
     */
    public boolean ajouterEnFin(String inter){
        return this.listInterpretes.add(inter);
    }


}