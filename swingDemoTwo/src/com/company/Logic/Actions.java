package com.company.Logic;

import com.company.Gui.MainGui;

import java.awt.*;
import java.awt.event.*;

public class Actions implements ActionListener, MouseListener, MouseMotionListener {
    private MainGui mainGui;
    int xMouse, yMouse;

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }

    public Actions(MainGui mainGui) {
        setMainGui(mainGui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getMainGui().getBarNavigation().getBtnExit()) {
            System.exit(0);
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnMain()) {
            getMainGui().getBarMain().getCardLayout().show(getMainGui().getBarMain().getJpMain(), "1");
            getMainGui().getBarEdit().getJpEdit().setVisible(false);
            getMainGui().getBarMain().getJpMain().setSize(1500, 750);
            getMainGui().getBarMain().getPageMain().getJpMain().setSize(1500, 750);
            getMainGui().getBarMain().getJpMain().setLocation(0, 50);
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnStatus()) {
            getMainGui().getBarMain().getCardLayout().show(getMainGui().getBarMain().getJpMain(), "2");
            getMainGui().getBarEdit().getJpEdit().setVisible(true);
            getMainGui().getBarMain().getJpMain().setSize(1500, 700);
            getMainGui().getBarMain().getJpMain().setLocation(0, 50);
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnCustomers()) {
            getMainGui().getBarMain().getCardLayout().show(getMainGui().getBarMain().getJpMain(), "3");
            getMainGui().getBarEdit().getJpEdit().setVisible(true);
            getMainGui().getBarMain().getJpMain().setSize(1500, 700);
            getMainGui().getBarMain().getJpMain().setLocation(0, 50);
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnReports()) {
            getMainGui().getBarMain().getCardLayout().show(getMainGui().getBarMain().getJpMain(), "4");
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnSettings()) {
            getMainGui().getBarMain().getCardLayout().show(getMainGui().getBarMain().getJpMain(), "5");
        } else if (e.getSource() == getMainGui().getBarStatus().getBtnNewCustomer()) {
            getMainGui().getBarMain().getCardLayout().show(getMainGui().getBarMain().getJpMain(), "6");
        } else if (e.getSource() == getMainGui().getBarStatus().getBtnEditCustomer()) {
            getMainGui().getBarMain().getCardLayout().show(getMainGui().getBarMain().getJpMain(), "7");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        xMouse = e.getX();
        yMouse = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == getMainGui().getBarNavigation().getBtnMain()) {
            getMainGui().getBarNavigation().getBtnMain().setBackground(new Color(126, 255, 245));
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnStatus()) {
            getMainGui().getBarNavigation().getBtnStatus().setBackground(new Color(126, 255, 245));
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnCustomers()) {
            getMainGui().getBarNavigation().getBtnCustomers().setBackground(new Color(126, 255, 245));
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnReports()) {
            getMainGui().getBarNavigation().getBtnReports().setBackground(new Color(126, 255, 245));
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnSettings()) {
            getMainGui().getBarNavigation().getBtnSettings().setBackground(new Color(126, 255, 245));
        } else if (e.getSource() == getMainGui().getBarStatus().getBtnNewCustomer()) {
            getMainGui().getBarStatus().getBtnNewCustomer().setBackground(new Color(126, 255, 245));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == getMainGui().getBarNavigation().getBtnMain()) {
            getMainGui().getBarNavigation().getBtnMain().setBackground(new Color(241, 231, 254));
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnStatus()) {
            getMainGui().getBarNavigation().getBtnStatus().setBackground(new Color(241, 231, 254));
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnCustomers()) {
            getMainGui().getBarNavigation().getBtnCustomers().setBackground(new Color(241, 231, 254));
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnReports()) {
            getMainGui().getBarNavigation().getBtnReports().setBackground(new Color(241, 231, 254));
        } else if (e.getSource() == getMainGui().getBarNavigation().getBtnSettings()) {
            getMainGui().getBarNavigation().getBtnSettings().setBackground(new Color(241, 231, 254));
        } else if (e.getSource() == getMainGui().getBarStatus().getBtnNewCustomer()) {
            getMainGui().getBarStatus().getBtnNewCustomer().setBackground(new Color(213, 184, 255));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        getMainGui().getJf().setLocation(x - xMouse, y - yMouse);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
