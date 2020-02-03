package View.Terminal;

import Control.Controleur;
import View.Inscription;

import java.util.Scanner;

public class InscriptionTerminalImpl implements Inscription {
    Controleur controleur;



    public InscriptionTerminalImpl(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void afficher(){
        Scanner scanner = new Scanner(System.in);
        String utilisateur = new String();
        String motdepasse = new String();
        int finish = -1;
        System.out.println("------------------Page d'inscription------------------");
        do {
            System.out.println("Tapez votre nom d'utilisateur");
            utilisateur = scanner.nextLine();
            System.out.println("Tapez votre mot de passe");
            motdepasse = scanner.nextLine();

        } while (utilisateur.length() <3 || motdepasse.length() < 3);
        controleur.validerInscription(utilisateur,motdepasse);
    }

    @Override
    public void erreur(String error) {
        System.err.println(error);

    }

}
