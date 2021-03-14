package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<LinearFunction> arrFunctions = new ArrayList<>();

        try {
                BufferedReader br = new BufferedReader(new FileReader("functions.txt"));
                String nextLine = br.readLine();

            while (nextLine != null) {
                    LinearFunction function = new LinearFunction();

                String[] raw = nextLine.substring(3).split(" " + (char) 42 + " ");

                    function.a = Integer.parseInt(raw[1].substring(0, raw[1].length() - 1));
                    function.b = Integer.parseInt(raw[3]);

                arrFunctions.add(function);
                    nextLine = br.readLine();
            }
        }   catch (FileNotFoundException e) {
                e.printStackTrace();
        }   catch (IOException e) {
                e.printStackTrace();
        }

        int count = arrFunctions.size();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));
                    bw.write(count + "");
                    bw.close();
        }   catch (IOException e) {
                System.out.println(e);
        }

        int duplicitaa = 0;
            int serve = 0;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("count_distinct.txt"));

            for (int i = 0; i < arrFunctions.size(); i++) {
                int duplicita = 0;

                int a1 = arrFunctions.get(i).a;
                    int b1 = arrFunctions.get(i).b;

                for (LinearFunction arrFunction : arrFunctions) {
                        int a2 = arrFunction.a;
                        int b2 = arrFunction.b;

                    if (a1 == a2 && b1 == b2) {
                            duplicita++;
                    }
                }
                    if (duplicita >= 2) {
                        duplicitaa++;
                }
            }
                serve = arrFunctions.size() - duplicitaa;

                bw.write(String.valueOf(serve));

            bw.close();
        }       catch (IOException e) {
                    System.out.println(e);
        }
    }
}