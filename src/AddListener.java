import java.util.Set;
import java.util.HashSet;

public class AddListener {
  
   private Set<IFolio> iFolio;
   
   public Set<IFolio> getIFolio() {
      if (this.iFolio == null) {
         this.iFolio = new HashSet<IFolio>();
      }
      return this.iFolio;
   }
   
  
   private Set<ITracker> iTracker;
   
   public Set<ITracker> getITracker() {
      if (this.iTracker == null) {
         this.iTracker = new HashSet<ITracker>();
      }
      return this.iTracker;
   }
   
   }
