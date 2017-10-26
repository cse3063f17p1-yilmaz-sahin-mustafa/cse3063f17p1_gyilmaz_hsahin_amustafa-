package bb;

public class Die{
	
	int faceValue;

	public int getValue() {
		int rand1 = (int) (Math.random() * (6 - 1)) + 1;
		int rand2 = (int) (Math.random() * (6 - 1)) + 1;
		faceValue =rand1+rand2;
		System.out.println("First die value "+rand1+"Second die value"+rand2);
		
		return faceValue;
		
	}

}
