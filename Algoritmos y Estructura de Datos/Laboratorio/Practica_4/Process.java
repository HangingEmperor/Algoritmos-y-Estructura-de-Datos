package Laboratorio.Practica_4;

public class Process {

    private int time;
    private int id;

    public Process(int time, int id) {
        this.time = time;
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Process{" +
                "time=" + time +
                ", id=" + id +
                '}';
    }
}
