package MathematicalModel;

import java.awt.Color;
import java.awt.Graphics;

public class RealForce {
	private final double GRAVITY_CONSTANT = 6.673 * Math.pow(10, -8);
	private final double CONSTANT = 10000000;
	double distance = 0;
	double acceleration = 0;
	double xLoc = 0;
	double yLoc = 0;
	double zLoc = 0;
	double velX = 0;
	double velY = 0;
	double velZ = 0;
	double accX = 0;
	double accY = 0;
	double accZ = 0;
	double dirX = 0;
	double dirY = 0;
	String name = "";
	double dirZ = 0;
	double mass = 0;
	boolean frozen = false;
	int timeStep = 0;

	public RealForce(String name, double x, double y, double z, double xVelocity, double yVelocity, double zVelocity,
			double bodyMass) {
		xLoc = x;
		yLoc = y;
		zLoc = z;
		velX = xVelocity;
		velY = yVelocity;
		velZ = zVelocity;
		mass = bodyMass;
		this.name = name;
	}

	public double getMass() {
		return mass;
	}

	public double getVelX() {
		return velX;
	}

	public double getVelY() {
		return velY;
	}

	public double getVelZ() {
		return velZ;
	}

	public double getAccX() {
		return accX;
	}

	public double getAccY() {
		return accY;
	}

	public double getAccZ() {
		return accZ;
	}

	public void setXPosition(double X) {
		xLoc = X;
	}

	public void setYPosition(double Y) {
		yLoc = Y;
	}

	public void setZPosition(double Z) {
		zLoc = Z;
	}

	public double getXPosition() {

		return xLoc;
	}

	public void changeVelocity(double vx, double vy, double vz) {
		velX += vx;
		velY += vy;
		velZ += vz;
	}

	public Point getLocation() {
		Point pt = new Point(xLoc, yLoc, zLoc);
		return pt;
	}

	public Point getVelocity() {
		Point pt = new Point(velX, velY, velZ);
		return pt;
	}

	public double getYPosition() {
		return yLoc;
	}

	public double getZPosition() {
		return zLoc;
	}

	public String getName() {
		return this.name;
	}
	/*
	public void move() {

		xLoc += velX * timeStep;
		yLoc += velY * timeStep;
		zLoc += velZ * timeStep;
	 */
	

	public void freeze() {
		frozen = !frozen;
	}

	/*
	 * public void update(double StarX, double StarY, double StarZ, double StarMass)
	 * { if (!frozen) {
	 * 
	 * distance = Math.sqrt((StarX - xLoc) * (StarX - xLoc) + (StarY - yLoc) *
	 * (StarY - yLoc) + (StarZ - zLoc) * (StarZ - zLoc));
	 * 
	 * acceleration = (GRAVITY_CONSTANT * StarMass * mass) / distance / distance;
	 * 
	 * // acceleration = StarMass/distance/distance;
	 * 
	 * dirX = (StarX - xLoc) / distance; dirY = (StarY - yLoc) / distance; dirZ =
	 * (StarZ - zLoc) / distance;
	 * 
	 * velX += dirX * acceleration; velY += dirY * acceleration; velZ += dirZ *
	 * acceleration; System.out.println(distance); move(); } }
	 */
	public void setVelX(double d) {
		velX = d;

	}

	public void setVelY(double d) {
		velY = d;
	}

	public void setVelZ(double d) {
		velZ = d;
	}

	public void setAccX(double d) {
		accX = d;

	}

	public void setAccY(double d) {
		accY = d;
	}

	public void setAccZ(double d) {
		accZ = d;
	}
	
	public void draw(Graphics g, double zoom) {

		g.setColor(Color.YELLOW);
		g.fillOval((int) (650 + (xLoc / CONSTANT) * zoom), (int) (500 + (yLoc / CONSTANT) * zoom), (int) (25 * zoom),
				(int) (25 * zoom));
	}

}
