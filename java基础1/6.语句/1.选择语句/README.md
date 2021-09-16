## 选择语句

### 单分支
> 判断条件直接写布尔值或表达式均可，最终结果为布尔值即可
```java
// 形式1
if(判断条件) {}
if() {}

// 形式2
if() {
  if () {};
  if () {}
}

// 形式3
if() {

} else {
  
}

// 形式4
if() {

} else if() {

} else if() {

} else {

}

// 除了上述方式，其还有很多变种，但本质依旧是'完成功能的前提下代码更易阅读'
```

### 多分支
> switch中传入的是'值'，直接写值或表达式均可，最终结果为值即可
> 值类型：byte short int char enum[java1.5支持] string[java1.7支持]
```java
switch(值) {
  case 值1:
       代码;
       [break];
  case 值2:
       代码;
       [break];
  case 值3:
       代码;
       [break];
  // 兜底
  default: 
       代码
       [break]
}
```