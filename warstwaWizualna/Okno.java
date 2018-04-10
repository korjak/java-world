package warstwaWizualna;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import filarySwiata.*;

public class Okno extends JFrame implements KeyListener {
    GridLayout mapaLayout = new GridLayout(20,20, 0, 0);
    GridLayout sterowanieLayout = new GridLayout(1,3);
    JButton[] przyciski = new JButton[400];
    JPanel mapa;
    int i, numerPrzycisku;
    int kodKlawisza;
    Integer k = new Integer(5);
    Organizm tempTab[][];
    JComboBox organizmyDoStworzenia;
    JButton tempButton;
    Okno tenObiekt = this;
    int x, y;
    String listaOrgananizmowDoStworzenia[] = {"Antylopa", "Lis", "Owca", "Wilk", "Zolw", "Barszcz Sosnowskiego", "Guarana", "Mlecz", "Trawa", "Wilcze Jagody"};
    public Okno(String name) {
        super(name);
        setResizable(false);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void addComponentsToPane(Container pane, Swiat swiat) {
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }
        mapa = new JPanel();
        mapa.setFocusable(false);
        JPanel sterowanie = new JPanel();
        sterowanie.setFocusable(false);
        organizmyDoStworzenia = new JComboBox(listaOrgananizmowDoStworzenia);
        organizmyDoStworzenia.setFocusable(false);
        sterowanie.setLayout(sterowanieLayout);
        this.nowaTura(pane, swiat, mapa);
        Label doStworzenia = new Label(" Organizm do stworzenia: ");
        doStworzenia.setFocusable(false);
        sterowanie.add(doStworzenia);
        sterowanie.add(organizmyDoStworzenia);
        tempButton = new JButton("Następna tura");
        tempButton.setFocusable(false);
        tempButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swiat.wykonajTure();
                tenObiekt.nowaTura(pane, swiat, mapa);
            }
        });
        sterowanie.add(tempButton);
        pane.add(mapa, BorderLayout.NORTH);
        pane.add(sterowanie, BorderLayout.SOUTH);
    }
    public void wywolajNowaTure(Swiat swiat) {
        nowaTura(this.getContentPane(), swiat, mapa);
    }
    public void nowaTura(Container pane, Swiat swiat, JPanel mapa) {
        kodKlawisza = 0;
        mapa.removeAll();
        mapa.setLayout(mapaLayout);
        mapa.setPreferredSize(new Dimension(500, 500));
        x = 0;
        y = 0;
        for(i = 0; i < 400; i++) {
            tempTab = swiat.getTabSwiat();
            if(tempTab[x][y] == null) {
                String lp = String.valueOf(i);
                przyciski[i] = new JButton(lp);
                przyciski[i].setFocusable(false);
                przyciski[i].setForeground(new Color(255, 255, 255, 0));
                przyciski[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        numerPrzycisku = Integer.parseInt(e.getActionCommand());
                        String gatunek = (String)organizmyDoStworzenia.getSelectedItem();
                        swiat.tworzNowyOrganizm(numerPrzycisku % 20, (numerPrzycisku - (numerPrzycisku % 20)) / 20 , gatunek);
                        nowaTura(pane, swiat, mapa);
                    }
                });
                mapa.add(przyciski[i]);
            }
            else {
                tempButton = new JButton();
                tempButton.setFocusable(false);
                tempButton.setBackground(tempTab[x][y].getKolor());
                mapa.add(tempButton);
            }
            if(x == 19) {
                y++;
                x = 0;
            }
            else {
                x++;
            }
        }
        mapa.updateUI();
        pane.add(mapa, BorderLayout.NORTH);
    }
    public void createAndShowGUI(Swiat swiat, Okno okno) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentsToPane(this.getContentPane(), swiat);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent key) {
        System.out.println(key.getKeyCode());
        kodKlawisza = key.getKeyCode();
        //kodKlawisza = 17;
        System.out.println("FUNKCJA klawisz: "+kodKlawisza);
    }
    @Override
    public void keyReleased(KeyEvent key) {
    }
    @Override
    public void keyTyped(KeyEvent key) {
    }

    public int getKodKlawisza() {
        System.out.println("OKNO klawisz: "+kodKlawisza);
        return kodKlawisza;
    }

}
