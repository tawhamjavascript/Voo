import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private static Repositorio instance;
    private List<Voo> voos;

    
    private Repositorio() {
        
        this.voos = new ArrayList<Voo>();
        
    }
    
    public static Repositorio getInstance() {
        if (instance == null) {
            instance = new Repositorio();
        }
        return instance;
    } 
    
    public Voo getVoo(String id) {
        Voo result = null;
        for(Voo voo : voos) {
            if (voo.getId().equals(id)) {
                result = voo;
                break;
            }
        }
        
        return result;
    }
    
    public List<Voo> getVoos() {
        return voos;
    }

    public void salvar(Voo voo) {
        this.voos.add(voo);
    }
    
}
