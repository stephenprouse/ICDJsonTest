/**
 * 
 */
package us.prouse;

import java.io.IOException;

import org.json.JSONException;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		;
		String code = "C53.1";
		String description;
		try {
			description = ICD10.GetDescription(code);
			System.out.println(description);
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
