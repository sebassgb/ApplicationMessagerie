package Control;

import View.*;
import modele.*;
import modele.FabriqueFacadeApplicationMessagerie;
import modele.FacadeApplicationMessagerie;

import java.util.Collection;

public class Controleur {

    FacadeApplicationMessagerie facadeApplicationMessagerie;
    FabriqueVues fabriqueVues;

    Inscription vueInscription;
    Accueil vueAccueil;
    Connexion vueConnexion;
    Menu vueMenu;
    EnvoiMessage vueEnvoiMessage;
    private long identifiants;


    public Controleur(FabriqueFacadeApplicationMessagerie fabriqueFacadeApplicationMessagerie,
                      FabriqueVues fabriqueVues){
        this.fabriqueVues = fabriqueVues;
        this.facadeApplicationMessagerie = fabriqueFacadeApplicationMessagerie.creer();
        fabriqueVues.setControleur(this);
    }


    public  void validerConnexion(String utilisateur, String motdepasse) {
        try {
            this.identifiants = facadeApplicationMessagerie.connexion(utilisateur,motdepasse);
            this.vueMenu = this.fabriqueVues.creerMenu();
            this.vueMenu.afficher();
        } catch (LoginDejaPrisException e) {
            this.vueConnexion.erreur("Le login " + utilisateur + " n'existe pas"+  e);
            this.vueAccueil.afficher();
            e.printStackTrace();
        } catch (InformationsNonConformesException | UtilisateurDejaConnecteException e) {
            this.vueConnexion.erreur("error informations saisies ne sont pas valides " + e);
            this.vueAccueil.afficher();
            e.printStackTrace();
        }
    }


    public void validerChoixAccueil(int choix) {
        switch (choix){
            case 1:
                this.vueInscription = this.fabriqueVues.creerInscription();
                this.vueInscription.afficher();
                break;
            case 2:
                this.vueConnexion = this.fabriqueVues.creerConnexion();
                this.vueConnexion.afficher();
                break;
            case 0:
                System.exit(1);
                break;
            default:
                this.run();
                break;
        }
    }

    public void validerInscription(String utilisateur, String motdepasse) {
        try {
            facadeApplicationMessagerie.inscription(utilisateur, motdepasse);
            vueAccueil.afficher();
        } catch (LoginDejaPrisException e) {
            vueInscription.erreur("Le login " + utilisateur + "est deja pris"+  e);
            vueInscription.afficher();
            e.printStackTrace();
        } catch (InformationsNonConformesException e) {
            vueInscription.erreur("error informations saisies ne sont pas valides " + e);
            vueInscription.afficher();
            e.printStackTrace();
        }



    }

    public void validerMenu(int choix) {

            switch (choix) {
                case 1:
                    this.vueEnvoiMessage = fabriqueVues.creerEnvoiMessage();
                    this.vueEnvoiMessage.afficher();
                    break;
                case 2:
                    this.vueConnexion = this.fabriqueVues.creerConnexion();
                    this.vueConnexion.afficher();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    this.run();
                    break;
    }

}

    public void run() {
        this.vueAccueil = this.fabriqueVues.creerAccueil();
        this.vueAccueil.afficher();
    }

    public Collection<UtilisateurDTO> getUtilisateur() throws UtilisateurNonConnecteException, UtilisateurInexistantException {
            return this.facadeApplicationMessagerie.getListeDesInscrits(this.identifiants);
    }

    public void envoyerMessage(long id, String message){
        try {
            this.facadeApplicationMessagerie.envoyerUnMessage(this.identifiants, id, message);
            this.vueEnvoiMessage.confirmation();
            this.vueMenu.afficher();
        }catch (UtilisateurNonConnecteException e){
            this.vueEnvoiMessage.erreur("non connecté "+ e);
            this.deconnexion();
        }catch (UtilisateurInexistantException e){
            this.vueEnvoiMessage.erreur("N'existe pas " + e);
        }
    }

    public void deconnexion() {
        System.exit(1);
    }

}
