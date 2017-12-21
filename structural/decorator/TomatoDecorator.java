public final class TomatoDecorator extends SandwichDecorator {

    private final Sandwich sandwich;

    public TomatoDecorator(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + tomato";
    }

    @Override
    public int getPriceCents() {
        return sandwich.getPriceCents() + 25;
    }
}

