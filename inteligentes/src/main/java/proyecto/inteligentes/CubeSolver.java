package proyecto.inteligentes;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CubeSolver {
	public static void main(String[] args) throws ParseException {

		final JSONObject cubo = fileReader();
		Cube cube = new Cube(divider(cubo.get("BACK").toString().toCharArray()),
				divider(cubo.get("DOWN").toString().toCharArray()), divider(cubo.get("FRONT").toString().toCharArray()),
				divider(cubo.get("LEFT").toString().toCharArray()), divider(cubo.get("RIGHT").toString().toCharArray()),
				divider(cubo.get("UP").toString().toCharArray()));
	}

	public static JSONObject fileReader() throws ParseException {
		/*Método para leer del archivo JSON ubicado en la carpeta del proyecto*/
		final JSONParser parser = new JSONParser();
		JSONObject initCube = new JSONObject();
		try {
			Object fileJson = parser.parse(new FileReader("JSON.json"));
			initCube = (JSONObject) fileJson;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return initCube;
	}

	public static char[][] divider(char[] face) {
		/*
		 * Método para guardar cada número del archivo JSON en una coordinada de la matriz
		 */
		int nCounter = 0;
		for (char c : face) {
			if (c == '[' || c == ']' || c == ',') {
			}else {
				++nCounter; //Variable que guarda cuántos números hay guardados
			}
		}
		int dimensions = 0;
		for(int i = 1; i<255 ; i++) {
			if((i * i) == nCounter) {
				dimensions = i; //Variable que calcula la potencia de la dimensión del cubo
				break;
			}
		}
		char[][] result = new char[dimensions][dimensions];
		int x = 0;
		for (int i = 1; i < face.length - 1; i++) {
			if (face[i] == '[') {
				int y = 0;
				i++;
				while (face[i] != ']') {
					if (face[i] != ',') {
						result[x][y] = face[i]; //La variable result guarda todos los números según su posición
						++y;					//en el JSON
					}
					++i;
				}
				++x;
			}
		}
		return result;
	}
}