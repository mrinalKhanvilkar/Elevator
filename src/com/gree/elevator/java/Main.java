package com.gree.elevator.java;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Elevator el = Elevator.getInstance();
				
				Requests re = new Requests(7, 1, false);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Requests re1 = new Requests(9, 0, false);
				Requests re3 = new Requests(5, 0, false);
				el.simulateKeyPressed(re);
				el.simulateKeyPressed(re1);
				el.simulateKeyPressed(re3);
				
				/*Requests req = new Requests(3, 1, true);
				el.simulateKeyPressed(req);
				
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Requests req1 = new Requests(1, 0, true);
				el.simulateKeyPressed(req1);
				
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Requests req2 = new Requests(9, 1, false);
				el.simulateKeyPressed(req2);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Requests req3 = new Requests(0, 0, false);
				el.simulateKeyPressed(req3);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Requests req4 = new Requests(8, 0, false);
				el.simulateKeyPressed(req4);
			
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Requests req5 = new Requests(4, 0, true);
				el.simulateKeyPressed(req5);*/
			}
		});
		t.start();
		
	}

}
