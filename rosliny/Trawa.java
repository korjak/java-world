package rosliny;
import filarySwiata.*;
import java.awt.*;

public class Trawa extends Roslina {
    public Trawa(int[] polozenie, Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 0;
        inicjatywa = 0;
        kolor = Color.GREEN;
        this.swiat = swiat;
        this.gatunek = "Trawa";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
    }
    public void tworz(int[] polozenie, Swiat swiat) {
        new Trawa(polozenie, swiat);
    }
    public void niszcz() {
        temp = swiat.getTabSwiat();
        //		delete temp[polozenie[0]][polozenie[1]];
        temp[polozenie[0]][polozenie[1]] = null;
    }
}
