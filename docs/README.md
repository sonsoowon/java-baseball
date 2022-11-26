## 기능 목록

- [x] 어플리케이션 시작 시 게임 시작 문구 출력

- [x] 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개 선택

- [ ] 플레이어가 입력한 1에서 9까지 서로 다른 수 3개 반환
- [x] 플레이어가 입력한 문자열을 유효한 숫자 리스트로 변환
  잘못된 값을 입력할 경우 `IllegalArgumentException` 발생


- [ ] 플레이어의 숫자 3개 -> 위치, 숫자값을 나타내는 아이템 객체 3개로 변환
- [ ] 두 아이템 객체가 볼 관계이면 `true` 반환
  - 위치가 다르고 숫자값이 같다
- [ ] 두 아이템 객체가 스트라이크 관계이면 `true` 반환
  - 두 객체가 같다
- [ ] 두 아이템 객체가 같다면 `true` 반환
  - 위치와 숫자값이 모두 같다
- [ ] 서로 다른 객체는 다른 hashCode를 반환하고 같은 객체는 같은 hashCode 반환


- [ ] 컴퓨터 3개의 수 중 볼인 플레이어 숫자가 존재하면 `true` 반환
- [ ] 컴퓨터 3개의 수 중 스트라이크인 플레이어 숫자가 존재하면 `true` 반환
- [ ] 컴퓨터 3개의 수와 플레이어 3개의 수를 비교해 볼/스트라이크 개수 반환
- [ ] 볼/스트라이크 개수를 출력 형식에 맞는 문자열로 변환

- [ ] 볼/스트라이크 개수 출력
- [ ] 올스트라이크이면 `true` 반환

- [ ] 올스트라이크 및 게임 재시작/종료 선택 문구 출력

- [ ] 플레이어가 게임 재시작/종료 입력
- [ ] 잘못된 선택지를 입력하면 `IllegalArgumentException` 발생


## 설계


### Item
- index, number
- ballWith
- strikeWith
- equalsTo
- hashCode
- toString

### ItemList
- Item items
- ballBy Item
- strikeBy Item
- getResultOf ItemList

### Result
- ballCnt, strikeCnt
- toString

