package zwierzeta;
import filarySwiata.Swiat;

import java.awt.*;
import java.util.Random;

public class Lis extends Zwierze {
    public Lis(int[] polozenie, Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        wiek = 0;
        sila = 3;
        inicjatywa = 7;
        kolor = Color.ORANGE;
        ruch = 1;
        this.swiat = swiat;
        gatunek = "Lis";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);

    }
    public void tworz(int[] polozenie, Swiat swiat) {
        new Lis(polozenie, swiat);
    }
    public void akcja() {
        Random generator = new Random();
        random = generator.nextInt(4);
        poAkcji = false;
        temp = swiat.getTabSwiat();
        while (poAkcji == false) {
            switch (random) {
                case 0:
                    if (polozenie[0] >= 1) {
                        if (temp[polozenie[0] - 1][polozenie[1]] != null) {
                            if (temp[polozenie[0] - 1][polozenie[1]].getSila() <= this.sila) {
                                polozeniePomocnicze[0] = polozenie[0] - 1;
                                polozeniePomocnicze[1] = polozenie[1];
                                kolizja(temp[polozenie[0] - 1][polozenie[1]], polozeniePomocnicze, polozenie);
                                poAkcji = true;
                                break;
                            }
                        }
                        else {
                            polozenie[0] -= 1;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0] + 1][polozenie[1]] = null;
                            poAkcji = true;
                            break;
                        }
                    }
                case 1:
                    if (polozenie[0] < 20 - 1) {
                        if (temp[polozenie[0] + 1][polozenie[1]] != null) {
                            if (temp[polozenie[0] + 1][polozenie[1]].getSila() <= this.sila) {
                                polozeniePomocnicze[0] = polozenie[0] + 1;
                                polozeniePomocnicze[1] = polozenie[1];
                                kolizja(temp[polozenie[0] + 1][polozenie[1]], polozeniePomocnicze, polozenie);
                                poAkcji = true;
                                break;
                            }
                        }
                        else {
                            polozenie[0] += 1;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0] - 1][polozenie[1]] = null;
                            poAkcji = true;
                            break;
                        }
                    }
                case 2:
                    if (polozenie[1] >= 1) {
                        if (temp[polozenie[0]][polozenie[1] - 1] != null) {
                            if (temp[polozenie[0]][polozenie[1] - 1].getSila() <= this.sila) {
                                polozeniePomocnicze[0] = polozenie[0];
                                polozeniePomocnicze[1] = polozenie[1] - 1;
                                kolizja(temp[polozenie[0]][polozenie[1] - 1], polozeniePomocnicze, polozenie);
                                poAkcji = true;
                                break;
                            }
                        }
                        else {
                            polozenie[1] -= 1;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0]][polozenie[1] + 1] = null;
                            poAkcji = true;
                            break;
                        }
                    }
                case 3:
                    if (polozenie[1] < 20 - 1) {
                        if (temp[polozenie[0]][polozenie[1] + 1] != null) {
                            //						cout << "temp gatunek " << temp[polozenie[0]][polozenie[1] + 1].gatunek << endl;
                            if (temp[polozenie[0]][polozenie[1] + 1].getSila() <= this.sila) {
                                polozeniePomocnicze[0] = polozenie[0];
                                polozeniePomocnicze[1] = polozenie[1] + 1;
                                kolizja(temp[polozenie[0]][polozenie[1] + 1], polozeniePomocnicze, polozenie);
                                poAkcji = true;
                                break;
                            }
                        }
                        else {
                            polozenie[1] += 1;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0]][polozenie[1] - 1] = null;
                            poAkcji = true;
                            break;
                        }
                    }
                default:
                    poAkcji = true;
                    break;
            }
        }
    }
}
