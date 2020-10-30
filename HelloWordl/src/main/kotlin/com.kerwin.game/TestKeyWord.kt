package com.kerwin.game

class TestKeyWord {

    data class Person(
            val name: String,
            val age: Int
    )

    companion object {

        fun test1() {
            val people = listOf(Person("jack", 29),
                    Person("nick", 23),
                    Person("jone", 26))
//年龄是否满足23
            val isAge23 = { p: Person -> p.age <= 23 }
//检查集合看是否所有元素满足（all）
            println(people.all(isAge23)) //false
//检查集合中是否至少存在一个匹配的元素(any)
            println(people.any(isAge23))//true
//检查有多少个元素满足判断式(count)
            println(people.count(isAge23))//1
//找到第一个满足判断式的元素(find)
//如有多个匹配返回其中第一个元素，没有返回null。同义函数firstOrNull。
            println(people.find(isAge23)) //Person(name=nick, age=23)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            test1()
        }
    }
}