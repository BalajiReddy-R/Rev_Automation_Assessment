package Question4_File_IO;

import java.io.*;
import java.util.*;
public class StudentFileProcessor {
    public static void main(String[] args) {
        String inputFile = "src\\Question4_File_IO\\students.csv";
        String outputFile = "sorted_students.csv"; // Output file
        List<String[]> studentList = new ArrayList<>();
        double totalGrades = 0;
        int numberOfStudents = 0;
        // Read data from CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                studentList.add(data);

                try {
                    double grade = Double.parseDouble(data[2]);
                    totalGrades += grade;
                    numberOfStudents++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid grade value for student: " + data[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Student data
        System.out.println("Student Data:");
        for (String[] student : studentList) {
            System.out.println(student[0] + " | " + student[1] + " | " + student[2]);
        }
        // Sort students by name
        Collections.sort(studentList, new Comparator<String[]>() {
            public int compare(String[] s1, String[] s2) {
                return s1[1].trim().compareTo(s2[1].trim());
            }
        });
        // Sorted Student data
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            System.out.println("Sorted Student Data:");
            for (String[] student : studentList) {
                bw.write(student[0] + "," + student[1] + "," + student[2]);
                System.out.println(student[0] + " | " + student[1] + " | " + student[2]);
                bw.newLine();
            }
            System.out.println("\n Sorted data written to...: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        // Average Grade Calculation
        if (numberOfStudents > 0) {
            double averageGrade = totalGrades / numberOfStudents;
            System.out.println("\nAverage Grade of all students: " + averageGrade);
        } else {
            System.out.println("\nNo grades available.");
        }
    }
}