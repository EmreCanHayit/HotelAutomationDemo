package com.company.Gui;

import com.company.Logic.Actions;
import com.company.Logic.DataBaseManagement;
import com.company.Logic.LocationCenter;
import com.company.Logic.Settings;

import javax.swing.*;
import java.awt.*;

public class MainGui {
    private JFrame jf = null;
    private JPanel jp = null;
    private BarEdit barEdit = null;
    private BarStatus barStatus = null;
    private BarNavigation barNavigation = null;
    private BarMain barMain = null;
    private Actions actions = null;
    private Settings settings = null;
    private DataBaseManagement dataBaseManagement = null;

    public MainGui() {
        getJp().add(getBarNavigation().getJpNav());
        //getJp().add(getBarStatus().getJpStatus());
        getJp().add(getBarMain().getJpMain());
        getJp().add(getBarEdit().getJpEdit());
        getJf().setVisible(true);
    }

    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("Heaa noldu ki");
            jf.setUndecorated(true);
            jf.setSize(1500, 800);
            jf.setBackground(new Color(0, 0, 0, 0));
            LocationCenter locationCenter = new LocationCenter(jf);
            jf.setLayout(null);
            jf.setContentPane(getJp());
        }
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setLayout(null);
        }
        return jp;
    }

    public BarEdit getBarEdit() {
        if (barEdit == null) {
            barEdit = new BarEdit(this);
        }
        return barEdit;
    }

    public void setBarEdit(BarEdit barEdit) {
        this.barEdit = barEdit;
    }

    public BarStatus getBarStatus() {
        if (barStatus == null) {
            barStatus = new BarStatus(this);
        }
        return barStatus;
    }

    public void setBarStatus(BarStatus barStatus) {
        this.barStatus = barStatus;
    }

    public BarNavigation getBarNavigation() {
        if (barNavigation == null) {
            barNavigation = new BarNavigation(this);
        }
        return barNavigation;
    }

    public void setBarNavigation(BarNavigation barNavigation) {
        this.barNavigation = barNavigation;
    }

    public BarMain getBarMain() {
        if (barMain == null) {
            barMain = new BarMain(this);
        }
        return barMain;
    }

    public void setBarMain(BarMain barMain) {
        this.barMain = barMain;
    }

    public Actions getActions() {
        if (actions == null) {
            actions = new Actions(this);
        }
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public Settings getSettings() {
        if(settings == null){
            settings = new Settings();
        }
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public DataBaseManagement getDataBaseManagement() {
        if(dataBaseManagement == null){
            dataBaseManagement = new DataBaseManagement(this);
        }
        return dataBaseManagement;
    }

    public void setDataBaseManagement(DataBaseManagement dataBaseManagement) {
        this.dataBaseManagement = dataBaseManagement;
    }
}
