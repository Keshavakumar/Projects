package com.example.UploadText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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




import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UploadTextActivity extends Activity {
	public Button button;
	public String text1;
    /** Called when the activity is first created. */
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = ( Button ) findViewById( R.id.button1 );
        button.setOnClickListener( new ButtonClickHandler1() );
        File sdcard = Environment.getExternalStorageDirectory();

      //Get the text file
      File file = new File(sdcard,"converted_text.txt");

      //Read text from file
      StringBuilder text = new StringBuilder();

      try {
          BufferedReader br = new BufferedReader(new FileReader(file));
          String line;

          while ((line = br.readLine()) != null) {
        	
        	  
              text.append(line);
              text.append(' ');
        	  
          }
      }
      catch (IOException e) {
          //You'll need to add proper error handling here
      }
      text1=text.toString();

      //Find the view by its id
      TextView tv = (TextView)findViewById(R.id.textView2);

      //Set the text
      tv.setText(text1);
      
   }

    public class ButtonClickHandler1 implements View.OnClickListener 
    {
    	public void onClick(View view){
    		EditText et = (EditText)findViewById(R.id.editText1);
    		String temp = et.getText().toString();
    		temp=temp.trim();
    		
    		if(temp.length()>0)
    		{	
    			text1=temp;
    		
    		//Toast.makeText(UploadTextActivity.this, temp + "abcdef", Toast.LENGTH_LONG).show();
    		}
    		
        ArrayList<NameValuePair> nameValuePairs = new  ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("image",text1));
            try{
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://192.168.1.4/upload_image1.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                String the_string_response = convertResponseToString(response);
                //Toast.makeText(UploadTextActivity.this,the_string_response, Toast.LENGTH_LONG).show();
                onDestroy();
            }catch(Exception e){
                 Toast.makeText(UploadTextActivity.this, "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
                  System.out.println("Error in http connection "+e.toString());
            }
            
        }
   
    
        public String convertResponseToString(HttpResponse response) throws IllegalStateException, IOException{
             String res = "";
             StringBuffer buffer = new StringBuffer();
             InputStream inputStream = response.getEntity().getContent();
             int contentLength = (int) response.getEntity().getContentLength(); //getting content length…..
             Toast.makeText(UploadTextActivity.this, "contentLength : " + contentLength, Toast.LENGTH_LONG).show();
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
                    res = "success";     // converting stringbuffer to string…..
 
                    Toast.makeText(UploadTextActivity.this, "Result : " + res, Toast.LENGTH_LONG).show();
                    //System.out.println("Response => " +  EntityUtils.toString(response.getEntity()));
             }
             return res;
        }
    }
}
