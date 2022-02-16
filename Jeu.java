import java.util.Scanner;
public class Jeu{

    private Player[] players = new Player[2];
    private Grille grilleJeu;

    public Jeu(Player j1, Player j2,int colonne ,int ligne ) {
        players[0] = j1;
        players[1] = j2;
        grilleJeu = new Grille(colonne,ligne);

    }
    
    public Grille getGrille()
    {
        return this.grilleJeu;
    }

    public Player getPlayer(int i)
    {
        return this.players[i];
    }
    /**
     * Cette méthode est la principale méthode qui lance le jeu et détermine quel joueur a gagné
     */
    public void play() {
        int vainqueur = -1;
        int JoueurCourant = 0;

        while (vainqueur==-1) {
            players[JoueurCourant].play(grilleJeu);
            if (grilleJeu.estPlein()) {
                vainqueur = -1;
            }

            if (grilleJeu.cherchervainqueur()) {
                vainqueur = JoueurCourant;
            }

            JoueurCourant++;
            JoueurCourant %= 2;
        }
<<<<<<< HEAD
=======

        System.out.println("Partie terminée!!");
>>>>>>> d6dd46d8c232144e962a0a61506e627e981eaf67
        grilleJeu.grille();
        System.out.println("Partie terminée!!");

        if (vainqueur == -1) {
            System.out.println("Match nul!!");
        } else {
            System.out.println("Le vainqueur est " + players[vainqueur].getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez votre nom: ");

        String nom = scanner.nextLine();
<<<<<<< HEAD

        Scanner Col = new Scanner(System.in);

        System.out.println("Veuillez entrer la taille des colonnes : ");  	

        int nbCol = Col.nextInt();			

        Scanner Line = new Scanner(System.in);

        System.out.println("Veuillez entrer la taille des lignes : ");

        int nbLine = Line.nextInt();
=======
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer la taille des colonnes : ");  	
        int c = sc.nextInt();			

        Scanner sl = new Scanner(System.in);
        System.out.println("Veuillez entrer la taille des lignes : ");
        int l = sl.nextInt();
>>>>>>> d6dd46d8c232144e962a0a61506e627e981eaf67

        System.out.println("Voulez-vous jouer contre l'ordinateur? 1/0");

        int h = Line.nextInt();

        if(h == 1){
            Jeu j = new Jeu(new Player(nom, 'X'),new Computer ('O'),nbCol,nbLine); 
            j.play();
        }else if(h == 0){
            System.out.println("Donnez le nom du Joueur 2!!");
            String nom2 = scanner.nextLine();
            Jeu p = new Jeu(new Player(nom, 'X'),new Player (nom2,'O'),nbCol,nbLine);
            p.play();

        }
    }
}
