package supermarche;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ticket {
    protected double total;
    protected List<String> listOflibelle = new ArrayList<String>();
    protected List<Double> listOfPrix = new ArrayList<Double>();
    public Ticket(List<String> list1, List<Double> list2){
        this.listOflibelle = list1;
        this.listOfPrix = list2;
    }
    protected void imprimer(){
        int i = 0;
        while (i < listOflibelle.size()){
            int j = i;
            while (j < listOflibelle.size()){
                if (!(listOflibelle.get(i).equals(listOflibelle.get(j)))){
                    break;
                }
                j++;
            }
            if (j - i > 1){
                System.out.println(listOflibelle.get(j-1));
                System.out.println("        "+(int) (j-i) +" x "+ listOfPrix.get(j-1)+"       "+ (double) ((int) (j-i) * listOfPrix.get(j-1)));
            }else {
                System.out.println(listOflibelle.get(i)+"                 "+ listOfPrix.get(i));
                i++;
            }
            i = j;
            for (int k = 0; k < listOfPrix.size(); k++){
                this.total = this.total + listOfPrix.get(k);
            }
        }
        System.out.println("-----------------------");
        System.out.println("Total "+ listOflibelle.size() +" articles :  "+ this.total);
        System.out.println("-----------------------");

    }
}
