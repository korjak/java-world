package rosliny;
import filarySwiata.*;
import java.awt.*;

public class BarszczSosnowskiego extends Roslina {
    public BarszczSosnowskiego(int[] polozenie, Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 10;
        inicjatywa = 0;
        kolor = Color.PINK;
        this.swiat = swiat;
        this.gatunek = "Barszcz Sosnowskiego";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
    }
    public void tworz(int[] polozenie, Swiat swiat) {
        new BarszczSosnowskiego(polozenie, swiat);
    }
    public void niszcz() {
        temp = swiat.getTabSwiat();
        //		delete &temp[polozenie[0]][polozenie[1]];
        temp[polozenie[0]][polozenie[1]] = null;
    }
    public void akcja() {
        temp = swiat.getTabSwiat();
        if (polozenie[0] > 0) {
            if (temp[polozenie[0] - 1][polozenie[1]] != null) {
                temp[polozenie[0] - 1][polozenie[1]].niszcz();
            }
        }
        if (polozenie[0] < 20 - 1) {
            if (temp[polozenie[0] + 1][polozenie[1]] != null) {
                temp[polozenie[0] + 1][polozenie[1]].niszcz();
            }
        }
        if (polozenie[1] > 0) {
            if (temp[polozenie[0]][polozenie[1] - 1] != null) {
                temp[polozenie[0]][polozenie[1] - 1].niszcz();
            }
        }
        if (polozenie[0] < 20 - 1) {
            if (temp[polozenie[0]][polozenie[1] + 1] != null) {
                temp[polozenie[0]][polozenie[1] + 1].niszcz();
            }
        }
    }
}
