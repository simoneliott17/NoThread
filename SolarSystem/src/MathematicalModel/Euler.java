package MathematicalModel;

import java.awt.Color;
import java.awt.Graphics;

public class Euler {
	private final double GRAVITY_CONSTANT = 6.673 * Math.pow(10, -8);
	public void calculate_single_body_acceleration(RealForce[] bodies, int index) {

		//Point acceleration = new Point();
		RealForce targetBody = bodies[index];

		for (int i = 0; i < bodies.length; i++) {
			if (i != index) {
				double r = (Math.pow((targetBody.getXPosition() - bodies[i].getXPosition()), 2)
						+ Math.pow((targetBody.getYPosition() - bodies[i].getYPosition()), 2)
						+ Math.pow((targetBody.getZPosition() - bodies[i].getZPosition()), 2));
				r = Math.sqrt(r);
				double tmp = GRAVITY_CONSTANT * bodies[index].getMass() / (Math.pow(r, 3));
			
				
				bodies[index].setAccX(tmp * (bodies[index].getXPosition() - targetBody.getXPosition()));
				bodies[index].setAccY(tmp * (bodies[index].getYPosition() - targetBody.getYPosition()));
				bodies[index].setAccZ(tmp * (bodies[index].getZPosition() - targetBody.getZPosition()));

				// targetBody.setAccX(targetBody.getAccX() + tmp * (bodies[i].getXPosition() -
				// targetBody.getXPosition()));
				// targetBody.setAccY(targetBody.getAccY() + tmp * (bodies[i].getYPosition() -
				// targetBody.getYPosition()));
				// targetBody.setAccZ(targetBody.getAccZ() + tmp * (bodies[i].getZPosition() -
				// targetBody.getZPosition()));
			}
		}

	}

	// Updates the velocities
	// dv = a.dt;
	private void computeVelocity(RealForce[] bodies, int timeStep) {
		for (int i = 0; i < bodies.length; i++) {
			// Point acceleration = calculate_single_body_acceleration(bodies, i);
			RealForce targetBody = bodies[i];
			System.out.println(targetBody.getName());
			System.out.println(
					"VX: " + targetBody.getVelX() + "\nVY: " + targetBody.getVelY() + "\nVZ: " + targetBody.getVelZ());

			bodies[i].setVelX(bodies[i].getVelX() + bodies[i].getAccX() * timeStep);
			bodies[i].setVelY(bodies[i].getVelY() + bodies[i].getAccY() * timeStep);
			bodies[i].setVelZ(bodies[i].getVelZ() + bodies[i].getAccZ() * timeStep);
		}
	}

	// Updates the locations
	// dx = v*dt
	void updateLocation(RealForce[] bodies, int timeStep) {
		for (int i = 0; i < bodies.length; i++) {
			RealForce targetBody = bodies[i];
			System.out.println(targetBody.getName());
			System.out.println("X: " + targetBody.getXPosition() + "\nY: " + targetBody.getYPosition() + "\nZ: "
					+ targetBody.getZPosition());

			targetBody.setXPosition(targetBody.getXPosition() + targetBody.getVelX() * timeStep);
			targetBody.setYPosition(targetBody.getYPosition() + targetBody.getVelY() * timeStep);
			targetBody.setZPosition(targetBody.getZPosition() + targetBody.getVelZ() * timeStep);

		}
	}

	// Combines the location and velocity update
	public void computeGravityStep(RealForce[] bodies, int timeStep) {
		for (int i = 0; i < bodies.length; i++) {

			calculate_single_body_acceleration(bodies, i);
		}
		updateLocation(bodies, timeStep);
		computeVelocity(bodies, timeStep);
	}
	

}
