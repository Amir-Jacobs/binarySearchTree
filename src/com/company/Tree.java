package com.company;

public class Tree {
    Node root;

    public void addNode(int value) {
        Node node = new Node(value);

        if (this.root == null) this.root = node;
        else this.root.addNode(node);
    }

    public void traverse() {
        if (this.root != null) this.root.traverse();
        else System.out.println("no root");
    }

    public void search(int value) {
        int found = -1;

        if (this.root != null) found = this.root.search(value);
        else System.out.println("no root");

        if (found != -1) System.out.println("found " + found);
    }

    public void deleteNode(int value) {
        if (this.root.value == value) {
            try {
                Node rootCopy = this.root.clone();

                if (this.root.right != null) {
                    this.root = this.root.right;
                    this.root.addNode(rootCopy.left);
                }
            } catch (CloneNotSupportedException ex) {
                System.out.println(ex);
            }
        } else {
            this.root.deleteNode(value);
        }
    }
}
