package mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by USER on 6/1/2017.
 */
public class MouseEvents implements MouseListener {
	private Mouse mouse;

	public MouseEvents(Mouse mouse) {
		this.mouse = mouse;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX());
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
