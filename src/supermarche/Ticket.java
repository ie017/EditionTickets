package supermarche;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ticket {
    protected double total;
    protected Map<String, Double> listeImprimer;
    protected void imprimer(){
        List myKeys = new ArrayList(listeImprimer.keySet());
        int i = 0;
        while (i != myKeys.size()){
            int j = 0;
            for (j = i+1; j < myKeys.size(); j++){
                if (!myKeys.get(j).equals(myKeys.get(i))){
                    break;
                }
            }
            if (j - i > 1){
                System.out.println(myKeys.get(j-1));
                System.out.println("        "+(int) (j-i) +" x "+ listeImprimer.get(myKeys.get(j-1))+"       "+ (double) ((int) (j-i) * listeImprimer.get(myKeys.get(j-1))));
            }else {
                System.out.println(myKeys.get(j-1)+"                 "+ listeImprimer.get(myKeys.get(j-1)));
            }
            i = j;
            for (int k = 0; k < myKeys.size(); k++){
                this.total = this.total + listeImprimer.get(myKeys.get(k));
            }
            System.out.println("Total "+ myKeys.size() +" articles :  "+ this.total);
        }

    }
}
