package Projekt1;

import org.jongo.MongoCursor;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FakeService implements IShipService {
    List<Ship> shipsFDB;

    public FakeService() {
        shipsFDB = new ArrayList<Ship>();
    }

    public void act(char in, Ship ship) throws IOException {
        switch (in) {
            case 'x':
                break;
            default:
                ship.move(in);
                shipsFDB.add(ship);
                break;
        }
    }

    public List<Ship> getAll() {

        if (shipsFDB == null) throw new NullPointerException();
        else return shipsFDB;
    }
}

