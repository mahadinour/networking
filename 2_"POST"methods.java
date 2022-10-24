package com.mycompany.mahadi201902121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Mahadi201902121 {
    
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();// creat connection with www
        con.setRequestMethod("POST");//con = connection
        con.setRequestProperty("User-Agent", "Chrom");//
        
        con.setDoOutput(true);//to see the post
        String postData = "hi ! this is mahadi";
        OutputStream output = con.getOutputStream();
        output.write(postData.getBytes());
        output.flush();
        output.close();
        
        int respons_code = con.getResponseCode();
        System.out.println("response massage  >>"+con.getResponseMessage());
        System.out.println("response code  >>"+respons_code);
        
        if(respons_code == HttpURLConnection.HTTP_CREATED){//chacking this connection is (ok)
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));//
            StringBuffer response = new StringBuffer();//get the all availabil data from web
            String readline = null;
            
            while((readline = in.readLine()) != null){
                response.append(readline);
            }
            in.close();
            System.out.println("response massage from server >>"+response.toString() );
        }
        else{
            System.out.println("error");
        }
    }
}
