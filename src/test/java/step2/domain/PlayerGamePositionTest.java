package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NotMoveLeftException;
import step2.exception.NotMoveRightException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerGamePositionTest {

    private PlayerGamePosition playerGamePosition;

    @BeforeEach
    void setUp() {
        playerGamePosition = new PlayerGamePosition(1, 2);
    }

    @Test
    @DisplayName("왼쪽으로 움직이는지 확인한다.")
    void moveLeft() {
        playerGamePosition.move(Direction.LEFT);
        assertThat(playerGamePosition.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽으로 움직이는지 확인한다.")
    void moveRight() {
        playerGamePosition.move(Direction.RIGHT);
        assertThat(playerGamePosition.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("아래쪽으로 움직이는지 확인한다.")
    void moveDown() {
        playerGamePosition.move(Direction.DOWN);
        assertThat(playerGamePosition.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽으로 움직일때 경계선을 넘어가면 익셉션이 터지는지 확인한다.")
    void moveLeftException() {
        playerGamePosition.move(Direction.LEFT);
        assertThatThrownBy(() -> playerGamePosition.move(Direction.LEFT))
                .isInstanceOf(NotMoveLeftException.class);
    }

    @Test
    @DisplayName("오쪽으로 움직일때 경계선을 넘어가면 익셉션이 터지는지 확인한다.")
    void moveRightException() {
        playerGamePosition.move(Direction.RIGHT);
        assertThatThrownBy(() -> playerGamePosition.move(Direction.RIGHT))
                .isInstanceOf(NotMoveRightException.class);
    }

}