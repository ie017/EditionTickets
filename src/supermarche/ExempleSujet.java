package supermarche;

import supermarche.articles.Article;
import supermarche.articles.BaseArticles;
import supermarche.articles.ReferenceInconnueException;

import java.util.ArrayList;

/**
 * ie017
 */
public class ExempleSujet {
    public static void main(String[] args) throws ReferenceInconnueException {
        //Create a new caisse
        Cassie caisse = new Cassie();
        caisse.nbTickets = 0;
        //New base of articles
        caisse.bArticles = new BaseArticles();
        //Liste of the articles
        Article a0, a1, a2, a3, a4, a5;
        a0 = new Article("Moutarde", 1.02);
        a1 = new Article("Brocoli", 1.98);
        a2 = new Article("Coulomier", 2.20);
        a3 = new Article("Lecteur DiVX", 69.99);
        a4 = new Article("Lait 1L", 0.67);
        a5 = new Article("Lait pack 6L", 3.65);
        caisse.bArticles.enregistrer("X1620Y1B", a0);
        caisse.bArticles.enregistrer("X1421Y1D", a1);
        caisse.bArticles.enregistrer("X5523Y1B", a2);
        caisse.bArticles.enregistrer("X1720Y1C", a3);
        caisse.bArticles.enregistrer("X1635Y1H", a4);
        caisse.bArticles.enregistrer("X1420Y1K", a5);
        /* Create new Caddie */
        Caddie<String> c1 = new Caddie<>(new ArrayList<>());
        c1.ajouter("X1635Y1H");//Lait 1L
        c1.ajouter("X1635Y1H");//Lait 1L
        c1.ajouter("X5523Y1B");//Coulomier
        c1.ajouter("X1420Y1K");//Lait pack 6L
        c1.ajouter("X1720Y1C");//Lecteur DiVX
        c1.ajouter("X1720Y1C");//Lecteur DiVX
        c1.ajouter("X1720Y1C");//Lecteur DiVX
        c1.ajouter("X1421Y1D");//Brocoli
        c1.ajouter("X1421Y1ddD");//unknown ref
        Caddie<String> c2 = new Caddie<>(new ArrayList<>());
        c2.ajouter("X1635Y1H");//Lait 1L
        c2.ajouter("X1635Y1H");//Lait 1L
        c2.ajouter("X1421Y1Ddd");//unknown ref
        c2.ajouter("X5523Y1B");//Coulomier
        c2.ajouter("X1420Y1K");//Lait pack 6L
        c2.ajouter("X1720Y1C");//Lecteur DiVX
        c2.ajouter("X1720Y1C");//Lecteur DiVX
        c2.ajouter("X1421Y1D");//Brocoli
        c2.enlever("X1421Y1Ddd");// Delete ref
        //Add caddie to the cassie
        caisse.listOfCaddie.add(0, c1);
        caisse.listOfCaddie.add(0, c2);
        //Scanner le Caddie
        caisse.scanner(caisse.listOfCaddie);
        //Get ticket
        int nb = caisse.listOfTicketB.size() - 1;
        while (nb >= 0) {
            caisse.listOfTicketB.get(nb).definirNumero(caisse.nbTickets++);
            caisse.listOfTicketB.get(nb).getTicket().imprimer();
            nb--;
        }
        //print all the unknown refes
        caisse.imprimerReferencesInconnues();
    }
}
