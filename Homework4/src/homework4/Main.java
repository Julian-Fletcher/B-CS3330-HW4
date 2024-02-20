package homework4;

import vehicleManager.VehicleManager;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("Code");
		
		VehicleManager vehicleManager = VehicleManager.getInstance(); //create the only instance of vehicleManager
		
		String vehicleFilePath = "vehicleManager/vehicleList.csv"; //creating filePath to vehicleList.csv
		boolean readCSV = vehicleManager.readFromFile(vehicleFilePath);
		if(readCSV == true) //checking if readFromFile worked
		{
			System.out.println("VehicleManger successfully read from .csv");
		}
		else
		{
			System.out.println("VehicleManger did NOT successfully read from .csv!!!");
		}
	}

}
