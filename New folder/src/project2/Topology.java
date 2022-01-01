package project2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class Topology {
	private String mTopologyId;
	private ArrayList<Component> mComponentList;
	
	public Topology() {
		mTopologyId = "";
		mComponentList = new ArrayList<>();
	}
	public Topology(String topologyId, ArrayList<Component> components) {
		this.mTopologyId = topologyId;
		this.mComponentList = components;
	}
	public String getTopologyId() {
		return mTopologyId;
	}
	public void setTopologyId(String mTopologyId) {
		this.mTopologyId = mTopologyId;
	}
	public ArrayList<Component> getComponentList() {
		return mComponentList;
	}
	public void setComponentList(ArrayList<Component> mComponentList) {
		this.mComponentList = mComponentList;
	}
	
	public void print() {
		System.out.println(mTopologyId);
		for(Component component : mComponentList ) {
			component.print();
		}
	}
	
	public void readFile(Scanner fileName) {
		mTopologyId = fileName.next();
		int numberOfComponents = Integer.parseInt(fileName.next());
		for(int i = 0; i < numberOfComponents; i++) {
			String type = fileName.next();
			switch(type) {
			case "resistor":
				Resistor r = new Resistor();
				r.readFile(fileName);
				mComponentList.add(r);
				break;
			case "nmos":
				NMOS n = new NMOS();
				n.readFile(fileName);
				mComponentList.add(n);
				break;
			default:
					break;
			}
		}
	}
	
	public void writeFile(FileWriter fileName) {
		try {
			fileName.append(mTopologyId + " " + mComponentList.size() + "\n");
			for(Component component : mComponentList) {
				component.writeFile(fileName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readJson(JsonObject ob) {
		mTopologyId = (String)ob.get("id");
		JsonArray components = (JsonArray)ob.get("components");
		for(Object component : components) {
			String type = (String)((JsonObject)component).get("type");
			switch(type) {
			case "resistor":
				Resistor r = new Resistor();
				r.readJson((JsonObject)component);
				mComponentList.add(r);
				break;
			case "nmos":
				NMOS n = new NMOS();
				n.readJson((JsonObject)component);
				mComponentList.add(n);
				break;
			default:
					break;
			}
		}
	}
	public void writeJson(JsonObject ob) {
		ob.put("id", mTopologyId);
		JsonArray components = new JsonArray();
		ob.put("components", components);
		for(Component component : mComponentList) {
			component.writeJson(ob);
		}
		
	}
	public ArrayList<Component> getComponentsAtNode(String nodeId){
		ArrayList<Component> list = new ArrayList<>();
		for(Component component: mComponentList) {
			HashMap<String, String> netlist = component.getNetlist();
			for(HashMap.Entry<String, String> entry: netlist.entrySet()) {
				if(entry.getValue().equals(nodeId)) {
					list.add(component);
					break;
				}
			}
		}
		return list;
		
	}

}
