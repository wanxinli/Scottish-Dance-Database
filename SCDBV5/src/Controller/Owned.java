package Controller;

import java.io.FileWriter;
import java.io.IOException;
//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Owned {

	private static String jsonPath = System.getProperty("." + File.separator + "owned.json");
	private static JSONObject objState;

	private static void write(JSONObject jsobj) {
		try (FileWriter file = new FileWriter(jsonPath)) {
			file.write(jsobj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void write() {
		try (FileWriter file = new FileWriter(jsonPath)) {
			file.write("{}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void read() {

		JSONParser parse = new JSONParser();

		try {

			Object obj = parse.parse(new FileReader(jsonPath));
			objState = (JSONObject) obj;

		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace(); // Maybe call write() here to get rid of
									// infinite loop possibility? test later
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static boolean isOwned(int id, String tableName) {
		if (objState.equals(null)) {
			System.out.println("objState not made yet");
			Owned.read();
			return isOwned(id, tableName);
			// WARNING: POSSIBILITY FOR INFINITE LOOP HERE. THINK ABOUT CALLING WRITE() AFTER A CHECK IN HERE
		} else {
			return objState.containsKey(tableName) && objState.containsValue(id);
			// There has to be a better way
		}
	}

	@SuppressWarnings("unchecked") // For the put operation. For now.
	public static void mark(int id, String tableName) {
		Owned.read();
		if (objState == null) {
			System.out.println("Could not find any file to read from. Making a new json file....");
			Owned.write(); // Creates a new json file where it should already be
		} else {
			// I REALLY hope that id's across tables don't clash and match. If they do,
			// we're kinda fucked with this way.
			objState.putIfAbsent(id, tableName); 
		}
		Owned.write(objState);
	}

	@SuppressWarnings("unchecked") // For the put operation. For now.
	public static void mark(int id, String tableName, int[] collection, String collectionTableName) {
		Owned.read();
		if (objState == null) {
			System.out.println("Could not find any file to read from. Making a new json file....");
			Owned.write(); // Creates a new "json" file where it should already
			// be
		} else {
			for (int el : collection) {
				objState.putIfAbsent(el, collectionTableName);
			}
			objState.putIfAbsent(id, tableName);
		}
		Owned.write(objState);
	}

	public static void unmark(int id) {
		Owned.read();
		if (objState == null) {
			System.out.println("Could not find any file to read from. Making a new json file....");
			Owned.write(); // Creates a new "json" file where it should already
							// be
		} else {
			if (objState.containsKey(id)) {
				objState.remove(id);
			} else {
				System.out.println(
						"Wrong function was probably used here. You want to use the mark(int id) method, not unmark(int id)");
				System.out.println("Just in case..... You tried to unmark something that you haven't marked yet.");
			}
		}
	}

	public static void unmark(int id, int[] collection) {
		Owned.read();
		if (objState == null) {
			System.out.println("Could not find any file to read from. Making a new json file....");
			Owned.write(); // Creates a new json file where it should already be
		} else {
			for (int el : collection) {
				if (objState.containsKey(el)) {
					objState.remove(el);
				}
			}
			if (objState.containsKey(id)) {
				objState.remove(id);
			} else {
				System.out.println(
						"Wrong function was probably used here. You want to use the mark(int id) method, not unmark(int id)");
				System.out.println("Just in case..... You tried to unmark something that you haven't marked yet.");
			}
		}
	}

}
