package supermarche;
import java.lang.*;
import java.util.*;

public class Caddie<String> implements Iterable<String>{
    public List<String> myList = new ArrayList<String>();
    public Caddie(List<String> l){
        this.myList = l;
    }
    public void ajouter(String ref){
         myList.add(0,ref);
    }
    public void enlever(String ref){
         myList.remove(ref);
    }
    public void enleverTous(String ref){
         myList.removeAll(Collections.singleton(ref));
    }

    @Override
    public Iterator<String> iterator() {
        return myList.iterator();
    }

}
