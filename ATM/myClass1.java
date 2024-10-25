package ATM;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class myClass1 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		 JSONObject jsonObject=new JSONObject();
		   JSONParser parser = new JSONParser();
	      jsonObject.put("ID", 1);
	      jsonObject.put("First_Name", "Shikhar");
	      jsonObject.put("Last_Name", "Dhawan");
	      jsonObject.put("Date_Of_Birth", "1981-12-05");
	      jsonObject.put("Place_Of_Birth", "Delhi");
	      jsonObject.put("Country", "India");
	      
	      System.out.println("HII");
	      try {
	         FileWriter file = new FileWriter("C:/Users/Raji/eclipse-workspace/NewATMproject/src/ATM/data.json");
	         file.write(jsonObject.toJSONString());
	         file.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
//	      System.out.println("JSON file created: "+jsonObject);
	      
	      FileReader reader = new FileReader("C:/Users/Raji/eclipse-workspace/NewATMproject/src/ATM/data.json");
	      
	      JSONObject jsonObject1 = (JSONObject) parser.parse(reader);
	      
	      System.out.println(jsonObject1.get("First_Name"));
	      System.out.println(jsonObject1.toJSONString());
	}
}




	


