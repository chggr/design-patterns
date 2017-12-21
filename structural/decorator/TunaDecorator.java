public final class TunaDecorator extends SandwichDecorator {

    private final Sandwich sandwich;

    public TunaDecorator(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + tuna";
    }

    @Override
    public int getPriceCents() {
        return sandwich.getPriceCents() + 65;
    }
}

