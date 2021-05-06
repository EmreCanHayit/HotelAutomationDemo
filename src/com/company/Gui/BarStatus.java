package com.company.Gui;

import javax.swing.*;

public class BarStatus {
    private JPanel jpStatus = null;
    private JLabel lblFull = null;
    private JLabel lblBlank = null;
    private JLabel lblDirty = null;
    private JLabel lblFault = null;
    private JButton btnNewCustomer =null;
    private JButton btnEditCustomer = null;
    private JButton btnLeaveCustomer =null;
    private MainGui mainGui;
    SpringLayout springLayout = new SpringLayout();
    public BarStatus(MainGui mainGui) {
        setMainGui(mainGui);
        getJpStatus().add(getLblFull());
        getJpStatus().add(getLblBlank());
        getJpStatus().add(getLblDirty());
        getJpStatus().add(getLblFault());
        getJpStatus().add(getBtnNewCustomer());
        getJpStatus().add(getBtnEditCustomer());
        getJpStatus().add(getBtnLeaveCustomer());
    }
    public JPanel getJpStatus() {
        if (jpStatus == null) {
            jpStatus = new JPanel();
            jpStatus.setBounds(0, 50, 1500, 30);
            jpStatus.setBackground(getMainGui().getSettings().colorStatus);
            jpStatus.setLayout(springLayout);
            jpStatus.setVisible(false);
        }
        return jpStatus;
    }

    public void setJpStatus(JPanel jpStatus) {
        this.jpStatus = jpStatus;
    }

    public JLabel getLblFull() {
        if (lblFull == null) {
            ImageIcon img = new ImageIcon(getClass().getResource("iconInfo.png"));
            lblFull = new JLabel("Dolu", getMainGui().getSettings().iconStatus, JLabel.CENTER);
            lblFull.setHorizontalTextPosition(JLabel.LEFT);

            springLayout.putConstraint(SpringLayout.WEST, lblFull, getMainGui().getSettings().springStatus, SpringLayout.WEST, getJpStatus());
            springLayout.putConstraint(SpringLayout.NORTH, lblFull, 0, SpringLayout.NORTH, getJpStatus());
            springLayout.putConstraint(SpringLayout.SOUTH, lblFull, 0, SpringLayout.SOUTH, getJpStatus());
        }
        return lblFull;
    }

    public void setLblFull(JLabel lblFull) {
        this.lblFull = lblFull;
    }

    public JLabel getLblBlank() {
        if (lblBlank == null) {
            ImageIcon img = new ImageIcon(getClass().getResource("iconInfo.png"));
            lblBlank = new JLabel("Boş", img, JLabel.CENTER);
            lblBlank.setHorizontalTextPosition(JLabel.LEFT);

            springLayout.putConstraint(SpringLayout.WEST, lblBlank, getMainGui().getSettings().springStatus, SpringLayout.EAST, getLblFull());
            springLayout.putConstraint(SpringLayout.NORTH, lblBlank, 0, SpringLayout.NORTH, getJpStatus());
            springLayout.putConstraint(SpringLayout.SOUTH, lblBlank, 0, SpringLayout.SOUTH, getJpStatus());
        }
        return lblBlank;
    }

    public void setLblBlank(JLabel lblBlank) {
        this.lblBlank = lblBlank;
    }

    public JLabel getLblDirty() {
        if (lblDirty == null) {
            ImageIcon img = new ImageIcon(getClass().getResource("iconInfo.png"));
            lblDirty = new JLabel("Kirli", img, JLabel.CENTER);
            lblDirty.setHorizontalTextPosition(JLabel.LEFT);

            springLayout.putConstraint(SpringLayout.WEST, lblDirty, getMainGui().getSettings().springStatus, SpringLayout.EAST, getLblBlank());
            springLayout.putConstraint(SpringLayout.NORTH, lblDirty, 0, SpringLayout.NORTH, getJpStatus());
            springLayout.putConstraint(SpringLayout.SOUTH, lblDirty, 0, SpringLayout.SOUTH, getJpStatus());
        }
        return lblDirty;
    }

    public void setLblDirty(JLabel lblDirty) {
        this.lblDirty = lblDirty;
    }

