package supermarche.articles;
import java.util.*;

public class BaseArticles {
     private Map<String, Article> listOfarticles;

     public BaseArticles() {
          this.listOfarticles = new HashMap<String, Article>();
     }

     public Article article(String ref) throws ReferenceInconnueException {
          Article value = null;
          for (Map.Entry<String, Article> pair : listOfarticles.entrySet()) {
               if (pair.getKey().equals(ref)) {
                    value = pair.getValue();
                    break;
               } else {
                    throw new ReferenceInconnueException("Could not find article with ref " + ref);
               }
          }
          return value;
     }

     private void supprimer(String ref) throws ReferenceInconnueException {
          for (Map.Entry<String, Article> pair : listOfarticles.entrySet()) {
               if (pair.getKey().equals(ref)) {
                    listOfarticles.remove(pair.getKey(), pair.getValue());
                    break;
               } else {
                    throw new ReferenceInconnueException("Could not find article with ref " + ref);
               }
          }
     }

     private void enregistrer(String ref, Article a) {
          listOfarticles.put(ref, a);
     }
}

