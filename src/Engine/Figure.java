package Engine;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Michał Krzysztof Feiler on 29.03.18.
 */
public class Figure implements GameObject {
    public final @NotNull FigType type;
    public final @NotNull Color color;
    public final int HP;

    public Figure(@NotNull FigType type, @NotNull Color color) {
        this.type = type;
        this.color = color;
        HP = type.HP();
    }

    public Figure(@NotNull FigType type, @NotNull Color color, int HP) {
        this.type = type;
        this.color = color;
        this.HP = HP;
    }

    public @NotNull Figure withHP(int HP) {
        return new Figure(type, color, HP);
    }

    @Override
    public String name(Locale locale) {
        return String.format("%s%s%s",
                color.name(locale),
                type.name(locale),
                Integer.toString(HP));
    }
}
