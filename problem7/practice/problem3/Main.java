abstract class GardenTool { public abstract String use(); }
class CuttingTool extends GardenTool {
    public String use() { return "Using the tool in the garden, blade sharpened first"; }
}
class Pruner extends CuttingTool {
    public String use() { return super.use() + ", then trimming branches precisely"; }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(new CuttingTool().use());
        System.out.println(new Pruner().use());
    }
}