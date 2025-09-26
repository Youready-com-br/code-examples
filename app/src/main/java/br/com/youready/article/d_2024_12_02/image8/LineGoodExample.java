package br.com.youready.article.d_2024_12_02.image8;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class LineGoodExample {
    private Point start;
    private Point end;

    public LineGoodExample(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(end.x - start.x, 2) + Math.pow(end.y - start.y, 2));
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        LineGoodExample line = new LineGoodExample(p1, p2);
        System.out.println("Length: " + line.getLength());
    }
}