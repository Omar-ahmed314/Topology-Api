package topologyApi;

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
	private FileWriter mFw;
	private Scanner mSc;
	
	public TopologyApi(String fileName) {
		mFileName = new File(fileName);
	}
	
	private void readFile() {
		try {
			mSc = new Scanner(mFileName);
			mTopologyCount = mSc.nextInt();
			for(int i = 0; i < mTopologyCount; i++) {
				Topology topology = new Topology();
				topology.readFile(mSc);
				mTopologyList.add(topology);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeFile() {
		try {
			mFw = new FileWriter(mFileName);
			mFw.write(mTopologyList.size());
			for(Topology topology : mTopologyList) {
				topology.writeFile(mFw);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Topology readJson(String jsonName) throws JsonException, FileNotFoundException {
		FileReader fr = new FileReader(jsonName);
		JsonObject ob = (JsonObject)Jsoner.deserialize(fr);
		Topology topology = new Topology();
		topology.readJson(ob);
		return topology;
	}
	
	public void readJSON(String jsonFileName) throws FileNotFoundException, JsonException {
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

}
