package july1;

public class ObjectCount {
	
	private static int objectCount  = 0;
	
	ObjectCount() {
		objectCount++;
	}
	
	public static int getObjectCount() {
		return objectCount;
	}

	public static void main(String[] args) {
		
		ObjectCount oc1 = new ObjectCount();
		ObjectCount oc2 = new ObjectCount();
		ObjectCount oc3 = new ObjectCount();
		ObjectCount oc4 = new ObjectCount();
		ObjectCount oc5 = new ObjectCount();
		ObjectCount oc6 = new ObjectCount();
		
		System.out.println("Total Objects Count: " + ObjectCount.getObjectCount());

	}

}
