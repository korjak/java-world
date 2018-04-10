package zwierzeta;
import filarySwiata.*;

import java.awt.*;

public class Owca extends Zwierze {
    public Owca(int[] polozenie, Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 4;
        inicjatywa = 4;
        kolor = Color.WHITE;
        ruch = 1;
        this.swiat = swiat;
        gatunek = "Owca";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);

    }
    public void tworz(int[] polozenie, Swiat swiat) {
        new Owca(polozenie, swiat);
    }
}