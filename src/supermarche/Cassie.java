package supermarche;
import supermarche.articles.Article;
import supermarche.articles.BaseArticles;
import supermarche.articles.ReferenceInconnueException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cassie {
    protected long total;
    protected int nbTickets;
    protected BaseArticles bArticles;
    protected Caddie caddie = new Caddie(new ArrayList<>());
    protected TicketBuilder ticketB = new TicketBuilder();
    protected void scanner(Caddie caddie) throws ReferenceInconnueException {
        Iterator<String> ite = caddie.iterator();
        System.out.println("issam4");
        while(ite.hasNext()){

            Article a = bArticles.article(ite.next());
            ticketB.ajouterArticle(a.libelle, a.prix);
        }
    }
    private void imprimerReferencesInconnues(){
        List<String> refList = new ArrayList<String>();
        Iterator<String> ite = caddie.iterator();
        while (ite.hasNext()){
            try {
                Article a = bArticles.article((String) ite.next());
            } catch (ReferenceInconnueException e) {
                if (!refList.contains((String) ite.next())){
                    refList.add((String) ite.next());
                }
            }
        }
        System.out.println("List of unknown Ref :");
        for (String getRef : refList){
            System.out.println(getRef);
        }
    }
}
