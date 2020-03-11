public class Body {
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;
	
	/**
	  * Constructor with multiple intputs
	  */
	public Body(double xP, double yP, double xV,
		double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/**
	  * Constructor using another Body object
	  */
	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	/**
	  * Calculate the distance bt. this and the input
	  */
	public double calcDistance(Body b) {
		double dx = this.xxPos - b.xxPos;
		double dy = this.yyPos - b.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	  * Calculate the Force bt. this and the input
	  */
	public double calcForceExertedBy(Body b) {
		double G = 6.67e-11;
		return (G * this.mass * b.mass) / Math.pow(this.calcDistance(b), 2);
	}

	/**
	  * Calculate the Force bt. this and the input by X
	  */
	public double calcForceExertedByX(Body b) {
		double force = this.calcForceExertedBy(b);
		double dx = b.xxPos - this.xxPos;
		return (force * dx) / calcDistance(b);
	}

	/**
	  * Calculate the Force bt. this and the input by Y
	  */
	public double calcForceExertedByY(Body b) {
		double force = this.calcForceExertedBy(b);
		double dy = b.yyPos - this.yyPos;
		return (force * dy) / calcDistance(b);
	}

	/**
	  * Calculate the net force exerted by all bodies
	  */
	public double calcNetForceExertedByX(Body[] allBodys) {
		double forceNetX = 0;
		for (Body b: allBodys) {
			if (this.equals(b)) {
				continue;
			}
			forceNetX += this.calcForceExertedByX(b);
		}
		return forceNetX;
	}

	/**
	  * Calculate the net force exerted by all bodies
	  */
	public double calcNetForceExertedByY(Body[] allBodys) {
		double forceNetY= 0;
		for (Body b: allBodys) {
			if (this.equals(b)) {
				continue;
			}
			forceNetY += this.calcForceExertedByY(b);
		}
		return forceNetY;
	}

	/**
	  * update the velocity and location
	  */
	public void update(double time, double forceX, double forceY) {
		this.xxVel += forceX / this.mass * time;
		this.yyVel += forceY / this.mass * time;
		this.xxPos += time * this.xxVel;
		this.yyPos += time * this.yyVel;
	}

	/**
	 *Draw one body
	 */
	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}

}