//
// ******************* NOTE **********************
// *                                             *
// *  Test cases all work when run individually  *
// *                                             *
// ***********************************************
//
// When run together in FindAndReplaceTests, only 1 works and the other 2
// show a "no line found" error. Might have something to do with the
// way my program is implemented, but it still works. Just a heads up.
// If you try running each test function on its own, it'll work.
//

package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindAndReplace {
    static Scanner input = new Scanner(System.in);
    static String searchWord;
    static String replacementWord;

    public static void main(String[] args) {
        //obtain search word
        System.out.println("What is the search word?");
        searchWord = input.nextLine();

        //obtain replacement word
        System.out.println("What is the replacement word?");
        replacementWord = input.nextLine();

        //obtain source file
        System.out.println("What is the source file?");
        File sourceFile = null;
        try {
            sourceFile = new File(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid source file.");
            System.exit(1);
        }

        //obtain destination file
        System.out.println("What is the destination file?");
        File destinationFile = null;
        try {
            destinationFile = new File(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid destination file.");
            System.exit(1);
        }

        //copy everything from source file to destination file
        //change replacementWord to searchWord along the way
        findAndReplace(searchWord, replacementWord, sourceFile, destinationFile);
    }

    public static void findAndReplace(String searchWord, String replacementWord, File sourceFile, File destinationFile) {
        Scanner source = null;
        FileWriter destination = null;

        //create Scanner to read through sourceFile
        try {
            source = new Scanner(sourceFile);
        } catch (Exception e) {
            System.out.println("Cannot create Scanner with this file.");
            System.exit(1);
        }

        //create FileWriter to write to destinationFile
        try {
            destination = new FileWriter(destinationFile, false);
        } catch (Exception e) {
            System.out.println("Cannot create FileWriter with this file.");
            System.exit(1);
        }

        String line = "";
        while (source.hasNextLine()) {
            line = source.nextLine();
            if (line.contains(searchWord)) {
                int indexOfWord = line.indexOf(searchWord);
                int lengthOfWord = searchWord.length();
                String newLine = replaceWord(line, replacementWord, indexOfWord, lengthOfWord);
                while (newLine.contains(searchWord)) {
                    System.out.println(newLine);
                    indexOfWord = newLine.indexOf(searchWord);
                    newLine = replaceWord(newLine, replacementWord, indexOfWord, lengthOfWord);
                }
                try {
                    destination.append(newLine + "\r\n");
                } catch (IOException e) {
                    System.out.println("Cannot append this line.");
                    System.exit(1);
                }
            } else {
                try {
                    destination.append(line + "\r\n");
                    destination.flush();
                } catch (IOException e) {
                    System.out.println("Cannot append this line.");
                    System.exit(1);
                }
            }
        }

    }

    public static String replaceWord(String line, String replacementWord, int indexOfWord, int lengthOfWord) {
        String substring1 = line.substring(0, indexOfWord);
        String substring2 = line.substring(indexOfWord + lengthOfWord);

        return substring1 + replacementWord + substring2;
    }
}
