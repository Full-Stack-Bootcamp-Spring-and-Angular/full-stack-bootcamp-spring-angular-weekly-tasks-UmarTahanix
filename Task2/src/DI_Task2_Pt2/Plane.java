package DI_Task2_Pt2;

public class Plane implements Vehicle{
    private DatabaseOperations databaseOperations;

    public Plane(){

    }

    public void setDatabaseOperations(DatabaseOperations databaseOperations){
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void storeVehicle(){
        databaseOperations.databaseOperations();
        System.out.println("Storing plane in the database ....... ");
    }
}
