package supermarche;
import java.util.*;

public class TicketBuilder {
   protected Map<String, Double> listvalide = new HashMap<String, Double>();
   protected Ticket getTicket(){
      Ticket ticket = new Ticket();
      ticket.listeImprimer = listvalide;
      return ticket;
   }
   protected void ajouterArticle(String libelle, double prix){
      listvalide.put(libelle,prix);
   }
   protected void definirNumero(int numero){
      System.out.println("Ticket numéro "+numero);
   }

}
