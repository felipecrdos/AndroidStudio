package com.n2.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    static String getJsonFromApi(String url){
        String result = "";
        try {
            URL apiEnd = new URL(url);
            HttpURLConnection connection;

            connection = (HttpURLConnection) apiEnd.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(150000);
            connection.setConnectTimeout(150000);
            connection.connect();

            int codigoResposta = connection.getResponseCode();
            InputStream is;
            if(codigoResposta == HttpURLConnection.HTTP_OK){
                is = connection.getInputStream();
            }else{
                is = connection.getErrorStream();
            }

            result = converterInputStreamToString(is);
            is.close();
            connection.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private static String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String row;

            br = new BufferedReader(new InputStreamReader(is));
            while((row = br.readLine())!=null){
                buffer.append(row);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }
}