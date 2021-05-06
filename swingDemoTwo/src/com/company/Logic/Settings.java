package com.company.Logic;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Settings {
    public Color colorNavigation = new Color(241, 231, 254);
    public Font fontNavigation = new Font("Tahoma", Font.BOLD, 12);
    public ImageIcon iconNavigation = new ImageIcon("src/com/company/Gui/iconExitSquare.png");

    public Color colorEdit = new Color(190, 144, 212);
    public Font fontEdit = new Font("Tahoma", Font.BOLD, 12);
    public int springEdit = 20;

    public Color colorPageEditBtn = new Color(59, 89, 182);
    public Color colorPageEditBtnFg = new Color(255,255,255);
    public Color colorPageEditShow = new Color(213, 184, 255);
    public Font fontPageEditBtn = new Font("Tahoma", Font.BOLD, 12);
    public Border borderPageEditEmpty = new EmptyBorder(20, 20, 20, 20);

    public Color colorStatus = new Color(213, 184, 255);
    public int springStatus = 20;
    //public ImageIcon iconStatus = new ImageIcon(getClass().getResource("icon.png"));
    public ImageIcon iconStatus = new ImageIcon("src/com/company/Gui/iconInfo.png");

    public Color colorNewCustomer = new Color(213, 184, 255);
    public Border borderNewCustomer = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    public Border borderNewCustomerFieldLine = BorderFactory.createLineBorder(Color.black,1);
    public Border borderNewCustomerFieldEmpty = BorderFactory.createEmptyBorder(5, 25, 5, 25);

    public Color colorPageStatus = new Color(213, 184, 255);
    public Border borderPageStatus = BorderFactory.createEmptyBorder(20, 20, 20, 20);

    int iconCurrencySize = 25;
    ImageIcon iconDollar = new ImageIcon("src/com/company/Logic/Image/dollar.png");
    Image imageDollar = iconDollar.getImage();
    public Image newIconDollar = imageDollar.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

    ImageIcon iconEuro = new ImageIcon("src/com/company/Logic/Image/euro.png");
    Image imageEuro = iconEuro.getImage();
    public Image newIconEuro = imageEuro.getScaledInstance(iconCurrencySize, iconCurrencySize, Image.SCALE_SMOOTH);

    ImageIcon iconPound = new ImageIcon("src/com/company/Logic/Image/pound.png");
    Image imagePound = iconPound.getImage();
    public Image newIconPound = imagePound.getScaledInstance(iconCurrencySize, iconCurrencySize, Image.SCALE_SMOOTH);

    ImageIcon iconYen = new ImageIcon("src/com/company/Logic/Image/yen.png");
    Image imageYen = iconYen.getImage();
    public Image newIconYen = imageYen.getScaledInstance(iconCurrencySize, iconCurrencySize, Image.SCALE_SMOOTH);

    ImageIcon iconRuble = new ImageIcon("src/com/company/Logic/Image/ruble.png");
    Image imageRuble = iconRuble.getImage();
    public Image newIconRuble = imageRuble.getScaledInstance(iconCurrencySize, iconCurrencySize, Image.SCALE_SMOOTH);

    ImageIcon iconFranc = new ImageIcon("src/com/company/Logic/Image/franc.png");
    Image imageFranc = iconFranc.getImage();
    public Image newIconFranc = imageFranc.getScaledInstance(iconCurrencySize, iconCurrencySize, Image.SCALE_SMOOTH);

    ImageIcon iconRoomFull = new ImageIcon("src/com/company/Logic/Image/roomFull2.png");
    Image imageRoomFull = iconRoomFull.getImage();
    public Image newIconRoomFull = imageRoomFull.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

    ImageIcon iconRoomBlank = new ImageIcon("src/com/company/Logic/Image/roomBlank2.png");
    Image imageRoomBlank = iconRoomBlank.getImage();
    public Image newIconRoomBlank = imageRoomBlank.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

    ImageIcon iconCustomerTotal = new ImageIcon("src/com/company/Logic/Image/customerTotal2.png");
    Image imageCustomerTotal = iconCustomerTotal.getImage();
    public Image newIconCustomerTotal = imageCustomerTotal.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

    ImageIcon iconRoomCapacity = new ImageIcon("src/com/company/Logic/Image/roomCapacity.png");
    Image imageRoomCapacity = iconRoomCapacity.getImage();
    public Image newIconRoomCapacity = imageRoomCapacity.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

    ImageIcon iconRoomStatus = new ImageIcon("src/com/company/Logic/Image/roomStatus.png");
    Image imageRoomStatus = iconRoomStatus.getImage();
    public Image newIconRoomStatus = imageRoomStatus.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
}
