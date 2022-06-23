package supermarche;
import java.util.*;

public class TicketBuilder {
   protected List<String> listeOFLibelle = new ArrayList<String>();
   protected List<Double> listeOfPrix = new ArrayList<Double>();
   protected Ticket getTicket(){
      Ticket ticket = new Ticket(this.listeOFLibelle,this.listeOfPrix);
      return ticket;

   }
   protected void ajouterArticle(String libelle, double prix){
      listeOFLibelle.add(0,libelle);
      listeOfPrix.add(0,prix);
   }
   protected void definirNumero(int numero){
      System.out.println("-----------------------");
      System.out.println("Ticket numéro "+numero);
      System.out.println("-----------------------");
   }

}
