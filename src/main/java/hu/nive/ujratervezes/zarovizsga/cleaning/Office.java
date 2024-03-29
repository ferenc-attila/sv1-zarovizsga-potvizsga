package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    private String address;
    private int area;
    private int levels;

    public Office(String address, int area, int levels) {
        this.address = address;
        this.area = area;
        this.levels = levels;
    }

    @Override
    public int clean() {
        return area * levels * 100;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getLevels() {
        return levels;
    }
}
