package topologyApi;

public class NMOS extends Component{
	private double mDefaultValue;
	private double mMinValue;
	private double mMaxValue;
	private String mDrain;
	private String mGate;
	private String mSource;
	
	public NMOS(String id, double defaultValue, double minValue, double maxValue, String drain, String gate, String source) {
		super("nmos", id);
		this.setDefaultValue(defaultValue);
		this.setMinValue(minValue);
		this.setMaxValue(maxValue);
		this.setDrain(drain);
		this.setGate(gate);
		this.setSource(source);
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

	public String getDrain() {
		return mDrain;
	}

	public void setDrain(String mDrain) {
		this.mDrain = mDrain;
	}

	public String getGate() {
		return mGate;
	}

	public void setGate(String mGate) {
		this.mGate = mGate;
	}

	public String getSource() {
		return mSource;
	}

	public void setSource(String mSource) {
		this.mSource = mSource;
	}
	
	@Override
	public void print() {
		System.out.println("NMOS");
		super.print();
		System.out.println("Default value: " + mDefaultValue + " Min value: " + mMinValue + " Max value: " + mMaxValue);
		System.out.println("Drain: " + mDrain + " Gate: " + mGate + " Source: " + mSource);
	}

}
