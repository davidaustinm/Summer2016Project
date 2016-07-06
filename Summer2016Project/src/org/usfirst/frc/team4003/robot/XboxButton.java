package org.usfirst.frc.team4003.robot;

import edu.wpi.first.wpilibj.buttons.Button;


public class XboxButton extends Button {
    public static final int BUTTONA = 0;
    public static final int BUTTONB = 1;
    public static final int BUTTONX = 2;
    public static final int BUTTONY = 3;
    public static final int BUTTONBACK = 4;
    public static final int BUTTONSTART = 5;
    public static final int BUTTONRB = 6;
    public static final int BUTTONLB = 7;
    public static final int BUTTONLS = 8;
    public static final int BUTTONRS = 9;
    public static final int DPADUP = 10;
    public static final int DPADRIGHT = 11;
    public static final int DPADDOWN = 12;
    public static final int DPADLEFT = 13;
    public static final int DPADNE = 14;
    public static final int DPADSE = 15;
    public static final int DPADSW = 16;
    public static final int DPADNW = 17;
    
    Xbox xbox;
    int button;
    public XboxButton(Xbox xb, int b) {
        xbox = xb;
        button = b;
    }
    
    public boolean get() {
        switch(button) {
            case BUTTONA: return xbox.getButtonA();
            case BUTTONB: return xbox.getButtonB();
            case BUTTONX: return xbox.getButtonX();
            case BUTTONY: return xbox.getButtonY();
            case BUTTONBACK: return xbox.getButtonBack();
            case BUTTONSTART: return xbox.getButtonStart();
            case BUTTONLB: return xbox.getButtonLB();
            case BUTTONRB: return xbox.getButtonRB();
            case BUTTONLS: return xbox.getButtonLS();
            case BUTTONRS: return xbox.getButtonRS();
            case DPADUP: return xbox.getDpadUp();
            case DPADRIGHT: return xbox.getDpadRight();
            case DPADDOWN: return xbox.getDpadDown();
            case DPADLEFT: return xbox.getDpadLeft();
            case DPADNE: return xbox.getDpadNE();
            case DPADSE: return xbox.getDpadNW();
            case DPADSW: return xbox.getDpadSW();
            case DPADNW: return xbox.getDpadNW();
        }
        return false;
    }
    
}
