package topologyApi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class NMOS extends Component{
	private double mDefaultValue;
	private double mMinValue;
	private double mMaxValue;
	private String mDrain;
	private String mGate;
	private String mSource;
	
	public NMOS(String id, double defaultValue, double minValue, double maxValue, String drain, String gate, String source) {
		super("nmos", id);
		this.mDefaultValue = defaultValue;
		this.mMinValue = minValue;
		this.mMaxValue = maxValue;
		this.mDrain = drain;
		this.mGate = gate;
		this.mSource = source;
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
	

	@Override
	public void readFile(Scanner fileName) {
		mType = "nmos";
		mId = fileName.next();
		mDefaultValue = fileName.nextDouble();
		mMinValue = fileName.nextDouble();
		mMaxValue = fileName.nextDouble();
		mDrain = fileName.next();
		mGate = fileName.next();
		mSource = fileName.next();
	}
	
	@Override
	public void writeFile(FileWriter fileName) {
		String output = "nmos " + mType + " " + mDefaultValue + " " + mMinValue + " " + mMaxValue + " " + mDrain + " " + mGate + " " + mSource;
	
		try {
			fileName.write(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void readJson(JsonObject ob) {
		JsonObject netlist = (JsonObject)ob.get("netlist");
		mType = "nmos";
		mId = (String)ob.get("id");
		
		// TODO modify this line of code to work with the id of the NMOS
		JsonObject m = (JsonObject)ob.get(mId);
		mDefaultValue = (double)m.get("default");
		mMinValue = (double)m.get("min");
		mMaxValue = (double)m.get("max");
		mDrain = (String)netlist.get("drain");
		mGate = (String)netlist.get("gate");
		mSource = (String)netlist.get("source");
	}
	
	@Override
	public void writeJson(JsonObject ob) {
		JsonArray components = (JsonArray)ob.get("component");
		JsonObject component = new JsonObject();
		JsonObject m = new JsonObject();
		JsonObject netlist = new JsonObject();
		component.put("type", "nmos");
		component.put("id", mId);
		m.put("default", mDefaultValue);
		m.put("min", mMinValue);
		m.put("max", mMaxValue);
		netlist.put("drain", mDrain);
		netlist.put("gate",  mGate);
		component.put(mId, m);
		component.put("netlist", netlist);
		components.add(component);
	}

}
