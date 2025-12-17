public class Square implements Shape {
    private int square_side;

    public Square(){
    }

    @Override
    public double getArea(){
        return square_side * square_side;
    }

    public void setSide(int side){
        this.square_side = side;
    }
}
