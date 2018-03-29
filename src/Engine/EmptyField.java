package Engine;

/**
 * Created by Michał Krzysztof Feiler on 29.03.18.
 */
public class EmptyField implements GameObject {
    @Override
    public String name(Locale locale) {
        switch (locale) {
            case English: return "EmptyField";
            case PolskiZOgonkami:
            case PolskiBezOgonkow: return "PustePole";
            default: throw new IllegalArgumentException(locale.toString());
        }
    }
}
