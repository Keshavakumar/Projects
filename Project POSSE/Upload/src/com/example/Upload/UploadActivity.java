package com.example.Upload;

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

public class UploadActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        	Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/download/make_machine_example.jpg");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream); //compress to which format you want.
            byte [] byte_arr = stream.toByteArray();
            String image_str = Base64.encodeBytes(byte_arr);
            ArrayList<NameValuePair> nameValuePairs = new  ArrayList<NameValuePair>();
 
            nameValuePairs.add(new BasicNameValuePair("image",image_str));
           
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://192.168.1.2/upload_image.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                String the_string_response = convertResponseToString(response);
                Toast.makeText(UploadActivity.this, "Response hello" + the_string_response, Toast.LENGTH_LONG).show();
            }catch(Exception e){
                 Toast.makeText(UploadActivity.this, "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
                  System.out.println("Error in http connection "+e.toString());
            }
        }
 
        public String convertResponseToString(HttpResponse response) throws IllegalStateException, IOException{
 
             String res = "";
             StringBuffer buffer = new StringBuffer();
             InputStream inputStream = response.getEntity().getContent();
             int contentLength = (int) response.getEntity().getContentLength(); //getting content length…..
             Toast.makeText(UploadActivity.this, "contentLength : " + contentLength, Toast.LENGTH_LONG).show();
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
 
                    Toast.makeText(UploadActivity.this, "Result : " + res, Toast.LENGTH_LONG).show();
                    //System.out.println("Response => " +  EntityUtils.toString(response.getEntity()));
             }
             return res;
        }
}