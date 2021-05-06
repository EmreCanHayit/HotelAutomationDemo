package com.company.Logic;

import com.company.Gui.MainGui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DataBaseManagement {
    private JPanel roomFill;
    private JPanel tek;
    int roomRank = 28, i = 0;
    public int totalRoomFull = 0, totalRoomBlank = 0, totalCustomer = 0;
    JLabel[] roomNumberLine = new JLabel[roomRank];
    JLabel[] roomCapacityLine = new JLabel[roomRank];
    JLabel[] roomStatusLine = new JLabel[roomRank];

    public String[] roomNumber = new String[roomRank];
    public String[] roomCapacity = {"1", "1", "1", "1", "2", "2", "3", "1", "1", "1", "1", "2", "2", "3", "1", "1", "1", "1", "2", "2", "3", "1", "1", "1", "1", "2", "2", "3"};
    public String[] roomStatus = new String[roomRank];
    public String[] roomDate = new String[roomRank];
    public String[] customerNumber = new String[roomRank];
    public String[] customerName = new String[roomRank];

    public String[] currencyName = {"Dollar", "Euro", "Pound", "Yen", "Ruble", "Franc"};
    public double[] currencyRate = {5.25, 6.45, 7.10, 2.22, 0.8, 12.5};

    private Color[] si = new Color[roomRank];

    private MainGui mainGui;
    public ActionData actionData;

    public DataBaseManagement(MainGui mainGui) {
        setMainGui(mainGui);
        int t = 0;
        for (int y = 0; y < 4; y++) {
            for (int i = 0; i < 7; i++) {
                roomNumber[t] = "1" + y + i;
                roomStatus[t] = "Boş";
                t++;
            }
        }
    }

    public JPanel getRoomFill(int i) {
        this.i = i;
        actionData = new ActionData(this, i);

        roomFill = new RoundedCenter(new GridLayout(3, 1), 50, ola());
        roomFill.setOpaque(false);
        roomFill.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        roomFill.setPreferredSize(new Dimension(100, 150));

        roomNumberLine[i] = new JLabel(roomNumber[i]);
        roomCapacityLine[i] = new JLabel(roomCapacity[i]);
        roomStatusLine[i] = new JLabel(roomStatus[i]);

        roomNumberLine[i].setFont(new Font("Tahoma", Font.BOLD, 22));
        roomStatusLine[i].setIcon(new ImageIcon(getMainGui().getSettings().newIconRoomStatus));
        roomCapacityLine[i].setIcon(new ImageIcon(getMainGui().getSettings().newIconRoomCapacity));

        roomFill.add(roomNumberLine[i]);
        roomFill.add(roomCapacityLine[i]);
        roomFill.add(roomStatusLine[i]);
        roomFill.addMouseListener(actionData);
        return roomFill;
    }

    public void setRoomFill(JPanel roomFill) {
        this.roomFill = roomFill;
    }

    public void tableFill(int row) {
        Random tableRandom = new Random();

        for (int i = 0; i < row; i++) {
            getMainGui().getBarMain().getPageCustomers().model.addRow(new Object[]{
                    roomNumber[i],
                    customerNumber[i],
                    customerName[i],
                    (tableRandom.nextInt(31) + 1) + " / " + (tableRandom.nextInt(12) + 1) + " / " + (tableRandom.nextInt(70) + 1900),
                    (tableRandom.nextInt(31) + 1) + " / " + (tableRandom.nextInt(12) + 1) + " / 2019"
            });
        }
    }

    public JPanel getTek() {
        tek = new JPanel();
        tek.setBackground(null);
        tek.setLayout(new GridLayout(4, 7, 20, 20));
        for (int i = 0; i < 28; i++) {
            tek.add(getRoomFill(i));
        }
        return tek;
    }

    public void setTek(JPanel tek) {
        this.tek = tek;
    }

    public MainGui getMainGui() {
        return mainGui;
    }

    public void setMainGui(MainGui mainGui) {
        this.mainGui = mainGui;
    }

    public Color ola() {
        if (roomStatus[i] == "Boş") {
            si[i] = new Color(127, 143, 166);
        } else if (roomStatus[i] == "Dolu") {
            si[i] = new Color(68, 189, 50);
        } else if (roomStatus[i] == "Kirli") {
            si[i] = new Color(232, 65, 24);
        } else if (roomStatus[i] == "Arızalı") {
            si[i] = new Color(251, 197, 49);
        } else if (roomStatus[i] == "Tadilat") {
            si[i] = new Color(64, 115, 158);
        }
        return si[i];
    }

    public void customerTotal() {
        totalRoomFull = 0;
        totalRoomBlank = 0;
        totalCustomer = 0;
        for (int i = 0; i < roomStatus.length; i++) {
            if (roomStatus[i] == "Dolu") {
                totalRoomFull++;
            } else {
                totalRoomBlank++;
            }
        }
        for (int i = 0; i < customerNumber.length; i++) {
            if (customerNumber[i] != null) {
                totalCustomer++;
            }
        }
    }
}
