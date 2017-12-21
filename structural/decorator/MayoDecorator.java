public final class MayoDecorator extends SandwichDecorator {

    private final Sandwich sandwich;

    public MayoDecorator(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + mayo";
    }

    @Override
    public int getPriceCents() {
        return sandwich.getPriceCents() + 5;
    }
}

