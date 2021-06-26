package com.company;
import com.company.SimpleTree;

public class TreeAlg {
    public static int findDepth(String s){
        int countSpace = 0;
        for (char element : s.toCharArray()){
            if (element == ' ') countSpace++;
        }
        return countSpace;
    }

    public static SimpleTree readTreeFromFile(String text){
        String[] lines = text.split("\n");
        SimpleTree tree = new SimpleTree(new SimpleTree.TreeItem(lines[0]));
        SimpleTree.TreeItem curr = tree.getRoot();
        int currDepth;
        for(int i = 0; i < lines.length; i++){
            curr = getTreeItem(lines[i]);
            currDepth = findDepth(lines[i]);
            for(int j = i+1; j < lines.length; j++){
                if(findDepth(lines[j]) == currDepth + 1){
                    curr.addChild(getTreeItem(lines[j]));
                }
                if(findDepth(lines[j]) == currDepth){
                    break;
                }
            }
        }
        return tree;
    }

    public static void addItems(String[] s, int a, int b, SimpleTree.TreeItem node){
        int currDepth = findDepth(s[a]);
        for(int i = a; i < b; i++){
            if(findDepth(s[i]) == currDepth + 1){
                SimpleTree.TreeItem childNode = getTreeItem(s[i]);
                node.addChild(childNode);
                addItems(s, i, findUpperBracket(s, i), childNode);
            }
        }
    }

    private static int findUpperBracket(String[] s, int i) {
        for(int j = i + 1; j < s.length; j++){
            if(findDepth(s[j]) == findDepth(s[i])){
                return j;
            }
        }
        return s.length;
    }

    public static SimpleTree.TreeItem getTreeItem(String line) {
        String value = line.replace(" ", "");
        return new SimpleTree.TreeItem(value);
    }
}
