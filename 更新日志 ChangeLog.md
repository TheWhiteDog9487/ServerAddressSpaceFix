# 0.1.2
时间：2023 10 28  
主要内容：融合由 JustAlittleWolf 提交的PR，修复刷新按钮的问题。
[PR链接](https://github.com/TheWhiteDog9487/ServerAddressSpaceFix/pull/1)  
然后我把trim方法替换成了更加激进的replace，这样就算是地址中间有空格也没问题。
然后fabric.mod.json中的Homepage属性从Github改成了Modrinth  
并且更改了Gradle构造的输出文件名  