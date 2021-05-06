package com.company.Gui;

import javax.swing.*;
import java.awt.*;

public class BarMain {
    private JPanel jpMain = null;
    private CardLayout cardLayout = null;
    private PageMain pageMain = null;
    private PageEditCustomer pageEditCustomer = null;
    private PageStatus pageStatus = null;
    private PageCustomers pageCustomers = null;
    private PageReports pageReports = null;
    private PageSettings pageSettings = null;
    private MainGui mainGui;

    public BarMain(MainGui mainGui) {
        setMainGui(mainGui);
        getJpMain().add(getPageMain().getJpMain(), "1");
        getJpMain().add(getPageStatus().getJpStatus(), "2");
        getJpMain().add(getPageCustomers().getJpCustomer(), "3");
        getJpMain().add(getPageReports().getJpReports(), "4");
        getJpMain().add(getPageSettings().getJpSettings(), "5");
        getJpMain().add(getPageEditCustomer().getJpNewCustomer(), "7");
        getCardLayout().show(jpMain, "1");
    }

    public JPanel getJpMain() {
        if (jpMain == null) {
            jpMain = new JPanel();
            jpMain.setBounds(0, 50, 1500, 750);
            jpMain.setLayout(getCardLayout());
        }
        return jpMain;
    }

    public void setJpMain(JPanel jpMain) {
        this.jpMain = jpMain;
    }

    public CardLayout getCardLayout() {
        if (cardLayout == null) {
            cardLayout = new CardLayout();
        }
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public PageMain getPageMain() {
        if (pageMain == null) {
            pageMain = new PageMain(this);
        }
        return pageMain;
    }

    public void setPageMain(PageMain pageMain) {
        this.pageMain = pageMain;
    }

    public PageStatus getPageStatus() {
        if (pageStatus == null) {
            pageStatus = new PageStatus(this);
        }
        return pageStatus;
    }

    public void setPageStatus(PageStatus pageStatus) {
        this.pageStatus = pageStatus;
    }

    public PageCustomers getPageCustomers() {
        if (pageCustomers == null) {
            pageCustomers = new PageCustomers(this);
        }
        return pageCustomers;
    }

    public void setPageCustomers(PageCustomers pageCustomers) {
        this.pageCustomers = pageCustomers;
    }

    public PageReports getPageReports() {
        if (pageReports == null) {
            pageReports = new PageReports();
        }
        return pageReports;
    }

    public void setPageReports(PageReports pageReports) {
        this.pageReports = pageReports;
    }

    public PageSettings getPageSettings() {
        if (pageSettings == null) {
            pageSettings = new PageSettings();
        }
        return pageSettings;
    }

    public void setPageSettings(PageSettings pageSettings) {
        this.pageSettings = pageSettings;
    }


    public PageEditCustomer getPageEditCustomer() {
        if (pageEditCustomer == null) {
            pageEditCustomer = new PageEditCustomer(this);
        }
        return pageEditCustomer;
    }

    public void setPageEditCustomer(PageEditCustomer pageEditCustomer) {
        this.pageEditCustomer = pageEditCustomer;
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}
