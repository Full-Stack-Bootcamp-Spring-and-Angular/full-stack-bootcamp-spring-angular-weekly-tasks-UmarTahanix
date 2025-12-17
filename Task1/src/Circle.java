public class Circle implements Shape{
    private int circle_radius;

    public Circle(){
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(circle_radius, 2.0);
    }

    public void setRadius(int radius){
        this.circle_radius = radius;
    }
}
