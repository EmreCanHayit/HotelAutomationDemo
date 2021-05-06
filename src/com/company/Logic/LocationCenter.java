package com.company.Logic;

import javax.swing.*;
import java.awt.*;

public class LocationCenter {
    public LocationCenter(JFrame jf){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - jf.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - jf.getHeight()) / 2);
        jf.setLocation(x, y);
    }
}
