package vehicleManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

public class VehicleManager {
	private static VehicleManager instance = null;

	public ArrayList<Vehicle> masterInventory = new ArrayList<>();
	private static String vehicleFilePath = "Files/vehicleList.csv"; //creating filePath to vehicleList.csv
	
	public static VehicleManager getInstance()
	{
		if(instance == null)
		{
			instance = new VehicleManager();
		}
		return instance;
	}

	public boolean initializeStock() // reads all data from the .csv file and makes vehicle objects that fall under
										// their given subclasses
	{
		try {
			Scanner fileIn = new Scanner(new FileInputStream(vehicleFilePath));
			fileIn.nextLine(); // storing the first line of the .csv file somewhere else since it doesn't
								// contain vehicle elements

			while (fileIn.hasNext()) {
				String nextLine = fileIn.nextLine();
				String token[] = nextLine.split(","); // token out each element

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

				switch (type) // based on the vehicle type read from the .csv file create appropriate vehicle
								// subclasses
				{
				case "Truck": {
					Truck newTruck = new Truck(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders,
							gasTankCapacity, startType);
					masterInventory.add(newTruck);
					break;
				}
				case "Car": {
					Car newCar = new Car(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders,
							gasTankCapacity, startType);
					masterInventory.add(newCar);
					break;
				}
				case "SUV": {
					SUV newSUV = new SUV(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders,
							gasTankCapacity, startType);
					masterInventory.add(newSUV);
					break;
				}
				case "MotorBike": {
					MotorBike newMotorBike = new MotorBike(brand, make, modelYear, price, color, fuelType, mileage,
							mass, cylinders, gasTankCapacity, startType);
					masterInventory.add(newMotorBike);
					break;
				}
				default: // if a given vehicle isn't "Truck, Car, SUV, or MotorBike" this default case
							// will appear
				{
					System.out.println("Vehicle Type Not Found!!!");
					break;
				}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void displayAllCarInformation()
	{
		int count = 0;
		for(Vehicle vehicle : masterInventory) {
			if(vehicle instanceof Car) {
				System.out.println(vehicle);
				count++;
			}
		}
		if(count==0) {
			System.out.println("There Are No Vehicles With These Parameters.");
		}
	}
	
	public void displayAllTruckInformation()
	{
		int count = 0;
		for(Vehicle vehicle : masterInventory) {
			if(vehicle instanceof Truck) {
				System.out.println(vehicle);
				count++;
			}
		}
		if(count==0) {
			System.out.println("There Are No Vehicles With These Parameters.");
		}
	}
	
	public void displayAllSUVInformation()
	{
		int count = 0;
		for(Vehicle vehicle : masterInventory) {
			if(vehicle instanceof SUV) {
				System.out.println(vehicle);
				count++;
			}
		}
		if(count==0) {
			System.out.println("There Are No Vehicles With These Parameters.");
		}
	}
	
	public void displayAllMotorBikeInformation() 
	{
		int count = 0;
		for(Vehicle vehicle : masterInventory) {
			if(vehicle instanceof MotorBike) {
				System.out.println(vehicle);
				count++;
			}
		}
		if(count==0) {
			System.out.println("There Are No Vehicles With These Parameters.");
		}
	}
	
	public void displayVehicleInformation(Vehicle v)
	{
		System.out.println(v);
	}
	
	public void displayAllVehicleInformation()
	{
		int count = 0;
		for(Vehicle vehicle : masterInventory) {
			System.out.println(vehicle);
			count++;
		}
		if(count==0) {
			System.out.println("There Are No Vehicles With These Parameters.");
		}
	}

	public boolean removeVehicle(Vehicle vehicle) {
		return masterInventory.remove(vehicle);
	}

	public boolean addVehicle(Vehicle vehicle) {
		return masterInventory.add(vehicle);
	}

	public boolean saveVehicleList() {
		try {
			FileWriter fileWriter = new FileWriter(vehicleFilePath);
			String headLine = "Type, Model, Make, ModelYear, Price, Color, FuelType, Mileage\n";
			fileWriter.write(headLine);
			for(Vehicle vehicle : masterInventory) {
				fileWriter.write(vehicle.printFormat());
			}
			
			fileWriter.close();
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	private boolean isVehicleType(Vehicle v, Class clazz) {
		return v.getClass().equals(clazz);
	}
	
	public int getNumberOfVehichlesByType(Class clazz)
	{
		int count = 0;
		for(Vehicle vehicle : masterInventory) {
			if(isVehicleType(vehicle, clazz)) {
				count++;
			}
		}
		return count;
	}

	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
	}

	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
	}

	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
	}

	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
	}
}
