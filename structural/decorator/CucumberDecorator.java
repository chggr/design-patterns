public final class CucumberDecorator extends SandwichDecorator {

    private final Sandwich sandwich;

    public CucumberDecorator(final Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + " + cucumber";
    }

    @Override
    public int getPriceCents() {
        return sandwich.getPriceCents() + 12;
    }
}

