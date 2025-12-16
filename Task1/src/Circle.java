public class Circle implements Shape{
    private int radius;

    public Circle(){
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(radius, 2.0);
    }

    public void setRadius(int r){
        this.radius = r;
    }
}
