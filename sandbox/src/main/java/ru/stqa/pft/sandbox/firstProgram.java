package ru.stqa.pft.sandbox;

public class FirstProgram
{
	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Damian");

		Point p1 = new Point(7.1, 5.2);
		Point p2 = new Point(9.7, 6.0);
		System.out.println("Odleglosc wynosi " + distance(p1, p2));


		Square s = new Square(5);
		System.out.println("Powierzchnia kwadratu " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Powierzchnia prostokata " + r.a + " i " + r.b + " = " + r.area());
	}

	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");

	}
  public static double distance(Point p1, Point p2) {
	   double dx = p1.x - p2.x;
	   double dy = p1.y - p2.y;
	   return Math.sqrt(dx * dx + dy * dy);
	}



}