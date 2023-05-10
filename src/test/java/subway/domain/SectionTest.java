package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SectionTest {

    @Test
    @DisplayName("isIncludeEmptyStation()를 호출했을 때 양 역 중 하나 이상이 emptyStation이라면 true를 반환한다.")
    void isIncludeEmptyStation_true(){
        //given
        Station upStation = new Station("상행역");
        Station downStation = Station.emptyStation;
        Distance distance = new Distance(10);
        Section section = new Section(upStation, downStation, distance);

        //when
        boolean actual = section.isIncludeEmptyStation();

        // then
        assertThat(actual).isTrue();
    }

    //TODO: isIncludeEmptyStation() false검증 

    @Test
    @DisplayName("validateSameStations()를 호출했을 때 양 역의 이름이 같다면 예외를 발생시킨다.")
    void validateSameStations_fail(){
        //given
        Station upStation = new Station("상행역");
        Station downStation = new Station("상행역");
        Distance distance = new Distance(10);

        //when, then
        assertThatThrownBy(()->new Section(upStation, downStation, distance))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상행역과 하행역은 같은 이름을 가질 수 없습니다.");

    }

    @Test
    @DisplayName("validateBothEmptyStation()를 호출했을 때 양 역이 둘 다 비어있다면 예외를 발생시킨다.")
    void validateBothEmptyStation_fail(){
        //given
        Station upStation = Station.emptyStation;
        Station downStation = Station.emptyStation;
        Distance distance = new Distance(10);

        //when, then
        assertThatThrownBy(()->new Section(upStation, downStation, distance))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상행역과 하행역이 모두 비어있을 수 없습니다");
    }

    @Test
    @DisplayName("생성자를 호출할 때, 올바른 값을 입력하면 구간이 정상적으로 생성된다")
    void constructor_success(){
        //given
        Station upStation = new Station("상행역");
        Station downStation = new Station("하행역");
        Distance distance = new Distance(10);

        //when, then
        assertThatCode(()->new Section(upStation, downStation, distance))
                .doesNotThrowAnyException();
    }
}
