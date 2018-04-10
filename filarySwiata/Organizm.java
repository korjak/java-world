package filarySwiata;
import java.awt.*;

public abstract class Organizm implements Comparable<Organizm>{
    protected int sila;
    protected int inicjatywa;
    protected int[] polozenie = new int[2];
    protected int[] polePier = new int[2];
    protected int[] polozeniePomocnicze = new int[2];
    protected int[] polozenieTemp = new int[2];
    protected int random;
    protected int input;
    protected int wiek;
    protected int ruch;
    protected Swiat swiat;
    protected String gatunek;
    protected String gatunek1;
    protected boolean poAkcji;
    protected Organizm[][] temp;
    protected Color kolor;
    protected int czasU;
    protected int odlRuchu;
    protected boolean isSkillOn;
    public abstract void akcja();
    public abstract void kolizja(Organizm org, int poleAtakowane[], int polePierwotne[]);
    public abstract void tworz(int polozenie[], Swiat swiat);
    public abstract void niszcz();
    public Color getKolor() {
        return kolor;
    }
    public int getSila() {
        return sila;
    }
    public String getGatunek() {
        return gatunek;
    }
    public void setSila(int sila) {
        this.sila = sila;
    }
    public int getInicjatywa() {
        return inicjatywa;
    }
    public int getWiek() {
        return wiek;
    }
    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }
    public void setCzasU(int czasU) {
        this.czasU = czasU;
    }
    public void setPolozenieX(int polozenieX) {
        this.polozenie[0] = polozenieX;
    }
    public void setPolozenieY(int polozenieY) {
        this.polozenie[1] = polozenieY;
    }
    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }
    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }
    public int getCzasU() {
        return czasU;
    }
    public int getPolozenieX() {
        return polozenie[0];
    }
    public int getPolozenieY() {
        return polozenie[1];
    }
    public Swiat getSwiat() {
        return swiat;
    }
    public abstract boolean czyOdbilAtak(Organizm org);

    @Override
    public int compareTo(Organizm org) {
        if(this.sila > org.sila) {
            return 1;
        }
        else if(this.sila < org.sila) {
            return -1;
        }
        else {
            if(this.inicjatywa > org.inicjatywa) {
                return 1;
            }
            else if(this.inicjatywa < org.inicjatywa) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }


}