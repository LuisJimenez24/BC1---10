package proyecto.inteligentes;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CubeSolver {
	public static void main(String[] args) throws ParseException {

		final JSONObject cubo = fileReader();
		int dimensiones = getDimensions(cubo.get("BACK").toString().toCharArray());
		Cube cube = new Cube(
				divider(cubo.get("BACK").toString().toCharArray(), dimensiones),
				divider(cubo.get("DOWN").toString().toCharArray(), dimensiones), 
				divider(cubo.get("FRONT").toString().toCharArray(), dimensiones),
				divider(cubo.get("LEFT").toString().toCharArray(), dimensiones), 
				divider(cubo.get("RIGHT").toString().toCharArray(), dimensiones),
				divider(cubo.get("UP").toString().toCharArray(), dimensiones));
		//System.out.println ("MD5 "+md5Generator("Hola"));
		Cube pruebaMov = movL0(cube, dimensiones);

	}
	private static Cube movL0(Cube cube, int dimensiones) {
		Cube newCubo = new Cube();
		char [][] front = cube.getFront();
		char [][] down = cube.getDown();
		char [][] back = cube.getBack();
		char [][] backCopy = cube.getBack();
		char [][] up = cube.getUp();
		for (int i = 0; i<dimensiones; i++) {
			down[i][0] = front [i][0];
			back[i][0] = backCopy [i][0];
		}
		
		return newCubo;
	}

	private static JSONObject fileReader() throws ParseException {
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

	private static char[][] divider(char[] face, int dimensions) {
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
	
	private static int getDimensions(char[] faces) {
		/*
		 * Método para guardar cada número del archivo JSON en una coordinada de la matriz
		 */
		int nCounter = 0;
		for (char c : faces) {
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
		return dimensions;
	}

	private static String md5Generator(String input) {
		try {
			MessageDigest instanceMDigest = MessageDigest.getInstance("MD5");
			byte [] mDigest = instanceMDigest.digest(input.getBytes());
			BigInteger number = new BigInteger(1, mDigest);
			String hashText = number.toString(16);
			while (hashText.length() < 32) {
				hashText = "0" + hashText;
			}
			return hashText;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}