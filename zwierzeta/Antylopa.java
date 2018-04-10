package zwierzeta;
import filarySwiata.*;
import java.util.Random;
import java.awt.*;

public class Antylopa extends Zwierze {
    public Antylopa(int[] polozenie, Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 4;
        inicjatywa = 4;
        kolor = Color.MAGENTA;
        ruch = 2;
        this.swiat = swiat;
        this.gatunek = "Antylopa";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
    }
    public void tworz(int[] polozenie, Swiat swiat) {
        new Antylopa(polozenie, swiat);
    }
    public boolean czyOdbilAtak(Organizm atakujacy) {
        Random generator = new Random();
        return generator.nextBoolean();
    }
}
