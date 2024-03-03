package animal;

interface CanFly {
	   default void fly() {};
}

class Bird {
	public int fly(int speed) {
		return speed;
	};
}

public class Eagle extends Bird implements CanFly {
	public void fly() {
		System.out.println("Lets Fly");
	}
}
