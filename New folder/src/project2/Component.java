package project2;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonObject;

public abstract class Component{
	protected String mType;
	protected String mId;
	protected double mDefaultValue;
	protected double mMinValue;
	protected double mMaxValue;
	protected HashMap<String, String> mNetlist = new HashMap<>();
	
	public Component() {}
	public Component(String type, String id, double defaultValue, double minValue, double maxValue) {
		mType = type;
		mId = id;
		mDefaultValue = defaultValue;
		mMinValue = minValue;
		mMaxValue = maxValue;
	}
	public String getType() {
		return mType;
	}
	public void setType(String mType) {
		this.mType = mType;
	}
	public String getId() {
		return mId;
	}
	public void setId(String mId) {
		this.mId = mId;
	}
	public HashMap<String, String> getNetlist(){
		return mNetlist;
	}
	public void print() {
		System.out.println("Type: " + mType + " " + "Id: " + mId);
	}
	
	public abstract void readFile(Scanner fileName);
	public abstract void writeFile(FileWriter fileName);
	public abstract void readJson(JsonObject ob);
	public abstract void writeJson(JsonObject ob);
}
