package fr.zak.vue;

import java.awt.Color;

import javax.swing.JProgressBar;

public class CourseProgressBar extends JProgressBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseProgressBar(Color color) {
		super();
		setStringPainted(true);
		setForeground(color);

	}
}
