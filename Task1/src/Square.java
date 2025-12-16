public class Square implements Shape {
    private int side;

    public Square(){
    }

    @Override
    public double getArea(){
        return side * side;
    }

    public void setSide(int s){
        this.side = s;
    }
}
