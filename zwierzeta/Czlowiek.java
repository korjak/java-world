package zwierzeta;
import filarySwiata.*;
import warstwaWizualna.*;

import java.awt.*;

public class Czlowiek extends Zwierze {
    Okno okno;
    public Czlowiek(int polozenie[], Swiat swiat, Okno okno)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        czasU = 0;
        sila = 5;
        inicjatywa = 4;
        kolor = Color.BLACK;
        this.swiat = swiat;
        this.gatunek = "Czlowiek";
        this.okno = okno;
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
    }
    public Czlowiek(int polozenie[], Swiat swiat)
    {
        this.polozenie[1] = polozenie[1];
        this.polozenie[0] = polozenie[0];
        czasU = 0;
        sila = 5;
        inicjatywa = 4;
        kolor = Color.BLACK;
        this.swiat = swiat;
        this.gatunek = "Czlowiek";
        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
    }
    public void akcja() {
        poAkcji = false;
        odlRuchu = 1;
        temp = swiat.getTabSwiat();
        if (czasU < 5) {
            isSkillOn = false;
        }
        while (!poAkcji) {
            if (isSkillOn) {
                odlRuchu = 2;
            }
            //input = _getch();
            //if (input == 224) {
            //    input = _getch();
            //}
            input = okno.getKodKlawisza();
            System.out.println("kod wpisanego klawisza: "+input);
            switch (input) {
                case 40:      //dol
                    if (polozenie[1] < 20 - odlRuchu) {
                        if (temp[polozenie[0]][polozenie[1] + odlRuchu] != null) {
                            polozeniePomocnicze[0] = polozenie[0];
                            polozeniePomocnicze[1] = polozenie[1] + odlRuchu;
                            kolizja(temp[polozenie[0]][polozenie[1] + odlRuchu], polozeniePomocnicze, polozenie);
                        }
                        else {
                            polozenie[1] += odlRuchu;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0]][polozenie[1] - odlRuchu] = null;
                        }
                        poAkcji = true;
                    }
                    break;
                case 38:      //gora
                    if (polozenie[1] >= odlRuchu) {
                        if (temp[polozenie[0]][polozenie[1] - odlRuchu] != null) {
                            polozeniePomocnicze[0] = polozenie[0];
                            polozeniePomocnicze[1] = polozenie[1] - odlRuchu;
                            kolizja(temp[polozenie[0]][polozenie[1] - odlRuchu], polozeniePomocnicze, polozenie);
                        }
                        else {
                            polozenie[1] -= odlRuchu;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0]][polozenie[1] + odlRuchu] = null;
                        }
                        poAkcji = true;
                    }
                    break;
                case 37:      //lewo
                    if (polozenie[0] >= odlRuchu) {
                        //cout << "polozenie x: " << polozenie[0] << endl;
                        if (temp[polozenie[0] - odlRuchu][polozenie[1]] != null) {
                            polozeniePomocnicze[0] = polozenie[0] - odlRuchu;
                            polozeniePomocnicze[1] = polozenie[1];
                            kolizja(temp[polozenie[0] - odlRuchu][polozenie[1]], polozeniePomocnicze, polozenie);
                        }
                        else {
                            polozenie[0] -= odlRuchu;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0] + odlRuchu][polozenie[1]] = null;
                        }
                        poAkcji = true;
                    }
                    break;
                case 39:      //prawo
                    if (polozenie[0] < 20 - odlRuchu) {
                        if (temp[polozenie[0] + odlRuchu][polozenie[1]] != null) {
                            polozeniePomocnicze[0] = polozenie[0] + odlRuchu;
                            polozeniePomocnicze[1] = polozenie[1];
                            kolizja(temp[polozenie[0] + odlRuchu][polozenie[1]], polozeniePomocnicze, polozenie);
                            //						//cout << "poszedlem w prawo PRZ1PS" << endl;
                        }
                        else {
                            polozenie[0] += odlRuchu;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0] - odlRuchu][polozenie[1]] = null;
                        }
                        poAkcji = true;
                    }
                    break;
                case 32:
                    if (czasU == 0) {
                        isSkillOn = true;
                        czasU = 11;
                        okno.wywolajNowaTure(swiat);
                        //cout << "INPUT CASE " << input << endl;
                    }
                    break;
                default:
                    //				poAkcji = true;
                    //cout << "INPUT " << input << endl;
                    poAkcji = true;
                    break;
            }

        }
        if (czasU != 0) {
            czasU--;
        }
    }
    public void tworz(int[] polozenie, Swiat swiat) {
        new Czlowiek(polozenie, swiat);
    }
}
