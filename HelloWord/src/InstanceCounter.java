
public class InstanceCounter {

	/**
	 * @param args
	 */
	private static int numInstances = 0;

    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] arguments) {
        System.out.println("Starting with " +
            InstanceCounter.getCount() + " instances");
        for (int  i = 0; i < 500; i++)
            new InstanceCounter();//new是新建对象标识符，一建立对象就要做的事，可以放到构造函数里
        System.out.println("Created " +
            InstanceCounter.getCount() + " instances");
    }

}
