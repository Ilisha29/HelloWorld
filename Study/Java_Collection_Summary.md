### - Java Collection -

: 자바의 콜렉션은 데이터의 집합이나 그룹을 의미하며, 특징(순서의 유무 와 중복 등)에 따라 여러 인터페이스로 나뉜다.

**원래 콜렉션의 상위 인터페이스는 Set, List, Queue지만 Map은 콜렉션으로 분류한다.**

#### 1. Set 인터페이스

​	순서 : O	데이터 중복 : X

​	ex) HashSet, TreeSet

#### 2. List 인터페이스

​	순서 : O	데이터 중복 : O

​	ex) LinkedList, Vector, ArrayList

#### 3. Queue 인터페이스

​	순서 : O	데이터 중복 : O (List와 유사)

​	ex) LinkedList, PriorityQueue

#### 4. Map 인터페이스

​	순서 : X	값 중복 : O	키 중복 : X

​	ex) Hashtable, HashMap, TreeMap