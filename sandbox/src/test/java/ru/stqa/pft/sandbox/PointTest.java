package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testPoint() {
      Point p1 = new Point(7.1, 5.2);
      Point p2 = new Point(9.7, 6.0);
      Assert.assertEquals(p1.distance(p2), 2.720294101747088);

    }
  @Test
  public void testPoint1() {
    Point p1 = new Point(2.0 2.0);
    Point p2 = new Point(6.0, 2.0);
    Assert.assertEquals(p1.distance(p2), 4.0);

}
