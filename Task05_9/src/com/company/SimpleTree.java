package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
    protected static class TreeItem{
        private final String value;
        private List<TreeItem> children;

        public TreeItem(String value, List<TreeItem> children) {
            this.value = value;
            this.children = children;
        }

        public TreeItem(String value) {
            this(value, new ArrayList<>());
        }

        public String getValue() {
            return value;
        }

        public List<TreeItem> getChildren() {
            return children;
        }

        public void addChild(String s){
            children.add(new TreeItem(s));
        }

        public void addChild(TreeItem node){
            children.add(node);
        }
    }

    private TreeItem root = null;

    public SimpleTree(TreeItem root) {
        this.root = root;
    }

    public SimpleTree(){this(null);}

    public TreeItem getRoot() {
        return root;
    }

    public void printOutTree(){
        printOutTree(root, "");
    }

    private void printOutTree(TreeItem node, String spacing){
        System.out.println(spacing + node.value);
        spacing += "    ";

        for(TreeItem item: node.children){
            printOutTree(item, spacing);
        }
    }


}
