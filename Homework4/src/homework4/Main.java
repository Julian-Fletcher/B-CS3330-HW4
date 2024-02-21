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
		
		vehicleManager.displayAllCarInformation();
		vehicleManager.displayVehicleInformation(vehicleManager.masterInventory.get(1));
		vehicleManager.masterInventory.get(1).calculateFuelEfficiency(23, 55);
		vehicleManager.masterInventory.get(1).calculateMaintenaceCost(55);
		vehicleManager.displayVehicleInformation(vehicleManager.masterInventory.get(1));
	}

}
