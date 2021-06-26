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
