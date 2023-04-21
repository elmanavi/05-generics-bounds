package ohm.softa.a05.tests.collections;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlantsTests {
    private final Logger logger = LogManager.getLogger();
    PlantBed<Flower> testPlantBed;
    Flower testFlower = new Flower(0.5, "Wildblumen", "Gaensebluemchen", PlantColor.BLUE);


    @BeforeEach()
    void setup(){
        testPlantBed = new PlantBed<>();
        testPlantBed.add(testFlower);
        testPlantBed.add( new Flower(0.3, "Wildblumen", "Loewenzahn", PlantColor.YELLOW));
        testPlantBed.add( new Flower(0.3, "Wildblumen", "Rose", PlantColor.RED));
        testPlantBed.add( new Flower(0.2, "Wildblumen", "Butterblume", PlantColor.YELLOW));


    }

    @Test()
    void createFlowerNotGreen(){
        logger.info("createFlowerNotGreen");
        assertEquals(testFlower.getHeight(), 0.5);
        assertEquals(testFlower.getFamily(), "Wildblumen");
        assertEquals(testFlower.getName(), "Gaensebluemchen");
        assertEquals(testFlower.getColor(), PlantColor.BLUE);
    }

    @Test
    public void createFlowerGreen() {
        logger.info("createFlowerGreen test");
        assertThrows(IllegalArgumentException.class, () -> {
            Flower flower = new Flower(0.5, "Wildblumen", "Gaensebluemchen", PlantColor.GREEN);
        });
    }

    @Test
    public void createShrub(){
        logger.info("createShrub test");
        Shrub shrub = new Shrub(0.8, "Kraeuter", "Basilikum");
        assertEquals(shrub.getHeight(), 0.8);
        assertEquals(shrub.getFamily(), "Kraeuter");
        assertEquals(shrub.getName(), "Basilikum");
        assertEquals(shrub.getColor(), PlantColor.GREEN);
    }

    @Test()
    public void flowerToString(){
        logger.info("flowerToString test:");
        logger.info(testFlower.toString());
        assertEquals("Name: Gaensebluemchen - Family: Wildblumen - Color: BLUE - Height: 0.5", testFlower.toString());
    }

    @Test
    public void getPlantsByColor(){
        logger.info("getPlantsByColor test:");
        SimpleList<Flower> filtered = testPlantBed.getPlantsByColor(PlantColor.BLUE);
        for (Flower f : filtered ) {
            assertEquals(f.getColor(), PlantColor.BLUE);
        }
    }

    @Test
    public void plantBedToString(){
        logger.info("plantBedToString Test:");
        logger.info(testPlantBed.toString());
    }


    @Test
    public void plantEqualsTrue(){
        logger.info("plantEqualsTrue Test");
        assertTrue(testFlower.equals(new Flower(0.5, "Wildblumen", "Gaensebluemchen", PlantColor.BLUE)));
    }

    @Test
    public void plantEqualsFalse(){
        logger.info("plantEqualsFalse Test");
        assertFalse(testFlower.equals(new Flower(0.3, "Wildblumen", "Gaensebluemchen", PlantColor.BLUE)));
        assertFalse(testFlower.equals(new Flower(0.5, "Blumen", "Gaensebluemchen", PlantColor.BLUE)));
        assertFalse(testFlower.equals(new Flower(0.5, "Wildblumen", "Gras", PlantColor.BLUE)));
        assertFalse(testFlower.equals(new Flower(0.5, "Wildblumen", "Gaensebluemchen", PlantColor.YELLOW)));
    }

    @Test
    public void removePlantFromPlantBed(){
        logger.info("removePlantFromPlantBed");
        testPlantBed.remove(testFlower);
        assertTrue((testPlantBed.getPlants().filter(p -> p.equals(testFlower))).size() == 0);
    }



}
