public class Circle implements Shape{
    private Draw2D draw_2D;
    private Draw3D draw_3D;

    public Circle(Draw2D draw_2D, Draw3D draw_3D){
        this.draw_2D = draw_2D;
        this.draw_3D = draw_3D;
    }

    @Override
    public String getShapeName(){
        return "circle";
    }

    public void drawCircle2D(){
        System.out.println(String.format("%s %s", draw_2D.draw2D(), this.getShapeName()));
    }

    public void drawCircle3D(){
        System.out.println(String.format("%s %s", draw_3D.draw3D(), this.getShapeName()));
    }
}
