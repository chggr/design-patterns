public final class LettuceDecorator extends SandwichDecorator {

    private final Sandwich sandwich;

    public LettuceDecorator(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + lettuce";
    }

    @Override
    public int getPriceCents() {
        return sandwich.getPriceCents() + 17;
    }
}

