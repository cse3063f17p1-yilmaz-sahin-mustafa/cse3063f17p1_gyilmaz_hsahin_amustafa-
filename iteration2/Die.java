
public class Die{
	
 private int faceValue;

	public int getValue() {
		faceValue = (int) (Math.random() * (6 - 1)) + 1;
		
		return faceValue;
		
	}

}
