package com.chili.pojo;

public class Visited {
	private int visitedCount;

	public int getVisitedCount() {
		return visitedCount;
	}

	public void setVisitedCount(int visitedCount) {
		this.visitedCount = visitedCount;
	}

	@Override
	public String toString() {
		return "Visited [visitedCount=" + visitedCount + "]";
	}

	public Visited(int visitedCount) {
		super();
		this.visitedCount = visitedCount;
	}
	public Visited() {
		super();
	}
}
