package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;

import java.lang.reflect.Type;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.json";
        String fileOutputName = "data.json";

        String json = readString(fileName);
        List<Employee> list = jsonToList(json);
        list.forEach(System.out::println);
    }

    public static String readString(String fileName) {
        StringBuilder json = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public static List<Employee> jsonToList(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {}.getType();
        return gson.fromJson( json, listType);
    }

}