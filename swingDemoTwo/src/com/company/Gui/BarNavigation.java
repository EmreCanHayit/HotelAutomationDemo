package com.company.Gui;

import javax.swing.*;
import java.awt.*;

public class BarNavigation {
    private JPanel jpNav = null;
    private JButton btnMain = null;
    private JButton btnStatus = null;
    private JButton btnCustomers = null;
    private JButton btnReports = null;
    private JButton btnSettings = null;
    private JButton btnExit = null;
    private MainGui mainGui;

    public BarNavigation(MainGui mainGui) {
        this.setMainGui(mainGui);
        getJpNav().add(getBtnExit());
        getJpNav().add(getBtnMain());
        getJpNav().add(getBtnStatus());
        getJpNav().add(getBtnCustomers());
        /*getJpNav().add(getBtnReports());
        getJpNav().add(getBtnSettings());*/
    }
    public JPanel getJpNav() {
        if (jpNav == null) {
            jpNav = new JPanel();
            jpNav.setBounds(0, 0, 1500, 50);
            jpNav.setBackground(getMainGui().getSettings().colorNavigation);
            jpNav.setLayout(null);
            jpNav.addMouseListener(getMainGui().getActions());
            jpNav.addMouseMotionListener(getMainGui().getActions());
        }
        return jpNav;
    }

    public void setJpNav(JPanel jpNav) {
        this.jpNav = jpNav;
    }
    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
    public JButton getBtnMain() {
        if (btnMain == null) {
            btnMain = new JButton("Ana Sayfa");
            btnMain.setBounds(10, 0, 150, 50);
            btnMain.setBackground(getMainGui().getSettings().colorNavigation);
            btnMain.setFont(getMainGui().getSettings().fontNavigation);
            btnMain.setBorder(BorderFactory.createEmptyBorder());
            btnMain.addActionListener(getMainGui().getActions());
            btnMain.addMouseListener(getMainGui().getActions());
        }
        return btnMain;
    }

    public void setBtnMain(JButton btnMain) {
        this.btnMain = btnMain;
    }

    public JButton getBtnStatus() {
        if (btnStatus == null) {
            btnStatus = new JButton("Oda Durumu");
            btnStatus.setBounds(170, 0, 150, 50);
            btnStatus.setBackground(getMainGui().getSettings().colorNavigation);
            btnStatus.setFont(getMainGui().getSettings().fontNavigation);
            btnStatus.setBorder(BorderFactory.createEmptyBorder());
            btnStatus.addActionListener(getMainGui().getActions());
            btnStatus.addMouseListener(getMainGui().getActions());
        }
        return btnStatus;
    }

    public void setBtnStatus(JButton btnStatus) {
        this.btnStatus = btnStatus;
    }

    public JButton getBtnCustomers() {
        if (btnCustomers == null) {
            btnCustomers = new JButton("Müşteriler");
            btnCustomers.setBounds(330, 0, 150, 50);
            btnCustomers.setBackground(getMainGui().getSettings().colorNavigation);
            btnCustomers.setFont(getMainGui().getSettings().fontNavigation);
            btnCustomers.setBorder(BorderFactory.createEmptyBorder());
            btnCustomers.addActionListener(getMainGui().getActions());
            btnCustomers.addMouseListener(getMainGui().getActions());
        }
        return btnCustomers;
    }

    public void setBtnCustomers(JButton btnCustomers) {
        this.btnCustomers = btnCustomers;
    }

    public JButton getBtnReports() {
        if (btnReports == null) {
            btnReports = new JButton("Raporlar");
            btnReports.setBounds(490, 0, 150, 50);
            btnReports.setBackground(getMainGui().getSettings().colorNavigation);
            btnReports.setFont(getMainGui().getSettings().fontNavigation);
            btnReports.setBorder(BorderFactory.createEmptyBorder());
            btnReports.addActionListener(getMainGui().getActions());
            btnReports.addMouseListener(getMainGui().getActions());
        }
        return btnReports;
    }

    public void setBtnReports(JButton btnReports) {
        this.btnReports = btnReports;
    }

    public JButton getBtnSettings() {
        if (btnSettings == null) {
            btnSettings = new JButton("Ayarlar");
            btnSettings.setBounds(650, 0, 150, 50);
            btnSettings.setBackground(getMainGui().getSettings().colorNavigation);
            btnSettings.setFont(getMainGui().getSettings().fontNavigation);
            btnSettings.setBorder(BorderFactory.createEmptyBorder());
            btnSettings.addActionListener(getMainGui().getActions());
            btnSettings.addMouseListener(getMainGui().getActions());
        }
        return btnSettings;
    }

    public void setBtnSettings(JButton btnSettings) {
        this.btnSettings = btnSettings;
    }
    public JButton getBtnExit() {
        if (btnExit == null) {
            //btnExit = new JButton(getMainGui().getSettings().iconNavigation);
            btnExit = new JButton("X");
            btnExit.setFont(new Font("Seoge UI", Font.BOLD, 50));
            //btnExit.setFont(new Font("Segoe MDL2 Assets", Font.BOLD, 18));
            //btnExit.setText("\uE1D8");
            btnExit.setBounds(1450, 0, 50, 50);
            btnExit.setBackground(getMainGui().getSettings().colorNavigation);
            btnExit.setFont(getMainGui().getSettings().fontNavigation);
            btnExit.setBorder(BorderFactory.createEmptyBorder());
            btnExit.addActionListener(getMainGui().getActions());
        }
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }
}
