package model;

import java.awt.*;
import java.io.Serializable;

public class Slot  implements Serializable {
    private Integer x;
    private Integer y;
    private Integer w;
    private Integer h;
    private Color neSelektovanBoja;
    private Color color;
    private SerializableStrokeAdapter stroke1;
    private Color selektovanColor = Color.RED;

    private String tip;
    private String content;

    public Slot(Integer x, Integer y, Integer w, Integer h, Color color, String tip) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        neSelektovanBoja = color;
        this.tip = tip;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getW() {
        return w;
    }

    public Integer getH() {
        return h;
    }

    public Color getColor() {
        return color;
    }


    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getSelektovanColor() {
        return selektovanColor;
    }

    public Color getNeSelektovanBoja() {
        return neSelektovanBoja;
    }

    public String getTip() {
        return tip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SerializableStrokeAdapter getStroke1() {
        return stroke1;
    }

    public void setStroke1(Stroke stroke1) {
        this.stroke1 = new SerializableStrokeAdapter(stroke1);
    }
}
