package topologyApi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class Resistor extends Component{
	private double mDefaultValue;
	private double mMinValue;
	private double mMaxValue;
	private String mT1;
	private String mT2;
	
	public Resistor() {}
	public Resistor(String id, double defaultValue, double minValue, double maxValue, String t1, String t2) {
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
	
	@Override
	public void readFile(Scanner fileName) {
		mType = "resistor";
		mId = fileName.next();
		mDefaultValue = fileName.nextDouble();
		mMinValue = fileName.nextDouble();
		mMaxValue = fileName.nextDouble();
		mT1 = fileName.next();
		mT2 = fileName.next();
	}
	
	@Override
	public void writeFile(FileWriter fileName) {
		String output = "resistor " + mType + " " + mDefaultValue + " " + mMinValue + " " + mMaxValue + " " + mT1 + " " + mT2;
		try {
			fileName.write(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void readJson(JsonObject ob) {
		JsonObject resistance = (JsonObject)ob.get("resistance");
		JsonObject netlist = (JsonObject)ob.get("netlist");
		mType = "resistor";
		mId = (String)ob.get("id");
		mDefaultValue = (double)resistance.get("default");
		mMinValue = (double)resistance.get("min");
		mMaxValue = (double)resistance.get("max");
		mT1 = (String)netlist.get("t1");
		mT2 = (String)netlist.get("t2");
	}
	
	@Override
	public void writeJson(JsonObject ob) {
		JsonArray components = (JsonArray)ob.get("component");
		JsonObject component = new JsonObject();
		JsonObject resistance = new JsonObject();
		JsonObject netlist = new JsonObject();
		component.put("type", "resistor");
		component.put("id", mId);
		resistance.put("default", mDefaultValue);
		resistance.put("min", mMinValue);
		resistance.put("max", mMaxValue);
		netlist.put("t1", mT1);
		netlist.put("t2",  mT2);
		component.put("resistance", resistance);
		component.put("netlist", netlist);
		components.add(component);
	}
}
