# SwipeListViewDemo
实现侧滑删除，更新操作，对现有swipeListView优化，代码简单易懂，只要代码在swipeView中劫持OnTouchEvent,效果很好

看了下其他的SwipeListView操作效果不是很好用，就觉得做一个关于侧滑的demo ，如是这个demo写成了

应用到你自己项目中步骤：

1、下载demo跑一边，看看效果，效果不错的话 把SwipeView拷贝到你的项目中
2、新建或者把SwipeListView拷贝到项目中
3、自己新建Adapter
3.1 adapter中需要注意的是实现swipeView.setOnSlideListener事件，这个回调处理旧的itemView关闭问题

其他用法和一般ListView一样 

