# Topology Api
## Specification
Topology api is a library helps access, manage and store the circuits topologies
### API
* readJSON
* writeJSON
* queryTopologies
* deleteTopology
* queryDevices
* queryDevicesWithNetlistNode

### readJSON
```Java
	 /**
	 * Reads the json file and store it in the memory
	 * @param ob The Json file name
	 * */
	public void readJSON(String jsonFileName);
```
### writeJSON
```Java
	 /**
	 * Read a given topology id from the memory and store it in a json file
	 * @param topologyId The topology Id
	 * @param jsonFileName The json file name
	 * */
	public void writeJSON(String topologyId, String jsonFileName);
```
### queryTopologies
```Java
	/**
	 * Reads the available topologies from the memory
	 * @return List of all topologies stored in the memory
	 * */
	public ArrayList<Topology> queryTopologies();
```
### deleteTopology
```Java
	 /**
	 * Delete a topology from memory given its id
	 * @param topologyId The topology id
	 * */
	public void deleteTopology(String topologyId);
```
### queryDevices
```Java
	/**
	 * Gets the given topology components
	 * @param topologyId The topology id
	 * @return List of the topology components
	 * */
	public ArrayList<Component> queryDevices(String topologyId);
```
### queryDevicesWithNetlistNode
```Java
	 /**
	 * Gets the given topology components connected to the same node
	 * @param topologyId The topology id
	 * @param nodeId The node id
	 * */
	public ArrayList<Component> queryDevicesWithNetlistNode(String topologyId, String nodeId);
```
### JSON file
---
```json
{
  "id": "top1",
  "components": [
    {
      "type": "resistor",
      "id": "res1",
      "resistance": {
        "default": 100,
        "min": 10,
        "max": 1000
      },
      "netlist": {
        "t1": "vdd",
        "t2": "n1"
      }
    },
    {
      "type": "nmos",
      "id": "m1",
      "m1": {
        "default": 1.5,
        "min": 1,
        "max": 2
      },
      "netlist": {
        "drain": "n1",
        "gate": "vin",
        "source": "vss"
      }
    }
  ]
}
```

### Memory file
---
```
top1 2
resistor res1 100.0 10.0 1000.0 vdd n1
nmos m1 1.5 1.0 2.0 n1 vin vss
```
