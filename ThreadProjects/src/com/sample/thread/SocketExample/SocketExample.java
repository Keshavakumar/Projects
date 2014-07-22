package com.sample.thread.SocketExample;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

public class SocketExample extends Thread{
	
	private int port;
	
	public SocketExample(int port){
		this.port = port;
	}
	
	@Override
	public void run() {
		
		 try {
			Socket socket = new Socket("localhost",port);
		} catch (UnknownHostException e) {
			System.out.println("port number " + port + " is not open ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("port number " + port + " is not open ");
		}
		System.out.println("port number " + port + " is open ");
		 
	}

}
