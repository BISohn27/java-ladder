package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("이름 생성")
    @Test
    void create() {
        String pobi = "pobi";

        Assertions.assertThat(new Name(pobi)).isEqualTo(new Name(pobi));
    }

    @DisplayName("이름은 1~5자")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "sixsix"})
    void valid(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5자입니다.");
    }

}