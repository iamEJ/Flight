import lt.itakademija.exam.FlightManager;
import lt.itakademija.exam.test.BaseTest;

public class TestFlight extends BaseTest{

	@Override
	protected FlightManager createFlightManager() {
		// TODO Auto-generated method stub
		return new Flight();
	}

}
