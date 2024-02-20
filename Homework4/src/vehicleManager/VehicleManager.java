package vehicleManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import vehicle.Car;
import vehicle.MotorBike;
import vehicle.SUV;
import vehicle.Truck;
import vehicle.Vehicle;
import vehicleAttributes.FuelType;
import vehicleAttributes.StartMechanism;
import vehicleAttributes.VehicleColor;

public class VehicleManager
{
	private static VehicleManager instance = null;
	//private final static String vehicleFilePath = "vehicleManager/vehicleList.csv";
	ArrayList<Vehicle> masterInventory = new ArrayList<>();
	
	public VehicleManager()
	{		
	}
	
	public static VehicleManager getInstance()
	{
		if(instance == null)
		{
			instance = new VehicleManager();
		}
		return instance;
	}

	public boolean readFromFile(String fileName) //reads all data from the .csv file and makes vehicle objects that fall under their given subclasses
	{
		try 
		{
			Scanner fileIn = new Scanner(new FileInputStream(fileName));
			fileIn.nextLine(); //storing the first line of the .csv file somewhere else since it doesn't contain vehicle elements
			
			while(fileIn.hasNext())
			{
				String nextLine = fileIn.nextLine();
				String token[] = nextLine.split(","); //token out each element
				
				String type = token[0];
				String brand = token[1];
				String make = token[2];
				long modelYear = Long.parseLong(token[3]);
				double price = Double.parseDouble(token[4]);
				VehicleColor color = VehicleColor.valueOf(token[5]);
				FuelType fuelType = FuelType.valueOf(token[6]);
				double mileage = Double.parseDouble(token[7]);
				double mass = Double.parseDouble(token[8]);
				int cylinders = Integer.parseInt(token[9]);
				double gasTankCapacity = Double.parseDouble(token[10]);
				StartMechanism startType = StartMechanism.valueOf(token[11]);
				
				switch(type) //based on the vehicle type read from the .csv file create appropriate vehicle subclasses
				{
					case "Truck":
					{
						Truck newTruck = new Truck(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
						masterInventory.add(newTruck);
						break;
					}
					case "Car":
					{
						Car newCar = new Car(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
						masterInventory.add(newCar);
						break;
					}
					case "SUV":
					{
						SUV newSUV = new SUV(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
						masterInventory.add(newSUV);
						break;
					}
					case "MotorBike":
					{
						MotorBike newMotorBike = new MotorBike(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
						masterInventory.add(newMotorBike);
						break;
					}
					default: //if a given vehicle isn't "Truck, Car, SUV, or MotorBike" this default case will appear
					{
						System.out.println("Vehicle Type Not Found!!!");
						break;
					}
				}
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return false;	
		}		
		return true;
	}
}
