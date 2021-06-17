package com.gromivchuk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.gromivchuk.*;


public class Main {

	//Checking the Data Base of Scents of last positions of lost robots
	public static boolean checkScent(ArrayList<ArrayList<Integer>> bbddOfScents, ArrayList<Integer> scent) {
		for (ArrayList<Integer> currentScent :bbddOfScents) {
			if(currentScent.get(0)== scent.get(0) && currentScent.get(1)== scent.get(1)) {
				return true;
			}		
		}
		return false;
	}

	//Method implementing the robot's route
	public static void routeImplementation(RobotLocation robot, String route) {
		String[] routeSplit = route.split("");
		int n = routeSplit.length;
		String lost = "";
		boolean borderReached = false;
		ArrayList<ArrayList<Integer>> bbddOfScents = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> newScent = new ArrayList<Integer>();     
		for (int i=0;i<n; i++) {

			switch (routeSplit[i]) {
			case "R": 
				robot.turn("R");
				break;
			case "L":
				robot.turn("L");
				break;
			case "F":
				if (!robot.move()) {
					borderReached = true;
					newScent.add(robot.getX());
					newScent.add(robot.getY());
					if (!checkScent(bbddOfScents, newScent)) {
						lost = "LOST";
						bbddOfScents.add(newScent);
					}
				}
				break;
			}
			if(borderReached) {
				break;
			}
		}
		System.out.println(robot.getX() + " " + robot.getY()  + " "+ robot.getDirection()  + " " + lost);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		//Reading first line of input - dimensions of the grid
		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int maxX = Integer.parseInt(firstMultipleInput[0]);

		int maxY = Integer.parseInt(firstMultipleInput[1]);

		//Reading position of the robot
		String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int x = Integer.parseInt(secondMultipleInput[0]);
		int y = Integer.parseInt(secondMultipleInput[1]);
		String direction = secondMultipleInput[2];

		//Initializing robot
		RobotLocation robot1 = new RobotLocation(x,y,direction,maxX,maxY);

		//Reading route 
		String route = bufferedReader.readLine().trim();

		routeImplementation(robot1, route);


		// bufferedWriter.write(String.valueOf(result));
		//        bufferedWriter.newLine();

		bufferedReader.close();
		//        bufferedWriter.close();

	}
}

