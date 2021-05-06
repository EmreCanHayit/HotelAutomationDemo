package com.company.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class PageEditCustomer {
    private JPanel jpNewCustomer = null;
    private JPanel roomEdit = null;
    private JPanel jpRoomShow = null;
    private JScrollPane roomShow = null;
    private JTextField txtCustomerName = null;
    private JTextField txtCustomerNumber = null;
    private JFormattedTextField txtDate = null;
    private JFormattedTextField txtCustomerDate = null;
    private JButton btnEditCustomer = null;
    private JButton btnExitCustomer = null;
    private JComboBox cbRoomNumber = null;
    private JComboBox cbRoomCapacity = null;
    private JComboBox cbRoomStatus = null;
    private BarMain barMain;
    public SpringLayout springLayout = new SpringLayout();

    public PageEditCustomer(BarMain barMain) {
        setBarMain(barMain);
        getJpNewCustomer().add(getRoomShow(), BorderLayout.WEST);
        getJpNewCustomer().add(getRoomEdit(), BorderLayout.EAST);
    }

    public JPanel getJpNewCustomer() {
        if (jpNewCustomer == null) {
            jpNewCustomer = new JPanel();
            jpNewCustomer.setLayout(new BorderLayout());
        }
        return jpNewCustomer;
    }

    public void setJpNewCustomer(JPanel jpNewCustomer) {
        this.jpNewCustomer = jpNewCustomer;
    }

    public JPanel getRoomEdit() {
        if (roomEdit == null) {
            roomEdit = new JPanel();
            roomEdit.setBackground(getBarMain().getMainGui().getSettings().colorNewCustomer);
            roomEdit.setBorder(getBarMain().getMainGui().getSettings().borderNewCustomer);
            roomEdit.setLayout(springLayout);
            roomEdit.setPreferredSize(new Dimension(500, 670));

            roomEdit.add(getCbRoomNumber());
            roomEdit.add(getCbRoomCapacity());
            roomEdit.add(getCbRoomStatus());
            roomEdit.add(getTxtCustomerNumber());
            roomEdit.add(getTxtCustomerName());
            roomEdit.add(getTxtDate());
            roomEdit.add(getTxtCustomerDate());
            roomEdit.add(getBtnEditCustomer());
            roomEdit.add(getBtnExitCustomer());
        }
        return roomEdit;
    }

    public void setRoomEdit(JPanel roomEdit) {
        this.roomEdit = roomEdit;
    }

    public JScrollPane getRoomShow() {
        if (roomShow == null) {
            roomShow = new JScrollPane(getJpRoomShow(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            roomShow.getVerticalScrollBar().setUnitIncrement(20);
            roomShow.setBorder(null);
            roomShow.setPreferredSize(new Dimension(1000, 670));
        }
        return roomShow;
    }

    public void setRoomShow(JScrollPane roomShow) {
        this.roomShow = roomShow;
    }

    public JTextField getTxtCustomerName() {
        if (txtCustomerName == null) {
            txtCustomerName = new JTextField("Müşteri Adı", 15);
            txtCustomerName.setOpaque(false);
            txtCustomerName.setBorder(BorderFactory.createCompoundBorder(
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldLine,
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldEmpty));
            txtCustomerName.addFocusListener((FocusListener) getBarMain().getMainGui().getDataBaseManagement().actionData);
            txtCustomerName.addKeyListener((KeyListener) getBarMain().getMainGui().getDataBaseManagement().actionData);

            springLayout.putConstraint(SpringLayout.WEST, txtCustomerName, 0, SpringLayout.WEST, getRoomEdit());
            springLayout.putConstraint(SpringLayout.NORTH, txtCustomerName, 20, SpringLayout.SOUTH, getTxtCustomerNumber());
            springLayout.putConstraint(SpringLayout.EAST, txtCustomerName, 0, SpringLayout.EAST, getRoomEdit());
            springLayout.getConstraints(txtCustomerName).setHeight(Spring.constant(50));
        }
        return txtCustomerName;
    }

    public void setTxtCustomerName(JTextField txtCustomerName) {
        this.txtCustomerName = txtCustomerName;
    }

    public JTextField getTxtCustomerNumber() {
        if (txtCustomerNumber == null) {
            txtCustomerNumber = new JTextField("Müşteri TC Numarası", 15);
            txtCustomerNumber.setOpaque(false);
            txtCustomerNumber.setBorder(BorderFactory.createCompoundBorder(
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldLine,
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldEmpty));
            txtCustomerNumber.addFocusListener((FocusListener) getBarMain().getMainGui().getDataBaseManagement().actionData);
            txtCustomerNumber.addKeyListener((KeyListener) getBarMain().getMainGui().getDataBaseManagement().actionData);

            springLayout.putConstraint(SpringLayout.WEST, txtCustomerNumber, 0, SpringLayout.WEST, getRoomEdit());
            springLayout.putConstraint(SpringLayout.NORTH, txtCustomerNumber, 20, SpringLayout.SOUTH, getCbRoomNumber());
            springLayout.putConstraint(SpringLayout.EAST, txtCustomerNumber, 0, SpringLayout.EAST, getRoomEdit());
            springLayout.getConstraints(txtCustomerNumber).setHeight(Spring.constant(50));
        }
        return txtCustomerNumber;
    }

    public void setTxtCustomerNumber(JTextField txtCustomerNumber) {
        this.txtCustomerNumber = txtCustomerNumber;
    }

    public JButton getBtnEditCustomer() {
        if (btnEditCustomer == null) {
            btnEditCustomer = new JButton("Düzelt");
            btnEditCustomer.setBackground(getBarMain().getMainGui().getSettings().colorPageEditBtn);
            btnEditCustomer.setForeground(getBarMain().getMainGui().getSettings().colorPageEditBtnFg);
            btnEditCustomer.setBorder(null);
            btnEditCustomer.setFocusPainted(false);
            btnEditCustomer.setFont(getBarMain().getMainGui().getSettings().fontPageEditBtn);
            btnEditCustomer.addActionListener((ActionListener) getBarMain().getMainGui().getDataBaseManagement().actionData);

            springLayout.putConstraint(SpringLayout.WEST, btnEditCustomer, 0, SpringLayout.WEST, getRoomEdit());
            springLayout.putConstraint(SpringLayout.NORTH, btnEditCustomer, 20, SpringLayout.SOUTH, getTxtDate());
            springLayout.getConstraints(btnEditCustomer).setHeight(Spring.constant(50));
            springLayout.getConstraints(btnEditCustomer).setWidth(Spring.constant(350));
        }
        return btnEditCustomer;
    }

    public void setBtnEditCustomer(JButton btnEditCustomer) {
        this.btnEditCustomer = btnEditCustomer;
    }

    public JComboBox getCbRoomNumber() {
        if (cbRoomNumber == null) {
            cbRoomNumber = new JComboBox(getBarMain().getMainGui().getDataBaseManagement().roomNumber);
            cbRoomNumber.setEditable(false);
            cbRoomNumber.setOpaque(false);
            cbRoomNumber.setBackground(getBarMain().getMainGui().getSettings().colorPageEditShow);

            springLayout.putConstraint(SpringLayout.WEST, cbRoomNumber, 0, SpringLayout.WEST, getRoomEdit());
            springLayout.putConstraint(SpringLayout.NORTH, cbRoomNumber, 0, SpringLayout.NORTH, getRoomEdit());
            springLayout.getConstraints(cbRoomNumber).setHeight(Spring.constant(50));
            springLayout.getConstraints(cbRoomNumber).setWidth(Spring.constant(100));
        }
        return cbRoomNumber;
    }

    public void setCbRoomNumber(JComboBox cbRoomNumber) {
        this.cbRoomNumber = cbRoomNumber;
    }

    public JComboBox getCbRoomCapacity() {
        if (cbRoomCapacity == null) {
            String roomCapacity[] = {"Oda Kapasitesi : 1", "Oda Kapasitesi : 2", "Oda Kapasitesi : 3", "Oda Kapasitesi : 4"};

            cbRoomCapacity = new JComboBox(roomCapacity);
            cbRoomCapacity.setEditable(false);
            cbRoomCapacity.setOpaque(false);
            cbRoomCapacity.setBackground(getBarMain().getMainGui().getSettings().colorPageEditShow);

            springLayout.putConstraint(SpringLayout.WEST, cbRoomCapacity, 20, SpringLayout.EAST, getCbRoomNumber());
            springLayout.putConstraint(SpringLayout.NORTH, cbRoomCapacity, 0, SpringLayout.NORTH, getRoomEdit());
            springLayout.getConstraints(cbRoomCapacity).setHeight(Spring.constant(50));
        }
        return cbRoomCapacity;
    }

    public void setCbRoomCapacity(JComboBox cbRoomCapacity) {
        this.cbRoomCapacity = cbRoomCapacity;
    }

    public JComboBox getCbRoomStatus() {
        if(cbRoomStatus == null){
            String[] roomStatus = {"Dolu","Boş","Kirli","Arızalı","Tadilat"};

            cbRoomStatus = new JComboBox(roomStatus);
            cbRoomStatus.setEditable(false);
            cbRoomStatus.setOpaque(false);
            cbRoomStatus.setBackground(getBarMain().getMainGui().getSettings().colorPageEditShow);

            springLayout.putConstraint(SpringLayout.WEST, cbRoomStatus, 20, SpringLayout.EAST, getCbRoomCapacity());
            springLayout.putConstraint(SpringLayout.NORTH, cbRoomStatus, 0, SpringLayout.NORTH, getRoomEdit());
            springLayout.putConstraint(SpringLayout.EAST, cbRoomStatus, 0, SpringLayout.EAST, getRoomEdit());
            springLayout.getConstraints(cbRoomStatus).setHeight(Spring.constant(50));
        }
        return cbRoomStatus;
    }

    public void setCbRoomStatus(JComboBox cbRoomStatus) {
        this.cbRoomStatus = cbRoomStatus;
    }

    public JFormattedTextField getTxtDate() {
        if (txtDate == null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = java.sql.Date.valueOf(LocalDate.now());

            txtDate = new JFormattedTextField(dateFormat);
            txtDate.setText(dateFormat.format(date));
            txtDate.setOpaque(false);
            txtDate.setBorder(BorderFactory.createCompoundBorder(
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldLine,
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldEmpty));

            springLayout.putConstraint(SpringLayout.WEST, txtDate, 0, SpringLayout.WEST, getRoomEdit());
            springLayout.putConstraint(SpringLayout.NORTH, txtDate, 20, SpringLayout.SOUTH, getTxtCustomerDate());
            springLayout.putConstraint(SpringLayout.EAST, txtDate, 0, SpringLayout.EAST, getRoomEdit());
            springLayout.getConstraints(txtDate).setHeight(Spring.constant(50));
        }
        return txtDate;
    }

    public void setTxtDate(JFormattedTextField txtDate) {
        this.txtDate = txtDate;
    }

    public BarMain getBarMain() {
        return barMain;
    }

    public void setBarMain(BarMain barMain) {
        this.barMain = barMain;
    }

    public JFormattedTextField getTxtCustomerDate() {
        if (txtCustomerDate == null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = java.sql.Date.valueOf(LocalDate.now());

            txtCustomerDate = new JFormattedTextField(dateFormat);
            txtCustomerDate.setText(dateFormat.format(date));
            txtCustomerDate.setOpaque(false);
            txtCustomerDate.setBorder(BorderFactory.createCompoundBorder(
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldLine,
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldEmpty));

            springLayout.putConstraint(SpringLayout.WEST, txtCustomerDate, 0, SpringLayout.WEST, getRoomEdit());
            springLayout.putConstraint(SpringLayout.NORTH, txtCustomerDate, 20, SpringLayout.SOUTH, getTxtCustomerName());
            springLayout.putConstraint(SpringLayout.EAST, txtCustomerDate, 0, SpringLayout.EAST, getRoomEdit());
            springLayout.getConstraints(txtCustomerDate).setHeight(Spring.constant(50));
        }
        return txtCustomerDate;
    }

    public void setTxtCustomerDate(JFormattedTextField txtCustomerDate) {
        this.txtCustomerDate = txtCustomerDate;
    }

    public JPanel getJpRoomShow() {
        if(jpRoomShow == null){
            jpRoomShow = new JPanel();
            jpRoomShow.setBackground(getBarMain().getMainGui().getSettings().colorPageEditShow);
            jpRoomShow.setBorder(getBarMain().getMainGui().getSettings().borderPageEditEmpty);
            jpRoomShow.setLayout(new BorderLayout());
            jpRoomShow.add(getBarMain().getMainGui().getDataBaseManagement().getTek(), BorderLayout.CENTER);
        }
        return jpRoomShow;
    }

    public void setJpRoomShow(JPanel jpRoomShow) {
        this.jpRoomShow = jpRoomShow;
    }

    public JButton getBtnExitCustomer() {
        if (btnExitCustomer == null) {
            btnExitCustomer = new JButton("Çıkış");
            btnExitCustomer.setBackground(getBarMain().getMainGui().getSettings().colorPageEditBtn);
            btnExitCustomer.setForeground(getBarMain().getMainGui().getSettings().colorPageEditBtnFg);
            btnExitCustomer.setBorder(null);
            btnExitCustomer.setFocusPainted(false);
            btnExitCustomer.setFont(getBarMain().getMainGui().getSettings().fontPageEditBtn);
            btnExitCustomer.setVisible(false);
            btnExitCustomer.addActionListener((ActionListener) getBarMain().getMainGui().getDataBaseManagement().actionData);

            springLayout.putConstraint(SpringLayout.WEST, btnExitCustomer, 20, SpringLayout.EAST, getBtnEditCustomer());
            springLayout.putConstraint(SpringLayout.NORTH, btnExitCustomer, 20, SpringLayout.SOUTH, getTxtDate());
            springLayout.putConstraint(SpringLayout.EAST, btnExitCustomer, 0, SpringLayout.EAST, getRoomEdit());
            springLayout.getConstraints(btnExitCustomer).setHeight(Spring.constant(50));
        }
        return btnExitCustomer;
    }

    public void setBtnExitCustomer(JButton btnExitCustomer) {
        this.btnExitCustomer = btnExitCustomer;
    }
}
