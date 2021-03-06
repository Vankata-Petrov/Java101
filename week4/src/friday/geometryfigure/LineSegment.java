package friday.geometryfigure;


public final class LineSegment implements Comparable<LineSegment> {
	private Point p1;
	private Point p2;

	public LineSegment(Point p1, Point p2) {
		if (p1.equals(p2)) {
			throw new IllegalArgumentException(
					"Cannot create a line segment with zero ");
		} else {
			this.p1 = p1;
			this.p2 = p2;
		}
	}

	public LineSegment(LineSegment line) {
		this(line.p1, line.p2);
	}

	public float getLength() {
		return (int) Math.sqrt((p1.getX() - p2.getX())
				* (p1.getX() - p2.getX()) + (p1.getY() - p2.getY())
				* (p1.getY() - p2.getY()));
	}

	public int hashCode() {
		int hash = 17;
		hash = hash * 23 + p1.hashCode();
		hash = hash * 23 + p2.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineSegment other = (LineSegment) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		return true;
	}

	@Override
	public int compareTo(LineSegment o) {
		return this.getLength() > o.getLength() ? 1 : this.getLength() < o
				.getLength() ? -1 : 0;
	}

	@Override
	public String toString() {
		return "LineSegment [" + p1 + "," + p2 + "]";
	}
}
