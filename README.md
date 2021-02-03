# 간단한 메모장 어플 만들기
* 프로젝트명 : NoteBook
* 기능 : DB를 통한 메모 작성 및 수정 그리고 삭제
![기본화면 215133](https://user-images.githubusercontent.com/41982054/106754844-cb69a200-6670-11eb-9257-3d233ee1a75b.png)






1. 메모 어플 기본 화면(메모들과 작성하기 버튼을 보여줌)
2. 메모 작성하기 버튼(제목과 내용을 입력 후 저장 및 취소 버튼)
3. 메모 클릭(해당 메모를 자세히 보여줌)
4. 메모 롱 클릭(해당 메모를 삭제 및 수정 가능)

## 주요 기능 설명
### MainActivity.java - 1
* 초기 Recycler View을 사용
*  메모 작성하기 버튼 클릭시 NoteWriteActivity로 화면 전환

### NoteWriteActivity.java 
* EditText로 각각 제목과 내용을 입력 받음
* 저장 버튼을 누르면 DB로 값을 저장 후 Toast 메세지 띄우고 메인 화면으로 돌아감 
* 취소 버튼을 누르면 그대로 종료

### RecyclerAdapter.java
* 메모 클릭 시 메모를 자세히 볼 수 있는 화면으로 넘겨줌
* 메모 롱 클릭 시 다이얼로그를 띄워 메모 수정과 삭제를 함

### DB
* 데이터베이스 만드는 과정

Memo.java

MemoDao.java

MemoDatabase.java



