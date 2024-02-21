package vehicle;

import vehicleAttributes.*;

public abstract class Vehicle {
	protected String brand;
	protected String make;
	protected long modelYear;
	protected double price;
	protected VehicleColor color;
	protected FuelType fuelType;
	protected double mileage;
	protected double mass;
	protected int cylinders;
	protected double gasTankCapacity;
	protected StartMechanism startType;
	protected double maintenanceCost = 1;
	protected double fuelEfficiency = 1;
	
	public abstract double calculateMaintenaceCost(double distance);
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
	public abstract void startEngine();
	
}	
