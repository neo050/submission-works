package plants;

import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
	public Lettuce(ZooPanel pan)
	{
		super(pan);
		MessageUtility.logConstractor("Lettuce", "Lettuce");
		super.loadImages("Lettuce");
		pan.repaint();
	}
}
