public class Square implements Shape{
    private Draw2D draw_2D;
    private Draw3D draw_3D;

    public Square(){}

    public void setDraw2D(Draw2D draw_2D){
        this.draw_2D = draw_2D;
    }

    public void setDraw3D(Draw3D draw_3D){
        this.draw_3D = draw_3D;
    }

    @Override
    public String getShapeName(){
        return "square";
    }

    public void drawSquare2D(){
        System.out.println(String.format("%s %s", draw_2D.draw2D(), this.getShapeName()));
    }

    public void drawSquare3D(){
        System.out.println(String.format("%s %s", draw_3D.draw3D(), this.getShapeName()));
    }
}
