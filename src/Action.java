import java.util.Set;
import java.util.HashSet;

public class Action {
   
   private Set<IAddListener> iAddListener;
   
   public Set<IAddListener> getIAddListener() {
      if (this.iAddListener == null) {
         this.iAddListener = new HashSet<IAddListener>();
      }
      return this.iAddListener;
   }
  
   private Set<IEditListener> iEditListener;
   
   public Set<IEditListener> getIEditListener() {
      if (this.iEditListener == null) {
         this.iEditListener = new HashSet<IEditListener>();
      }
      return this.iEditListener;
   }
   
 
   private Set<IDeleteListener> iDeleteListener;
   
   public Set<IDeleteListener> getIDeleteListener() {
      if (this.iDeleteListener == null) {
         this.iDeleteListener = new HashSet<IDeleteListener>();
      }
      return this.iDeleteListener;
   }
   
  
   private Set<IDisplayListener> iDisplayListener;
   
   public Set<IDisplayListener> getIDisplayListener() {
      if (this.iDisplayListener == null) {
         this.iDisplayListener = new HashSet<IDisplayListener>();
      }
      return this.iDisplayListener;
   }
   
   }
