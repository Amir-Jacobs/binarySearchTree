package com.company;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();

        for (int i = 0; i < 10; i++) {
            tree.addNode((int)(Math.random() * ((10000 - 1) + 1)) + 1);
        }

        tree.addNode(3000);

        System.out.println("first traverse\n=========");
        tree.traverse();

        System.out.println();
        tree.deleteNode(3000);
        System.out.println();

        System.out.println("second traverse\n=========");
        tree.traverse();
    }
}
