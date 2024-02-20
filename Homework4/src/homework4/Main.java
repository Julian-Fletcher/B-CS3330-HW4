package homework4;

import vehicleManager.VehicleManager;

public class Main {

	public static void main(String[] args) 
	{
		VehicleManager vehicleManager = VehicleManager.getInstance(); //create the only instance of vehicleManager
		
		boolean readCSV = vehicleManager.initializeStock();
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
