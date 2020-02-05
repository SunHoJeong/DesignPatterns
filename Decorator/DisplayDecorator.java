public class DisplayDecorator extends Display {
    public Display displayDecorator;

    //합성(composition) 관계를 통해 RoadDisplay 객체를 참조
    public DisplayDecorator(Display displayDecorator) {
        this.displayDecorator = displayDecorator;
    }

    @Override
    public void draw() {
        displayDecorator.draw();
    }
}
