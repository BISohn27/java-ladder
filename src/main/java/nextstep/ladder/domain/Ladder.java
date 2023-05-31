package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder (int height, int countOfPerson, LineStrategy lineStrategy) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("높이는 " + MINIMUM_HEIGHT + " 이상이어야 합니다. (높이: " + height + ")");
        }
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson, lineStrategy))
                .collect(Collectors.toList());
    }

    public int execute(int nameOrder) {
        int currentPosition = nameOrder;
        for (Line line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

    public List<List<Boolean>> getLines() {
        return lines.stream()
                .map(Line::getPoints)
                .collect(Collectors.toList());
    }
}
