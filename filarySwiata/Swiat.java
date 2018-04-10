package filarySwiata;
import rosliny.*;
import zwierzeta.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public class Swiat {
    private int licznikTur;
    private List<Organizm> listaOrganizmow = new LinkedList<Organizm>();
    private Organizm tabSwiat[][] = new Organizm[20][20];
    public Swiat()
    {
        licznikTur = 0;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                tabSwiat[i][j] = null;
            }
        }

    }
    public void wykonajTure() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (tabSwiat[j][i] != null) {
                    listaOrganizmow.add(tabSwiat[j][i]);
                }
            }
        }
        Collections.sort(listaOrganizmow, new Comparator<Organizm>() {
            @Override
            public int compare(Organizm o1, Organizm o2) {
                if (o1.getInicjatywa() > o2.getInicjatywa()) {
                    return 1;
                }
                else if (o1.getInicjatywa() < o2.getInicjatywa()) {
                    return -1;
                }
                else {
                    if (o1.getWiek() > o2.getWiek()) {
                        return 1;
                    }
                    else if (o1.getWiek() < o2.getWiek()) {
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        });
        for (Organizm org : listaOrganizmow) {
            org.akcja();
        }
        listaOrganizmow.clear();
        //rysujSwiat();
        licznikTur++;
    }
/*    void rysujSwiat() {
        clear();
        refresh();
        cout << "Autor: Jakub Korthals 165202" << endl;
        for (int i = 0; i < YMAX; i++) {
            for (int j = 0; j < XMAX; j++) {
                if (tabSwiat[j][i] != nullptr) {
                    cout << tabSwiat[j][i]->getZnak();
                }
                else {
                    cout << "-";
                }
            }
            cout << endl;
        }
        move(0, 22);
    } */
    public void setTabSwiat(int x, int y, Organizm setOrg) {
        tabSwiat[x][y] = setOrg;
    }
    public void setTabSwiatNull(int x, int y) {
        tabSwiat[x][y] = null;
    }
    public Organizm[][] getTabSwiat() {
        return tabSwiat;
    }
    public void tworzNowyOrganizm(int polozenieX, int polozenieY, String gatunek) {
        switch(gatunek) {
            case "Barszcz Sosnowskiego":
                new BarszczSosnowskiego(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Guarana":
                new Guarana(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Mlecz":
                new Mlecz(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Trawa":
                new Trawa(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Wilcze Jagody":
                new WilczeJagody(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Antylopa":
                new Antylopa(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Lis":
                new Lis(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Owca":
                new Owca(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Wilk":
                new Wilk(new int[]{polozenieX, polozenieY}, this);
                break;
            case "Zolw":
                new Zolw(new int[]{polozenieX, polozenieY}, this);
                break;
            default:
                System.out.println("ERROR: nie rozpoznano gatunku");
                break;
        }
    }
}
