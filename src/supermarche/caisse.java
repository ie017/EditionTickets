package supermarche;
import supermarche.articles.Article;
import supermarche.articles.BaseArticles;
import supermarche.articles.ReferenceInconnueException;

import java.util.ArrayList;
import java.util.List;

public class caisse {
    private long total;
    private int nbTickets;
    private BaseArticles bArticles;
    private Caddie c = new Caddie();
    private TicketBuilder ticketB = new TicketBuilder();
    private caisse(long t, int nbt){
        this.total = t;
        this.nbTickets = nbt;
    }
    private void scanner(Caddie c){
        while (c.iterator().hasNext()){
            try {
                Article a = bArticles.article((String) c.iterator().next());
                ticketB.ajouterArticle(a.libellé, a.prix);
            } catch (ReferenceInconnueException e) {
                e.printStackTrace();
            }
        }
    }
    private void imprimerReferencesInconnues(){
        List<String> refList = new ArrayList<String>();
        while (c.iterator().hasNext()){
            try {
                Article a = bArticles.article((String) c.iterator().next());
            } catch (ReferenceInconnueException e) {
                if (!refList.contains((String) c.iterator().next())){
                    refList.add((String) c.iterator().next());
                }
            }
        }
        System.out.println("List of unknown Ref :");
        for (String getRef : refList){
            System.out.println(getRef);
        }
    }
}
