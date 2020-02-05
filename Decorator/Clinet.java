public class Clinet {
    public static void main(String[] args) {
        Display road = new RoadDisplay();
        road.draw(); // 기본 operation

        Display roadWithLane = new LaneDecorator(new RoadDisplay());
        roadWithLane.draw(); // 기본 operation + 추가 operation
    }
}
