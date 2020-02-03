package View.Terminal;

import Control.Controleur;
import View.Accueil;
import View.EnvoiMessage;
import modele.UtilisateurDTO;
import modele.UtilisateurInexistantException;
import modele.UtilisateurNonConnecteException;

import java.util.Collection;
import java.util.Scanner;

public class EnvoiMessageTerminalImpl implements EnvoiMessage {

    Controleur controleur;

    public EnvoiMessageTerminalImpl(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void afficher() {
        Scanner scanner = new Scanner(System.in);

        Collection<UtilisateurDTO> utilisateurs = null;
        try {
            utilisateurs = controleur.getUtilisateur();
            System.out.println("voici la liste des utilisateurs");
            for (UtilisateurDTO u:utilisateurs){
                System.out.println(u.getId() + " : " +u.getLogin());
            }

            System.out.println("Saisir l'identifiant du destinaitaire");
            long id = scanner.nextLong();

            scanner = new Scanner(System.in);

            System.out.println("Saisir votre message");
            String message = scanner.nextLine();

            controleur.envoyerMessage(id,message);

        } catch (UtilisateurNonConnecteException e) {
            e.printStackTrace();
            controleur.deconnexion();
        } catch (UtilisateurInexistantException e) {
            e.printStackTrace();
        }

        System.out.println("utilisateurs");



    }

    @Override
    public void confirmation(){
        System.out.println("Message bien envoyé");

    }

    @Override
    public void erreur(String e) {

    }


}
