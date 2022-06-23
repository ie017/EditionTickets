package supermarche.articles;
import java.util.*;

public class BaseArticles {
     public Map<String, Article> listOfarticles;

     public BaseArticles() {
          this.listOfarticles = new HashMap<String, Article>();
     }

     public Article article(String ref) throws ReferenceInconnueException {
          List<String> myKeys = new ArrayList(listOfarticles.keySet());
          int index = -1;
          for (int i = 0; i < myKeys.size(); i++){
               if ( myKeys.get(i).equals(ref)) {
                    index = i;
                    break;
               }
          }
          if (index == -1){
               throw new ReferenceInconnueException("could not find the reference "+ref);
          }
          return listOfarticles.get(myKeys.get(index));
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

     public void enregistrer(String ref, Article a) {
          listOfarticles.put(ref, a);
     }
}

