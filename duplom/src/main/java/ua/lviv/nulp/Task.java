package ua.lviv.nulp;

public class Task {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public Task(boolean a, boolean b, boolean c, boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public boolean isD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
    }

}
