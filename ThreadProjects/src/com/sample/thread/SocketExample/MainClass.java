package com.sample.thread.SocketExample;

public class MainClass {
	
	public static void main(String[] args) {
		
		for(int i=0; i<10000; i++){
			new SocketExample(i).start();
		}
	}

}
