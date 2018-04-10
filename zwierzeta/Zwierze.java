package zwierzeta;
import filarySwiata.*;
import java.util.Random;

public abstract class Zwierze extends Organizm {
    public void akcja() {
        Random generator = new Random();
        random = generator.nextInt(4);
        poAkcji = false;
        temp = swiat.getTabSwiat();
        ruch = 1;
        if (this.getGatunek().compareTo("Antylopa") == 0) {
            ruch = 2;
        }
        while (poAkcji == false) {
            switch (random) {
                case 0:
                    if (polozenie[0] >= ruch) {
                        if (temp[polozenie[0] - ruch][polozenie[1]] != null) {
                            polozeniePomocnicze[0] = polozenie[0] - ruch;
                            polozeniePomocnicze[1] = polozenie[1];
                            kolizja(temp[polozenie[0] - ruch][polozenie[1]], polozeniePomocnicze, polozenie);
                        }
                        else {
                            polozenie[0] -= ruch;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0] + ruch][polozenie[1]] = null;
                        }
                        poAkcji = true;
                        break;
                    }
                case 1:
                    if (polozenie[0] < 20 - ruch) {
                        if (temp[polozenie[0] + ruch][polozenie[1]] != null) {
                            polozeniePomocnicze[0] = polozenie[0] + ruch;
                            polozeniePomocnicze[1] = polozenie[1];
                            kolizja(temp[polozenie[0] + ruch][polozenie[1]], polozeniePomocnicze, polozenie);
                        }
                        else {
                            polozenie[0] += ruch;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0] - ruch][polozenie[1]] = null;
                        }
                        poAkcji = true;
                        break;
                    }
                case 2:
                    if (polozenie[1] >= ruch) {
                        if (temp[polozenie[0]][polozenie[1] - ruch] != null) {
                            polozeniePomocnicze[0] = polozenie[0];
                            polozeniePomocnicze[1] = polozenie[1] - ruch;
                            kolizja(temp[polozenie[0]][polozenie[1] - ruch], polozeniePomocnicze, polozenie);
                        }
                        else {
                            polozenie[1] -= ruch;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0]][polozenie[1] + ruch] = null;
                        }
                        poAkcji = true;
                        break;
                    }
                case 3:
                    if (polozenie[1] < 20 - ruch) {
                        if (temp[polozenie[0]][polozenie[1] + ruch] != null) {
                            polozeniePomocnicze[0] = polozenie[0];
                            polozeniePomocnicze[1] = polozenie[1] + ruch;
                            kolizja(temp[polozenie[0]][polozenie[1] + ruch], polozeniePomocnicze, polozenie);
                        }
                        else {
                            polozenie[1] += ruch;
                            swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                            temp[polozenie[0]][polozenie[1] - ruch] = null;
                        }
                        poAkcji = true;
                        break;
                    }
                default:
                    poAkcji = true;
                    break;
            }
            random--;
        }
        setWiek(getWiek() + 1);
    }
    public void kolizja(Organizm org, int poleAtakowane[], int polePierwotne[]) {
        polePier[0] = polePierwotne[0];
        polePier[1] = polePierwotne[1];
        temp = swiat.getTabSwiat();
        if (this.getGatunek().compareTo(org.getGatunek()) == 0) {
            if (polozenie[1] == 0) {
                if (temp[polozenie[0]][polozenie[1] + 1] == null) {
                    polozenieTemp[1] = polozenie[1] + 1;
                    polozenieTemp[0] = polozenie[0];
                    this.tworz(polozenieTemp, swiat);
                    //cout << this.getGatunek() << " zadbal o przedluzenie gatunku.";
                }
            }
            else if (temp[polozenie[0]][polozenie[1] - 1] == null) {
                polozenieTemp[1] = polozenie[1] - 1;
                polozenieTemp[0] = polozenie[0];
                this.tworz(polozenieTemp, swiat);
                //cout << this.getGatunek() << " zadbal o przedluzenie gatunku.";
            }
        }
		else {
			if(!org.czyOdbilAtak(this)) {
                random = 1;
                boolean randomBool = true;
                if (org.getGatunek().compareTo("Antylopa") == 0) {
                    Random generator = new Random();
                    randomBool = generator.nextBoolean();
                }
                temp = swiat.getTabSwiat();
                if (randomBool) {
                    if (this.getSila() > org.getSila()) {
                        if (org.getGatunek().compareTo("Guarana") == 0) {
                            this.setSila(this.getSila() + 3);
                        }
                        org.niszcz();
                        this.polozenie[0] = poleAtakowane[0];
                        this.polozenie[1] = poleAtakowane[1];
                        swiat.setTabSwiat(poleAtakowane[0], poleAtakowane[1], this);
                        swiat.setTabSwiatNull(polePier[0], polePier[1]);

                        //cout << this.getGatunek() << " defeats " << org.getGatunek() << endl;
                    }
					else if (this.getSila() < org.getSila()) {
                        this.niszcz();
                        swiat.setTabSwiatNull(polePier[0], polePier[1]);
                        ////cout << org.getGatunek() << " defeats " << this.getGatunek() << endl;

                    }
					else {
                        org.niszcz();
                        this.polozenie[0] = poleAtakowane[0];
                        this.polozenie[1] = poleAtakowane[1];
                        swiat.setTabSwiat(poleAtakowane[0], poleAtakowane[1], this);
                        swiat.setTabSwiatNull(polePier[0], polePier[1]);
                        //cout << org.getGatunek() << " defeats " << this.getGatunek() << endl;
                    }
                }
                else {
                    if (polozenie[0] > 0 && temp[polozenie[0] - 1][polozenie[1]] == null) {
                        polozenie[0] -= 1;
                        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                        temp[polozenie[0] + 1][polozenie[1]] = null;
                        //cout << "Antylopa zdolala uciec";
                    }
                    else if (polozenie[0] < 20 - 1 && temp[polozenie[0] + 1][polozenie[1]] == null) {
                        polozenie[0] += 1;
                        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                        temp[polozenie[0] - 1][polozenie[1]] = null;
                        //cout << "Antylopa zdolala uciec";
                    }
                    else if (polozenie[1] > 0 && temp[polozenie[0]][polozenie[1] - 1] == null) {
                        polozenie[1] -= 1;
                        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                        temp[polozenie[0]][polozenie[1] + 1] = null;
                        //cout << "Antylopa zdolala uciec";
                    }
                    else if (polozenie[1] < 20 - 1 && temp[polozenie[0]][polozenie[1] + 1] == null) {
                        polozenie[1] += 1;
                        swiat.setTabSwiat(polozenie[0], polozenie[1], this);
                        temp[polozenie[0]][polozenie[1] - 1] = null;
                        //cout << "Antylopa zdolala uciec";
                    }
                    else {
                        if (this.getSila() > org.getSila()) {
                            org.niszcz();
                            swiat.setTabSwiat(poleAtakowane[0], poleAtakowane[1], this);
                            temp[polePierwotne[0]][polePierwotne[1]] = null;
                            //cout << this.getGatunek() << " defeats " << org.getGatunek() << endl;
                        }
						else if (this.getSila() < org.getSila()) {
                            this.niszcz();
                            temp[polePierwotne[0]][polePierwotne[1]] = null;
                            //cout << org.getGatunek() << " defeats " << this.getGatunek() << endl;
                        }
						else {
                            org.niszcz();
                            swiat.setTabSwiat(poleAtakowane[0], poleAtakowane[1], this);
                            temp[polePierwotne[0]][polePierwotne[1]] = null;
                            //cout << org.getGatunek() << " defeats " << this.getGatunek() << endl;
                        }
                    }
                }

            }

        }
    }
    public boolean czyOdbilAtak(Organizm atakujacy) {
        return false;
    }
    public void niszcz() {
        swiat.setTabSwiatNull(polozenie[0], polozenie[1]);
    }
}
