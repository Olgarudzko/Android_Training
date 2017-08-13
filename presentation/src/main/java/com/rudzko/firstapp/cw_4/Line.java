package com.rudzko.firstapp.cw_4;

/**
 * @author Olga Rudzko
 */

class Line {

    private int xStart;
    private int yStart;
    private int cx;
    private int cy;

    Line(int xStart, int yStart, int cx, int cy) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.cx = cx;
        this.cy = cy;
    }

    Line(float xStart, float yStart, float cx, float cy) {
        this.xStart = Math.round(xStart);
        this.yStart = Math.round(yStart);
        this.cx = Math.round(cx);
        this.cy = Math.round(cy);
    }

    float getLength() {
        double sq = (cx - xStart) ^ 2 + (cy - yStart) ^ 2;
        return Math.round(Math.sqrt(sq));
    }

    int getxStart() {
        return xStart;
    }

    int getyStart() {
        return yStart;
    }

    int getCx() {
        return cx;
    }

    int getCy() {
        return cy;
    }
}
