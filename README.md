# MyGameFrame

游戏窗口引擎


## 代码示例

+ #### 创建窗口
~~~java
GameFrame frame = new GameFrame(new FrameInfo("Test", new Dimension(100, 100), new Point(0, 0), JFrame.EXIT_ON_CLOSE, false, true));
~~~

|参数|解释|
|:---:|:---:|
|title _["Test"]_|窗口标题|
|size _[Dimension(100, 100)]_|窗口尺寸|
|point _[Point(0, 0)]_|窗口坐标,值为null时窗口居中|
|closeOperation _[JFrame.EXIT_ON_CLOSE]_|窗口关闭操作|
|undecorated _[false]_|是否隐藏窗口边框|
|visible _[true]_|是否显示窗口|


+ #### 鼠标拖动窗口 
> *2.x* 版本代码示例

~~~java
// 添加监听器
int id = frame.addMouseDragWindowAdapter(new Point(0, 0), frame.geiSize());
~~~

|参数|解释|
|:---:|:---:|
|p _[Point(0, 0)]_|鼠标拖动范围的左上角坐标|
|d _[Dimension(100, 100)]_|鼠标拖动范围的尺寸|
|return|监听器编号,用于删除监听器|

~~~java
// 移除监听器
frame.removeMouseMotionListener(id);
~~~

|参数|解释|
|:---:|:---:|
|id|要删除的监听器的编号|



## 信息

|||
|:---:|:---:|
|语言|Java|
|JDK版本|jdk-11.0.6|
|项目版本|1.0|

