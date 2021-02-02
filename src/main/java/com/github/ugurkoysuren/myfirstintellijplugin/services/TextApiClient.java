package com.github.ugurkoysuren.myfirstintellijplugin.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class TextApiClient {

    public TextApiClient() {
    }

    public String method() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return (generatedString);
    }

    public String getRest(){
        try {

            URL url = new URL("https://isento.free.beeceptor.com/helloworld");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            String result = "";
            while ((output = br.readLine()) != null) {
                result+=output;
            }
            conn.disconnect();
            return  result;

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return "fail";
        }
    }
}
