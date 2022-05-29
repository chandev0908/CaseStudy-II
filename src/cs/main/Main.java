package cs.main;

import java.awt.EventQueue;

import cs.primaries.Application;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
