package zwierzeta;
import filarySwiata.*;

import java.awt.*;
import java.util.Random;

public class Zolw extends Zwierze {
    public Zolw(int polozenie[], Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 2;
        inicjatywa = 1;
        kolor = Color.CYAN;
        ruch = 1;
        this.swiat = swiat;
        this.gatunek = "Zolw";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
    }
    public void tworz(int polozenie[], Swiat swiat) {
        new Zolw(polozenie, swiat);
    }
    public void akcja() {
        Random generator = new Random();
        random = generator.nextInt(4);
        if (random == 0) {
            super.akcja();
        }
    }
    public boolean czyOdbilAtak(Organizm atakujacy) {
        if(atakujacy.getSila() < 5) {
            return true;
        }
        else {
            return false;
        }
    }
}
