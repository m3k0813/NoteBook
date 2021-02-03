# 간단한 메모장 어플 만들기
* 프로젝트명 : NoteBook
* 기능 : DB를 통한 메모 작성 및 수정 그리고 삭제

![GIF 2021-02-03 오후 10-44-57](https://user-images.githubusercontent.com/41982054/106755659-b4777f80-6671-11eb-987d-7107ff3eaad3.gif)






1. 메모 어플 기본 화면(메모들과 작성하기 버튼을 보여줌)
2. 메모 작성하기 버튼(제목과 내용을 입력 후 저장 및 취소 버튼)
3. 메모 클릭(해당 메모를 자세히 보여줌)
4. 메모 롱 클릭(해당 메모를 삭제 및 수정 가능)

## 주요 기능 설명
### MainActivity.java - 1
<img src = "https://user-images.githubusercontent.com/41982054/106755821-ec7ec280-6671-11eb-8792-759f1f27ac87.png" width="400px">
<img src = "https://user-images.githubusercontent.com/41982054/106755857-f99bb180-6671-11eb-84ca-76d2bf73e844.png" width="400px">


* 초기 Recycler View을 사용
*  메모 작성하기 버튼 클릭시 NoteWriteActivity로 화면 전환

### NoteWriteActivity.java 
![메모작성 액티비티0](https://user-images.githubusercontent.com/41982054/106755984-189a4380-6672-11eb-9d63-5d92908fb3ac.png)
![메모작성액티비티 DB저장57](https://user-images.githubusercontent.com/41982054/106756013-2223ab80-6672-11eb-93ce-63dc4541beea.png)

* EditText로 각각 제목과 내용을 입력 받음
* 저장 버튼을 누르면 DB로 값을 저장 후 Toast 메세지 띄우고 메인 화면으로 돌아감 
* 취소 버튼을 누르면 그대로 종료

### RecyclerAdapter.java(메모 클릭/롱클릭)
![클릭시 메모보기1](https://user-images.githubusercontent.com/41982054/106756030-28b22300-6672-11eb-98ba-8208ad690e7d.png)
![메모롱클릭1](https://user-images.githubusercontent.com/41982054/106756041-2d76d700-6672-11eb-966c-340c1f716b91.png)

* 메모 클릭 시 메모를 자세히 볼 수 있는 화면으로 넘겨줌
* 메모 롱 클릭 시 다이얼로그를 띄워 메모 수정과 삭제를 함

### DB
* 데이터베이스 만드는 과정


Memo.java
![Memo 12](https://user-images.githubusercontent.com/41982054/106756102-42ec0100-6672-11eb-847b-cc1613bd92a5.png)

MemoDao.java
![MemoDao3](https://user-images.githubusercontent.com/41982054/106756126-48494b80-6672-11eb-92f0-4fbffc0680eb.png)

MemoDatabase.java
![DATABASE21530](https://user-images.githubusercontent.com/41982054/106756145-4da69600-6672-11eb-8608-cecc31f9968d.png)




