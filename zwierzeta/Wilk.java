package zwierzeta;
import filarySwiata.*;

import java.awt.*;

public class Wilk extends Zwierze {
    public Wilk(int[] polozenie, Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 9;
        inicjatywa = 5;
        kolor = Color.GRAY;
        ruch = 1;
        this.swiat = swiat;
        gatunek = "Wilk";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);

    }
    public void tworz(int[] polozenie, Swiat swiat) {
        new Wilk(polozenie, swiat);
    }
}
