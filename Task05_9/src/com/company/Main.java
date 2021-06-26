package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите путь файла");
        Scanner in = new Scanner(System.in);
        String inputFileName = in.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
            String text1 = text.toString();
            String[] lines = text1.split("\n");
            SimpleTree tree = new SimpleTree(TreeAlg.getTreeItem(lines[0]));
            TreeAlg.addItems(lines, 0, lines.length, tree.getRoot());
            tree.printOutTree();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
