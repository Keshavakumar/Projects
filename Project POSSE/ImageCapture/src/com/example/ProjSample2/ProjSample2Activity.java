package com.example.ProjSample2;

import android.app.Activity;
import android.os.Bundle;
import java.io.File;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast; 

public class ProjSample2Activity extends Activity 
{
	protected Button button;
	protected ImageView image;
	protected TextView field;
	protected String _path;

	protected static final String PHOTO_TAKEN   = "photo_taken";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        image = ( ImageView ) findViewById( R.id.imageView1);
        field = ( TextView ) findViewById( R.id.textView1 );
        button = ( Button ) findViewById( R.id.button2 );
        button.setOnClickListener( new ButtonClickHandler() );
        
        button = ( Button ) findViewById( R.id.button1 );
        button.setOnClickListener( new ButtonClickHandler1() );

        _path = Environment.getExternalStorageDirectory() + "/download/make_machine_example.jpg";
        
    }
    
    public class ButtonClickHandler implements View.OnClickListener 
    {
        public void onClick( View view ){
            Log.i("MakeMachine", "ButtonClickHandler.onClick()" );
            startCameraActivity();
        }
    }
    
    public class ButtonClickHandler1 implements View.OnClickListener 
    {
    	public void onClick(View view){
    	final Intent intentDeviceTest = new Intent("android.intent.action.MAIN");                
    	intentDeviceTest.setComponent(new ComponentName("com.example.tesstrial","com.example.tesstrial.TesstrialActivity"));
    	startActivity(intentDeviceTest);
    	}
    }
    
    protected void startCameraActivity()
    {
        Log.i("MakeMachine", "startCameraActivity()" );
        File file = new File( _path );
        Uri outputFileUri = Uri.fromFile( file );

        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
        intent.putExtra( MediaStore.EXTRA_OUTPUT, outputFileUri );

        startActivityForResult( intent, 0 );
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
    super.onKeyDown(keyCode, event);
        switch(keyCode)
        {
        case KeyEvent.KEYCODE_BACK:   	
        	Toast.makeText(ProjSample2Activity.this, "Quitting Application", Toast.LENGTH_SHORT).show();
        	Intent result = new Intent("Complete");
            setResult(Activity.RESULT_OK, result);
            finish();
            return true;
        }

        return false;
    }
    
}
