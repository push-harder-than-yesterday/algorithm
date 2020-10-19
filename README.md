# Algorithm Study
자신의 알고리즘 실력을 마음껏 뽐내보세요! :)

### # 알고리즘 사이트
[top interview question - Leetcode](https://leetcode.com/explore/interview/card/top-interview-questions-medium/)에서 문제를 볼 수 있습니다.

### # 스터디 진행방식

* 일주일에 5~7개의 문제를 정해서 풀어보아요!
* 푼 문제들은 PR 날려고 서로의 코드를 리뷰해주세요.
* 스터디의 원활한 진행을 위해 목표 미달성시 💰**벌금**이 있으니 참고하세요!

### # 폴더 구성
```
algorithm 
    +- week1
    |   +- Remove-Duplicates-from-Sorted-Array
    |   |    +- 혜주.java
    |   |    +- 태형.cpp
    |   |    +- 종윤.js
    |   |    +- 승우.kt
    |   +- Best-Time-to-Buy-and-Sell-Stock-II
    |   |    +- 위의 구조 동일
        •
        •   
        •
문제 폴더명 네이밍 : 문제 이름으로 쓰되 띄어쓰기는 '-'으로 연결
```

### # 폴더 자동 생성 스크립트

폴더 생성하고 이름 바꾸고 이런거 귀찮으셨나요...?
이걸 사용해보세요!
그 주에 해당하는 문제들을 텍스트 파일에 넣으면 자동으로 폴더를 만들어줍니다!🤗

**실행 방법**

1. 터미널을 키고 folderCreator 폴더로 이동

2. problems.txt 파일에 다음과 같이 주차를 적고 `week(해당 주)` 그 밑에 문제 이름들을 복붙한다.

   ```java
   // problems.txt
   			•
   			•
   			•
   week3
   Binary Tree Level Order Traversal //문제를 적을때는 공백을 기준으로 - 로 대치하기 때문에
   Delete Node in a Linked List			//문제에 불필요한 공백은 없어야 된다.
   Remove Nth Node From End of List
   Symmetric Tree
   Merge Two Sorted Lists
   Maximum Depth of Binary Tree
   Reverse Linked List
   Validate Binary Search Tree
   ```

3. 쉘 스크립트를 실행한다.

   ```shell
   sh createFolders.sh (생성할 주)
   ```

**실행 화면**

<img src="folderCreator/createFolders.gif" />

버그나 추가적인 요청은 Issue에 올려주시면 감사하겠습니다~🙌🏻

