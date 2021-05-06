package com.company.Gui;

import javax.swing.*;

public class BarEdit {
    private JPanel jpEdit = null;
    private JLabel dollar = null;
    private JLabel euro = null;
    private JLabel ruble = null;
    private JLabel yen = null;
    private JLabel pound = null;
    private JLabel franc = null;
    private JLabel statisticFull = null;
    private JLabel statisticBlank = null;
    private JLabel statisticCustomer = null;
    private MainGui mainGui;
    SpringLayout springLayout = new SpringLayout();

    public BarEdit(MainGui mainGui) {
        setMainGui(mainGui);
        getJpEdit().add(getDollar());
        getJpEdit().add(getEuro());
        getJpEdit().add(getRuble());
        getJpEdit().add(getYen());
        getJpEdit().add(getPound());
        getJpEdit().add(getFranc());
        getJpEdit().add(getStatisticFull());
        getJpEdit().add(getStatisticBlank());
        getJpEdit().add(getStatisticCustomer());
    }

    public JPanel getJpEdit() {
        if (jpEdit == null) {
            jpEdit = new JPanel();
            jpEdit.setBounds(0, 750, 1500, 50);
            jpEdit.setBackground(getMainGui().getSettings().colorEdit);
            jpEdit.setLayout(springLayout);
            jpEdit.setVisible(false);
        }
        return jpEdit;
    }

    public void setJpEdit(JPanel jpEdit) {
        this.jpEdit = jpEdit;
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }

    public JLabel getDollar() {
        if (dollar == null) {
            dollar = new JLabel(getMainGui().getDataBaseManagement().currencyName[0]+" : "+getMainGui().getDataBaseManagement().currencyRate[0]);
            dollar.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.WEST, dollar, getMainGui().getSettings().springEdit, SpringLayout.WEST, getJpEdit());
            springLayout.putConstraint(SpringLayout.NORTH, dollar, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, dollar, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return dollar;
    }

    public void setDollar(JLabel dollar) {
        this.dollar = dollar;
    }

    public JLabel getEuro() {
        if (euro == null) {
            euro = new JLabel(getMainGui().getDataBaseManagement().currencyName[1]+" : "+getMainGui().getDataBaseManagement().currencyRate[1]);
            euro.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.WEST, euro, getMainGui().getSettings().springEdit, SpringLayout.EAST, getDollar());
            springLayout.putConstraint(SpringLayout.NORTH, euro, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, euro, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return euro;
    }

    public void setEuro(JLabel euro) {
        this.euro = euro;
    }

    public JLabel getRuble() {
        if (ruble == null) {
            ruble = new JLabel(getMainGui().getDataBaseManagement().currencyName[2]+" : "+getMainGui().getDataBaseManagement().currencyRate[2]);
            ruble.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.WEST, ruble, getMainGui().getSettings().springEdit, SpringLayout.EAST, getEuro());
            springLayout.putConstraint(SpringLayout.NORTH, ruble, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, ruble, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return ruble;
    }

    public void setRuble(JLabel ruble) {
        this.ruble = ruble;
    }

    public JLabel getYen() {
        if (yen == null) {
            yen = new JLabel(getMainGui().getDataBaseManagement().currencyName[3]+" : "+getMainGui().getDataBaseManagement().currencyRate[3]);
            yen.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.WEST, yen, getMainGui().getSettings().springEdit, SpringLayout.EAST, getRuble());
            springLayout.putConstraint(SpringLayout.NORTH, yen, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, yen, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return yen;
    }

    public void setYen(JLabel yen) {
        this.yen = yen;
    }

    public JLabel getPound() {
        if (pound == null) {
            pound = new JLabel(getMainGui().getDataBaseManagement().currencyName[4]+" : "+getMainGui().getDataBaseManagement().currencyRate[4]);
            pound.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.WEST, pound, getMainGui().getSettings().springEdit, SpringLayout.EAST, getYen());
            springLayout.putConstraint(SpringLayout.NORTH, pound, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, pound, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return pound;
    }

    public void setPound(JLabel pound) {
        this.pound = pound;
    }

    public JLabel getFranc() {
        if (franc == null) {
            franc = new JLabel(getMainGui().getDataBaseManagement().currencyName[5]+" : "+getMainGui().getDataBaseManagement().currencyRate[5]);
            franc.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.WEST, franc, getMainGui().getSettings().springEdit, SpringLayout.EAST, getPound());
            springLayout.putConstraint(SpringLayout.NORTH, franc, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, franc, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return franc;
    }

    public void setFranc(JLabel franc) {
        this.franc = franc;
    }

    public JLabel getStatisticFull() {
        if (statisticFull == null) {
            statisticFull = new JLabel("Boş oda : "+getMainGui().getDataBaseManagement().totalRoomBlank);
            statisticFull.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.EAST, statisticFull, -getMainGui().getSettings().springEdit, SpringLayout.EAST, getJpEdit());
            springLayout.putConstraint(SpringLayout.NORTH, statisticFull, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, statisticFull, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return statisticFull;
    }

    public void setStatisticFull(JLabel statisticFull) {
        this.statisticFull = statisticFull;
    }

    public JLabel getStatisticBlank() {
        if (statisticBlank == null) {
            statisticBlank = new JLabel("Dolu oda : "+getMainGui().getDataBaseManagement().totalRoomFull);
            statisticBlank.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.EAST, statisticBlank, -getMainGui().getSettings().springEdit, SpringLayout.WEST, getStatisticFull());
            springLayout.putConstraint(SpringLayout.NORTH, statisticBlank, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, statisticBlank, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return statisticBlank;
    }

    public void setStatisticBlank(JLabel statisticBlank) {
        this.statisticBlank = statisticBlank;
    }

    public JLabel getStatisticCustomer() {
        if (statisticCustomer == null) {
            statisticCustomer = new JLabel("Müşteri : "+getMainGui().getDataBaseManagement().totalCustomer);
            statisticCustomer.setFont(getMainGui().getSettings().fontEdit);
            springLayout.putConstraint(SpringLayout.EAST, statisticCustomer, -getMainGui().getSettings().springEdit, SpringLayout.WEST, getStatisticBlank());
            springLayout.putConstraint(SpringLayout.NORTH, statisticCustomer, 0, SpringLayout.NORTH, getJpEdit());
            springLayout.putConstraint(SpringLayout.SOUTH, statisticCustomer, 0, SpringLayout.SOUTH, getJpEdit());
        }
        return statisticCustomer;
    }

    public void setStatisticCustomer(JLabel statisticCustomer) {
        this.statisticCustomer = statisticCustomer;
    }
}
