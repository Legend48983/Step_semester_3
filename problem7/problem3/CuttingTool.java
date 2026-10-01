public class CuttingTool extends GardenTool {
    @Override
    public String use() {
        return superUse();
    }

    private String superUse() {
        return "Using the tool in the garden, blade sharpened first";
    }
}