    public JLabel getLblFault() {
        if (lblFault == null) {
            ImageIcon img = new ImageIcon(getClass().getResource("iconInfo.png"));
            lblFault = new JLabel("Arızalı", img, JLabel.CENTER);
            //lblFault.setVerticalTextPosition(JLabel.CENTER);
            lblFault.setHorizontalTextPosition(JLabel.LEFT);

            springLayout.putConstraint(SpringLayout.WEST, lblFault, getMainGui().getSettings().springStatus, SpringLayout.EAST, getLblDirty());
            springLayout.putConstraint(SpringLayout.NORTH, lblFault, 0, SpringLayout.NORTH, getJpStatus());
            springLayout.putConstraint(SpringLayout.SOUTH, lblFault, 0, SpringLayout.SOUTH, getJpStatus());
        }
        return lblFault;
    }

    public void setLblFault(JLabel lblFault) {
        this.lblFault = lblFault;
    }

    public JButton getBtnNewCustomer() {
        if(btnNewCustomer == null){
            btnNewCustomer=new JButton("Yeni Müşteri Ekle");
            btnNewCustomer.setBackground(getMainGui().getSettings().colorStatus);
            btnNewCustomer.setEnabled(true);
            btnNewCustomer.setBorder(null);
            btnNewCustomer.setVisible(true);
            btnNewCustomer.addActionListener(getMainGui().getActions());
            btnNewCustomer.addMouseListener(getMainGui().getActions());

            springLayout.putConstraint(SpringLayout.EAST, btnNewCustomer, -getMainGui().getSettings().springStatus, SpringLayout.EAST, getJpStatus());
            springLayout.putConstraint(SpringLayout.NORTH, btnNewCustomer, 0, SpringLayout.NORTH, getJpStatus());
            springLayout.putConstraint(SpringLayout.SOUTH, btnNewCustomer, 0, SpringLayout.SOUTH, getJpStatus());
        }
        return btnNewCustomer;
    }

    public void setBtnNewCustomer(JButton btnNewCustomer) {
        this.btnNewCustomer = btnNewCustomer;
    }

    public JButton getBtnEditCustomer() {
        if(btnEditCustomer == null){
            btnEditCustomer=new JButton("Müşteri Düzenle");
            btnEditCustomer.setBackground(getMainGui().getSettings().colorStatus);
            btnEditCustomer.setOpaque(false);
            btnEditCustomer.setEnabled(true);
            btnEditCustomer.setBorder(null);
            btnEditCustomer.setVisible(false);
            btnEditCustomer.addActionListener(getMainGui().getActions());
            btnEditCustomer.addMouseListener(getMainGui().getActions());

            springLayout.putConstraint(SpringLayout.EAST, btnEditCustomer, -getMainGui().getSettings().springStatus, SpringLayout.WEST, getBtnNewCustomer());
            springLayout.putConstraint(SpringLayout.NORTH, btnEditCustomer, 0, SpringLayout.NORTH, getJpStatus());
            springLayout.putConstraint(SpringLayout.SOUTH, btnEditCustomer, 0, SpringLayout.SOUTH, getJpStatus());
        }
        return btnEditCustomer;
    }

    public JButton getBtnLeaveCustomer() {
        if(btnLeaveCustomer == null){
            btnLeaveCustomer=new JButton("Müşteri Çıkış");
            btnLeaveCustomer.setBackground(getMainGui().getSettings().colorStatus);
            btnLeaveCustomer.setOpaque(false);
            btnLeaveCustomer.setEnabled(true);
            btnLeaveCustomer.setBorder(null);
            btnLeaveCustomer.setVisible(true);
            btnLeaveCustomer.addActionListener(getMainGui().getActions());
            //btnLeaveCustomer.addMouseListener(getMainGui().actions);

            springLayout.putConstraint(SpringLayout.EAST, btnLeaveCustomer, -getMainGui().getSettings().springStatus, SpringLayout.WEST, getBtnEditCustomer());
            springLayout.putConstraint(SpringLayout.NORTH, btnLeaveCustomer, 0, SpringLayout.NORTH, getJpStatus());
            springLayout.putConstraint(SpringLayout.SOUTH, btnLeaveCustomer, 0, SpringLayout.SOUTH, getJpStatus());
        }
        return btnLeaveCustomer;
    }

    public void setBtnLeaveCustomer(JButton btnLeaveCustomer) {
        this.btnLeaveCustomer = btnLeaveCustomer;
    }

    public void setBtnEditCustomer(JButton btnEditCustomer) {
        this.btnEditCustomer = btnEditCustomer;
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }
}
