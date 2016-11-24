import java.util.Set;

public interface IFolio {
   
   public Set<DisplayListener> getDisplayListener();
   
  
   public Set<DeleteListener> getDeleteListener();
   
   public Set<EditListener> getEditListener();
   
   
   public Set<AddListener> getAddListener();
   
   }
