package com.deeparishi.javaapp.hackerrank.sde.restapi;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int userId = Integer.parseInt(bufferedReader.readLine().trim());

        String result = MedicalRecords.getAverageTemperatureForUser(userId);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
