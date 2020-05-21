package exercise6;

public class Node {
    // INSTANCE DATA
    private char name;
    private boolean end;
    private Node top;
    private Node bottom;
    private Node left;
    private Node right;

    // CONSTRUCTOR 1 - sets all connection points to null by default and boolean "end" to false
    public Node(char name) {
        this.end = false;
        this.name = name;
        this.top = null;
        this.bottom = null;
        this.left = null;
        this.right = null;
    }

    // CONSTRUCTOR 2 - used for constructing the endpoint node by taking an entry for "end"
    public Node(char name, boolean end) {
        this.name = name;
        this.end = end;
        this.top = null;
        this.bottom = null;
        this.left = null;
        this.right = null;
    }

    // GETTERS
    public char getName() {
        return name;
    }

    public boolean isEnd() {
        return end;
    }

    public Node getTop() {
        return top;
    }

    public Node getBottom() {
        return bottom;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    // CONNECT TOP OF ROOT NODE TO A POINT ON ANOTHER NODE (point determined by connectionPoint)
    public void connectToTop(Node nodeToConnect, String connectionPoint) {
        if (connectionPoint.toUpperCase().equals("TOP")) {
            this.top = nodeToConnect;
            nodeToConnect.top = this;
        }
        if (connectionPoint.toUpperCase().equals("LEFT")) {
            this.top = nodeToConnect;
            nodeToConnect.left = this;
        }
        if (connectionPoint.toUpperCase().equals("RIGHT")) {
            this.top = nodeToConnect;
            nodeToConnect.right = this;
        }
        if (connectionPoint.toUpperCase().equals("BOTTOM")) {
            this.top = nodeToConnect;
            nodeToConnect.bottom = this;
        }
    }

    // CONNECT LEFT OF ROOT NODE TO A POINT ON ANOTHER NODE (point determined by connectionPoint)
    public void connectToLeft(Node nodeToConnect, String connectionPoint) {
        if (connectionPoint.toUpperCase().equals("TOP")) {
            this.left = nodeToConnect;
            nodeToConnect.top = this;
        }
        if (connectionPoint.toUpperCase().equals("LEFT")) {
            this.left = nodeToConnect;
            nodeToConnect.left = this;
        }
        if (connectionPoint.toUpperCase().equals("RIGHT")) {
            this.left = nodeToConnect;
            nodeToConnect.right = this;
        }
        if (connectionPoint.toUpperCase().equals("BOTTOM")) {
            this.left = nodeToConnect;
            nodeToConnect.bottom = this;
        }
    }

    // CONNECT RIGHT OF ROOT NODE TO A POINT ON ANOTHER NODE (point determined by connectionPoint)
    public void connectToRight(Node nodeToConnect, String connectionPoint) {
        if (connectionPoint.toUpperCase().equals("TOP")) {
            this.right = nodeToConnect;
            nodeToConnect.top = this;
        }
        if (connectionPoint.toUpperCase().equals("LEFT")) {
            this.right = nodeToConnect;
            nodeToConnect.left = this;
        }
        if (connectionPoint.toUpperCase().equals("RIGHT")) {
            this.right = nodeToConnect;
            nodeToConnect.right = this;
        }
        if (connectionPoint.toUpperCase().equals("BOTTOM")) {
            this.right = nodeToConnect;
            nodeToConnect.bottom = this;
        }
    }

    // CONNECT BOTTOM OF ROOT NODE TO A POINT ON ANOTHER NODE (point determined by connectionPoint)
    public void connectToBottom(Node nodeToConnect, String connectionPoint) {
        if (connectionPoint.toUpperCase().equals("TOP")) {
            this.bottom = nodeToConnect;
            nodeToConnect.top = this;
        }
        if (connectionPoint.toUpperCase().equals("LEFT")) {
            this.bottom = nodeToConnect;
            nodeToConnect.left = this;
        }
        if (connectionPoint.toUpperCase().equals("RIGHT")) {
            this.bottom = nodeToConnect;
            nodeToConnect.right = this;
        }
        if (connectionPoint.toUpperCase().equals("BOTTOM")) {
            this.bottom = nodeToConnect;
            nodeToConnect.bottom = this;
        }
    }
}
