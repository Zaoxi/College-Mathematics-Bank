package control;

public class MathManager {
	static private MathManager instance = null;
	
	static public MathManager GetInstance() {
		if(instance == null) instance = new MathManager();
		return instance;
	}
	// Initialize the Manager Class
	private MathManager()
	{
		
	}
	
	
}
