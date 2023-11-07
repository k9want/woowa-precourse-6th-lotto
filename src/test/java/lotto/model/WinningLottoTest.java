package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("보너스 번호가 로또 번호 6개와 중복된 경우 예외 발생")
    @Test
    void createWinningLottoNotDuplicatedBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("WinningLotto 생성 성공 및 당첨번호와 보너스번호 확인")
    @Test
    void createWinningLotto() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int number = 7;

        //when
        WinningLotto winningLotto = new WinningLotto(lotto, number);
        Lotto winningNumbers = winningLotto.getWinningNumbers();
        Integer bonusNumber = winningLotto.getBonusNumber();

        //then
        assertThat(winningNumbers.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(bonusNumber).isEqualTo(number);
    }
}