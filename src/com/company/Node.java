package com.company;

public class Node implements Cloneable {
    public Node left;
    public Node right;

    public Integer value;

    public Node(int value) {
        this.value = value;
    }

    public void addNode(Node node) {
        // left side
        if (node.value < this.value && this.left == null) this.left = node;
        else if (node.value < this.value) this.left.addNode(node);

        // right side
        if (node.value > this.value && this.right == null) this.right = node;
        else if (node.value > this.value) this.right.addNode(node);
    }

    public void traverse() {
        // left side
        if (this.left != null) this.left.traverse();

        System.out.println("value: " + this.value);

        // right side
        if (this.right != null) this.right.traverse();
    }

    public int search(int value) {
        if (this.value == value) return this.value;

        else if (value < this.value) return this.left.search(value);
        else return this.right.search(value);
    }

    public void deleteNode(int value) {
        if (value < this.value && this.left != null && this.left.value == value) {
            try {
                Node copy = this.left.clone();

                this.left = null;

                if (copy.left != null) this.addNode(copy.left);
                if (copy.right != null) this.addNode(copy.right);

                System.out.println("deleted on left side of " + this.value);

            } catch (CloneNotSupportedException ex) {
                System.out.println(ex);
            }
        }

        else if (value > this.value && this.right != null && this.right.value == value) {
            try {
                Node copy = this.right.clone();

                this.right = null;

                if (copy.left != null) this.addNode(copy.left);
                if (copy.right != null) this.addNode(copy.right);

                System.out.println("deleted on right side of " + this.value);

            } catch (CloneNotSupportedException ex) {
                System.out.println(ex);
            }
        }

        else if (value < this.value && this.left != null) this.left.deleteNode(value);
        else if (value > this.value && this.right != null) this.right.deleteNode(value);

        else {
            System.out.println("no node found");
        }
    }

    @Override
    public Node clone() throws CloneNotSupportedException {
        return (Node) super.clone();
    }
}
