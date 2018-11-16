# 整个项目中有的文件夹对应的说明

## booksBackstage 是后台代码，是用Java 框架 jfinal 写的 

>该项目是用maven 打包而成的一个javaweb 项目，如需使用，需要先下载安装maven，之后在进行打包运行下载maven的jar包，我使用的编辑器为vscode，打开文件夹后，会自动提醒安装插件，之后只要complie 即可

#
>因为这个是刚开始使用就final，在代码书写方面并不太熟悉，所以显得有点累赘，也是写了有段时间了，所以也懒得修改， 但在下次书写时，会注意这些问题，更注重优化的问题

## booksFront 是前端展示文件

> brown 为首页展示的文件，已全部复制进后台代码的webapps 当中
> manager 为后台展示的文件，是通过webpack 脚手架的一个单页面应用
  
``` 使用：
# 搭建环境
npm install

# 运行  localhost:8080
npm run dev

# 打包
npm run build

```

## mysql 是数据库文件，

> 在本地数据库中创建 booksmanage 数据库，然后导入.sql 文件即可

> 这是后台管理系统

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).
