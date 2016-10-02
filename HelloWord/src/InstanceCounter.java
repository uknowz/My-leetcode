
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
            new InstanceCounter();//new���½������ʶ����һ���������Ҫ�����£����Էŵ����캯����
        System.out.println("Created " +
            InstanceCounter.getCount() + " instances");
    }

}
