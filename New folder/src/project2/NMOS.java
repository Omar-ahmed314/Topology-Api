package project2;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class NMOS extends Component{
	
	public NMOS() {}
	public NMOS(String id, double defaultValue, double minValue, double maxValue, String drain, String gate, String source) {
		super("nmos", id, defaultValue, minValue, maxValue);
		mNetlist.put("drain", drain);
		mNetlist.put("gate",  gate);
		mNetlist.put("source",  source);
	}

	
	@Override
	public void print() {
		System.out.println("NMOS");
		super.print();
		System.out.println("Default value: " + mDefaultValue + " Min value: " + mMinValue + " Max value: " + mMaxValue);
		System.out.println("Drain: " + mNetlist.get("drain") + " Gate: " + mNetlist.get("gate") + " Source: " + mNetlist.get("source"));
	}
	

	@Override
	public void readFile(Scanner fileName) {
		mType = "nmos";
		mId = fileName.next();
		mDefaultValue = fileName.nextDouble();
		mMinValue = fileName.nextDouble();
		mMaxValue = fileName.nextDouble();
		mNetlist.put("drain", fileName.next());
		mNetlist.put("gate", fileName.next());
		mNetlist.put("source", fileName.next());
	}
	
	@Override
	public void writeFile(FileWriter fileName) {
		String output = mType + " " + mId + " " + mDefaultValue + " " + mMinValue + " " + mMaxValue + " " + mNetlist.get("drain") + " " + mNetlist.get("gate") + " " + mNetlist.get("source") + "\n";
	
		try {
			fileName.append(output);
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
		mDefaultValue = ((BigDecimal) m.get("default")).doubleValue();
		mMinValue = ((BigDecimal) m.get("min")).doubleValue();
		mMaxValue = ((BigDecimal) m.get("max")).doubleValue();
		mNetlist.put("drain", (String)netlist.get("drain"));
		mNetlist.put("gate", (String)netlist.get("gate"));
		mNetlist.put("source", (String)netlist.get("source"));
	}
	
	@Override
	public void writeJson(JsonObject ob) {
		JsonArray components = (JsonArray)ob.get("components");
		JsonObject component = new JsonObject();
		JsonObject m = new JsonObject();
		JsonObject netlist = new JsonObject();
		component.put("type", "nmos");
		component.put("id", mId);
		m.put("default", mDefaultValue);
		m.put("min", mMinValue);
		m.put("max", mMaxValue);
		netlist.put("drain", mNetlist.get("drain"));
		netlist.put("gate",  mNetlist.get("gate"));
		netlist.put("source", mNetlist.get("source"));
		component.put(mId, m);
		component.put("netlist", netlist);
		components.add(component);
	}

}
