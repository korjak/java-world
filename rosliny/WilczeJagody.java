package rosliny;
import filarySwiata.*;
import java.awt.*;

public class WilczeJagody extends Roslina {
    public WilczeJagody(int[] polozenie, Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 99;
        inicjatywa = 0;
        kolor = Color.BLUE;
        this.swiat = swiat;
        this.gatunek = "Wilcze Jagody";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
    }
    public void tworz(int polozenie[], Swiat swiat) {
        new WilczeJagody(polozenie, swiat);
    }
    public void niszcz() {
        temp = swiat.getTabSwiat();
        //		delete &temp[polozenie[0]][polozenie[1]];
        temp[polozenie[0]][polozenie[1]] = null;
    }
}
