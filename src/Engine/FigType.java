package Engine;

import io.vavr.Tuple2;

/**
 * Created by Michał Krzysztof Feiler on 29.03.18.
 */
public enum FigType {
    PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING;

    public int HP() {
        switch (this) {
            case PAWN:
                return 5;
            case KNIGHT:
                return 3;
            case BISHOP:
                return 7;
            case ROOK:
                return 8;
            case QUEEN:
                return 12;
            case KING:
                return 20;
            default:
                throw new IllegalArgumentException(this.toString());
        }
    }

    public int DMG() {
        switch (this) {
            case PAWN:
                return 2;
            case KNIGHT:
                return 5;
            case BISHOP:
                return 3;
            case ROOK:
                return 2;
            case QUEEN:
                return 3;
            case KING:
                return 2;
            default:
                throw new IllegalArgumentException(this.toString());
        }
    }

    @Override
    public String name(Locale locale) {
        switch (this) {
            case KING:
                switch (locale) {
                    case English:
                        return "King";
                    case PolskiZOgonkami:
                        return "Król";
                    case PolskiBezOgonkow:
                        return "Krol";
                    default:
                        throw new IllegalArgumentException(locale.toString());
                }
            case PAWN:
                switch (locale) {
                    case PolskiBezOgonkow:
                    case PolskiZOgonkami:
                        return "Pionek";
                    case English:
                        return "Pawn";
                    default:
                        throw new IllegalArgumentException(locale.toString());
                }
            case ROOK:
                switch (locale) {
                    case English:
                        return "Rook";
                    case PolskiZOgonkami:
                        return "Wieża";
                    case PolskiBezOgonkow:
                        return "Wieza";
                    default:
                        throw new IllegalArgumentException(locale.toString());
                }
            case QUEEN:
                switch (locale) {
                    case PolskiBezOgonkow:
                    case PolskiZOgonkami:
                        return "Hetman";
                    case English:
                        return "Queen";
                    default:
                        throw new IllegalArgumentException(locale.toString());
                }
            case BISHOP:
                switch (locale) {
                    case English:
                        return "Bishop";
                    case PolskiZOgonkami:
                    case PolskiBezOgonkow:
                        return "Goniec";
                    default:
                        throw new IllegalArgumentException(locale.toString());
                }
            case KNIGHT:
                switch (locale) {
                    case PolskiBezOgonkow:
                    case PolskiZOgonkami:
                        return "Skoczek";
                    case English:
                        return "Knight";
                    default:
                        throw new IllegalArgumentException(locale.toString());
                }
            default:
                throw new IllegalArgumentException(this.toString());
        }
    }

    /**
     * @param c ((fromX,fromY),(targetX,targetY))
     * @return can this, of this figtype, attack from to?
     */
    public boolean canThisAttack(Tuple2<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>> c) {
        Tuple2<Integer, Integer> fr = c._1;
        Tuple2<Integer, Integer> to = c._2;
        int frX = fr._1;
        int frY = fr._2;
        int toX = to._1;
        int toY = to._2;
        return canThisAttack(frX, frY, toX, toY);
    }

    public boolean canThisAttack(int frX, int frY, int toX, int toY) {
        switch (this) {
            case KING:
            case PAWN:
                return (toX == frX + 1 && toY == frY + 1) ||
                        toX == frX + 1 && toY == frY - 1 ||
                        toX == frX - 1 && toY == frY + 1 ||
                        toX == frX - 1 && toY == frY - 1;
            case KNIGHT:
                return (frY == toY + 1 && Math.abs(toX - frX) == 1) ||
                        frY == toY - 1 && Math.abs(toX - frX) == 1 ||
                        frY == toY && Math.abs(toX - frX) == 1 ||
                        frX == toX && Math.abs(toY - frY) == 1;
            case ROOK:
                return (toX == frX && Math.abs(frY - toY) <= 3) ||
                        toY == frY && Math.abs(frX - toX) <= 3;
            case BISHOP:
                int xd = Math.abs(frX - toX);
                int yd = Math.abs(frY - toY);
                return xd == yd && xd <= 3 && yd <= 3;
            case QUEEN:
                int x = Math.abs(frX - toX);
                int y = Math.abs(frY - toY);
                return x == y && x <= 3;
        }
    }
}
