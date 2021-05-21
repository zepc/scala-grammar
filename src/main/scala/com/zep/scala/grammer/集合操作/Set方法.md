### Scala Set ���÷���

1. `def +(elem: A): Set[A]`Ϊ���������Ԫ�أ�x������һ���µļ��ϣ�����Ԫ���Ѵ���
2. `def -(elem: A): Set[A]`�����е�Ԫ�أ�������һ���µļ���
3. `def contains(elem: A): Boolean`���Ԫ���ڼ����д��ڣ����� true�����򷵻� false��
4. `def &(that: Set[A]): Set[A]`�����������ϵĽ���
5. `def &~(that: Set[A]): Set[A]`�����������ϵĲ
6. `def +(elem1: A, elem2: A, elems: A*): Set[A]`ͨ����Ӵ���ָ�����ϵ�Ԫ�ش���һ���µĲ��ɱ伯��
7. `def ++(elems: A): Set[A]`�ϲ���������
8. `def -(elem1: A, elem2: A, elems: A*): Set[A]`ͨ���Ƴ�����ָ�����ϵ�Ԫ�ش���һ���µĲ��ɱ伯��
9. `def addString(b: StringBuilder): StringBuilder`�����ɱ伯�ϵ�����Ԫ����ӵ��ַ���������
10. `def addString(b: StringBuilder, sep: String): StringBuilder`�����ɱ伯�ϵ�����Ԫ����ӵ��ַ�������������ʹ��ָ���ķָ���
11. `def apply(elem: A)`��⼯�����Ƿ����ָ��Ԫ��
12. `def count(p: (A) => Boolean): Int`��������ָ�������ļ���Ԫ�ظ���
13. `def copyToArray(xs: Array[A], start: Int, len: Int): Unit`���Ʋ��ɱ伯��Ԫ�ص�����
14. `def diff(that: Set[A]): Set[A]`�Ƚ��������ϵĲ
15. `def drop(n: Int): Set[A]`���ض���ǰn��Ԫ���¼���
16. `def dropRight(n: Int): Set[A]`���ض������n��Ԫ���¼���
17. `def dropWhile(p: (A) => Boolean): Set[A]`�������Ҷ���Ԫ�أ�ֱ������p������
18. `def equals(that: Any): Boolean`equals �����������������С����ڱȽ�ϵ���Ƿ���ȡ�
19. `def exists(p: (A) => Boolean): Boolean`�жϲ��ɱ伯����ָ��������Ԫ���Ƿ���ڡ�
20. `def filter(p: (A) => Boolean): Set[A]`�������ָ�����������в��ɱ伯��Ԫ�ء�
21. `def find(p: (A) => Boolean): Option[A]`���Ҳ��ɱ伯��������ָ�������ĵ�һ��Ԫ��
22. `def forall(p: (A) => Boolean): Boolean`���Ҳ��ɱ伯��������ָ������������Ԫ��
23. `def foreach(f: (A) => Unit): Unit`������Ӧ�õ����ɱ伯�ϵ�����Ԫ��
24. `def head: A`��ȡ���ɱ伯�ϵĵ�һ��Ԫ��
25. `def init: Set[A]`��������Ԫ�أ��������һ��
26. `def intersect(that: Set[A]): Set[A]`�����������ϵĽ���
27. `def isEmpty: Boolean`�жϼ����Ƿ�Ϊ��
28. `def iterator: Iterator[A]`����һ���µĵ�����������Ԫ��
29. `def last: A`�������һ��Ԫ��
30. `def map[B](f: (A) => B): immutable.Set[B]`ͨ�������ķ���������Ԫ�����¼���
31. `def max: A`�������Ԫ��
32. `def min: A`������СԪ��
33. `def mkString: String`��������Ԫ����Ϊ�ַ�����ʾ
34. `def mkString(sep: String): String`ʹ�÷ָ�������������Ԫ����Ϊ�ַ�����ʾ
35. `def product: A`���ز��ɱ伯��������Ԫ�صĻ���
36. `def size: Int`���ز��ɱ伯��Ԫ�ص�����
37. `def splitAt(n: Int): (Set[A], Set[A])`�Ѳ��ɱ伯�ϲ��Ϊ������������һ����ǰ n ��Ԫ����ɣ��ڶ�����ʣ�µ�Ԫ�����
38. `def subsetOf(that: Set[A]): Boolean`��������к����Ӽ����� true�����򷵻�false
39. `def sum: A`���ز��ɱ伯������������Ԫ��֮��
40. `def tail: Set[A]`����һ�����ɱ伯���г��˵�һԪ��֮�������Ԫ��
41. `def take(n: Int): Set[A]`����ǰ n ��Ԫ��
42. `def takeRight(n: Int):Set[A]`���غ� n ��Ԫ��
43. `def toArray: Array[A]`������ת��Ϊ����
44. `def toBuffer[B >: A]: Buffer[B]`���ػ������������˲��ɱ伯�ϵ�����Ԫ��
45. `def toList: List[A]`���� List�������˲��ɱ伯�ϵ�����Ԫ��
46. `def toMap[T, U]: Map[T, U]`���� Map�������˲��ɱ伯�ϵ�����Ԫ��
47. `def toSeq: Seq[A]`���� Seq�������˲��ɱ伯�ϵ�����Ԫ��
48. `def toString(): String`����һ���ַ������Զ�������ʾ