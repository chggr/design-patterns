public final class HamDecorator extends SandwichDecorator {

    private final Sandwich sandwich;

    public HamDecorator(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + ham";
    }

    @Override
    public int getPriceCents() {
        return sandwich.getPriceCents() + 72;
    }
}

