package project2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

/**
 * Class Resistor that represent the resistor component and its parameters
 * */
public class Resistor extends Component{
	
	public Resistor() {}
	public Resistor(String id, double defaultValue, double minValue, double maxValue, String t1, String t2) {
		super("resistor", id, defaultValue, minValue, maxValue);
		mNetlist.put("t1", t1);
		mNetlist.put("t2", t2);
	}
	
	/**
	 * Print the data of the resistor in ordered manner
	 * */
	@Override
	public void print() {
		System.out.println("Resistor");
		super.print();
		System.out.println("Default value: " + mDefaultValue + " Min value: " + mMinValue + " Max value: " + mMaxValue);
		System.out.println("T1: " + mNetlist.get("t1") + " T2: " + mNetlist.get("t2"));
	}
	
	/**
	 * reads the resistor data stored in the memory file and assign its data itself
	 * @param fileName the scanner of the memory file that read the file line by line or word by word
	 * */
	@Override
	public void readFile(Scanner fileName) {
		mType = "resistor";
		mId = fileName.next();
		mDefaultValue = fileName.nextDouble();
		mMinValue = fileName.nextDouble();
		mMaxValue = fileName.nextDouble();
		mNetlist.put("t1", fileName.next());
		mNetlist.put("t2", fileName.next());
	}
	
	/**
	 * write the data of herself into the memory file with organized pattern
	 * @param fileName The name of the memory file
	 * */
	@Override
	public void writeFile(FileWriter fileName) {
		String output = mType + " " + mId + " " + mDefaultValue + " " + mMinValue + " " + mMaxValue + " " + mNetlist.get("t1") + " " + mNetlist.get("t2") + "\n";
		try {
			fileName.append(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * read the data from the Json file and assign its data into a resistor object
	 * @param ob The json object of the json file
	 * */
	@Override
	public void readJson(JsonObject ob) {
		JsonObject resistance = (JsonObject)ob.get("resistance");
		JsonObject netlist = (JsonObject)ob.get("netlist");
		mType = "resistor";
		mId = (String)ob.get("id");
		mDefaultValue = ((BigDecimal) resistance.get("default")).doubleValue();
		mMinValue = ((BigDecimal) resistance.get("min")).doubleValue();
		mMaxValue = ((BigDecimal) resistance.get("max")).doubleValue();
		mNetlist.put("t1", (String)netlist.get("t1"));
		mNetlist.put("t2", (String)netlist.get("t2"));
	}
	
	/**
	 * write the data of herself into the Json file with organized pattern
	 * @param ob The Json object of the Json file
	 * */
	@Override
	public void writeJson(JsonObject ob) {
		JsonArray components = (JsonArray)ob.get("components");
		JsonObject component = new JsonObject();
		JsonObject resistance = new JsonObject();
		JsonObject netlist = new JsonObject();
		component.put("type", "resistor");
		component.put("id", mId);
		resistance.put("default", mDefaultValue);
		resistance.put("min", mMinValue);
		resistance.put("max", mMaxValue);
		netlist.put("t1", mNetlist.get("t1"));
		netlist.put("t2",  mNetlist.get("t2"));
		component.put("resistance", resistance);
		component.put("netlist", netlist);
		components.add(component);
	}
}
