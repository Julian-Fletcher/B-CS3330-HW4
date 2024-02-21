package vehicle;

import java.time.LocalDate;

import vehicleAttributes.FuelType;
import vehicleAttributes.StartMechanism;
import vehicleAttributes.VehicleColor;

public class SUV extends Vehicle
{

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
	
	public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) 
	{
		super();
		this.brand = brand;
		this.make = make;
		this.modelYear = modelYear;
		this.price = price;
		this.color = color;
		this.fuelType = fuelType;
		this.mileage = mileage;
		this.mass = mass;
		this.cylinders = cylinders;
		this.gasTankCapacity = gasTankCapacity;
		this.startType = startType;
	}

	public SUV(SUV other)//copy constructor
	{
		super();
		this.brand = other.brand;
		this.make = other.make;
		this.modelYear = other.modelYear;
		this.price = other.price;
		this.color = other.color;
		this.fuelType = other.fuelType;
		this.mileage = other.mileage;
		this.mass = other.mass;
		this.cylinders = other.cylinders;
		this.gasTankCapacity = other.gasTankCapacity;
		this.startType = other.startType;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public long getModelYear() {
		return modelYear;
	}

	public void setModelYear(long modelYear) {
		this.modelYear = modelYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public VehicleColor getColor() {
		return color;
	}

	public void setColor(VehicleColor color) {
		this.color = color;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

	public double getGasTankCapacity() {
		return gasTankCapacity;
	}

	public void setGasTankCapacity(double gasTankCapacity) {
		this.gasTankCapacity = gasTankCapacity;
	}

	public StartMechanism getStartType() {
		return startType;
	}

	public void setStartType(StartMechanism startType) {
		this.startType = startType;
	}

	@Override
	public double calculateMaintenaceCost(double distance)
	{
		double maintenanceCost;
		double maintenConst = 0.001;
		
		LocalDate date = LocalDate.now();
		int currentYear = date.getYear();
		
		maintenanceCost = distance * this.mass * (currentYear - this.modelYear) * this.cylinders * maintenConst;
		
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) 
	{
		double fuelEfficiency;
		double fuelEffiConst = 0.05;
		
		fuelEfficiency = this.cylinders * this.gasTankCapacity * (fuelPrice / distance) * fuelEffiConst;
		
		return fuelEfficiency;
	}

	@Override
	public void startEngine() 
	{
		System.out.println(this.startType);
	}

	@Override
	public String toString() {
		return "SUV [brand=" + brand + ", make=" + make + ", modelYear=" + modelYear + ", price=" + price + ", color="
				+ color + ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass + ", cylinders="
				+ cylinders + ", gasTankCapacity=" + gasTankCapacity + ", startType=" + startType + "]";
	}

	public String printFormat() {
		return "SUV" + brand + "," + modelYear + "," + price + "," + color + "," + fuelType + "," 
				+ mileage + "," + mass + "," + cylinders + "," + gasTankCapacity + "," + startType + "\n";
	}
}
