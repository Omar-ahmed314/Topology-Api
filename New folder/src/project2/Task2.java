package project2;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonException;

public class Task2 {

	public static void main(String[] args) throws Exception {
		
		TopologyApi api = new TopologyApi("memory.txt");
		//api.readJSON("api.json");
		//api.writeJSON("top1", "api.json");
		//api.deleteTopology("top1");
		
		/*
		ArrayList<Topology> list = api.queryTopologies();
		for(Topology t : list) {
			t.print();
		}
		
		ArrayList<Component> list = api.queryDevices("top1");
		for(Component c : list) {
			c.print();
		}
		*/
		ArrayList<Component> list = api.queryDevicesWithNetlistNode("top1", "n1");
		for(Component c : list) {
			c.print();
		}
		
		
		
		System.out.println("Done...");
	}

}
