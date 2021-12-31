package topologyApi;

public class Resistor extends Component{
	private int mDefaultValue;
	private int mMinValue;
	private int mMaxValue;
	public Resistor(String id, int defaultValue, int minValue, int maxValue) {
		super("resistor", id);
		this.setDefaultValue(defaultValue);
		this.setMinValue(minValue);
		this.setMaxValue(maxValue);
	}
	public int getDefaultValue() {
		return mDefaultValue;
	}
	public void setDefaultValue(int mDefaultValue) {
		this.mDefaultValue = mDefaultValue;
	}
	public int getMinValue() {
		return mMinValue;
	}
	public void setMinValue(int mMinValue) {
		this.mMinValue = mMinValue;
	}
	public int getMaxValue() {
		return mMaxValue;
	}
	public void setMaxValue(int mMaxValue) {
		this.mMaxValue = mMaxValue;
	}
	
	@Override
	public void print() {
		System.out.println("Resistor");
		super.print();
		System.out.println("Default value: " + mDefaultValue);
		System.out.println("Min value: " + mMinValue);
		System.out.println("Max value: " + mMaxValue);
	}
}
