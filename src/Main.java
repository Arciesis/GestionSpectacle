public class Main {
    public static void main(String args[]){

        // write your code here
        Creneau c = new Creneau(1,new Horaire(11,30),new Horaire(13,30));
        System.out.println(c.calculerDuree());
        Salle s = new Salle("salle n1",100,10.70);

        //doit retourner -1
        System.out.println(c.compareTo(new Creneau(1,new Horaire(10,30),new Horaire(11,30))));

        //doit retourner 1
        System.out.println(c.compareTo(new Creneau(1,new Horaire(13,30),new Horaire(15,30))));

        //doit retourner 0
        System.out.println(c.compareTo(new Creneau(1,new Horaire(11,35),new Horaire(12,30))));

        //doit retourner 0
        System.out.println(c.compareTo(new Creneau(1,new Horaire(10,30),new Horaire(12,30))));

        //doit retourner 0
        System.out.println(c.compareTo(new Creneau(1,new Horaire(12,30),new Horaire(14,30))));

        // System.out.println(s.toString());
        s.ajouterCreneau(new Creneau(1,new Horaire(10,30),new Horaire(11,30)));
        s.ajouterCreneau(new Creneau(1,new Horaire(13,30),new Horaire(15,30)));
        s.ajouterCreneau(c);
        s.ajouterCreneau(new Creneau(1,new Horaire(11,30),new Horaire(12,30)));
        s.ajouterCreneau(new Creneau(1,new Horaire(10,30),new Horaire(12,30)));
        s.ajouterCreneau(new Creneau(1,new Horaire(12,30),new Horaire(14,30)));


        System.out.println(s.toString());
    }

}
