public class LaneDecorator extends DisplayDecorator {

    public LaneDecorator(Display displayDecorator) {
        super(displayDecorator);
    }

    @Override
    public void draw() {
        super.draw(); //기존 operation
        drawLane();
    }

    public void drawLane(){
        System.out.println("차선 표시"); // 추가 차선 표시 기능
    }
}
