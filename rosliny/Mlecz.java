package rosliny;
import filarySwiata.*;
import java.awt.*;

public class Mlecz extends Roslina {
    public Mlecz(int[] polozenie, Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 0;
        inicjatywa = 0;
        kolor = Color.YELLOW;
        this.swiat = swiat;
        this.gatunek = "Mlecz";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
    }
    public void tworz(int[] polozenie, Swiat swiat) {
        new Mlecz(polozenie, swiat);
    }
    public void niszcz() {
        temp = swiat.getTabSwiat();
        //		delete &temp[polozenie[0]][polozenie[1]];
        temp[polozenie[0]][polozenie[1]] = null;
    }
    public void akcja() {
        for (int i = 0; i < 3; i++) {
            super.akcja();
        }
    }
}
