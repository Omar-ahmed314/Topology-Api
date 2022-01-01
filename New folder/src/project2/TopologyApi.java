package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class TopologyApi {
	private int mTopologyCount;
	private ArrayList<Topology> mTopologyList;
	private File mFileName;
	
	public TopologyApi(String fileName) throws FileNotFoundException {
		mTopologyList = new ArrayList<>();
		mFileName = new File(fileName);
		readFile();
	}
	
	private void readFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(mFileName);
		
		// if the file is empty
		if(!scanner.hasNext()) {return ;}
		
		mTopologyCount = Integer.parseInt(scanner.next());
		for(int i = 0; i < mTopologyCount; i++) {
			Topology topology = new Topology();
			topology.readFile(scanner);
			mTopologyList.add(topology);
		}
	}
	
	private void writeFile() throws IOException {
		FileWriter writer = new FileWriter(mFileName);
		writer.write(mTopologyList.size() + "\n");
		for(Topology topology : mTopologyList) {
			topology.writeFile(writer);
		}
		writer.flush();
	}
	
	private Topology readJson(String jsonName) throws JsonException, FileNotFoundException {
		FileReader fr = new FileReader(jsonName);
		JsonObject ob = (JsonObject)Jsoner.deserialize(fr);
		Topology topology = new Topology();
		topology.readJson(ob);
		return topology;
	}
	
	public void readJSON(String jsonFileName) throws JsonException, IOException {
		Topology topology = readJson(jsonFileName);
		mTopologyList.add(topology);
		writeFile();
	}
	
	
	public void writeJSON(String topologyId, String jsonFileName) throws Exception {
		Topology topology = getTopologyWithId(topologyId);
		if(topology == null) {throw new Exception("Topology Id is not found");}
		JsonObject ob = new JsonObject();
		topology.writeJson(ob);
		FileWriter fw = new FileWriter(jsonFileName);
		fw.write(ob.toJson());
		
		fw.flush();
		fw.close();
		
	}
	
	private Topology getTopologyWithId(String topologyId) {
		for(Topology topology: mTopologyList) {
			if(topology.getTopologyId().equals(topologyId)) { return topology;}
		}
		return null;
	}
	
	public ArrayList<Topology> queryTopologies(){
		return mTopologyList;
	}
	
	public void deleteTopology(String topologyId) throws Exception {
		Topology topology = getTopologyWithId(topologyId);
		if(topology == null) {throw new Exception("Topology Id not found");}
		mTopologyList.remove(topology);
		writeFile();
	}
	
	public ArrayList<Component> queryDevices(String topologyId) throws Exception{
		Topology topology = getTopologyWithId(topologyId);
		if(topology == null) {throw new Exception("Topology Id not found");}
		return topology.getComponentList();
	}
	
	public ArrayList<Component> queryDevicesWithNetlistNode(String topologyId, String nodeId) throws Exception{
		Topology topology = getTopologyWithId(topologyId);
		if(topology == null) {throw new Exception("Topology Id not found");}
		return topology.getComponentsAtNode(nodeId);
	}

}
