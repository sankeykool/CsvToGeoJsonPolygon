import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class Converter {

	public static void main(String[] args) throws IOException {

		BufferedReader br = null;
		String sCurrentLine,lat,lon;
		JSONArray arrtop = new JSONArray();
		br = new BufferedReader(new FileReader("C:\\Users\\Mobilewalla\\workspace\\CSVtoJSON\\src\\input.txt"));
		while ((sCurrentLine = br.readLine()) != null) {
			String[] st = sCurrentLine.split(" ");
			JSONArray arrbottom = new JSONArray();
			for(int i = 0;i<st.length;i++)
			{
				String[] latlon = st[i].split(",");
				lat = latlon[0];
				lon = latlon[1];
				JSONObject jsonentry = new JSONObject();
				jsonentry.put("lon", lat);
				jsonentry.put("lat", lon);
				arrbottom.add(jsonentry);
			}
			JSONObject jsoncenterpoint = new JSONObject();
			jsoncenterpoint.put("points",arrbottom);
			JSONObject jsongeopolygon = new JSONObject();
			jsongeopolygon.put("center_point", jsoncenterpoint);
			JSONObject jsongeofilters = new JSONObject();
			jsongeofilters.put("geo_polygon", jsongeopolygon);
			arrtop.add(jsongeofilters);
		}
		br.close();
		PrintWriter writer = new PrintWriter("C:\\Users\\Mobilewalla\\workspace\\CSVtoJSON\\src\\output.txt", "UTF-8");
		writer.print(arrtop.toJSONString());
		writer.close();
		
	}
	


}
