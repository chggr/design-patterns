public final class AvocadoDecorator extends SandwichDecorator {

    private final Sandwich sandwich;

    public AvocadoDecorator(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + avocado";
    }

    @Override
    public int getPriceCents() {
        return sandwich.getPriceCents() + 85;
    }
}

