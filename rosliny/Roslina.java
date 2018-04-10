package rosliny;
import filarySwiata.*;
import java.util.Random;

public abstract class Roslina extends Organizm {
    public void akcja() {
        Random generator = new Random();
        random = generator.nextInt(10);
        if (random == 0) {
            random = generator.nextInt(4);
            poAkcji = false;
            temp = swiat.getTabSwiat();
            while (poAkcji == false) {
                switch (random) {
                    case 0:
                        if (polozenie[0] > 0) {
                            if (temp[polozenie[0] - 1][polozenie[1]] == null) {
                                polozenieTemp[0] = polozenie[0] - 1;
                                polozenieTemp[1] = polozenie[1];
                                this.tworz(polozenieTemp, swiat);
                                poAkcji = true;
                                break;
                            }
                        }
                    case 1:
                        if (polozenie[0] < 20 - 1) {
                            if (temp[polozenie[0] + 1][polozenie[1]] == null) {
                                polozenieTemp[0] = polozenie[0] + 1;
                                polozenieTemp[1] = polozenie[1];
                                this.tworz(polozenieTemp, swiat);
                                poAkcji = true;
                                break;
                            }
                        }
                    case 2:
                        if (polozenie[1] > 0) {
                            if (temp[polozenie[0]][polozenie[1] - 1] == null) {
                                polozenieTemp[0] = polozenie[0];
                                polozenieTemp[1] = polozenie[1] - 1;
                                this.tworz(polozenieTemp, swiat);
                                poAkcji = true;
                                break;
                            }
                        }
                    case 3:
                        if (polozenie[1] < 20 - 1) {
                            if (temp[polozenie[0]][polozenie[1] + 1] == null) {
                                polozenieTemp[0] = polozenie[0];
                                polozenieTemp[1] = polozenie[1] + 1;
                                this.tworz(polozenieTemp, swiat);
                                poAkcji = true;
                                break;
                            }
                        }
                    default:
                        poAkcji = true;
                        break;
                }
                random--;
            }

        }
    }
    public void kolizja(Organizm org, int poleAtakowane[], int polePierwotne[]) {
        System.out.println("nie ma tu żadneg easteregga");
    }
    public boolean czyOdbilAtak(Organizm org) {
        return false;
    }
}
