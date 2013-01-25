package com.gree.elevator.java;

import java.util.TreeMap;
import java.util.Vector;

public class Elevator {

	public static Elevator instance = new Elevator();
	private int maxFloors = 10;
	private int direction = 0;
	private int floor = 0;
	private boolean moving = false;

	private TreeMap<Integer, Requests> upRequests = new TreeMap<Integer, Requests>();
	private TreeMap<Integer, Requests> downRequests = new TreeMap<Integer, Requests>();

	private TreeMap<Integer, Requests> currentRequests = null;

	private Elevator() {

	}

	public static Elevator getInstance() {
		return instance;
	}

	public void simulateKeyPressed(Requests req) {
		if (req.inOrOut) {
			if (!moving) {
				if (req.floor < floor) {
					direction = 0;
					downRequests.put(req.floor, req);
					moving = true;
				} else {
					direction = 1;
					upRequests.put(req.floor, req);
					moving = true;
				}
				startMoving(direction, floor);
			} else {
				if (req.floor > floor) {
					if (direction == 1) {
						upRequests.put(req.floor, req);
					} else {
						downRequests.put(req.floor, req);
					}
				} else {
					if (direction == 1) {
						downRequests.put(req.floor, req);
					} else {
						upRequests.put(req.floor, req);
					}
				}
			}
		} else {
			if (!moving) {
				if (req.floor < floor) {
					direction = 0;
					downRequests.put(req.floor, req);
					moving = true;
				} else {
					direction = 1;
					upRequests.put(req.floor, req);
					moving = true;
				}
				startMoving(direction, floor);
			} else {
				if (req.floor > floor) {
					if (req.direction == 1) {
						upRequests.put(req.floor, req);
					} else {
						downRequests.put(req.floor, req);
					}
				} else {
					if (req.direction == 1) {
						upRequests.put(req.floor, req);
					} else {
						downRequests.put(req.floor, req);
					}
				}
			}
		}
	}

	private void startMoving(final int direction, final int fromFloor) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				if (direction == 1) {
					currentRequests = upRequests;
					for (int i = fromFloor; i < maxFloors; i++) {
						try {
							floor = i;
							System.out.println("Moving up at floor" + i);
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (currentRequests.containsKey(i)) {
							System.out.println("Stopping at floor" + i);
							currentRequests.remove(i);
						}
						if (!currentRequests.isEmpty()) {
							if (i == currentRequests.lastKey()) {
								if (downRequests.isEmpty()) {
									moving = false;
									return;
								} else {
									startMoving(0, i);
									return;
								}
							}
						} else {
							if (downRequests.isEmpty()) {
								moving = false;
								return;
							} else {
								if (downRequests.lastKey() > floor) {
									Requests req = new Requests(downRequests
											.lastKey(), 1, true);
									simulateKeyPressed(req);
								} else {
									startMoving(0, i);
									return;
								}
								
							}
						}
					}

				} else {
					currentRequests = downRequests;
					for (int i = fromFloor; i >= 0; i--) {
						try {
							floor = i;
							System.out.println("Moving Down at floor" + i);
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (currentRequests.containsKey(i)) {
							System.out.println("Stopping at floor" + i);
							currentRequests.remove(i);
						}
						if (!currentRequests.isEmpty()) {
							if (i == currentRequests.lastKey()) {
								if (upRequests.isEmpty()) {
									moving = false;
									return;
								} else {
									if (upRequests.lastKey() < floor) {
										Requests req = new Requests(
												upRequests.lastKey(), 0, true);
										simulateKeyPressed(req);
									} else {
										startMoving(1, i);
										return;
									}
								}
							}
						} else {
							if (upRequests.isEmpty()) {
								moving = false;
								return;
							} else {
								startMoving(1, i);
								return;
							}
						}
					}
				}

			}
		});
		t.start();
	}

}
