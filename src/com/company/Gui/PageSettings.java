package com.company.Gui;

import javax.swing.*;
import java.awt.*;

public class PageSettings {
    private JPanel jpSettings = null;
    private JPanel hamburger = null;
    public PageSettings() {
        getJpSettings().add(getHamburger(), BorderLayout.WEST);
    }
    public JPanel getJpSettings() {
        if (jpSettings == null) {
            jpSettings = new JPanel();
            jpSettings.setBackground(Color.pink);
            jpSettings.setLayout(new BorderLayout());
        }
        return jpSettings;
    }

    public void setJpSettings(JPanel jpSettings) {
        this.jpSettings = jpSettings;
    }

    public JPanel getHamburger() {
        if(hamburger== null){
            hamburger = new JPanel();
            hamburger.setPreferredSize(new Dimension(300,670));
            hamburger.setBackground(Color.white);
            hamburger.setLayout(new GridLayout(15,1));

            for(int i =0; i<9; i++){
                hamburger.add(new JButton("Deneme"+i));
            }
        }
        return hamburger;
    }

    public void setHamburger(JPanel hamburger) {
        this.hamburger = hamburger;
    }
}
