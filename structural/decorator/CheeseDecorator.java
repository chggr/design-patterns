public final class CheeseDecorator extends SandwichDecorator {

    private final Sandwich sandwich;

    public CheeseDecorator(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + cheese";
    }

    @Override
    public int getPriceCents() {
        return sandwich.getPriceCents() + 47;
    }
}

