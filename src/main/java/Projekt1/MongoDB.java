package Projekt1;

import java.io.IOException;
import java.util.List;

public class MongoDB {
    public IShipService service;

    public MongoDB(){

        service = new Service();
    }

    public MongoDB(FakeService fake) {

        service = fake;
    }
    public List<Ship> getAll() {

        return service.getAll();
    }
    public void act(char in, Ship ship) throws IOException {
        service.act(in, ship);
    }
}
