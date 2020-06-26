package com.spring.practice.bean;

/**
 * @author Bittu
 *
 */
public class Vehicles {

	private int numberOfWheels;
	private String vehicleType;
	private String modelName;
	private String vehicleBrand;
	
	public Vehicles() {
		// Default Constructor
	}
	public Vehicles(int numberOfWheels, String vehicleType, String modelName, String vehicleBrand) {
		this.numberOfWheels = numberOfWheels;
		this.vehicleType = vehicleType;
		this.modelName = modelName;
		this.vehicleBrand = vehicleBrand;
	}
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
		result = prime * result + numberOfWheels;
		result = prime * result + ((vehicleBrand == null) ? 0 : vehicleBrand.hashCode());
		result = prime * result + ((vehicleType == null) ? 0 : vehicleType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicles other = (Vehicles) obj;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (numberOfWheels != other.numberOfWheels)
			return false;
		if (vehicleBrand == null) {
			if (other.vehicleBrand != null)
				return false;
		} else if (!vehicleBrand.equals(other.vehicleBrand))
			return false;
		if (vehicleType == null) {
			if (other.vehicleType != null)
				return false;
		} else if (!vehicleType.equals(other.vehicleType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vehicles [numberOfWheels=" + numberOfWheels + ", vehicleType=" + vehicleType + ", modelName="
				+ modelName + ", vehicleBrand=" + vehicleBrand + "]";
	}
}
