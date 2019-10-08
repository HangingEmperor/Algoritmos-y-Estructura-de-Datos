package Laboratorio.Practica_4;

public class Process {

    private int id;
    private int time;
    private int requerido;
    private int start;
    private int end;

    public Process(int id, int time) {
        this.id = id;
        this.time = time;
    }

    public Process(int id, int time, int requerido, int start, int end) {
        this.id = id;
        this.time = time;
        this.requerido = requerido;
        this.start = start;
        this.end = end;
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

    public int getRequerido() {
        return requerido;
    }

    public void setRequerido(int requerido) {
        this.requerido = requerido;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Process{" + "id=" + id +
                ", time=" + time +
                ", requerido=" + requerido +
                ", start=" + start + 
                ", end=" + end + '}';
    }
}

