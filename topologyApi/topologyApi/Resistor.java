package topologyApi;

public class Resistor extends Component{
	private double mDefaultValue;
	private double mMinValue;
	private double mMaxValue;
	private String mT1;
	private String mT2;
	public Resistor(String id, int defaultValue, int minValue, int maxValue, String t1, String t2) {
		super("resistor", id);
		this.mDefaultValue = defaultValue;
		this.mMinValue = minValue;
		this.mMaxValue = maxValue;
		this.mT1 = t1;
		this.mT2 = t2;
	}
	public double getDefaultValue() {
		return mDefaultValue;
	}
	public void setDefaultValue(double mDefaultValue) {
		this.mDefaultValue = mDefaultValue;
	}
	public double getMinValue() {
		return mMinValue;
	}
	public void setMinValue(double mMinValue) {
		this.mMinValue = mMinValue;
	}
	public double getMaxValue() {
		return mMaxValue;
	}
	public void setMaxValue(double mMaxValue) {
		this.mMaxValue = mMaxValue;
	}
	
	public String getT1() {
		return mT1;
	}
	public void setT1(String mT1) {
		this.mT1 = mT1;
	}
	
	@Override
	public void print() {
		System.out.println("Resistor");
		super.print();
		System.out.println("Default value: " + mDefaultValue + " Min value: " + mMinValue + " Max value: " + mMaxValue);
		System.out.println("T1: " + mT1 + " T2: " + mT2);
	}
}
// TODO edit this class