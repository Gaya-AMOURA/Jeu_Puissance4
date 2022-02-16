import java.util.Scanner;

public class Player{
    private String Name;
    private char joueur;
    public Player(String Name,char joueur){
        this.Name = Name;
        this.joueur = joueur;
    }

    public String getName(){ return this.Name;}

    public char getJoueur(){return this.joueur;}

    /**
     * Cette méthode permet au joueur de saisir son coup et vérifier si ce dernier est valide
     * @param G La grille de la partie actuelle
     */
    public void play(Grille G){

        G.grille();
        boolean player = false;
        boolean coupValide = true;
        int c=-1;
        String line="";
        do {
            try {
                System.out.println("Joueur " + this.getName() + ", entrez un numero de colonne" +
                    "  (entre 1 et " + G.getColonne() + ") : ");  
                Scanner sc = new Scanner(System.in);
                line = sc.nextLine();  
                c=Integer.valueOf(line);
                c--;  				 			
                coupValide = G.jouerCoup(c, this.getJoueur());  	 
                if (coupValide == false)
                    System.out.println("Votre coup n'est pas valide!!");

            }catch(Exception e) {
                System.out.println("Erreur de converstion en Integer"); 

            } 
        }
        while (coupValide == false);

    }   	
}

