package models.Stat;

public abstract class Stat {
    //
    protected String name;
    protected double value;
    //
    protected void setName(String name) {this.name = name;}
    protected void setValue(double value) {this.value = value;}
    //
    public String name() {return this.name;}
    public double value() {return this.value;}
    public void print() {System.out.printf(name() + ": %.2f\n", value());}
    public abstract void scale(double amt);
    public abstract void modify(double amt);
    public abstract void calculate();
}
