import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorCynthia
{
    private String Nom;
    private Pokemon Poke;

    public EntrenadorCynthia(String Nom, Pokemon poke) {
        this.Nom=Nom;
        Poke = poke;
    }

    public Pokemon getPoke() {
        return Poke;
    }

    public void setPoke(Pokemon poke) {
        Poke = poke;
    }
}
