package com.deeparishi.javaapp.hackerrank.sde.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class MedicalRecords {

    /*
     * Complete the 'getAverageTemperatureForUser' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/medical_records?userId=<userId>&page=<page>
     *
     * The function is expected to return a String value.
     * The function accepts a userId argumnent (Integer).
     *
     * In the case of an empty array result, return value '0'
     */

    public static String getAverageTemperatureForUser(int userId) {

        String apiUrl = "https://jsonmock.hackerrank.com/api/medical_records?userId=%d&page=%d";
        int currentPage = 1;
        int totalPages = 1;
        double totalTemperature = 0;
        int temperatureCount = 0;

//        try {
//            while (currentPage <= totalPages) {
//
//                // Construct the URL for the current page
//                String url = String.format(apiUrl, userId, currentPage);
//
//                // Fetch the data from the API
//                String jsonResponse = getApiResponse(url);
//
//                // Parse the JSON response
//                JSONObject jsonObject = new JSONObject(jsonResponse);
//                totalPages = jsonObject.getInt("total_pages");
//
//                // Extract the data array
//                JSONArray data = jsonObject.getJSONArray("data");
//
//                // Iterate through the records
//                for (int i = 0; i < data.length(); i++) {
//                    JSONObject record = data.getJSONObject(i);
//                    if (record.has("vitals")) {
//                        JSONObject vitals = record.getJSONObject("vitals");
//                        if (vitals.has("bodyTemperature")) {
//                            double bodyTemperature = vitals.getDouble("bodyTemperature");
//                            totalTemperature += bodyTemperature;
//                            temperatureCount++;
//                        }
//                    }
//                }
//
//                // Move to the next page
//                currentPage++;
//            }
//        } catch (Exception e) {
//            return "0";
//        }

        // If no temperatures were found, return "0"
        if (temperatureCount == 0) {
            return "0";
        }

        // Calculate the average temperature
        double averageTemperature = totalTemperature / temperatureCount;

        // Return the average temperature formatted to 1 decimal place
        return String.format("%.1f", averageTemperature);
    }

    // Helper function to make HTTP GET requests
    private static String getApiResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();

        return content.toString();
    }
}



/**

 * JSON EXAMPLE

 {
  "page": 1,
 "per_page": 10,
 "total": 22,
 "total_pages": 3,
 "data": [
 {
 "id": 9,
 "timestamp": 1548036340751,
 "diagnosis": {
 "id": 3,
 "name": "Pulmonary embolism",
 "severity": 4
 },
 "vitals": {
 "bloodPressureDiastole": 147,
 "bloodPressureSystole": 96,
 "pulse": 130,
 "breathingRate": 28,
 "bodyTemperature": 101
 },
 "doctor": {
 "id": 2,
 "name": "Dr Arnold Bullock"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 106
 }
 },
 {
 "id": 10,
 "timestamp": 1562161672195,
 "diagnosis": {
 "id": 2,
 "name": "Common Cold",
 "severity": 1
 },
 "vitals": {
 "bloodPressureDiastole": 127,
 "bloodPressureSystole": 78,
 "pulse": 130,
 "breathingRate": 22,
 "bodyTemperature": 103.8
 },
 "doctor": {
 "id": 4,
 "name": "Dr Allysa Ellis"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 110
 }
 },
 {
 "id": 11,
 "timestamp": 1563846626267,
 "diagnosis": {
 "id": 2,
 "name": "Common Cold",
 "severity": 1
 },
 "vitals": {
 "bloodPressureDiastole": 126,
 "bloodPressureSystole": 75,
 "pulse": 99,
 "breathingRate": 22,
 "bodyTemperature": 101.9
 },
 "doctor": {
 "id": 2,
 "name": "Dr Arnold Bullock"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 108
 }
 },
 {
 "id": 18,
 "timestamp": 1560177927736,
 "diagnosis": {
 "id": 3,
 "name": "Pulmonary embolism",
 "severity": 4
 },
 "vitals": {
 "bloodPressureDiastole": 141,
 "bloodPressureSystole": 96,
 "pulse": 123,
 "breathingRate": 29,
 "bodyTemperature": 99
 },
 "doctor": {
 "id": 2,
 "name": "Dr Arnold Bullock"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 103
 }
 },
 {
 "id": 25,
 "timestamp": 1551539005307,
 "diagnosis": {
 "id": 3,
 "name": "Pulmonary embolism",
 "severity": 4
 },
 "vitals": {
 "bloodPressureDiastole": 154,
 "bloodPressureSystole": 90,
 "pulse": 131,
 "breathingRate": 22,
 "bodyTemperature": 103
 },
 "doctor": {
 "id": 2,
 "name": "Dr Arnold Bullock"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 107
 }
 },
 {
 "id": 27,
 "timestamp": 1556836728887,
 "diagnosis": {
 "id": 4,
 "name": "Pleurisy",
 "severity": 3
 },
 "vitals": {
 "bloodPressureDiastole": 133,
 "bloodPressureSystole": 84,
 "pulse": 124,
 "breathingRate": 26,
 "bodyTemperature": 99.2
 },
 "doctor": {
 "id": 2,
 "name": "Dr Arnold Bullock"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 109
 }
 },
 {
 "id": 29,
 "timestamp": 1551436887626,
 "diagnosis": {
 "id": 2,
 "name": "Common Cold",
 "severity": 1
 },
 "vitals": {
 "bloodPressureDiastole": 124,
 "bloodPressureSystole": 80,
 "pulse": 129,
 "breathingRate": 21,
 "bodyTemperature": 102.3
 },
 "doctor": {
 "id": 3,
 "name": "Dr Pilar Cristancho"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 107
 }
 },
 {
 "id": 34,
 "timestamp": 1553964012428,
 "diagnosis": {
 "id": 3,
 "name": "Pulmonary embolism",
 "severity": 4
 },
 "vitals": {
 "bloodPressureDiastole": 151,
 "bloodPressureSystole": 95,
 "pulse": 126,
 "breathingRate": 29,
 "bodyTemperature": 102.9
 },
 "doctor": {
 "id": 4,
 "name": "Dr Allysa Ellis"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 102
 }
 },
 {
 "id": 42,
 "timestamp": 1551568255913,
 "diagnosis": {
 "id": 4,
 "name": "Pleurisy",
 "severity": 3
 },
 "vitals": {
 "bloodPressureDiastole": 133,
 "bloodPressureSystole": 86,
 "pulse": 115,
 "breathingRate": 26,
 "bodyTemperature": 97.7
 },
 "doctor": {
 "id": 3,
 "name": "Dr Pilar Cristancho"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 110
 }
 },
 {
 "id": 47,
 "timestamp": 1568317109556,
 "diagnosis": {
 "id": 4,
 "name": "Pleurisy",
 "severity": 3
 },
 "vitals": {
 "bloodPressureDiastole": 139,
 "bloodPressureSystole": 83,
 "pulse": 124,
 "breathingRate": 26,
 "bodyTemperature": 99.7
 },
 "doctor": {
 "id": 4,
 "name": "Dr Allysa Ellis"
 },
 "userId": 3,
 "userName": "Helena Fernandez",
 "userDob": "23-12-1987",
 "meta": {
 "height": 157,
 "weight": 104
 }
 }
 ]
 }
 */
