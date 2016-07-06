package org.usfirst.frc.team4003.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class Xbox {
	
	/**
	* Use an XBox controller like a regular Joystick class
	*
	* @author Jon Morton
	*/

	private DriverStation _ds;
	private final int _port;
	public Xbox(int port) {
		_ds = DriverStation.getInstance();
		_port = port;
	}
	public double getRawAxis(final int axis) {
		return _ds.getStickAxis(_port, axis);
	}
	public boolean getRawButton(final int button) {
		return ((0x1 << (button - 1)) & _ds.getStickButtons(_port)) != 0;
	}
	public int getDpad() {
		return _ds.getStickPOV(_port, 0);
	}
	public boolean getDpadUp() {
		return getDpad() == 0;
	}
	public boolean getDpadRight() {
		return getDpad() == 90;
	}
	public boolean getDpadDown() {
		return getDpad() == 180;
	}
	public boolean getDpadLeft() {
		return getDpad() == 270;
	}
	public boolean getDpadNE() {
		return getDpad() == 45;
	}
	public boolean getDpadSE() {
		return getDpad() == 135;
	}
	public boolean getDpadSW() {
		return getDpad() == 225;
	}
	public boolean getDpadNW() {
		return getDpad() == 315;
	}
	/**
	* Warning! getRightTrigger() and getLeftTrigger() both use getRawAxis(3).
	* As getRawAxis(3) goes below zero, getRightTrigger() increases, and as
	* getRawAxis(3) goes above zero, getLeftTrigger() increases. If both
	* triggers are pressed, both of them will be treated as zero. You can only
	* use one trigger at a time.
	*
	* @return
	*/
	public double getRightTrigger() {
		return getRawAxis(3);
	}
	public double getLeftTrigger() {
		//return Math.max(getRawAxis(3), 0);
		return getRawAxis(2);
	}
	public double getRightJoyX() {
		return getRawAxis(4);
	}
	public double getRightJoyY() {
		return getRawAxis(5);
	}
	public double getLeftJoyX() {
		return getRawAxis(0);
	}
	public double getLeftJoyY() {
		return getRawAxis(1);
	}
	public boolean getButtonA() {
		return getRawButton(1);
	}
	public boolean getButtonB() {
		return getRawButton(2);
	}
	public boolean getButtonX() {
		return getRawButton(3);
	}
	public boolean getButtonY() {
		return getRawButton(4);
	}
	public boolean getButtonBack() {
		return getRawButton(7);
	}
	public boolean getButtonStart() {
		return getRawButton(8);
	}
	public boolean getButtonRB() {
		return getRawButton(6);
	}
	public boolean getButtonLB() {
		return getRawButton(5);
	}
	public boolean getButtonLS() {
		return getRawButton(9);
	}
	public boolean getButtonRS() {
		return getRawButton(10);
	}

}
