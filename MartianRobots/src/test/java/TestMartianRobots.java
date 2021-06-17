import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import com.gromivchuk.Main;


public class TestMartianRobots {
	String[] input = {"5 3\r\n1 1 E\r\nRFRFRFRF",
				"5 3\r\n3 2 N\r\nFRRFLLFFRRFLL", 
				"5 3\r\n0 3 W\r\nLLFFFLFLFL"};
	String[] output = {"1 1 E", "3 3 N LOST", };

	@Test
	public void TestAllInputs() {
		for(int i =0; i<input.length; i++) {
			testMartianRobotsOutput(input[i],output[i]);
		}

	}
	
	public void testMartianRobotsOutput(String s, String out) {
		Main main = new Main();
		String[] args = {s};

		try {
			Main.main(args);
			String string = "";
			assertEquals(out, FileUtils.readFileToString(new File("C:\\Users\\Svit Juancho\\git\\MartianRobots\\MartianRobots\\src\\main\\resources\\output.txt"), string));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}
