import java.util.*;

public class Tracker {
private ArrayList Folios;
   
   public void setFolios(ArrayList value) {
      this.Folios = value;
   }
   
   public ArrayList getFolios() {
      return this.Folios;
   }
   
   private Set<Folio> folio;
   
   public Set<Folio> getFolio() {
      if (this.folio == null) {
         this.folio = new HashSet<Folio>();
      }
      return this.folio;
   }
   
   public boolean addFolio(String Name) {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   public boolean deleteFolio(String Name) {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   public void addStock(String folioName, int quantity, String stockName, double price) {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   public void editHolding(String folioName, String stockName, int quantity, double price) {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   public void refreshPrices() {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   }
