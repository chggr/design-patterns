public final class Person {

    private final String name;
    private final String surname;
    private final String middleName;
    private final String title;
    private final Double height;
    private final Integer weight;
    private final String profession;

    private Person(final Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.middleName = builder.middleName;
        this.title = builder.title;
        this.height = builder.height;
        this.weight = builder.weight;
        this.profession = builder.profession;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getHeight() {
        return this.height;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getProfession() {
        return this.profession;
    }

    public static class Builder {

        private String name;
        private String surname;
        private String middleName;
        private String title;
        private Double height;
        private Integer weight;
        private String profession;

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder height(Double height) {
            this.height = height;
            return this;
        }

        public Builder weight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public Builder profession(String profession) {
            this.profession = profession;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
        
