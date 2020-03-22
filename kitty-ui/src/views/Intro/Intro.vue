<template>
  <div class="page-container" style="width:99%;margin-top:15px;">
    <el-carousel :interval="3000" type="card" height="450px" class="carousel">
      <el-carousel-item class="carousel-item-intro">
        <h2>项目介绍</h2>
        <ul>
          <li>中国核工业第五集团公司智慧工地系统</li>
        </ul>
        <div><img src="@/assets/logo_kitty_blue.png" style="width:200px;height:120px;padding-top:15px;" /></div>
      </el-carousel-item>
      <el-carousel-item class="carousel-item-func">
        <h2>项目计划</h2>
        <ul>
          <li>需求分析</li>
          <li>主框架搭建</li>
          <li>数据结构分析</li>
          <li>基础组建开发</li>
          <li>展示页面设计及实现</li>
          <li>核心业务逻辑实现</li>
          <li>移动端适配</li>
          <li>多代理数据模型</li>
          <li>现场测试</li>
        
        </ul>
      </el-carousel-item>
      <el-carousel-item class="carousel-item-env">
        <h2>教师团队</h2>
        <ul>
          <li>上海电力大学教师-曾俊冬-项目负责</li>
          <li>上海电力大学教师-黄琼-技术</li>
          <li>上海电力大学教师-宋小军-文档</li>
          <li>上海电力大学教师-初凤红-管理</li>

        </ul>
        <h2>学生团队</h2>
        <ul>
          <li>上海电力大学研究生-黄云-软件</li>
          <li>上海电力大学研究生-张璠-软件</li>
          <li>上海电力大学研究生-张涵-文档</li>
          <li>上海电力大学本科生-曹珈铭-软件</li>

        </ul>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
  export default {
    components:{
    },
    methods :{
    }
  }
</script>

<style>
  .carousel {
    padding-left: 20px;
    padding-right: 20px;
    margin-right: 20px;
  }
  .carousel h2 {
    color: #475669;
    font-size: 22px;
    opacity: 1.75;
    line-height: 100px;
    margin: 0;
  }
  .carousel ul {
    color: #475669;
    font-size: 15px;
    opacity: 1.75;
    line-height: 40px;
    margin: 0;
  }
  .carousel-item-intro h2 {
    color: #ffffff;
    font-size: 22px;
    opacity: 1.75;
    line-height: 80px;
    margin: 0;
  }
  .carousel-item-intro ul {
    color: #ffffff;
    font-size: 15px;
    opacity: 1.75;
    line-height: 65px;
    padding: 5px;
    margin: 0;
  }
   .carousel-item-func h2 {
    color: #3f393b;
    font-size: 22px;
    opacity: 1.75;
    line-height: 50px;
    margin: 0;
  }
  .carousel-item-func ul {
    color: #3f393b;
    font-size: 15px;
    opacity: 1.75;
    line-height: 30px;
    text-align: left;
    padding-left: 90px;
    margin: 0;
  }
  .carousel-item-env h2 {
    color: #475669;
    font-size: 22px;
    opacity: 1.75;
    line-height: 50px;
    margin: 0;
  }
  .carousel-item-env ul {
    color: #475669;
    font-size: 15px;
    opacity: 1.75;
    line-height: 35px;
    text-align: left;
    padding-left: 110px;
    margin: 0;
  }
  .carousel-item-intro {
    background-color: #19aaaf73;
    -webkit-border-radius: 25px;
    border-radius: 25px;
    -moz-border-radius: 15px;
    background-clip: padding-box;
    box-shadow: 0 0 25px #a3b3b965;
  }
  .carousel-item-func {
    background-color: #19aaaf73;
    -webkit-border-radius: 25px;
    border-radius: 25px;
    -moz-border-radius: 15px;
    background-clip: padding-box;
    box-shadow: 0 0 25px #a3b3b965;
  }
  .carousel-item-env {
    background-color: #19aaaf73;
    -webkit-border-radius: 25px;
    border-radius: 25px;
    -moz-border-radius: 15px;
    background-clip: padding-box;
    box-shadow: 0 0 25px #a3b3b965;
  }
  .carousel-item-intro {
    background-color: #b95e5e;
  }
  .carousel-item-func {
    background-color: #52c578;
  }
  .carousel-item-env {
    background-color: #41a7b9;
  }
</style>