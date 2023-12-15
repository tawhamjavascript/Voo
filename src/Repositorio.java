import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private static Repositorio instance;
    private List<Voo> voos;

    
    private Repositorio() {
        Aeronave a1 = new Aeronave("aerotaw1", 1);
        Aeronave a2 = new Aeronave("aerotaw2", 2);
        Aeronave a3 = new Aeronave("aerotaw3", 1);
        
        Voo v1 = new Voo("v1", "taw", "ham", "12/12/2012", "00:00", "03:00", "p1", a1);
        Voo v2 = new Voo("v2", "ham", "taw", "09/12/2002", "12:02", "15:00", "p2", a2);
        Voo v3 = new Voo("v3", "balbino", "paula", "08/07/2014", "00:00", "02:00", "p3", a3);

        this.voos = new ArrayList<Voo>();
        this.voos.add(v1);
        this.voos.add(v2);
        this.voos.add(v3);
        
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
