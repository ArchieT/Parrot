package Engine;

/**
 * Created by Michał Krzysztof Feiler on 29.03.18.
 */
public enum Color {
    WHITE,
    BLACK;

    public String name(Locale locale) {
        switch (this) {
            case BLACK: switch (locale) {
                case PolskiBezOgonkow:
                case PolskiZOgonkami: return "Czarny";
                case English: return "Black";
                default: throw new IllegalArgumentException(locale.toString());
            }
            case WHITE: switch (locale) {
                case English: return "White";
                case PolskiZOgonkami: return "Biały";
                case PolskiBezOgonkow: return "Bialy";
                default: throw new IllegalArgumentException(locale.toString());
            }
            default: throw new IllegalArgumentException(this.toString());
        }
    }
}
