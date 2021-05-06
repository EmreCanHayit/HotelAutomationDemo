package com.company.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionData implements MouseListener, ActionListener, FocusListener, KeyListener {
    private DataBaseManagement dataBaseManagement;
    int i = 0, tableRemoveRate=0;
    int[] tableRemove = new int[28];

    public ActionData(DataBaseManagement dataBaseManagement, int i) {
        setDataBaseManagement(dataBaseManagement);
        this.i = i;
    }
    public DataBaseManagement getDataBaseManagement() {
        return dataBaseManagement;
    }

    public void setDataBaseManagement(DataBaseManagement dataBaseManagement) {
        this.dataBaseManagement = dataBaseManagement;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getBtnEditCustomer()){
            getDataBaseManagement().getMainGui().getBarMain().getPageCustomers().model.addRow(new Object[]{
                    getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedItem(),
                    getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().getText(),
                    getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().getText(),
                    getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerDate().getText(),
                    getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtDate().getText()
            });

            tableRemove[tableRemoveRate] = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex();
            tableRemoveRate++;
            getDataBaseManagement().customerNumber[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().getText();

            getDataBaseManagement().customerName[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().getText();

            getDataBaseManagement().roomDate[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtDate().getText();

            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setText("Müşteri Adı");
            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setText("Müşteri TC Numarası");
            getDataBaseManagement().getMainGui().getBarMain().getCardLayout().show(getDataBaseManagement().getMainGui().getBarMain().getJpMain(),"2");

            getDataBaseManagement().getMainGui().getBarMain().getPageStatus().getJpStatus().removeAll();
            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getJpRoomShow().removeAll();

            getDataBaseManagement()
                    .roomNumber[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    =(String) getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedItem();
            getDataBaseManagement()
                    .roomCapacity[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    = (String) getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomCapacity().getSelectedItem();
            getDataBaseManagement()
                    .roomStatus[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    = (String) getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomStatus().getSelectedItem();

            getDataBaseManagement().getMainGui().getBarMain().getPageStatus().getJpStatus().add(getDataBaseManagement().getTek(), BorderLayout.CENTER);
            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getJpRoomShow().add(getDataBaseManagement().getTek(), BorderLayout.CENTER);

            getDataBaseManagement().customerTotal();
            getDataBaseManagement().getMainGui().getBarMain().getPageMain().a2.setText("Dolu oda : "+getDataBaseManagement().totalRoomFull);
            getDataBaseManagement().getMainGui().getBarMain().getPageMain().a3.setText("Boş oda : "+getDataBaseManagement().totalRoomBlank);
            getDataBaseManagement().getMainGui().getBarMain().getPageMain().a1.setText("Müşteri : "+getDataBaseManagement().totalCustomer);
            getDataBaseManagement().getMainGui().getBarEdit().getStatisticBlank().setText("Boş oda : "+getDataBaseManagement().totalRoomBlank);
            getDataBaseManagement().getMainGui().getBarEdit().getStatisticFull().setText("Dolu oda : "+getDataBaseManagement().totalRoomFull);
            getDataBaseManagement().getMainGui().getBarEdit().getStatisticCustomer().setText("Müşteri : "+getDataBaseManagement().totalCustomer);

            getDataBaseManagement().getMainGui().getBarMain().getPageMain().getMainComing().removeAll();
            getDataBaseManagement().getMainGui().getBarMain().getPageMain().comingRefresh();

        } else if(e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getBtnExitCustomer()){
            for(int y = 0; y<tableRemove.length; y++){
                if (tableRemove[y] == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()){
                    getDataBaseManagement().getMainGui().getBarMain().getPageCustomers().model.removeRow(y);
                }
            }
            getDataBaseManagement().customerNumber[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]= null;
            getDataBaseManagement().customerName[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]= null;
            getDataBaseManagement().roomDate[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]= null;

            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setText("Müşteri Adı");
            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setText("Müşteri TC Numarası");
            getDataBaseManagement().getMainGui().getBarMain().getCardLayout().show(getDataBaseManagement().getMainGui().getBarMain().getJpMain(),"2");

            getDataBaseManagement().getMainGui().getBarMain().getPageStatus().getJpStatus().removeAll();
            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getJpRoomShow().removeAll();

            getDataBaseManagement()
                    .roomNumber[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    =(String) getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedItem();
            getDataBaseManagement()
                    .roomCapacity[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    = (String) getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomCapacity().getSelectedItem();
            getDataBaseManagement()
                    .roomStatus[getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().getSelectedIndex()]
                    = "Kirli";

            getDataBaseManagement().getMainGui().getBarMain().getPageStatus().getJpStatus().add(getDataBaseManagement().getTek(), BorderLayout.CENTER);
            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getJpRoomShow().add(getDataBaseManagement().getTek(), BorderLayout.CENTER);

            getDataBaseManagement().customerTotal();
            getDataBaseManagement().getMainGui().getBarMain().getPageMain().a2.setText("Dolu oda : "+getDataBaseManagement().totalRoomFull);
            getDataBaseManagement().getMainGui().getBarMain().getPageMain().a3.setText("Boş oda : "+getDataBaseManagement().totalRoomBlank);
            getDataBaseManagement().getMainGui().getBarMain().getPageMain().a1.setText("Müşteri : "+getDataBaseManagement().totalCustomer);
            getDataBaseManagement().getMainGui().getBarEdit().getStatisticBlank().setText("Boş oda : "+getDataBaseManagement().totalRoomBlank);
            getDataBaseManagement().getMainGui().getBarEdit().getStatisticFull().setText("Dolu oda : "+getDataBaseManagement().totalRoomFull);
            getDataBaseManagement().getMainGui().getBarEdit().getStatisticCustomer().setText("Müşteri : "+getDataBaseManagement().totalCustomer);

            getDataBaseManagement().getMainGui().getBarMain().getPageMain().getMainComing().removeAll();
            getDataBaseManagement().getMainGui().getBarMain().getPageMain().comingRefresh();
        }else if(e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageMain().getNoteAdd()){
            System.out.println("asdasda");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
            getDataBaseManagement().getMainGui().getBarMain().getCardLayout().show(getDataBaseManagement().getMainGui().getBarMain().getJpMain(),"7");

            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomNumber().setSelectedItem(getDataBaseManagement().roomNumber[i]);
            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomCapacity().setSelectedItem("Oda Kapasitesi : "+getDataBaseManagement().roomCapacity[i]);
            getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomStatus().setSelectedItem(getDataBaseManagement().roomStatus[i]);

            if(getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getCbRoomStatus().getSelectedItem().equals("Boş")){
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getBtnEditCustomer().setText("Ekle");
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer()
                        .springLayout.getConstraints(getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getBtnEditCustomer()).setWidth(Spring.constant(460));
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getBtnExitCustomer().setVisible(false);
            }else{
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getBtnEditCustomer().setText("Düzelt");
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer()
                        .springLayout.getConstraints(getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getBtnEditCustomer()).setWidth(Spring.constant(350));
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getBtnExitCustomer().setVisible(true);
            }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber()) {
            String customerNumber = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().getText();
            if (customerNumber.equals("Müşteri TC Numarası")) {
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setCaretPosition(0);
            }
        } else if (e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber()) {
            String customerName = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().getText();
            if (customerName.equals("Müşteri Adı")) {
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setCaretPosition(0);
            }
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber()) {
            String customerNumber = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().getText();
            if (customerNumber.equals("")) {
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setCaretPosition(0);
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setText("Müşteri TC Numarası");
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setForeground(Color.black);
            }
        } else if (e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName()) {
            String customerName = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().getText();
            if (customerName.equals("")) {
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setCaretPosition(0);
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setText("Müşteri Adı");
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setForeground(Color.black);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber()) {
            String customerNumber = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().getText();
            if (customerNumber.equals("Müşteri TC Numarası")) {
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setForeground(Color.black);
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setText(null);
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setCaretPosition(0);
            }
        } else if (e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName()) {
            String customerName = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().getText();
            if (customerName.equals("Müşteri Adı")) {
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setForeground(Color.black);
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setText(null);
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setCaretPosition(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber()) {
            String customerNumber = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().getText();
            if (customerNumber.equals("")) {
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setText("Müşteri TC Numarası");
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setForeground(Color.black);
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerNumber().setCaretPosition(0);
            }
        } else if (e.getSource() == getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName()) {
            String customerName = getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().getText();
            if (customerName.equals("")) {
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setText("Müşteri Adı");
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setForeground(Color.black);
                getDataBaseManagement().getMainGui().getBarMain().getPageEditCustomer().getTxtCustomerName().setCaretPosition(0);
            }
        }
    }
}
