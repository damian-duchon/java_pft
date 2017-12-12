package ru.stqa.pft.sandbox;

public class firstProgram
{
	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Damian");

		Point p1 = new Point(7.1, 5.2);
		Point p2 = new Point(9.7, 6.0);
		System.out.println("Odleglosc wynosi " + p1.distance(p2));


		Square s = new Square(5);
		System.out.println("Powierzchnia kwadratu " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Powierzchnia prostokata " + r.a + " i " + r.b + " = " + r.area());
	}

	public static void hello(String somebody) { System.out.println("Hello, " + somebody + "!"); }

}