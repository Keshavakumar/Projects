package com.example.Uploadtext;

import android.app.Activity;

import android.os.Bundle;
import android.app.Activity;

import android.os.Bundle;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.widget.Toast;
import android.app.Activity;

import android.os.Bundle;

public class UploadtextActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //compress to which format you want.
        //byte [] byte_arr = stream.toByteArray();
    
        ArrayList<NameValuePair> nameValuePairs = new  ArrayList<NameValuePair>();

        nameValuePairs.add(new BasicNameValuePair("image","this is cool"));
               
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://192.168.1.2/upload_image1.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                String the_string_response = convertResponseToString(response);
                Toast.makeText(UploadtextActivity.this, "Response hello" + the_string_response, Toast.LENGTH_LONG).show();
            }catch(Exception e){
                 Toast.makeText(UploadtextActivity.this, "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
                  System.out.println("Error in http connection "+e.toString());
            }
        }
 
        public String convertResponseToString(HttpResponse response) throws IllegalStateException, IOException{
 
             String res = "";
             StringBuffer buffer = new StringBuffer();
             InputStream inputStream = response.getEntity().getContent();
             int contentLength = (int) response.getEntity().getContentLength(); //getting content length…..
             Toast.makeText(UploadtextActivity.this, "contentLength : " + contentLength, Toast.LENGTH_LONG).show();
             if (contentLength < 0){
             }
             else{
                    byte[] data = new byte[512];
                    int len = 0;
                    try
                    {
                        while (-1 != (len = inputStream.read(data)) )
                        {
                            buffer.append(new String(data, 0, len)); //converting to string and appending  to stringbuffer…..
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    try
                    {
                        inputStream.close(); // closing the stream…..
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    res = buffer.toString();     // converting stringbuffer to string…..
 
                    Toast.makeText(UploadtextActivity.this, "Result : " + res, Toast.LENGTH_LONG).show();
                    //System.out.println("Response => " +  EntityUtils.toString(response.getEntity()));
             }
             return res;
        }
        
}