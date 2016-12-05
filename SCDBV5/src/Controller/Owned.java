package Controller;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Owned {

	private static FileWriter fw;
	private static FileReader fr;
	private static File jsonPath = new File("owned.json");
	private static JSONObject objState;

	private static void init() {
		try {
			fw = new FileWriter(jsonPath);
			fw.write("{}");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void write(JSONObject jsobj) {
		try {
			fw = new FileWriter(jsonPath);
			fw.write(jsobj.toJSONString());
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read() {

		JSONParser parse = new JSONParser();

		try {

			fr = new FileReader(jsonPath);
			Object obj = parse.parse(fr);
			objState = (JSONObject) obj;
			fr.close();
			
		} catch (FileNotFoundException e) {
			Owned.init();
			e.printStackTrace();
		} catch ( ParseException e ) {
//			System.out.println("malformed json file.");
			e.printStackTrace();
		} catch (IOException e) {
//			Owned.init();
			e.printStackTrace();
		}
	}

	public static boolean isOwned(int id, String tableName) {
		return objState.containsKey((String) Integer.toString(id)) && objState.containsValue((String) tableName);
		// There has to be a better way...
	}

	@SuppressWarnings("unchecked") // For the put operation. For now.
	public static void mark(String id, String tableName) {
		objState.putIfAbsent(id, tableName);
		Owned.write(objState);
	}

	@SuppressWarnings("unchecked") // For the put operation. For now.
	public static void mark(String id, String tableName, int[] collection, String collectionTableName) {
		for (int el : collection) {
			objState.putIfAbsent(el, collectionTableName);
		}

		objState.putIfAbsent(id, tableName);

		Owned.write(objState);
	}

	public static void unmark(int id) {
		if (objState.containsKey(id)) {
			objState.remove(id);
		} else {
			System.out.println("Wrong function was probably used here. You want to use the mark(int id) method, not unmark(int id)");
			System.out.println("Just in case..... You tried to unmark something that you haven't marked yet.");
		}
	}

	public static void unmark(int id, int[] collection) {
		for (int el : collection) {
			if (objState.containsKey(el)) {
				objState.remove(el);
			}
		}
		if (objState.containsKey(id)) {
			objState.remove(id);
		} else {
			System.out.println("Wrong function was probably used here. You want to use the mark(int id) method, not unmark(int id)");
			System.out.println("Just in case..... You tried to unmark something that you haven't marked yet.");
		}
	}

}
