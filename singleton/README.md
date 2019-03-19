# 单例模式
###1.单例写法的优、缺点
#####1.饿汉式单例 优点：没有任何锁操作，执行效率高。缺点：类加载的时候就初始化，浪费内存
       饿汉式内部类写法可以减少内存浪费
#####2.懒汉式单例 优点：类加载的时候不会初始化，防止内存浪费。缺点：有线程安全问题
       使用synchronized加锁方式可以避免线程安全问题，但是会出现锁操作，执行效率降低。
       通过double check方式（synchronized只加代码块锁）可以提高执行效率。
#####3.注册式单例 1.容器缓存：优点是可以存储多个单例模式 缺点是不是线程安全的，需要使用synchronised加锁操作，执行效率降低。2.枚举式单例：优点是用静态代码块初始化，线程安全。反射破坏枚举式单例，在jvm层就做特殊处理，抛出异常。
#####4.
###2.破坏单例模式的方式有哪些
#####反射      在私有构造方法中做特殊判断抛出异常，注册式单例的枚举式单例不会出现此问题
#####序列化    类重写readResolve可以防止序列化破坏单例





