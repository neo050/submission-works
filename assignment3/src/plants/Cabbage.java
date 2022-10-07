package plants;

import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {
	public Cabbage(ZooPanel pan)
	{
		super(pan);
		MessageUtility.logConstractor("Cabbage", "Cabbage");
		super.loadImages("cabbage");
		pan.repaint();
	}


}
