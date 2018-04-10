import filarySwiata.*;
import zwierzeta.*;
import warstwaWizualna.Okno;
import rosliny.*;

public class Main {
    public static void main(String[] args) {
        Okno okno = new Okno("Jakub Korthals");
        Swiat swiat = new Swiat();
        new Wilk(new int[]{2,2}, swiat);
        new Trawa(new int[]{4,4}, swiat);
        new WilczeJagody(new int[]{2,6}, swiat);
        new Trawa(new int[]{8,8}, swiat);
        new Owca(new int[]{9,8}, swiat);
        new Trawa(new int[]{10,15}, swiat);
        new Lis(new int[]{11,1}, swiat);
        new Trawa(new int[]{12,8}, swiat);
        new Antylopa(new int[]{13,18}, swiat);
        new Trawa(new int[]{7,8}, swiat);
        new Czlowiek(new int[]{13,13}, swiat, okno);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                okno.createAndShowGUI(swiat, okno);
            }
        });
    }
}
