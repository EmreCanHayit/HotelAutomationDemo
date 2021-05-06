package com.company.Gui;

import javax.swing.*;
import java.awt.*;

public class PageStatus {
    private JPanel jpStatus = null;
    private BarMain barMain;

    public PageStatus(BarMain barMain) {
        setBarMain(barMain);
        getJpStatus().add(getBarMain().getMainGui().getDataBaseManagement().getTek(), BorderLayout.CENTER);
    }

    public JPanel getJpStatus() {
        if (jpStatus == null) {
            jpStatus = new JPanel();
            jpStatus.setBackground(getBarMain().getMainGui().getSettings().colorPageStatus);
            jpStatus.setBorder(getBarMain().getMainGui().getSettings().borderPageStatus);
            jpStatus.setLayout(new BorderLayout());
        }
        return jpStatus;
    }

    public void setJpStatus(JPanel jpStatus) {
        this.jpStatus = jpStatus;
    }

    public BarMain getBarMain() {
        return barMain;
    }

    public void setBarMain(BarMain barMain) {
        this.barMain = barMain;
    }
}
