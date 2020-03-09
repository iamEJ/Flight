import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lt.itakademija.exam.FlightManager;
import lt.itakademija.exam.Passenger;
import lt.itakademija.exam.Plane;
import lt.itakademija.exam.SeatIsOccupiedException;

public class Flight implements  FlightManager {
	
	private List<Plane> planes = new ArrayList<>();
	

	@Override
	public Passenger createPassenger(String name, String surname, int age) {
		
		if( name.isEmpty() || name == null) {
			throw new IllegalArgumentException();
		}
		
		if( surname.isEmpty() || surname == null) {
			throw new IllegalArgumentException();
		}
		
		
		Passenger pa = new Passenger(name, surname,age);
		
		return pa;
	}

	@Override
	public Plane createPlane(String id, int seats) {
		
		
		if( id.isEmpty() || id == null) {
			throw new IllegalArgumentException();
		}
		
		if( seats <= 0) {
			throw new IllegalArgumentException();
		}
		
		Plane pl = new Plane (id,seats);
		planes.add(pl);
		return pl;
	}

	@Override
	public double getAveragePassengerAge(String planeId) {
		
		return getPlaneById(planeId).getPassengers().stream()
		        .collect(Collectors.averagingInt(p -> p.getAge()));
	}

	@Override
	public List<Plane> getCreatedPlanes() {
		
		return planes;
	}

	@Override
	public Passenger getOldestPassenger(String planeId) {
		
		return  getPlaneById(planeId).getPassengers().stream().max((a,b) -> a.getAge() - b.getAge()).get();
	}

	@Override
	public List<Passenger> getPassengers(String planeId) {
		
		return getPlaneById(planeId).getPassengers();
	}

	@Override
	public Plane getPlaneById(String id) {
		if(id == null) {
			throw new NullPointerException();
		}
		for (Plane p : planes) {
			
			if(p.getId().equals(id)) {

				
				
				return p;
			}
		}
		return null;
	}

	@Override
	public void registerPassenger(Plane plane, int seatNo, Passenger passenger) throws SeatIsOccupiedException {
		
		if(plane.isSeatOccupied(seatNo)) {
			throw new SeatIsOccupiedException();
		}
		
		plane.registerPassenger(seatNo, passenger);
		
	}

}
