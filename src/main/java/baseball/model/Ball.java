package baseball.model;

import java.util.Objects;

public class Ball {
    private final int index;
    private final int number;
    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public boolean isBallWith(Ball other) {
        return (other.getIndex() != index) && (other.getNumber() == number);
    }

    public boolean isStrikeWith(Ball other) {
        return (other.getIndex() == index) && (other.getNumber() == number);
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Ball)) {
            return false;
        }
        return (((Ball) o).getIndex() == index) && (((Ball) o).getNumber() == number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, number);
    }
}
