package Examen_1;

public class DoubleList<T> {

    private Node<T> start;
    private int size = 0;

    public void insertStart(T data) {
        Node<T> node = new Node<>();
        node.setInfo(data);
        node.setSig(start);
        node.setAnt(null);

        if (start != null) {
            start.setAnt(node);
        }
        start = node;
        size++;
    }

    public void insertEnd(T data) {
        Node<T> node = new Node<>();
        node.setInfo(data);
        node.setSig(null);
        if (start == null) {
            node.setAnt(start);
            start = node;
        } else {
            Node<T> r = new Node<>();
            r = start;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.setSig(node);
            node.setAnt(r);
        }
        size++;
    }

    public Node<T> removeStart() {
        if (start == null) {
            return null;
        } else {
            if (start.getSig() == null) {
                start = null;
            } else {
                start = start.getSig();
                start.setAnt(null);
            }
        }
        size--;
        return start;
    }

    public Node<T> removeEnd() {
        Node<T> r = new Node<>();
        if (start == null) {
            return null;
        } else {
            if (start.getSig() == null) {
                start = null;
            } else {
                while (r.getSig() != null) {
                    r = r.getSig();
                }
                r.setAnt(null);
                return r;
            }
        }
        size--;
        return r;
    }

    public String recorrer() {
        Node<T> r = new Node<>();
        String aux = "";
        if (start == null) {
            return "lista vacia";
        } else {
            r = start;
            while (r != null) {
                aux += r.getInfo() + "\n";
                r = r.getSig();
            }
        }
        return aux;
    }

    public Node<T> remove(int position) {
        if (position <= size) {
            int informacion;
            if (position == 1) {
                //informacion = (int) start.getInfo();
                start = start.getSig();
                if (start != null)
                    start.setAnt(null);
            } else {
                Node<T> reco;
                reco = start;
                for (int f = 1; f <= position - 2; f++)
                    reco = reco.getSig();
                Node<T> prox = reco.getSig();
                reco.setSig(prox.getSig());
                Node<T> siguiente = prox.getSig();
                if (siguiente != null)
                    siguiente.setAnt(reco);
                //informacion = (int) prox.getInfo();
            }
            return start;
        } else
            return null;
    }

    public void insert(T data, int position) {
        if (start == null) {
            Node<T> node = new Node<>();
            node.setInfo(data);
            if (position == 1) {
                node.setSig(start);
                if (start != null) {
                    start.setAnt(node);
                }
                start = node;
            } else {
                if (start.getSig() == null) {
                    Node<T> r = new Node<>();
                    r = start;
                    while (r.getSig() != null) {
                        r = r.getSig();
                    }
                    r.setSig(node);
                    node.setAnt(r);
                    node.setSig(null);
                } else {
                    Node<T> r = new Node<>();
                    for (int f = 1; f <= position; f++) {
                        r = r.getSig();
                    }
                    Node<T> s = r.getSig();
                    r.setSig(node);
                    node.setAnt(r);
                    node.setSig(s);
                    s.setAnt(node);
                }
            }
        }
    }
}
