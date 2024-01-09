package org.workwork.d_java_core_one.homework_d6.work_1;

public class Segment implements Comparable<Segment> {
    private double xBegin;
    private double xEng;
    private double yBegin;
    private double yEnd;

    public Segment(double xBegin, double xEng, double yBegin, double yEnd) {
        this.xBegin = xBegin;
        this.xEng = xEng;
        this.yBegin = yBegin;
        this.yEnd = yEnd;
    }

    @Override
    public int compareTo(Segment o) {
        return Double.compare(getLength(), o.getLength());
    }

    public double getLength(){
        return Math.sqrt(Math.pow(Math.abs(xEng - xBegin), 2) + Math.pow(Math.abs(yEnd - yBegin), 2));
    }

    @Override
    public String toString() {
        return "Segment{" +
                "xBegin=" + xBegin +
                ", xEng=" + xEng +
                ", yBegin=" + yBegin +
                ", yEnd=" + yEnd +
                '}';
    }


}
