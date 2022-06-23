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
    protected List<Caddie> listOfCaddie = new ArrayList<Caddie>();
    protected List<TicketBuilder> listOfTicketB = new ArrayList<TicketBuilder>();
    protected void scanner(List<Caddie> list) throws ReferenceInconnueException {
        int index = listOfCaddie.size() - 1;
        while (index >= 0){
            Iterator ite = listOfCaddie.get(index).iterator();
            listOfTicketB.add(0,new TicketBuilder());
            while(ite.hasNext()){
                try{
                    Article a = new Article();
                    a = bArticles.article((String) ite.next());
                    listOfTicketB.get(0).ajouterArticle(a.libelle, a.prix);
                }catch (ReferenceInconnueException e){
                    e.printStackTrace();
                }
            }
            index--;
        }
    }
    protected void imprimerReferencesInconnues(){
        List<String> refList = new ArrayList<String>();
        int index = listOfCaddie.size() - 1;
          while (index >= 0){
            Iterator ite = listOfCaddie.get(index).iterator();
            listOfTicketB.add(0,new TicketBuilder());
            while(ite.hasNext()){
                try{
                    Article a = new Article();
                    a = bArticles.article((String) ite.next());
                    listOfTicketB.get(0).ajouterArticle(a.libelle, a.prix);
                }catch (ReferenceInconnueException e){
                    if (!refList.contains((String) ite.next())){
                        refList.add((String) ite.next());
                    }
                }
            }
            index--;
        }
        System.out.println("List of unknown Ref :");
        for (String getRef : refList){
            System.out.println(getRef);
        }
    }
}
