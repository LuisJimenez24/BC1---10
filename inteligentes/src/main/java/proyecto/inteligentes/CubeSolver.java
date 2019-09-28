package proyecto.inteligentes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class CubeSolver {
	public static void main(String[] args) throws ParseException {
		
		final JSONObject cubo = fileReader();
		System.out.print(cubo);

	}

	public static JSONObject fileReader() throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject initCube = new JSONObject();
		try {
			Object fileJson = parser.parse(new FileReader("/Users/luisj/Documents/GitHub/BC1---10/inteligentes/JSON.json"));
			initCube = (JSONObject) fileJson;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*BufferedReader reader;
		try {
			reader = new BufferedReader(
					new FileReader("/Users/luisj/Documents/GitHub/BC1---10/inteligentes/JSON.json"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		return initCube;
	}
}