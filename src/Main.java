public class Main {
    public static void main(String args[]){
        // write your code here
        Creneau c = new Creneau(1,new Horaire(11,55),new Horaire(14,30));
        System.out.println(c.calculerDuree());
        Salle s = new Salle("salle n1",100,10.70f);
        s.ajouterCreneau(c);
        System.out.println(s.toString());
    }

}
