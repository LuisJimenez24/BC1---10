package proyecto.inteligentes;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CubeSolver {
	public static void main(String[] args) throws ParseException {

		final JSONObject cubo = fileReader();
		Cube cube = new Cube();
		cube.setRight(divider(cubo.get("RIGHT").toString().toCharArray()));
		cube.setBack((divider(cubo.get("BACK").toString().toCharArray())));
		cube.setFront(((divider(cubo.get("FRONT").toString().toCharArray()))));
		cube.setLeft(((divider(cubo.get("LEFT").toString().toCharArray()))));
		cube.setUp(((divider(cubo.get("UP").toString().toCharArray()))));
		cube.setDown(((divider(cubo.get("DOWN").toString().toCharArray()))));
	}

	public static JSONObject fileReader() throws ParseException {
		final JSONParser parser = new JSONParser();
		JSONObject initCube = new JSONObject();
		try {
			Object fileJson = parser
					.parse(new FileReader("/Users/luisj/Documents/GitHub/BC1---10/inteligentes/JSON.json"));
			initCube = (JSONObject) fileJson;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return initCube;
	}

	public static char[][] divider(char[] face) {

		char[][] result = new char[3][3];
		int x = 0;
		for (int i = 1; i < face.length - 1; i++) {
			if (face[i] == '[') {
				int y = 0;
				i++;
				while (face[i] != ']') {
					if (face[i] != ',') {
						result[x][y] = face[i];
						++y;
					}
					++i;
				}
				++x;
			}
		}
		return result;
	}
}