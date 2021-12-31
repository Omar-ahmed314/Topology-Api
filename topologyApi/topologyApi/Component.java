package topologyApi;

import java.util.HashMap;

public abstract class Component {
	private String mType;
	private String mId;
	public Component(String type, String id) {
		this.setType(type);
		this.setId(id);
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
	public void print() {
		System.out.println("Type: " + mType + " " + "Id: " + mId);
	}
}
