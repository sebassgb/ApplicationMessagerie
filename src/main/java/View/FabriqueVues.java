package View;

import Control.Controleur;

public interface FabriqueVues {
    void setControleur(Controleur controleur);

    Accueil creerAccueil();

    Inscription creerInscription();

    Connexion creerConnexion();

    Menu creerMenu();

    EnvoiMessage creerEnvoiMessage();
}
