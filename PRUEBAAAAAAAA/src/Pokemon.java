import java.util.ArrayList;
import java.util.List;

public class Pokemon
{

    private String nombre;
    private int hp;
    private int Lv;
    private Tipos tipo;

    public Pokemon(String nombre,int hp,int Lv,Tipos tipo) {
        this.nombre=nombre;
        this.hp=hp;
        this.Lv=Lv;
        this.tipo = tipo;
    }

}
