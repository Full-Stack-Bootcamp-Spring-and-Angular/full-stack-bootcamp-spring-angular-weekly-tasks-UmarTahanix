package DI_Task2_Pt1;

public class Square implements Shape {
    private Draw2D draw_2D;
    private Draw3D draw_3D;

    public Square(){

    }

    public void setDraw2D(Draw2D draw_2D){
        this.draw_2D = draw_2D;
    }

    public void setDraw3D(Draw3D draw_3D){
        this.draw_3D = draw_3D;
    }

    @Override
    public void draw2D(){
        System.out.println(String.format("%s square", draw_2D.Drawing2D()));
    }

    @Override
    public void draw3D(){
        System.out.println(String.format("%s square", draw_3D.Drawing3D()));
    }
}
