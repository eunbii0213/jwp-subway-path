# jwp-shopping-cart

# 📚 도메인 모델 네이밍 사전

| 한글명 | 영문명      | 설명          | 분류    |
|-----|----------|-------------|-------|
| 역   | Station  | 지하철 역       | class |
| 노선  | Line     | 역의 모음       | class |
| 거리  | Distance | 역과 역 사이의 거리 | class |

<br>

## DB(DAO)

- H2 데이터베이스를 사용한다.
- DB 테이블 설계

<br>

- 테이블 이름: STATION

  | id | name | next | distance | line_id  |
                                | --- | --- |------|----------| -------- |
  | 1L | 노포역 | 2L | 10   | 1L       |
  | 2L | 화정역 | 3L | 5    | 1L       |
  | 3L | 잠실역 | 0L | null | 1L       |
  | 4L | 화정역 | 5L | 8    | 2L       |

name 중복을 허용한다

<br>

- 테이블 이름: LINE

  | id | name | color | head_station |
                                | --- | --- |-------| ------------ |
  | 1L | 1호선 | 파란색 | 1L    |
  | 2L | 2호선 | 초록색 | 4L    |

<br>

# 👨‍🍳 기능 목록

## Line

- [x] 이름을 가진다
- [x] 색깔을 가진다
- [x] Stations 가진다

## LineEntity

- [] id를 가진다
- [] 이름을 가진다
- [] 색깔을 가진다
- [] headStation을 가진다

## Station

- [x] 이름을 가진다
- [x] 거리를 가진다

## Stations

- [x] List<Station>의 일급컬렉션

## StationEntity

- [] id를 가진다
- [] 이름을 가진다
- [] nextStation을 가진다
- [] 거리를 가진다

## distance

- [x] 거리는 초기값으로 0을 가진다

## 노선 추가

    - [] 노선 생성시 역 2개가 등록되어야 한다.(처음 추가되는 역은 다음 역을 가지고 있어야 한다)
    - [] 노선에 처음 추가되는 역은 비어있으면 안된다
    - [] 연결된 두 역이 같은 이름이면 예외처리
    - [] 같은 이름의 노선이 2개 이상 존재하면 예외 처리.

## 노선에 역 등록

- [] 노선은 종점의 정보를 가진다
- []  A-B-C가 있을 때 A의 앞, C의 뒤, A와 B 사이에도 추가할 수 있다.
- []  노선은 역 간 거리 정보를 포함한다.
- []  역 사이에 새로운 역을 등록할 경우 기존 역 사이 길이보다 크거나 같으면 등록할 수 없다.
- [] 입력되는 상행역과 하행역이 노선에 모두 존재하지 않을 경우 예외처리
- [] 입력되는 상행역과 하행역 모두 역이 노선에 이미 존재할 경우 예외처리
- []  거리는 양의 정수이다.

## [ ] 노선 제거

- [] 이름으로 노선을 삭제

## 노선의 역 제거

- []  A-B-C에서 B를 제거할 경우 A-C의 연결이 남는다
- []  역이 제거될 때 역과 역 사이의 거리도 재배정되어야 한다.
- [ ]  노선에 역이 2개인 경우 하나를 제거하면 둘 다 제거되어야 한다.

## 노선 목록 조회
