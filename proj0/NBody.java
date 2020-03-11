public class NBody {

	/**
	  * Read the readRadius
	  */
	public static double readRadius(String filename) {
		In in = new In(filename);

		in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	/**
	  * Read the file, and return the Body class array*
	  */
	public static Body[] readBodies(String filename) {
		In in = new In(filename);

		int numPs = in.readInt();
		Body[] planets = new Body[numPs];
		String[] ss;
		double radius = in.readDouble();

		double xxPos, yyPos, xxVel, yyVel, mass;
		String imgFileName;
		for (int i = 0; i < numPs; i++) {
			xxPos = in.readDouble();
			yyPos = in.readDouble();
			xxVel = in.readDouble();
			yyVel = in.readDouble();
			mass = in.readDouble();
			imgFileName = in.readString();
			planets[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planets;
	}


	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]), dT = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] planets = readBodies(filename);

		/**
		 * draw the background
		 */
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for (Body b : planets) {
			b.draw();
		}

		StdDraw.show();
		StdDraw.pause(10);

		/**
		 * Animation
		 */
		for (double time = 0; time < T; time += dT) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dT, xForces[i], yForces[i]);
			}

			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");	
			for (Body b : planets) {
				b.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		/**
		 * Output the final state
		 */
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i =0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
				planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
				planets[i].yyVel, planets[i].mass, planets[i].imgFileName);  
		}
	}
}