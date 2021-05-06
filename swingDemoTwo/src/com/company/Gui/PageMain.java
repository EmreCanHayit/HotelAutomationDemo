package com.company.Gui;

import com.company.Logic.GraphPanel;
import com.company.Logic.RoundedCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PageMain {
    private JPanel jpMain = null;
    private JPanel mainGraphic = null;
    private JPanel mainRate = null;
    private JPanel mainStatus = null;
    private JPanel mainComing = null;
    SpringLayout springLayout = new SpringLayout();
    SpringLayout springLayoutZ = new SpringLayout();
    private BarMain barMain;
    public JLabel a1, a2, a3;
    public int bufferComing;
    DefaultTableModel model;

    private JTextField noteHeader = null;
    private JTextField noteContent = null;
    private JButton noteAdd = null;

    public PageMain(BarMain barMain) {
        setBarMain(barMain);
        getJpMain().add(getMainRate());
        getJpMain().add(getMainStatus());
        getJpMain().add(getMainComing());
        getJpMain().add(getMainGraphic());
    }

    public JPanel getJpMain() {
        if (jpMain == null) {
            jpMain = new JPanel();
            jpMain.setBackground(new Color(241, 231, 254));
            jpMain.setLayout(springLayout);
        }
        return jpMain;
    }

    public void setJpMain(JPanel jpMain) {
        this.jpMain = jpMain;
    }

    public JPanel getMainRate() {
        if (mainRate == null) {
            SpringLayout springLayoutX = new SpringLayout();
            mainRate = new RoundedCenter(springLayoutX, 50);
            mainRate.setPreferredSize(new Dimension(400, 300));
            mainRate.setBackground(Color.white);
            mainRate.setOpaque(false);
            mainRate.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            springLayout.putConstraint(SpringLayout.WEST, mainRate, 40, SpringLayout.WEST, getJpMain());
            springLayout.putConstraint(SpringLayout.NORTH, mainRate, 40, SpringLayout.NORTH, getJpMain());

            JLabel[] currency = new JLabel[6];
            for (int i = 0; i < currency.length; i++) {
                currency[i] = new JLabel(getBarMain().getMainGui().getDataBaseManagement().currencyName[i] + " : " + getBarMain().getMainGui().getDataBaseManagement().currencyRate[i]);
            }

            currency[0].setIcon(new ImageIcon(getBarMain().getMainGui().getSettings().newIconDollar));
            currency[0].setText(""+getBarMain().getMainGui().getDataBaseManagement().currencyRate[0]);
            currency[0].setHorizontalTextPosition(JLabel.CENTER);
            currency[0].setVerticalTextPosition(JLabel.BOTTOM);

            currency[1].setIcon(new ImageIcon(getBarMain().getMainGui().getSettings().newIconEuro));
            currency[2].setIcon(new ImageIcon(getBarMain().getMainGui().getSettings().newIconPound));
            currency[3].setIcon(new ImageIcon(getBarMain().getMainGui().getSettings().newIconYen));
            currency[4].setIcon(new ImageIcon(getBarMain().getMainGui().getSettings().newIconRuble));
            currency[5].setIcon(new ImageIcon(getBarMain().getMainGui().getSettings().newIconFranc));

            JSeparator separator = new JSeparator(JSeparator.VERTICAL);
            separator.setPreferredSize(new Dimension(1, 100));

            springLayoutX.putConstraint(SpringLayout.EAST, currency[0], -40, SpringLayout.EAST, mainRate);
            springLayoutX.putConstraint(SpringLayout.VERTICAL_CENTER, currency[0], 0, SpringLayout.VERTICAL_CENTER, mainRate);

            springLayoutX.putConstraint(SpringLayout.EAST, separator, -60, SpringLayout.WEST, currency[0]);
            springLayoutX.putConstraint(SpringLayout.VERTICAL_CENTER, separator, 0, SpringLayout.VERTICAL_CENTER, mainRate);

            springLayoutX.putConstraint(SpringLayout.WEST, currency[1], 0, SpringLayout.WEST, mainRate);
            springLayoutX.putConstraint(SpringLayout.SOUTH, currency[1], -20, SpringLayout.NORTH, currency[2]);

            springLayoutX.putConstraint(SpringLayout.WEST, currency[2], 0, SpringLayout.WEST, mainRate);
            springLayoutX.putConstraint(SpringLayout.SOUTH, currency[2], -20, SpringLayout.NORTH, currency[3]);

            springLayoutX.putConstraint(SpringLayout.WEST, currency[3], 0, SpringLayout.WEST, mainRate);
            springLayoutX.putConstraint(SpringLayout.VERTICAL_CENTER, currency[3], 0, SpringLayout.VERTICAL_CENTER, mainRate);

            springLayoutX.putConstraint(SpringLayout.WEST, currency[4], 0, SpringLayout.WEST, mainRate);
            springLayoutX.putConstraint(SpringLayout.NORTH, currency[4], 20, SpringLayout.SOUTH, currency[3]);

            springLayoutX.putConstraint(SpringLayout.WEST, currency[5], 0, SpringLayout.WEST, mainRate);
            springLayoutX.putConstraint(SpringLayout.NORTH, currency[5], 20, SpringLayout.SOUTH, currency[4]);

            mainRate.add(currency[0]);
            mainRate.add(currency[1]);
            mainRate.add(currency[2]);
            mainRate.add(currency[3]);
            mainRate.add(currency[4]);
            mainRate.add(currency[5]);
            mainRate.add(separator);
        }
        return mainRate;
    }

    public void setMainRate(JPanel mainRate) {
        this.mainRate = mainRate;
    }

    public JPanel getMainStatus() {
        if (mainStatus == null) {
            SpringLayout springLayoutY = new SpringLayout();
            mainStatus = new RoundedCenter(springLayoutY, 50);
            mainStatus.setPreferredSize(new Dimension(400, 300));
            mainStatus.setBackground(Color.white);
            mainStatus.setOpaque(false);
            mainStatus.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            springLayout.putConstraint(SpringLayout.WEST, mainStatus, 40, SpringLayout.EAST, getMainRate());
            springLayout.putConstraint(SpringLayout.NORTH, mainStatus, 40, SpringLayout.NORTH, getJpMain());

            getBarMain().getMainGui().getDataBaseManagement().customerTotal();
            a1 = new JLabel(new ImageIcon(getBarMain().getMainGui().getSettings().newIconCustomerTotal));
            a1.setText("Müşteri : " + getBarMain().getMainGui().getDataBaseManagement().totalCustomer);
            a1.setHorizontalTextPosition(JLabel.CENTER);
            a1.setVerticalTextPosition(JLabel.BOTTOM);

            a2 = new JLabel(new ImageIcon(getBarMain().getMainGui().getSettings().newIconRoomFull));
            a2.setText("Dolu oda : " + getBarMain().getMainGui().getDataBaseManagement().totalRoomFull);
            a2.setHorizontalTextPosition(JLabel.CENTER);
            a2.setVerticalTextPosition(JLabel.BOTTOM);

            a3 = new JLabel(new ImageIcon(getBarMain().getMainGui().getSettings().newIconRoomBlank));
            a3.setText("Boş oda : " + getBarMain().getMainGui().getDataBaseManagement().totalRoomBlank);
            a3.setHorizontalTextPosition(JLabel.CENTER);
            a3.setVerticalTextPosition(JLabel.BOTTOM);

            JSeparator separator1 = new JSeparator(JSeparator.VERTICAL);
            JSeparator separator2 = new JSeparator(JSeparator.VERTICAL);
            separator1.setPreferredSize(new Dimension(1, 100));
            separator2.setPreferredSize(new Dimension(1, 100));

            springLayoutY.putConstraint(SpringLayout.WEST, a1, 0, SpringLayout.WEST, mainStatus);
            springLayoutY.putConstraint(SpringLayout.VERTICAL_CENTER, a1, 0, SpringLayout.VERTICAL_CENTER, mainStatus);

            springLayoutY.putConstraint(SpringLayout.WEST, separator1, 20, SpringLayout.EAST, a1);
            springLayoutY.putConstraint(SpringLayout.VERTICAL_CENTER, separator1, 0, SpringLayout.VERTICAL_CENTER, mainStatus);

            springLayoutY.putConstraint(SpringLayout.WEST, a2, 20, SpringLayout.EAST, separator1);
            springLayoutY.putConstraint(SpringLayout.VERTICAL_CENTER, a2, 0, SpringLayout.VERTICAL_CENTER, mainStatus);
            springLayoutY.putConstraint(SpringLayout.HORIZONTAL_CENTER, a2, 0, SpringLayout.HORIZONTAL_CENTER, mainStatus);

            springLayoutY.putConstraint(SpringLayout.WEST, separator2, 20, SpringLayout.EAST, a2);
            springLayoutY.putConstraint(SpringLayout.VERTICAL_CENTER, separator2, 0, SpringLayout.VERTICAL_CENTER, mainStatus);

            springLayoutY.putConstraint(SpringLayout.WEST, a3, 0, SpringLayout.EAST, separator2);
            springLayoutY.putConstraint(SpringLayout.VERTICAL_CENTER, a3, 0, SpringLayout.VERTICAL_CENTER, mainStatus);
            springLayoutY.putConstraint(SpringLayout.EAST, a3, 0, SpringLayout.EAST, mainStatus);

            mainStatus.add(a1);
            mainStatus.add(separator1);
            mainStatus.add(a2);
            mainStatus.add(separator2);
            mainStatus.add(a3);
        }
        return mainStatus;
    }

    public void setMainStatus(JPanel mainStatus) {
        this.mainStatus = mainStatus;
    }

    public JPanel getMainComing() {
        if (mainComing == null) {
            mainComing = new RoundedCenter(springLayoutZ, 50);
            mainComing.setPreferredSize(new Dimension(400, 300));
            mainComing.setBackground(Color.white);
            mainComing.setOpaque(false);
            comingRefresh();
            springLayout.putConstraint(SpringLayout.WEST, mainComing, 40, SpringLayout.EAST, getMainStatus());
            springLayout.putConstraint(SpringLayout.NORTH, mainComing, 40, SpringLayout.NORTH, getJpMain());
            springLayout.putConstraint(SpringLayout.EAST, mainComing, -40, SpringLayout.EAST, getJpMain());
        }
        return mainComing;
    }

    public void setMainComing(JPanel mainComing) {
        this.mainComing = mainComing;
    }

    public JPanel getMainGraphic() {
        if (mainGraphic == null) {
            SpringLayout springLayoutT = new SpringLayout();
            mainGraphic = new RoundedCenter(springLayoutT,50);
            mainGraphic.setBackground(Color.white);
            mainGraphic.setOpaque(false);

            springLayout.putConstraint(SpringLayout.WEST, mainGraphic, 40, SpringLayout.WEST, getJpMain());
            springLayout.putConstraint(SpringLayout.NORTH, mainGraphic, 40, SpringLayout.SOUTH, getMainRate());
            springLayout.putConstraint(SpringLayout.SOUTH, mainGraphic, -40, SpringLayout.SOUTH, getJpMain());
            springLayout.putConstraint(SpringLayout.EAST, mainGraphic, -40, SpringLayout.EAST, getJpMain());

            model = new DefaultTableModel();
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            scrollPane.getViewport().setBackground(Color.white);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 0));

            table.setBackground(Color.white);
            table.setFont(new Font("Seoge UI", Font.BOLD, 15));
            table.setFocusable(false);
            table.setRowHeight(35);
            table.setOpaque(false);
            table.setSelectionBackground(new Color(32, 136, 203));
            table.setSelectionForeground(new Color(255, 255, 255));
            table.setShowVerticalLines(false);
            table.setShowHorizontalLines(true);
            table.setIntercellSpacing(new Dimension(0, 1));

            table.getTableHeader().setFont(new Font("Seoge UI", Font.BOLD, 20));
            table.getTableHeader().setOpaque(false);
            table.getTableHeader().setBackground(Color.white);
            table.getTableHeader().setForeground(Color.black);
            table.getTableHeader().setBorder(null);
            table.getTableHeader().setReorderingAllowed(true);
            table.getTableHeader().setResizingAllowed(true);

            model.addColumn("Başlık");
            model.addColumn("Not");

            springLayoutT.putConstraint(SpringLayout.WEST, getNoteHeader(), 20, SpringLayout.WEST, mainGraphic);
            springLayoutT.putConstraint(SpringLayout.NORTH, getNoteHeader(), 20, SpringLayout.NORTH, mainGraphic);
            springLayoutT.getConstraints(getNoteHeader()).setHeight(Spring.constant(50));
            springLayoutT.getConstraints(getNoteHeader()).setWidth(Spring.constant(350));

            springLayoutT.putConstraint(SpringLayout.WEST, getNoteContent(), 20, SpringLayout.WEST, mainGraphic);
            springLayoutT.putConstraint(SpringLayout.NORTH, getNoteContent(), 20, SpringLayout.SOUTH, getNoteHeader());
            springLayoutT.getConstraints(getNoteContent()).setHeight(Spring.constant(150));
            springLayoutT.getConstraints(getNoteContent()).setWidth(Spring.constant(350));

            springLayoutT.putConstraint(SpringLayout.WEST, getNoteAdd(), 20, SpringLayout.WEST, mainGraphic);
            springLayoutT.putConstraint(SpringLayout.NORTH, getNoteAdd(), 20, SpringLayout.SOUTH, getNoteContent());
            springLayoutT.getConstraints(getNoteAdd()).setHeight(Spring.constant(50));
            springLayoutT.getConstraints(getNoteAdd()).setWidth(Spring.constant(350));

            springLayoutT.putConstraint(SpringLayout.WEST, scrollPane, 40, SpringLayout.EAST, getNoteHeader());
            springLayoutT.putConstraint(SpringLayout.EAST, scrollPane, -30, SpringLayout.EAST, mainGraphic);
            springLayoutT.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, mainGraphic);
            springLayoutT.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, mainGraphic);


            mainGraphic.add(getNoteHeader());
            mainGraphic.add(getNoteContent());
            mainGraphic.add(getNoteAdd());
            mainGraphic.add(scrollPane);
        }
        return mainGraphic;
    }

    public void setMainGraphic(JPanel mainGraphic) {
        this.mainGraphic = mainGraphic;
    }
    public List<Double> scores = new ArrayList<>();
    public void graphMain(){
        Random random = new Random();
        int maxDataPoints = 7;
        int maxScore = 30;
            for (int i = 0; i < maxDataPoints; i++) {
                scores.add((double) random.nextDouble() * maxScore);
                //scores.add((double)i);
            }
        GraphPanel mainPanel = new GraphPanel(scores);
        mainPanel.setBackground(new Color(241, 231, 254));
        getMainGraphic().add(mainPanel);
    }

    public BarMain getBarMain() {
        return barMain;
    }

    public void setBarMain(BarMain barMain) {
        this.barMain = barMain;
    }

    public void comingRefresh() {
        JLabel[] onComingTime = new JLabel[getBarMain().getMainGui().getDataBaseManagement().roomDate.length];
        JLabel[] onComingText = new JLabel[getBarMain().getMainGui().getDataBaseManagement().roomDate.length];

        bufferComing = 0;
        onComingTime[0] = new JLabel("deneme");
        onComingText[0] = new JLabel("sadasda");

        for (int i = 0; i < getBarMain().getMainGui().getDataBaseManagement().roomDate.length; i++) {
            if (getBarMain().getMainGui().getDataBaseManagement().roomDate[i] != null) {
                onComingTime[bufferComing] = new JLabel(getBarMain().getMainGui().getDataBaseManagement().roomDate[i]);
                onComingTime[bufferComing].setFont(new Font("Tahoma", Font.BOLD, 14));

                onComingText[bufferComing] = new JLabel(getBarMain().getMainGui().getDataBaseManagement().roomNumber[i] + " numara çıkıyor.");
                onComingText[bufferComing].setFont(new Font("Tahoma", Font.BOLD, 14));
                bufferComing++;
            }
        }
        JLabel onComingLine = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                graphics2D.setPaint(Color.BLACK);
                graphics2D.drawLine(10, 0, 10, 300);
                for (int i = 0; i < bufferComing * 40; i += 40) {
                    graphics2D.fillRoundRect(0, 20 + i, 20, 20, 20, 20);
                }
            }
        };

        JPanel timeLine = new JPanel();
        timeLine.setPreferredSize(new Dimension(20, 300));
        timeLine.setBackground(Color.white);
        timeLine.setLayout(new BorderLayout());
        timeLine.add(onComingLine);

        springLayoutZ.putConstraint(SpringLayout.WEST, onComingTime[0], 40, SpringLayout.WEST, getMainComing());
        springLayoutZ.putConstraint(SpringLayout.NORTH, onComingTime[0], 20, SpringLayout.NORTH, getMainComing());

        for (int i = 1; i < bufferComing; i++) {
            springLayoutZ.putConstraint(SpringLayout.WEST, onComingTime[i], 40, SpringLayout.WEST, getMainComing());
            springLayoutZ.putConstraint(SpringLayout.NORTH, onComingTime[i], 24, SpringLayout.SOUTH, onComingTime[i - 1]);
        }

        springLayoutZ.putConstraint(SpringLayout.NORTH, timeLine, 0, SpringLayout.NORTH, getMainComing());
        springLayoutZ.putConstraint(SpringLayout.WEST, timeLine, 10, SpringLayout.EAST, onComingTime[0]);

        springLayoutZ.putConstraint(SpringLayout.WEST, onComingText[0], 10, SpringLayout.EAST, timeLine);
        springLayoutZ.putConstraint(SpringLayout.NORTH, onComingText[0], 20, SpringLayout.NORTH, getMainComing());

        for (int i = 1; i < bufferComing; i++) {
            springLayoutZ.putConstraint(SpringLayout.WEST, onComingText[i], 10, SpringLayout.EAST, timeLine);
            springLayoutZ.putConstraint(SpringLayout.NORTH, onComingText[i], 24, SpringLayout.SOUTH, onComingText[i - 1]);
        }

        mainComing.add(timeLine);
        for (int i = 0; i < bufferComing; i++) {
            mainComing.add(onComingTime[i]);
            mainComing.add(onComingText[i]);
        }
    }

    public JTextField getNoteHeader() {
        if(noteHeader == null){
            noteHeader = new JTextField("Başlık");
            noteHeader.setOpaque(false);
            noteHeader.setBorder(BorderFactory.createCompoundBorder(
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldLine,
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldEmpty));
        }
        return noteHeader;
    }

    public void setNoteHeader(JTextField noteHeader) {
        this.noteHeader = noteHeader;
    }

    public JTextField getNoteContent() {
        if(noteContent == null){
            noteContent = new JTextField("Notunuzu Giriniz.");
            noteContent.setOpaque(false);
            noteContent.setBorder(BorderFactory.createCompoundBorder(
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldLine,
                    getBarMain().getMainGui().getSettings().borderNewCustomerFieldEmpty));
        }
        return noteContent;
    }

    public void setNoteContent(JTextField noteContent) {
        this.noteContent = noteContent;
    }

    public JButton getNoteAdd() {
        if(noteAdd == null){
            noteAdd = new JButton("Not Ekle");
            noteAdd.setBackground(getBarMain().getMainGui().getSettings().colorPageEditBtn);
            noteAdd.setForeground(getBarMain().getMainGui().getSettings().colorPageEditBtnFg);
            noteAdd.setBorder(null);
            noteAdd.setFocusPainted(false);
            noteAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.addRow(new Object[]{getNoteHeader().getText(),getNoteContent().getText()});
                }
            });
        }
        return noteAdd;
    }

    public void setNoteAdd(JButton noteAdd) {
        this.noteAdd = noteAdd;
    }
}
