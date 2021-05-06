package com.company.Gui;

import javax.swing.*;
import java.awt.*;

public class PageReports {
    private JPanel jpReports = null;

    public PageReports() {
    }

    public JPanel getJpReports() {
        if (jpReports == null) {
            jpReports = new JPanel();
            jpReports.setBackground(Color.red);
            jpReports.setLayout(new GridLayout(4,4,20,20));
        }
        return jpReports;
    }

    public void setJpReports(JPanel jpReports) {
        this.jpReports = jpReports;
    }
}