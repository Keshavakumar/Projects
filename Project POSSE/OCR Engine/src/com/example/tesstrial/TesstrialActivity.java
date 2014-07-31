package com.example.tesstrial;

import java.io.File
;
import java.io.FileWriter;
import java.io.IOException;
import com.googlecode.tesseract.android.TessBaseAPI;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

public class TesstrialActivity extends Activity {
    /** Called when the activity is first created. */
	public String _path=Environment.getExternalStorageDirectory() + "/download/make_machine_example.jpg";
	public String recognizedText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    		 
    	TessBaseAPI baseApi = new TessBaseAPI();
    	baseApi.init("/mnt/sdcard/tesseract", "eng"); 
    	File myImage = new File( _path );
		baseApi.setImage(myImage);	 
    	recognizedText = baseApi.getUTF8Text(); 
    	baseApi.end();
 	
        FileWriter f;
        try 
        {
              f = new FileWriter("/sdcard/converted_text.txt");
              f.write(recognizedText);
              f.flush();
              f.close();
        }
        catch (IOException e1) 
        {
              e1.printStackTrace();
        }
        final Intent intentDeviceTest = new Intent("android.intent.action.MAIN");                
    	intentDeviceTest.setComponent(new ComponentName("com.example.UploadText","com.example.UploadText.UploadTextActivity"));
    	startActivity(intentDeviceTest);
    }
}
    	
    	
    	
    



       
    
