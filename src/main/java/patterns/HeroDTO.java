package patterns;

import java.util.ArrayList;
import java.util.List;

public class HeroDTO {
    private String name;
    private List<String> movies;

    public HeroDTO(String name, List<String> movies) {
        this.name = name;
        this.movies = movies;
    }

    public static HeroDtoBuilder builder() {
        return new HeroDtoBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "HeroDtoBuilder{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }

    public static class HeroDtoBuilder {
        private String name;
        private List<String> movies = new ArrayList<>();

        public HeroDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public HeroDtoBuilder withMovies(List<String> movies) {
            this.movies = movies;
            return this;
        }

        public HeroDTO build() {
            return new HeroDTO(name, movies);
        }
    }
}
