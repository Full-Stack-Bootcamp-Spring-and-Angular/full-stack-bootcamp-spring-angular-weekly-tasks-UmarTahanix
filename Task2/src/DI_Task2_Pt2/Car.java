package DI_Task2_Pt2;

public class Car implements Vehicle{
    private DatabaseOperations databaseOperations;

    public Car(DatabaseOperations databaseOperations){
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void storeVehicle(){
        databaseOperations.databaseOperations();
        System.out.println("Storing car in the database ....... ");
    }
}
