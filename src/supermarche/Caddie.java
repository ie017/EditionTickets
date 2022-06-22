package supermarche;
import java.lang.*;
import java.util.*;

public class Caddie<String> implements Iterable<String>{
    private List<String> myList = new ArrayList<String>();
    private void ajouter(String ref){
         myList.add(ref);
    }
    private void enlever(String ref){
         myList.remove(ref);
    }
    private void enleverTous(String ref){
         myList.removeAll(Collections.singleton(ref));
    }

    @Override
    public Iterator<String> iterator() {
        return myList.iterator();
    }
}
