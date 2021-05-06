package com.company.Gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class PageCustomers {
    private JPanel jpCustomer = null;
    private JScrollPane scrollPane = null;
    private BarMain barMain;
    public DefaultTableModel model;

    public PageCustomers(BarMain barMain) {
        setBarMain(barMain);
        getJpCustomer().add(getScrollPane(), BorderLayout.CENTER);
    }

    public JPanel getJpCustomer() {
        if (jpCustomer == null) {
            jpCustomer = new JPanel();
            jpCustomer.setBackground(Color.cyan);
            jpCustomer.setLayout(new BorderLayout());
        }
        return jpCustomer;
    }

    public void setJpCustomer(JPanel jpCustomer) {
        this.jpCustomer = jpCustomer;
    }

    public JScrollPane getScrollPane() {
        // Param @ UIManager : Look and Feel'i değiştirir. Bütün tabloların hücre kenarını(cell border) kaldırır.
        UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String column[] = {"Oda Numarası", "Müşteri T.C.", "İsim Soyisim", "Doğum Tarihi", "Giriş Tarihi"};
        int[] columnWidth = {200, 200, 600, 250, 250};

        model = new DefaultTableModel();
        JTable table = new JTable(model);
        scrollPane = new JScrollPane(table);
        table.setBounds(0, 0, 1500, 670);

        //getBarMain().getMainGui().getDataBaseManagement().tableFill(getBarMain().getMainGui().getDataBaseManagement().customerName.length, column.length), column);
        //JTable table = new JTable(getBarMain().getMainGui().getDataBaseManagement().tableFill(getBarMain().getMainGui().getDataBaseManagement().customerName.length, column.length), column);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.LEFT);
        for (int i = 0; i < columnWidth.length; i++) {
            model.addColumn(column[i]);
            TableColumn tableColumn = table.getColumnModel().getColumn(i);
            tableColumn.setPreferredWidth(columnWidth[i]);
            tableColumn.setCellRenderer(centerRenderer);
        }

        table.setBackground(Color.white);
        table.setFont(new Font("Seoge UI", Font.BOLD, 15));
        table.setFocusable(false);
        table.setRowHeight(35);
        table.setSelectionBackground(new Color(32, 136, 203));
        table.setSelectionForeground(new Color(255, 255, 255));
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        table.getTableHeader().setFont(new Font("Seoge UI", Font.BOLD, 15));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32, 136, 203));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.getTableHeader().setBorder(null);
        table.getTableHeader().setReorderingAllowed(true);
        table.getTableHeader().setResizingAllowed(true);
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public BarMain getBarMain() {
        return barMain;
    }

    public void setBarMain(BarMain barMain) {
        this.barMain = barMain;
    }
}
