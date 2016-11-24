import java.util.Set;

public interface ITracker {

   public Set<DisplayListener> getDisplayListener();

   public Set<DeleteListener> getDeleteListener();
   
  
   public Set<AddListener> getAddListener();
   
 
   public Set<EditListener> getEditListener();
   
   
   public Set<IObserver> getIObserver();
   
   }
