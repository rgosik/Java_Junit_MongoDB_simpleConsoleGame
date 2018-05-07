package Projekt1;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IShipService {
    public void act(char in, Ship ship) throws IOException;
    public List<Ship> getAll();
}