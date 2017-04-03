package us.prouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class ICD10 {

	public static String GetDescription(String code) throws IOException, JSONException {

		URL url = new URL("http://icd10api.com/?code=" + code + "&desc=short&r=json");
		HttpURLConnection connection;
		connection = (HttpURLConnection) url.openConnection();
		connection.connect();

		InputStream stream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		StringBuffer buffer = new StringBuffer();

		String line = "";
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}

		JSONObject json = new JSONObject(buffer.toString());
		String description = json.getString("Description");

		connection.disconnect();
		reader.close();

		return description;
	}
}