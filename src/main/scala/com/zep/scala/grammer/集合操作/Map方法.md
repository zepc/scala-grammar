1. `def ++(xs: Map[(A, B)]): Map[A, B]`����һ���µ� Map���µ� Map xs ���
2. `def -(elem1: A, elem2: A, elems: A*): Map[A, B]`����һ���µ� Map, �Ƴ� key Ϊ elem1, elem2 ������ elems��
3. `def --(xs: GTO[A]): Map[A, B]`����һ���µ� Map, �Ƴ� xs �����ж�Ӧ�� key
4. `def get(key: A): Option[B]`����ָ�� key ��ֵ
5. `def iterator: Iterator[(A, B)]`�����µĵ������������ key/value ��
6. `def addString(b: StringBuilder): StringBuilder`��Map�е�����Ԫ�ظ��ӵ�StringBuilder���ɼ���ָ���
7. `def addString(b: StringBuilder, sep: String): StringBuilder`��Map�е�����Ԫ�ظ��ӵ�StringBuilder���ɼ���ָ���
8. `def apply(key: A): B`����ָ������ֵ����������ڷ��� Map ��Ĭ�Ϸ���
9. `def clear(): Unit`��� Map
10. `def clone(): Map[A, B]`��һ�� Map ���Ƶ���һ�� Map
11. `def contains(key: A): Boolean`��� Map �д���ָ�� key������ true�����򷵻� false��
12. `def copyToArray(xs: Array[(A, B)]): Unit`���Ƽ��ϵ�����
13. `def count(p: ((A, B)) => Boolean): Int`��������ָ�������ļ���Ԫ������
14. `def default(key: A): B`���� Map ��Ĭ��ֵ���� key ������ʱ���ء�
15. `def drop(n: Int): Map[A, B]`���ض���ǰn��Ԫ���¼���
16. `def dropRight(n: Int): Map[A, B]`���ض������n��Ԫ���¼���
17. `def dropWhile(p: ((A, B)) => Boolean): Map[A, B]`�������Ҷ���Ԫ�أ�ֱ������p������
18. `def empty: Map[A, B]`������ͬ���͵Ŀ� Map
19. `def equals(that: Any): Boolean`������� Map ���(key/value �����)������true�����򷵻�false
20. `def exists(p: ((A, B)) => Boolean): Boolean`�жϼ�����ָ��������Ԫ���Ƿ����
21. `def filter(p: ((A, B))=> Boolean): Map[A, B]`��������ָ�����������м���
22. `def filterKeys(p: (A) => Boolean): Map[A, B]`���ط���ָ�������ĵĲ��ɱ� Map
23. `def find(p: ((A, B)) => Boolean): Option[(A, B)]`���Ҽ���������ָ�������ĵ�һ��Ԫ��
24. `def foreach(f: ((A, B)) => Unit): Unit`������Ӧ�õ����ϵ�����Ԫ��
25. `def init: Map[A, B]`��������Ԫ�أ��������һ��
26. `def isEmpty: Boolean`��� Map �Ƿ�Ϊ��
27. `def keys: Iterable[A]`�������е�key
28. `def last: (A, B)`�������һ��Ԫ��
29. `def max: (A, B)`�������Ԫ��
30. `def min: (A, B)`������СԪ��
31. `def mkString: String`��������Ԫ����Ϊ�ַ�����ʾ
32. `def product: (A, B)`���ؼ���������Ԫ�صĻ���
33. `def remove(key: A): Option[B]`�Ƴ�ָ�� key
34. `def retain(p: (A, B) => Boolean): Map.this.type`����������������ķ��� true
35. `def size: Int`���� Map Ԫ�صĸ���
36. `def sum: (A, B)`���ؼ�������������Ԫ��֮��
37. `def tail: Map[A, B]`����һ�������г��˵�һԪ��֮�������Ԫ��
38. `def take(n: Int): Map[A, B]`����ǰ n ��Ԫ��
39. `def takeRight(n: Int): Map[A, B]`���غ� n ��Ԫ��
40. `def takeWhile(p: ((A, B)) => Boolean): Map[A, B]`��������ָ��������Ԫ��
41. `def toArray: Array[(A, B)]`����ת����
42. `def toBuffer[B >: A]: Buffer[B]`���ػ������������� Map ������Ԫ��
43. `def toList: List[A]`���� List�������� Map ������Ԫ��
44. `def toSeq: Seq[A]`���� Seq�������� Map ������Ԫ��
45. `def toSet: Set[A]`���� Set�������� Map ������Ԫ��
46 `def toString(): String`�����ַ�������