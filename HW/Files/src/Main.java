import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
        task3();

    }

    //TODO: Задание 1:
    //    1. Пользователь вводит с клавиатуры путь к файлу.
    //    2. Программа считывает содержимое файла.
    //    3. Программа анализирует содержимое файла и подсчитывает количество букв, чисел и знаков препинания.
    //    4. Программа выводит на экран количество букв, чисел и знаков препинания в файле.
    public static void task1() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter file path: ");
        String path = scanner.next();
        String punctuationSymbols = ",.?!;:-";
        int amountOfDigits = 0;
        int amountOfLetters = 0;
        int amountOfPunctuation = 0;

        try {
            FileReader reader = new FileReader(path);
            int charCode;
            char character;

            while ((charCode = reader.read()) != -1) {
                character = (char) charCode;
                if (character >= '0' && character <= '9') {
                    amountOfDigits++;
                    continue;
                }
                if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) {
                    amountOfLetters++;
                    continue;
                }
                if (punctuationSymbols.contains(String.valueOf(character))) {
                    amountOfPunctuation++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Amout of digits: %d\nAmount of letters: %d\nAmount of punctuation symbols: %d\n", amountOfDigits, amountOfLetters,
                amountOfPunctuation);
    }

    //TODO: Задание 2:
    //    1. Пользователь с клавиатуры вводит путь к файлу, искомое слово и слово для замены.
    //    2. Программа открывает файл и ищет искомое слово в его содержимом.
    //    3. Если слово найдено, программа заменяет его на указанное слово.
    //    4. Программа подсчитывает количество произведенных замен.
    //    5. Программа выводит на экран отчет о количестве замен.
    public static void task2() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter path to a file:");
        String enteredPath = scanner.next();
        System.out.println("Word to change:");
        String wordToChange = scanner.next();
        System.out.println("New word:");
        String newWord = scanner.next();
        Path path = Path.of(enteredPath);
        try {
            String contents = new String(Files.readAllBytes(path));
            int wordOccurrences = (contents.length() - contents.replaceAll(wordToChange, "").length()) / wordToChange.length();
            String newContents = contents.replaceAll(wordToChange, newWord);

            System.out.println(newContents);
            System.out.printf("replaced %d times", wordOccurrences);
        } catch (IOException e) {
            System.out.println("failed to read file");
        }
    }

    //TODO: Задание 3:
    //    1. Пользователь вводит с клавиатуры пути к четырем файлам.
    //    2. Программа открывает каждый из четырех файлов и считывает их содержимое.
    //    3. Программа записывает содержимое трех файлов в четвертый файл.
    //    4. Программа подсчитывает количество перенесенных байт.
    //    5. Программа выводит на экран отчет о количестве перенесенных байт.
    public static void task3() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter paths to four files");
        String[] paths = new String[4];
//        System.out.print("File 1: ");
//        paths[0] = scanner.next();
//        System.out.print("File 2: ");
//        paths[1] = scanner.next();
//        System.out.print("File 3: ");
//        paths[2] = scanner.next();
//        System.out.print("File 4: ");
//        paths[3] = scanner.next();

        paths[0] = "data/text1.txt";
        paths[1] = "data/text2.txt";
        paths[2] = "data/text3.txt";
        paths[3] = "data/text4.txt";
        int numberOfTransferredBytes = 0;
        Path path;
        List<byte[]> contents = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            path = Path.of(paths[i]);
            try {
                contents.add(Files.readAllBytes(path));
                numberOfTransferredBytes += contents.getFirst().length;
            } catch (IOException e) {
                System.out.println("failed to read file " + i);
            }
        }
        try {
            FileWriter writer = new FileWriter(paths[3], true);
            writer.write(new String(contents.get(0), StandardCharsets.UTF_8));
            writer.write(new String(contents.get(1), StandardCharsets.UTF_8));
            writer.write(new String(contents.get(2), StandardCharsets.UTF_8));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(new String(contents.get(0), StandardCharsets.UTF_8));
        System.out.println(new String(contents.get(1), StandardCharsets.UTF_8));
        System.out.println(new String(contents.get(2), StandardCharsets.UTF_8));
    }
}