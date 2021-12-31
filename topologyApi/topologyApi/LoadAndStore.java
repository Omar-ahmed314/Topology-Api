package topologyApi;

import com.github.cliftonlabs.json_simple.*;

public interface LoadAndStore {
	public Component readFile(String fileName);
	public void writeFile(String fileName);
	public Component readJson(JsonObject ob);
	public void writeJson(JsonObject ob);
}