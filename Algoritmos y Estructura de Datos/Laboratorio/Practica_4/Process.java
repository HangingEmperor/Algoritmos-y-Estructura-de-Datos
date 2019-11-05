package Laboratorio.Practica_4;

/**
 * Clase que establece los procesos.
 *
 * @author Omar
 */
public class Process {

    private int id;
    private int time;
    private int requerido;
    private int start;
    private int end;

    /**
     * @param id
     * @param time
     */
    public Process(int id, int time) {
        this.id = id;
        this.time = time;
    }

    /**
     * @param id
     * @param time
     * @param requerido
     * @param start
     * @param end
     */
    public Process(int id, int time, int requerido, int start, int end) {
        this.id = id;
        this.time = time;
        this.requerido = requerido;
        this.start = start;
        this.end = end;
    }

    /**
     * @return
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public int getRequerido() {
        return requerido;
    }

    /**
     * @param requerido
     */
    public void setRequerido(int requerido) {
        this.requerido = requerido;
    }

    /**
     * @return
     */
    public int getStart() {
        return start;
    }

    /**
     * @param start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @return
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end
     */
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

